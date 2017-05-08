package homepunk.work.mall.domain.listeners;

import homepunk.work.mall.data.models.UserLogin;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface LoginListener {
    void onLoginSuccess(UserLogin user);

    void onLoginFailed(Throwable error);
}
