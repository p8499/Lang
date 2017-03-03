package com.p8499.lang;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.litesuits.common.utils.BitmapUtil;
import com.p8499.lang.gen.stub.UserStub;
import com.p8499.lang.stubex.UserStubEx;

import java.net.HttpURLConnection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import polanski.option.Option;

public class TitleFragment extends Fragment {
    @BindView(R.id.root)
    protected RelativeLayout root;
    @BindView(R.id.back)
    protected ImageView back;
    @BindView(R.id.title)
    protected TextView title;
    @BindView(R.id.account)
    protected LinearLayout account;
    @BindView(R.id.signin)
    protected ImageView signin;
    @BindView(R.id.profile)
    protected CircleImageView profile;
    @BindView(R.id.signup)
    protected ImageView signup;
    protected Presenter presenter = new Presenter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.request();
    }

    @OnClick(R.id.back)
    public void onBackClick(View view) {
        getActivity().finish();
    }

    @OnClick(R.id.signin)
    public void onSigninClick(View view) {
        Intent intent = new Intent(getActivity(), SigninActivity.class);
        getActivity().startActivity(intent);
    }

    @OnClick(R.id.profile)
    public void onProfileClick(View view) {
        Intent intent = new Intent(getActivity(), ProfileActivity.class);
        getActivity().startActivity(intent);
    }

    @OnClick(R.id.signup)
    public void onSignupClick(View view) {
        Intent intent = new Intent(getActivity(), Signup1Activity.class);
        getActivity().startActivity(intent);
    }

    public CharSequence getTitle() {
        return title.getText();
    }

    public TitleFragment setTitle(CharSequence t) {
        title.setText(t);
        return this;
    }

    public TitleFragment hideBack() {
        back.setVisibility(View.GONE);
        return this;
    }

    public TitleFragment displayBack() {
        back.setVisibility(View.VISIBLE);
        return this;
    }

    public TitleFragment hideAccount() {
        account.setVisibility(View.GONE);
        return this;
    }

    public TitleFragment displayAccount() {
        account.setVisibility(View.VISIBLE);
        return this;
    }

    public TitleFragment hideSignup() {
        signup.setVisibility(View.GONE);
        return this;
    }

    public TitleFragment displaySignup() {
        signup.setVisibility(View.VISIBLE);
        return this;
    }

    public void onSessionIn() {
        profile.setVisibility(View.VISIBLE);
        signin.setVisibility(View.GONE);
    }

    public void onSessionOut() {
        profile.setVisibility(View.GONE);
        signin.setVisibility(View.VISIBLE);
    }

    public void onPortrait(Bitmap bitmap) {
        if (bitmap != null)
            profile.setImageBitmap(bitmap);
        else
            profile.setImageResource(R.drawable.ic_face_white_48dp);
    }

    public void onError(Throwable throwable) {
        Snackbar.make(root, R.string.fragment_title_error, Snackbar.LENGTH_LONG).show();
    }

    class Presenter {
        public void request() {
            final Bundle data = new Bundle();
            //from Response<Integer>
            UserStubEx.getInstance(getContext()).status()
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(response -> {
                        if (response.code() == HttpURLConnection.HTTP_OK) {
                            data.putInt("usid", response.body());
                            onSessionIn();
                        } else onSessionOut();
                    })
                    //mapTo Option<Bitmap>
                    .flatMap(response -> {
                        if (response.code() == HttpURLConnection.HTTP_OK && Utils.getPortraitThumbnailPath(getContext()).exists())
                            return Flowable.just(Option.ofObj(BitmapFactory.decodeFile(Utils.getPortraitThumbnailPath(getContext()).getAbsolutePath())));
                        else if (response.code() == HttpURLConnection.HTTP_OK)
                            return Flowable.just(Option.ofObj((Bitmap) null));
                        else
                            return Flowable.never();
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(option -> option.ifSome(bitmap -> onPortrait(bitmap)))
                    //mapTo Response<ResponseBody>
                    .flatMap(option -> option
                            .match(bitmap -> Flowable.never(),
                                    () -> UserStub.getInstance(getContext()).downloadAttach(data.getInt("usid"), "portrait-thumbnail.png")))
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
                            .matchAction(bitmap -> BitmapUtil.saveBitmap(bitmap, Utils.getPortraitThumbnailPath(getContext())), () -> {
                            }))
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(option -> option
                            .matchAction(bitmap -> onPortrait(bitmap),
                                    () -> onPortrait(null)))
                    .subscribe(option -> {
                    }, throwable -> onError(throwable));
        }
    }
}
