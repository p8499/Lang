package com.p8499.lang;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import polanski.option.Option;

/**
 * Created by Administrator on 3/1/2017.
 */

public class SignuppvDialog extends AppCompatDialog {
    @BindView(R.id.root)
    protected LinearLayout root;
    @BindView(R.id.iv_pv)
    protected ImageView ivPv;
    protected Presenter presenter = new Presenter();

    public SignuppvDialog(Context context) {
        super(context);
    }

    public SignuppvDialog(Context context, int theme) {
        super(context, theme);
    }

    protected SignuppvDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_signuppv);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.request();
    }

    @OnClick(R.id.root)
    public void onRootClick(View view) {
        dismiss();
    }

    public void onImage(Bitmap bitmap) {
        ivPv.setImageBitmap(bitmap);
    }

    class Presenter {
        public void request() {
            Flowable.just(Option.ofObj(BitmapFactory.decodeFile(Utils.getPvThumbnailPath(getContext()).getAbsolutePath())))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(option ->
                            option.ifSome(bitmap -> onImage(bitmap)), throwable -> {
                    });
        }
    }
}
