package com.p8499.lang;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.p8499.lang.gen.FilterLogicExpr;
import com.p8499.lang.gen.OrderByListExpr;
import com.p8499.lang.gen.RangeExpr;
import com.p8499.lang.gen.bean.Language;
import com.p8499.lang.gen.stub.LanguageStub;
import com.p8499.lang.gen.view.LanguageListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * Created by Administrator on 3/1/2017.
 */

public class LanguagesDialog extends AppCompatDialog implements LanguageListView, SwipeRefreshLayout.OnRefreshListener, SearchView.OnQueryTextListener {
    @BindView(R.id.root)
    protected LinearLayout root;
    @BindView(R.id.search)
    protected SearchView search;
    @BindView(R.id.recycler)
    protected RecyclerView recycler;
    protected Predicate<Language> selection;
    protected Consumer<Language> onSelect;
    protected Presenter presenter = new Presenter();

    public LanguagesDialog(Context context) {
        super(context);
    }

    public LanguagesDialog(Context context, int theme) {
        super(context, theme);
    }

    protected LanguagesDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.setWindowGravity(getWindow(), Gravity.BOTTOM);
        setContentView(R.layout.dialog_languages);
        ButterKnife.bind(this);
        search.setIconifiedByDefault(false);
        search.setSubmitButtonEnabled(false);
        search.setOnQueryTextListener(this);
        Adapter adapter = new Adapter();
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.addOnItemTouchListener(new ItemClickListener());
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.request();
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        presenter.request();
        return true;
    }

    @Override
    public void onRefresh() {
        Adapter adapter = (Adapter) recycler.getAdapter();
        adapter.setEnableLoadMore(false);
        presenter.request();
    }

    public LanguagesDialog setSelection(Predicate<Language> predicate) {
        selection = predicate;
        return this;
    }

    public LanguagesDialog setOnSelect(Consumer<Language> consumer) {
        onSelect = consumer;
        return this;
    }

    @Override
    public void onLanguageListReloaded(List<Language> languageList) {
        Adapter adapter = (Adapter) recycler.getAdapter();
        adapter.setNewData(languageList);
        adapter.loadMoreEnd();
    }

    @Override
    public void onLanguageListAppended(List<Language> languageList) {
    }

    class ViewHolder extends BaseViewHolder {
        @BindView(R.id.root)
        protected LinearLayout root;
        @BindView(R.id.name)
        protected TextView name;
        @BindView(R.id.loc)
        protected TextView loc;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    class Adapter extends BaseQuickAdapter<Language, ViewHolder> {
        public Adapter() {
            super(R.layout.dialog_languages_recycler, null);
        }

        @Override
        protected ViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(getItemView(mLayoutResId, parent));
        }

        @Override
        protected void convert(ViewHolder viewHolder, Language language) {
            try {
                viewHolder.root.setSelected(selection != null && selection.test(language));
            } catch (Exception e) {
                e.printStackTrace();
            }
            String query = search.getQuery().toString();
            if (query.length() > 0 && language.getLsname().contains(query)) {
                SpannableStringBuilder styled = new SpannableStringBuilder(language.getLsname());
                int start = language.getLsname().indexOf(query);
                styled.setSpan(new BackgroundColorSpan(Color.YELLOW), start, start + query.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                viewHolder.name.setText(styled);
            } else
                viewHolder.name.setText(language.getLsname());
            if (query.length() > 0 && language.getLsloc().contains(query)) {
                SpannableStringBuilder styled = new SpannableStringBuilder(language.getLsloc());
                int start = language.getLsloc().indexOf(query);
                styled.setSpan(new BackgroundColorSpan(Color.YELLOW), start, start + query.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                viewHolder.loc.setText(styled);
            } else
                viewHolder.loc.setText(language.getLsloc());
            viewHolder.getConvertView().setTag(language);
        }
    }

    class ItemClickListener extends OnItemClickListener {
        @Override
        public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
            if (onSelect != null)
                try {
                    onSelect.accept(((Adapter) baseQuickAdapter).getItem(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            dismiss();
        }
    }

    class Presenter {
        public void request() {
            LanguageStub.getInstance(getContext()).query(new FilterLogicExpr(FilterLogicExpr.OP_OR)
                    .containsString(Language.FIELD_LSNAME, search.getQuery().toString())
                    .containsString(Language.FIELD_LSLOC, search.getQuery().toString()), new OrderByListExpr().append(Language.FIELD_LSSORT, true), new RangeExpr(0L, Long.MAX_VALUE - 1))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> onLanguageListReloaded(response.body()), throwable -> {
                    });
        }
    }
}
