package homepunk.work.mall.domain.listeners;

import homepunk.work.mall.presentation.viewmodel.UserLoginViewModel;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface LoginListener {
    void onLoginSuccess(UserLoginViewModel user);

    void onLoginFailed(Throwable error);
}
