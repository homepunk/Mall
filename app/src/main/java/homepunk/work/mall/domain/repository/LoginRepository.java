package homepunk.work.mall.domain.repository;

import homepunk.work.mall.presentation.model.UserLogin;
import homepunk.work.mall.presentation.model.UserLoginCredentials;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface LoginRepository {
    Single<UserLogin> login(UserLoginCredentials loginCredentials);
}
