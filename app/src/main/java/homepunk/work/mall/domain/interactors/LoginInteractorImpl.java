package homepunk.work.mall.domain.interactors;

import android.content.Context;

import homepunk.work.mall.data.repository.LoginRepositoryImpl;
import homepunk.work.mall.domain.interactors.interfaces.LoginInteractor;
import homepunk.work.mall.domain.listeners.LoginListener;
import homepunk.work.mall.domain.model.UserCredentials;
import homepunk.work.mall.domain.repository.LoginRepository;
import homepunk.work.mall.presentation.viewmodel.UserViewModel;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class LoginInteractorImpl implements LoginInteractor {
    private LoginRepository loginRepository;

    public LoginInteractorImpl(Context context) {
        this.loginRepository = new LoginRepositoryImpl(context);
    }

    @Override
    public void login(UserCredentials loginCredentials, LoginListener listener) {
        loginRepository.login(loginCredentials)
                       .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<UserViewModel>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onSuccess(UserViewModel userViewModel) {
                                listener.onLoginSuccess(userViewModel);
                            }

                            @Override
                            public void onError(Throwable error) {
                                listener.onLoginFailed(error);
                            }
                        });
    }

    @Override
    public boolean isUserAuthenticated() {
        return loginRepository.isUserAuthenticated();
    }
}