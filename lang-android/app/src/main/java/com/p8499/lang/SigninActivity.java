package com.p8499.lang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.p8499.lang.stubex.UserStubEx;

import java.net.HttpURLConnection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SigninActivity extends AppCompatActivity {
    @BindView(R.id.root)
    protected LinearLayout root;
    @BindView(R.id.phone)
    protected EditText phone;
    @BindView(R.id.pass)
    protected EditText pass;
    @BindView(R.id.eyeon)
    protected ImageView eyeon;
    @BindView(R.id.eyeoff)
    protected ImageView eyeoff;
    protected Presenter presenter = new Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);
        ((TitleFragment) getSupportFragmentManager().findFragmentById(R.id.title)).setTitle(getString(R.string.activity_signin_title)).hideAccount().displaySignup();
        processIntent(getIntent());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (phone.getText().length() == 0)
            phone.setText(Utils.getPreferenceCredential(getBaseContext()).getString("uscell", ""));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        processIntent(getIntent());
    }

    protected void processIntent(Intent intent) {
    }

    @OnClick(R.id.eyeon)
    public void onEyeOnClick(View view) {
        eyeon.setVisibility(View.INVISIBLE);
        eyeoff.setVisibility(View.VISIBLE);
        pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    @OnClick(R.id.eyeoff)
    public void onEyeOffClick(View view) {
        eyeon.setVisibility(View.VISIBLE);
        eyeoff.setVisibility(View.INVISIBLE);
        pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
    }

    @OnClick(R.id.submit)
    public void onSubmitClick(View view) {
        presenter.submit(phone.getText().toString(), pass.getText().toString());
    }

    public void onSuccess() {
        Snackbar.make(root, R.string.activity_signin_success, Snackbar.LENGTH_SHORT).show();
        SharedPreferences.Editor editor = Utils.getPreferenceCredential(getBaseContext()).edit();
        editor.putString("uscell", phone.getText().toString());
        editor.commit();
        finish();
    }

    public void onFail() {
        Snackbar.make(root, R.string.activity_signin_fail, Snackbar.LENGTH_LONG).show();
    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        Snackbar.make(root, R.string.activity_signin_error, Snackbar.LENGTH_LONG).show();
    }

    class Presenter {
        public void submit(String uscell, String uspswd) {
            UserStubEx.getInstance(SigninActivity.this).signin(uscell, uspswd)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> {
                        if (response.code() == HttpURLConnection.HTTP_OK)
                            onSuccess();
                        else
                            onFail();
                    }, throwable -> onError(throwable));
        }
    }
}
