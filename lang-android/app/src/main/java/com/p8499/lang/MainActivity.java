package com.p8499.lang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.root)
    protected LinearLayout root;
    protected Presenter presenter = new Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((TitleFragment) getSupportFragmentManager().findFragmentById(R.id.title)).setTitle(getString(R.string.activity_main_title)).hideBack();
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

    class Presenter {

    }
}
