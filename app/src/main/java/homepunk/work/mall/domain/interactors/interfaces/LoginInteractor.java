package homepunk.work.mall.domain.interactors.interfaces;

import homepunk.work.mall.data.models.UserLoginCredentials;
import homepunk.work.mall.domain.listeners.LoginListener;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface LoginInteractor {
    void login(UserLoginCredentials loginCredentials, LoginListener listener);
}
