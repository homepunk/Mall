package homepunk.work.mall.presentations.login.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import homepunk.work.mall.data.rest.repository.interfaces.IMallApiRepository;
import homepunk.work.mall.data.rest.repository.MallApiRepository;
import homepunk.work.mall.presentations.login.models.LoginCredentials;
import homepunk.work.mall.presentations.login.models.UserLogin;
import homepunk.work.mall.presentations.login.presenter.interfaces.ILoginPresenter;
import homepunk.work.mall.presentations.login.view.interfaces.ILoginView;
import homepunk.work.mall.presentations.main.view.MainMallsActivity;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static homepunk.work.mall.data.Constants.USER_KEY_ID;


public class LoginPresenter implements ILoginPresenter {
    private ILoginView view;
    private IMallApiRepository mallApiRepository;

    public LoginPresenter() {
        this.mallApiRepository = new MallApiRepository();
    }

    @Override
    public void setView(ILoginView view) {
        this.view = view;
    }

    @Override
    public void navigateToHomeScreen(UserLogin user) {
        Context context = view.getContext();
        Intent intent = new Intent(context, MainMallsActivity.class);

        intent.putExtra(USER_KEY_ID, user);

        context.startActivity(intent);
    }

    @Override
    public void login(String email, String password) {
        if (view == null) {
            return;
        }

        boolean error = false;
        view.showProgressDialog(true);

        if (TextUtils.isEmpty(email) || email.length() < 3) {
            error = true;
            view.onEmailError();
            view.showProgressDialog(false);
        }

        if (TextUtils.isEmpty(password) || password.length() < 4) {
            error = true;
            view.onPasswordError();
            view.showProgressDialog(false);
        }

        if (!error) {
            mallApiRepository
                    .loginByCredentials(new LoginCredentials(email, password))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleSubscriber<UserLogin>() {
                        @Override
                        public void onSuccess(UserLogin user) {
                            if (view != null) {
                                view.onLoginSuccess(user);
                                view.showProgressDialog(false);
                            }
                        }

                        @Override
                        public void onError(Throwable error) {
                            if (view != null) {
                                view.onLoginError(error.getLocalizedMessage());
                                view.showProgressDialog(false);
                            }
                        }
                    });
        }
    }
}
