package homepunk.work.mall.domain.interactors.interfaces;

import homepunk.work.mall.domain.model.UserCredentials;
import homepunk.work.mall.domain.listeners.LoginListener;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface LoginInteractor {
    void login(UserCredentials loginCredentials, LoginListener listener);

    boolean isUserAuthenticated();
}
