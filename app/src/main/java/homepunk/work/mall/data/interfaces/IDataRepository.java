package homepunk.work.mall.data.interfaces;

import homepunk.work.mall.presentations.login.models.LoginCredentials;
import homepunk.work.mall.presentations.login.models.UserLogin;
import homepunk.work.mall.presentations.main.model.Malls;
import rx.Single;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface IDataRepository {
    Single<UserLogin> loginByCredentials(LoginCredentials credentials);

    Single<Malls> fetchMalls();
}