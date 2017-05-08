package homepunk.work.mall.data.repository.datasource.remote.interfaces;

import homepunk.work.mall.data.models.UserLogin;
import homepunk.work.mall.data.models.UserLoginCredentials;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface LoginDataSource {
    Single<UserLogin> login(UserLoginCredentials loginCredentials);
}
