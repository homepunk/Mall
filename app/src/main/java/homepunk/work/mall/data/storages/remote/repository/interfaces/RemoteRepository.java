package homepunk.work.mall.data.storages.remote.repository.interfaces;

import homepunk.work.mall.data.models.MallDetails;
import homepunk.work.mall.data.models.UserLoginCredentials;
import homepunk.work.mall.data.models.UserLogin;
import homepunk.work.mall.data.models.MallUpdate;
import rx.Single;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface RemoteRepository {
    Single<UserLogin> login(UserLoginCredentials credentials);

    Single<MallUpdate> loadMalls();

    Single<MallDetails> loadMallDetails(int id);
}
