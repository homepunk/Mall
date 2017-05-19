package homepunk.work.mall.presentation.presenter;

import android.text.TextUtils;

import homepunk.work.mall.domain.interactors.LoginInteractorImpl;
import homepunk.work.mall.domain.interactors.interfaces.LoginInteractor;
import homepunk.work.mall.domain.listeners.LoginListener;
import homepunk.work.mall.domain.model.UserCredentials;
import homepunk.work.mall.presentation.base.BasePresenter;
import homepunk.work.mall.presentation.presenter.interfaces.LoginPresenter;
import homepunk.work.mall.presentation.view.LoginView;
import homepunk.work.mall.presentation.viewmodel.UserViewModel;
import homepunk.work.mall.utils.NavigationUtils;


public class LoginPresenterImpl extends BasePresenter<LoginView> implements LoginPresenter {
    private LoginInteractor loginInteractor;

    @Override
    public void navigateToMallListActivity() {
        NavigationUtils.navigateToHomeScreen(view.getContext());
    }

    @Override
    public void verifyUserAuthentication() {
        if (view != null) {
            loginInteractor = new LoginInteractorImpl(view.getContext());

            if (loginInteractor.isUserAuthenticated()) {
                navigateToMallListActivity();
            }
        }
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
}
