package homepunk.work.mall.data.rest.repository.interfaces;

import homepunk.work.mall.presentations.login.models.LoginCredentials;
import homepunk.work.mall.presentations.login.models.LoginUser;
import rx.Single;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface IMallApiRepository {
    Single<LoginUser> loginByCredentials(LoginCredentials credentials);
}
