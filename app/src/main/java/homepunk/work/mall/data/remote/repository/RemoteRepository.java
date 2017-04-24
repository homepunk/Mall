package homepunk.work.mall.data.remote.repository;

import homepunk.work.mall.data.managers.ModuleManager;
import homepunk.work.mall.data.remote.repository.interfaces.IRemoteRepository;
import homepunk.work.mall.data.remote.service.MallApi;
import homepunk.work.mall.presentations.login.models.LoginCredentials;
import homepunk.work.mall.presentations.login.models.UserLogin;
import homepunk.work.mall.presentations.main.model.Mall;
import homepunk.work.mall.presentations.main.model.Malls;
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
    public Single<UserLogin> login(LoginCredentials credentials) {
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
