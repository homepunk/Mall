package homepunk.work.mall.data.storages.remote.repository;

import homepunk.work.mall.data.managers.ModuleManager;
import homepunk.work.mall.data.storages.remote.repository.interfaces.IRemoteRepository;
import homepunk.work.mall.data.storages.remote.service.MallApi;
import homepunk.work.mall.data.models.UserLoginCredentials;
import homepunk.work.mall.data.models.UserLogin;
import homepunk.work.mall.data.models.Mall;
import homepunk.work.mall.data.models.Malls;
import rx.Single;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class RemoteRepository implements IRemoteRepository {
    private MallApi mallApi;

    public RemoteRepository(MallApi mallApi) {
        this.mallApi = mallApi;
    }

    @Override
    public Single<UserLogin> login(UserLoginCredentials credentials) {
        return mallApi.loginByCredentials(credentials);
    }

    @Override
    public Single<Malls> loadMalls() {
        String token = new ModuleManager().getLocalManagers().getLocalDataManager().getSharedPreferencesRepository().retrieveAccessToken();

        return mallApi.fetchMalls(token);
    }

    @Override
    public Single<Mall> loadMallDetails(int id) {
        String token = new ModuleManager().getLocalManagers().getLocalDataManager().getSharedPreferencesRepository().retrieveAccessToken();

        return mallApi.fetchMallDetails(id, token);
    }
}
