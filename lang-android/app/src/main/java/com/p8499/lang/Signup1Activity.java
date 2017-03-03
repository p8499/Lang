package com.p8499.lang;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.litesuits.common.utils.BitmapUtil;
import com.p8499.lang.gen.bean.Usercreation;
import com.p8499.lang.gen.mask.UsercreationMask;
import com.p8499.lang.gen.stub.UsercreationStub;

import java.net.HttpURLConnection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import polanski.option.Option;

public class Signup1Activity extends AppCompatActivity {
    @BindView(R.id.root)
    protected LinearLayout root;
    @BindView(R.id.ic_phone)
    protected ImageView icPhone;
    @BindView(R.id.phone)
    protected TextView phone;
    @BindView(R.id.initialize)
    protected Button initialize;
    @BindView(R.id.ct_pv)
    protected RelativeLayout ctPv;
    @BindView(R.id.ic_pv)
    protected ImageView icPv;
    @BindView(R.id.pv)
    protected EditText pv;
    @BindView(R.id.ct_mv)
    protected RelativeLayout ctMv;
    @BindView(R.id.ic_mv)
    protected ImageView icMv;
    @BindView(R.id.mv)
    protected EditText mv;
    @BindView(R.id.verify)
    protected Button verify;
    protected Presenter presenter = new Presenter();
    protected Integer ucid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);
        ButterKnife.bind(this);
        ((TitleFragment) getSupportFragmentManager().findFragmentById(R.id.title)).setTitle(getString(R.string.activity_signup1_title)).hideAccount();
        processIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        processIntent(getIntent());
    }

    protected void processIntent(Intent intent) {
    }

    @OnTextChanged(value = R.id.phone, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void onPhoneChanged(Editable editable) {
        if (Utils.cellPattern.matcher(editable.toString()).matches())
            initialize.setVisibility(View.VISIBLE);
        else
            initialize.setVisibility(View.GONE);
    }

    @OnClick(R.id.initialize)
    public void onInitializeClick(View view) {
        presenter.initilaize();
    }

    @OnClick(R.id.ic_pv)
    public void onIcpvClick() {
        SignuppvDialog dialog = new SignuppvDialog(this, R.style.DialogTheme_Center_Transparent);
        dialog.setCancelable(true);
        dialog.show();
    }

    @OnTextChanged(value = R.id.pv, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void onPvChanged(Editable editable) {
        if (editable.length() == 6) {
            presenter.send(ucid, editable.toString());
        }
    }

    @OnClick(R.id.verify)
    public void onVerifyClick(View view) {
        presenter.verify(ucid, mv.getText().toString());
    }

    public void onInitialized(Integer ucid) {
        this.ucid = ucid;
        phone.setEnabled(false);
        initialize.setEnabled(false);
        ctPv.setVisibility(View.VISIBLE);
    }

    public void onSent() {
        pv.setEnabled(false);
        icPv.setClickable(false);
        ctMv.setVisibility(View.VISIBLE);
        verify.setEnabled(true);
    }

    public void onVerified() {
        finish();
        Intent intent = new Intent(this, Signup2Activity.class);
        intent.putExtra("uscell", phone.getText().toString());
        startActivity(intent);
    }

    public void onConflict() {
        Snackbar.make(root, R.string.activity_signup1_conflict, Snackbar.LENGTH_LONG).show();
    }

    public void onForbidden() {
        Snackbar.make(root, R.string.activity_signup1_forbidden, Snackbar.LENGTH_LONG).show();
    }

    public void onIncorrect() {
        Snackbar.make(root, R.string.activity_signup1_incorrect, Snackbar.LENGTH_LONG).show();
    }

    public void onTimeout() {
        Snackbar.make(root, R.string.activity_signup1_timeout, Snackbar.LENGTH_LONG).show();
    }

    public void onError(Throwable t) {
        t.printStackTrace();
        Snackbar.make(root, R.string.activity_signup1_error, Snackbar.LENGTH_LONG).show();
    }

    class Presenter {
        public void initilaize() {
            //from Response<Usercreation>
            UsercreationStub.getInstance(getBaseContext()).add(new Usercreation().setUccell(phone.getText().toString()))
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(response -> {
                        if (response.code() == HttpURLConnection.HTTP_OK)
                            onInitialized(response.body().getUcid());
                        else if (response.code() == HttpURLConnection.HTTP_CONFLICT)
                            onConflict();
                        else if (response.code() == HttpURLConnection.HTTP_FORBIDDEN)
                            onForbidden();
                    })
                    //mapTo Response<ResponseBody>
                    .flatMap(response -> {
                        if (response.code() == HttpURLConnection.HTTP_OK)
                            return UsercreationStub.getInstance(getBaseContext()).downloadAttach(response.body().getUcid(), "captcha.png");
                        else return Flowable.never();
                    })
                    //mapTo Option<Bitmap>
                    .flatMap(response -> {
                        if (response.code() == HttpURLConnection.HTTP_OK)
                            return Flowable.just(Option.ofObj(BitmapUtil.byteToBitmap(response.body().bytes())));
                        else
                            return Flowable.just(Option.ofObj((Bitmap) null));
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .doOnNext(option -> option
                            .matchAction(bitmap -> BitmapUtil.saveBitmap(bitmap, Utils.getPvThumbnailPath(getBaseContext())), () -> {
                            }))
                    .subscribe(response -> {
                    }, throwable -> onError(throwable));
        }

        public void send(int ucid, String ucpv) {
            UsercreationStub.getInstance(getBaseContext()).update(new Usercreation().setUcid(ucid).setUcpv(ucpv).setUcac(Usercreation.UCAC_SENT), new UsercreationMask().setUcac(true))
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(response -> {
                        if (response.code() == HttpURLConnection.HTTP_OK)
                            onSent();
                        else if (response.code() == HttpURLConnection.HTTP_NOT_FOUND)
                            onTimeout();
                        else if (response.code() == HttpURLConnection.HTTP_FORBIDDEN)
                            onIncorrect();
                    })
                    .subscribe(response -> {
                    }, throwable -> onError(throwable));
        }

        public void verify(int ucid, String ucmv) {
            UsercreationStub.getInstance(getBaseContext()).update(new Usercreation().setUcid(ucid).setUcmv(ucmv).setUcac(Usercreation.UCAC_VERIFIED), new UsercreationMask().setUcac(true))
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(response -> {
                        if (response.code() == HttpURLConnection.HTTP_OK)
                            onVerified();
                        else if (response.code() == HttpURLConnection.HTTP_NOT_FOUND)
                            onTimeout();
                        else if (response.code() == HttpURLConnection.HTTP_FORBIDDEN)
                            onIncorrect();
                    })
                    .subscribe(response -> {
                    }, throwable -> onError(throwable));
        }
    }
}
