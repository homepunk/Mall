package homepunk.work.mall.domain.repositorys;

import homepunk.work.mall.data.models.UserLogin;
import homepunk.work.mall.data.models.UserLoginCredentials;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface LoginRepository {
    Single<UserLogin> login(UserLoginCredentials loginCredentials);
}
