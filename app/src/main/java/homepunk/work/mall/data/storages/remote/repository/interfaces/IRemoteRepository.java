package homepunk.work.mall.data.storages.remote.repository.interfaces;

import homepunk.work.mall.data.models.UserLoginCredentials;
import homepunk.work.mall.data.models.UserLogin;
import homepunk.work.mall.data.models.Mall;
import homepunk.work.mall.data.models.Malls;
import rx.Single;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface IRemoteRepository {
    Single<UserLogin> login(UserLoginCredentials credentials);

    Single<Malls> loadMalls();

    Single<Mall> loadMallDetails(int id);
}
