package homepunk.work.mall.domain.interactors;

import homepunk.work.mall.data.repository.LoginRepositoryImpl;
import homepunk.work.mall.domain.interactors.interfaces.LoginInteractor;
import homepunk.work.mall.domain.listeners.LoginListener;
import homepunk.work.mall.domain.repository.LoginRepository;
import homepunk.work.mall.presentation.viewmodel.UserLoginViewModel;
import homepunk.work.mall.domain.model.UserLoginCredentials;
import homepunk.work.mall.utils.RxUtils;
import rx.SingleSubscriber;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class LoginInteractorImpl implements LoginInteractor {
    private LoginRepository loginRepository;

    public LoginInteractorImpl() {
        this.loginRepository = new LoginRepositoryImpl();
    }

    @Override
    public void login(UserLoginCredentials loginCredentials, LoginListener listener) {
        loginRepository
                .login(loginCredentials)
                .compose(RxUtils.applyIOSchedulers())
                .subscribe(new SingleSubscriber<UserLoginViewModel>() {
                    @Override
                    public void onSuccess(UserLoginViewModel value) {
                        listener.onLoginSuccess(value);
                    }

                    @Override
                    public void onError(Throwable error) {
                        listener.onLoginFailed(error);
                    }
                });
    }
}
