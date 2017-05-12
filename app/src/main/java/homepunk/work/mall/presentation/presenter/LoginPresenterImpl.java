package homepunk.work.mall.presentation.presenter;

import android.content.Intent;
import android.text.TextUtils;

import homepunk.work.mall.domain.interactors.LoginInteractorImpl;
import homepunk.work.mall.domain.interactors.interfaces.LoginInteractor;
import homepunk.work.mall.domain.listeners.LoginListener;
import homepunk.work.mall.domain.model.UserCredentials;
import homepunk.work.mall.presentation.presenter.interfaces.LoginPresenter;
import homepunk.work.mall.presentation.service.MallSyncService;
import homepunk.work.mall.presentation.view.LoginView;
import homepunk.work.mall.presentation.viewmodel.UserViewModel;
import homepunk.work.mall.utils.NavigationUtils;


public class LoginPresenterImpl implements LoginPresenter {
    private LoginView view;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl() {
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void init(LoginView view) {
        this.view = view;
    }

    @Override
    public void navigateToMainScreen(UserViewModel user) {
        NavigationUtils.navigateToHomeScreen(view.getContext(), user);
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
            loginInteractor.login(new UserCredentials(email, password), new LoginListener() {
                @Override
                public void onLoginSuccess(UserViewModel user) {
                    if (view != null) {
                        view.onLoginSuccess(user);
                        view.showProgressDialog(false);

                        startSyncService();
                    }
                }

                @Override
                public void onLoginFailed(Throwable error) {
                    if (view != null) {
                        view.onLoginError(error.getLocalizedMessage());
                        view.showProgressDialog(false);
                    }
                }
            });
        }
    }

    private void startSyncService() {
        if (view != null) {
            Intent intent = new Intent(view.getContext(), MallSyncService.class);

            view.getContext().startService(intent);
        }
    }
}
