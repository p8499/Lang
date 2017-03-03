package com.p8499.lang;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.litesuits.common.utils.BitmapUtil;
import com.p8499.lang.gen.FilterLogicExpr;
import com.p8499.lang.gen.RangeListExpr;
import com.p8499.lang.gen.bean.Certificate;
import com.p8499.lang.gen.bean.Language;
import com.p8499.lang.gen.bean.User;
import com.p8499.lang.gen.mask.UserMask;
import com.p8499.lang.gen.stub.LanguageStub;
import com.p8499.lang.gen.stub.UserStub;
import com.p8499.lang.gen.view.UserView;
import com.p8499.lang.stubex.UserStubEx;

import java.net.HttpURLConnection;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import polanski.option.Option;

public class ProfileActivity extends AppCompatActivity implements UserView {
    @BindView(R.id.root)
    protected LinearLayout root;
    @BindView(R.id.ct_user)
    protected RelativeLayout ctUser;
    @BindView(R.id.portrait)
    protected CircleImageView portrait;
    @BindView(R.id.edit_cell)
    protected ImageView editCell;
    @BindView(R.id.cell)
    protected EditText cell;
    @BindView(R.id.edit_name)
    protected ImageView editName;
    @BindView(R.id.name)
    protected EditText name;
    @BindView(R.id.ct_favlang)
    protected RelativeLayout ctFavlang;
    @BindView(R.id.favlang)
    protected TextView favlang;
    @BindView(R.id.mycerti)
    protected TextView mycerti;
    protected Presenter presenter = new Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        ((TitleFragment) getSupportFragmentManager().findFragmentById(R.id.title)).setTitle(getString(R.string.activity_profile_title)).hideAccount();
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

    @OnClick(R.id.signout)
    public void onSignoutClick(View view) {
        presenter.signout();
    }

    @OnClick(R.id.ct_favlang)
    public void onFavlangClick(View view) {
        LanguagesDialog dialog = new LanguagesDialog(this, R.style.DialogTheme_Bottom_Default);
        dialog.setSelection(language -> ctUser.getTag() != null && ((User) ctUser.getTag()).getUslsid().equals(language.getLsid()));
        dialog.setOnSelect(language -> {
            favlang.setText(language.getLsname());
            ((User) ctUser.getTag()).setUslsid(language.getLsid()).setUslsname(language.getLsname());
            presenter.saveFavlang();
        });
        dialog.show();
    }

    @OnClick(R.id.ct_mycerti)
    public void onMycertiClick(View view) {
        Intent intent = new Intent(this, CertificatesActivity.class);
        startActivity(intent);
    }

    public void onSessionOut() {
        finish();
    }

    @Override
    public void onUser(User user) {
        cell.setText(user.getUscell());
        name.setText(user.getUsname());
        favlang.setText(user.getUslsname());
        ctUser.setTag(user);
    }

    public void onCertificatCount(Long cnt) {
        mycerti.setText(String.valueOf(cnt));
    }

    public void onPortrait(Bitmap bitmap) {
        if (bitmap != null)
            portrait.setImageBitmap(bitmap);
        else
            portrait.setImageResource(R.drawable.ic_face_muted_48dp);
    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        Snackbar.make(root, R.string.activity_profile_error, Snackbar.LENGTH_LONG).show();
    }

    class Presenter {
        private FilterLogicExpr filterLanguage(Integer usid) {
            return new FilterLogicExpr().existsObject(Certificate.TABLE,
                    new FilterLogicExpr().equalsNumber(Certificate.FIELD_CRUSID, usid).gtDate(Certificate.FIELD_CREXDT, new Date()).equalsField(Certificate.FIELD_CRLSID, Language.FIELD_LSID));
        }

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
                    //mapTo Response<User>
                    .flatMap(response -> {
                        if (response.code() == HttpURLConnection.HTTP_OK)
                            return UserStub.getInstance(getBaseContext()).get(data.getInt("usid"));
                        else
                            return Flowable.never();
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(response -> onUser(response.body()))
                    //mapTo Response<Void>
                    .flatMap(response -> LanguageStub.getInstance(getBaseContext()).count(filterLanguage(data.getInt("usid"))))
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(response -> onCertificatCount(RangeListExpr.parseTotal(response.headers().get("Content-Range"))))
                    //mapTo Option<Bitmap>
                    .flatMap(response -> {
                        if (Utils.getPortraitThumbnailPath(getBaseContext()).exists())
                            return Flowable.just(Option.ofObj(BitmapFactory.decodeFile(Utils.getPortraitThumbnailPath(getBaseContext()).getAbsolutePath())));
                        else
                            return Flowable.just(Option.ofObj((Bitmap) null));
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(option -> option.ifSome(bitmap -> onPortrait(bitmap)))
                    //mapTo Response<ResponseBody>
                    .flatMap(option -> option
                            .match(bitmap -> Flowable.never(),
                                    () -> UserStub.getInstance(getBaseContext()).downloadAttach(data.getInt("usid"), "portrait-thumbnail.png")))
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
                            .matchAction(bitmap -> BitmapUtil.saveBitmap(bitmap, Utils.getPortraitThumbnailPath(getBaseContext())), () -> {
                            }))
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(option -> option
                            .matchAction(bitmap -> onPortrait(bitmap),
                                    () -> onPortrait(null)))
                    .subscribe(option -> {
                    }, throwable -> onError(throwable));
        }

        public void saveFavlang() {
            UserStub.getInstance(getBaseContext()).update((User) ctUser.getTag(), new UserMask().setUslsid(true))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> {
                    }, throwable -> onError(throwable));
        }

        public void signout() {
            UserStubEx.getInstance(getBaseContext()).signout()
                    .subscribe(response -> onSessionOut(),
                            throwable -> onError(throwable));
        }
    }
}
