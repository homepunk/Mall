package homepunk.work.mall.domain.interactors;

import homepunk.work.mall.data.models.UserLogin;
import homepunk.work.mall.data.models.UserLoginCredentials;
import homepunk.work.mall.data.repository.LoginRepositoryImpl;
import homepunk.work.mall.domain.interactors.interfaces.LoginInteractor;
import homepunk.work.mall.domain.listeners.LoginListener;
import homepunk.work.mall.domain.repositorys.LoginRepository;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<UserLogin>() {
                    @Override
                    public void onSuccess(UserLogin user) {
                        listener.onLoginSuccess(user);
                    }

                    @Override
                    public void onError(Throwable error) {
                        listener.onLoginFailed(error);
                    }
                });
    }
}
