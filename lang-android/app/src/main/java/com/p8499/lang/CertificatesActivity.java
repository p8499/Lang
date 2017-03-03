package com.p8499.lang;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.p8499.lang.gen.FilterLogicExpr;
import com.p8499.lang.gen.OrderByListExpr;
import com.p8499.lang.gen.RangeExpr;
import com.p8499.lang.gen.bean.Certificate;
import com.p8499.lang.gen.bean.Language;
import com.p8499.lang.gen.stub.CertificateStub;
import com.p8499.lang.gen.stub.LanguageStub;
import com.p8499.lang.gen.view.CertificateListView;
import com.p8499.lang.stubex.UserStubEx;

import java.net.HttpURLConnection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CertificatesActivity extends AppCompatActivity implements CertificateListView, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.root)
    protected LinearLayout root;
    @BindView(R.id.refresh)
    protected SwipeRefreshLayout refresh;
    @BindView(R.id.recycler)
    protected RecyclerView recycler;
    protected Presenter presenter = new Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificates);
        ButterKnife.bind(this);
        ((TitleFragment) getSupportFragmentManager().findFragmentById(R.id.title)).setTitle(getString(R.string.activity_certificates_title)).hideAccount();
        refresh.setOnRefreshListener(this);
        Adapter adapter = new Adapter();
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new GridLayoutManager(this, 3));
        recycler.addOnItemTouchListener(new CertificatesItemClickListener());
        processIntent(getIntent());
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.request();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        processIntent(getIntent());
    }

    protected void processIntent(Intent intent) {
    }

    @Override
    public void onRefresh() {
        Adapter adapter = (Adapter) recycler.getAdapter();
        adapter.setEnableLoadMore(false);
        presenter.request();
    }

    public void onSessionOut() {
        finish();
    }

    @Override
    public void onCertificateListReloaded(List<Certificate> certificateList) {
        Adapter adapter = (Adapter) recycler.getAdapter();
        adapter.setNewData(certificateList);
        adapter.loadMoreComplete();
        refresh.setRefreshing(false);
    }

    @Override
    public void onCertificateListAppended(List<Certificate> certificateList) {
        Adapter adapter = (Adapter) recycler.getAdapter();
        adapter.addData(certificateList);
        adapter.loadMoreEnd();
    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        Snackbar.make(root, R.string.activity_certificates_error, Snackbar.LENGTH_LONG).show();
    }


    class ViewHolder extends BaseViewHolder {
        @BindView(R.id.root)
        protected LinearLayout root;
        @BindView(R.id.level)
        protected ImageView level;
        @BindView(R.id.name)
        protected TextView name;
        @BindView(R.id.expire)
        protected TextView expire;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    class Adapter extends BaseQuickAdapter<Certificate, ViewHolder> {
        public static final long SECOND = 1000;
        public static final long MINUTE = 60 * SECOND;
        public static final long HOUR = 60 * MINUTE;
        public static final long DAY = 24 * HOUR;

        public Adapter() {
            super(R.layout.activity_certificates_recycler, null);
        }

        @Override
        protected ViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(getItemView(mLayoutResId, parent));
        }

        @Override
        protected void convert(ViewHolder viewHolder, Certificate certificate) {
            viewHolder.name.setText(certificate.getCrlsname());
            if (certificate.getCrlv() == 20)
                viewHolder.level.setImageResource(R.drawable.ic_level_v2_yellow_48dp);
            else if (certificate.getCrlv() == 10)
                viewHolder.level.setImageResource(R.drawable.ic_level_v1_yellow_48dp);
            else
                viewHolder.level.setImageDrawable(null);
            long remain = certificate.getCrexdt().getTime() - System.currentTimeMillis();
            viewHolder.expire.setVisibility(remain <= 30 * DAY ? View.VISIBLE : View.INVISIBLE);
            viewHolder.expire.setText(remain < 0 ? getString(R.string.activity_certificates_expire0)
                    : remain < DAY ? String.format(getString(R.string.activity_certificates_expire1))
                    : remain < 2 * DAY ? String.format(getString(R.string.activity_certificates_expire2))
                    : String.format(getString(R.string.activity_certificates_expire3), remain / DAY));
            viewHolder.root.setEnabled(remain > 0);
            viewHolder.getConvertView().setTag(certificate);
        }
    }

    class CertificatesItemClickListener extends OnItemClickListener {
        @Override
        public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        }
    }

    class Presenter {
        public void request() {
            final Bundle data = new Bundle();
            //from Response<Integer>
            UserStubEx.getInstance(getBaseContext()).status()
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(response -> {
                        if (response.code() == HttpURLConnection.HTTP_OK)
                            data.putInt("usid", response.body());
                        else
                            onSessionOut();
                    })
                    .doOnNext(response -> onCertificateListReloaded(null))
                    //mapTo Response<List<Language>>
                    .flatMap(response -> {
                        if (response.code() == HttpURLConnection.HTTP_OK)
                            return LanguageStub.getInstance(getBaseContext()).query(
                                    new FilterLogicExpr().existsObject(Certificate.TABLE, new FilterLogicExpr().equalsNumber(Certificate.FIELD_CRUSID, data.getInt("usid")).equalsField(Certificate.FIELD_CRLSID, Language.FIELD_LSID)),
                                    new OrderByListExpr().append(Language.FIELD_LSSORT, true),
                                    new RangeExpr(0L, Long.MAX_VALUE - 1));
                        else
                            return Flowable.never();
                    })
                    //mapTo Language
                    .flatMap(response -> Flowable.fromIterable(response.body()))
                    .subscribeOn(Schedulers.io())
                    //mapTo Response<List<Certificate>>
                    .flatMap(language -> CertificateStub.getInstance(getBaseContext()).query(
                            new FilterLogicExpr().equalsNumber(Certificate.FIELD_CRUSID, data.getInt("usid")).equalsString(Certificate.FIELD_CRLSID, language.getLsid()),
                            new OrderByListExpr().append(Certificate.FIELD_CREXDT, false),
                            new RangeExpr(0L, 1L)))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> onCertificateListAppended(response.body())
                            , throwable -> onError(throwable));
        }
    }
}
