package homepunk.work.mall.data.remote.repository.interfaces;

import homepunk.work.mall.presentations.login.models.LoginCredentials;
import homepunk.work.mall.presentations.login.models.UserLogin;
import homepunk.work.mall.presentations.main.model.Mall;
import homepunk.work.mall.presentations.main.model.Malls;
import rx.Single;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface IRemoteRepository {
    Single<UserLogin> login(LoginCredentials credentials);

    Single<Malls> loadMalls();

    Single<Mall> loadMallDetails(int id);
}
