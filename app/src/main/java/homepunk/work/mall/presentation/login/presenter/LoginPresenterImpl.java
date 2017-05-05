package homepunk.work.mall.presentation.login.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import homepunk.work.mall.data.models.UserLogin;
import homepunk.work.mall.data.models.UserLoginCredentials;
import homepunk.work.mall.data.managers.DataManagerImpl;
import homepunk.work.mall.data.managers.interfaces.DataManager;
import homepunk.work.mall.presentation.login.presenter.interfaces.LoginPresenter;
import homepunk.work.mall.presentation.login.view.interfaces.LoginView;
import homepunk.work.mall.presentation.main.views.MallsActivity;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static homepunk.work.mall.data.Constants.SerializedNames.User.USER_KEY_ID;


public class LoginPresenterImpl implements LoginPresenter {
    private LoginView view;
    private DataManager moduleManager;

    public LoginPresenterImpl() {
        this.moduleManager = new DataManagerImpl();
    }

    @Override
    public void init(LoginView view) {
        this.view = view;
    }

    @Override
    public void navigateToMainScreen(UserLogin user) {
        Context context = view.getContext();
        Intent intent = new Intent(context, MallsActivity.class);

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
            moduleManager.getRemoteManagers()
                    .getRemoteRepository()
                    .login(new UserLoginCredentials(email, password))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleSubscriber<UserLogin>() {
                        @Override
                        public void onSuccess(UserLogin user) {
                            if (view != null) {
                                view.onLoginSuccess(user);
                                view.showProgressDialog(false);

                                moduleManager.getLocalManagers()
                                        .getPreferencesHelper()
                                        .storeAccessToken(user.getToken());
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
