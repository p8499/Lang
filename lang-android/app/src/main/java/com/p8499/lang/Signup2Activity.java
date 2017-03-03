package com.p8499.lang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.p8499.lang.gen.bean.Language;
import com.p8499.lang.gen.bean.User;
import com.p8499.lang.gen.stub.UserStub;

import java.net.HttpURLConnection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by Administrator on 3/2/2017.
 */

public class Signup2Activity extends AppCompatActivity {
    @BindView(R.id.root)
    protected LinearLayout root;
    @BindView(R.id.phone)
    protected EditText phone;
    @BindView(R.id.name)
    protected EditText name;
    @BindView(R.id.pass)
    protected EditText pass;
    @BindView(R.id.eyeon)
    protected ImageView eyeon;
    @BindView(R.id.eyeoff)
    protected ImageView eyeoff;
    @BindView(R.id.pass2)
    protected EditText pass2;
    @BindView(R.id.eyeon2)
    protected ImageView eyeon2;
    @BindView(R.id.eyeoff2)
    protected ImageView eyeoff2;
    @BindView(R.id.favlang)
    protected EditText favlang;
    @BindView(R.id.finalize)
    protected Button finalize;
    protected Presenter presenter = new Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        ButterKnife.bind(this);
        ((TitleFragment) getSupportFragmentManager().findFragmentById(R.id.title)).setTitle(getString(R.string.activity_signup2_title)).hideAccount();
        processIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        processIntent(getIntent());
    }

    protected void processIntent(Intent intent) {
        phone.setText(intent.getStringExtra("uscell"));
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

    @OnClick(R.id.eyeon2)
    public void onEyeOn2Click(View view) {
        eyeon2.setVisibility(View.INVISIBLE);
        eyeoff2.setVisibility(View.VISIBLE);
        pass2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        pass2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    @OnClick(R.id.eyeoff2)
    public void onEyeOff2Click(View view) {
        eyeon2.setVisibility(View.VISIBLE);
        eyeoff2.setVisibility(View.INVISIBLE);
        pass2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        pass2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
    }

    @OnClick(R.id.favlang)
    public void onFavlangClick(View view) {
        LanguagesDialog dialog = new LanguagesDialog(this, R.style.DialogTheme_Bottom_Default);
        dialog.setSelection(language -> favlang.getTag() != null && ((Language) favlang.getTag()).getLsid().equals(language.getLsid()));
        dialog.setOnSelect(language -> {
            favlang.setText(language.getLsname());
            favlang.setTag(language);
        });
        dialog.show();
    }

    @OnClick(R.id.finalize)
    public void onFinalizeClick(View view) {
        if (name.getText().length() == 0)
            Snackbar.make(root, R.string.activity_signup2_noname, Snackbar.LENGTH_LONG).show();
        else if (pass.getText().length() < 4)
            Snackbar.make(root, R.string.activity_singup2_shortpass, Snackbar.LENGTH_LONG).show();
        else if (!pass.getText().toString().equals(pass2.getText().toString()))
            Snackbar.make(root, R.string.activity_signup2_mismatch, Snackbar.LENGTH_LONG).show();
        else if (favlang.getText().length() == 0)
            Snackbar.make(root, R.string.activity_signup2_nolang, Snackbar.LENGTH_LONG).show();
        else presenter.add();
    }

    public void onFinalized() {
        Snackbar.make(root, R.string.activity_signup2_success, Snackbar.LENGTH_LONG).show();
        SharedPreferences.Editor editor = Utils.getPreferenceCredential(getBaseContext()).edit();
        editor.putString("uscell", phone.getText().toString());
        editor.commit();
        finish();
    }

    public void onTimeout() {
        Snackbar.make(root, R.string.activity_signup2_timeout, Snackbar.LENGTH_LONG).show();
    }

    public void onError(Throwable t) {
        t.printStackTrace();
        Snackbar.make(root, R.string.activity_signup2_error, Snackbar.LENGTH_LONG).show();
    }

    class Presenter {
        public void add() {
            UserStub.getInstance(getBaseContext()).add(new User(
                    null, phone.getText().toString(), pass.getText().toString(), name.getText().toString(), null, ((Language) (favlang.getTag())).getLsid(), null))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> {
                        if (response.code() == HttpURLConnection.HTTP_OK)
                            onFinalized();
                        else if (response.code() == HttpURLConnection.HTTP_NOT_FOUND)
                            onTimeout();
                    }, throwable -> onError(throwable));
        }
    }
}
