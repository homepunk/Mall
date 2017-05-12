package homepunk.work.mall.domain.listeners;

import homepunk.work.mall.presentation.viewmodel.UserViewModel;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface LoginListener {
    void onLoginSuccess(UserViewModel user);

    void onLoginFailed(Throwable error);
}
