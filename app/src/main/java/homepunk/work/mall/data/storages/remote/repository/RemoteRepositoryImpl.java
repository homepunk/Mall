package homepunk.work.mall.data.storages.remote.repository;

import homepunk.work.mall.data.models.MallDetails;
import homepunk.work.mall.data.managers.DataManagerImpl;
import homepunk.work.mall.data.models.MallUpdate;
import homepunk.work.mall.data.models.UserLogin;
import homepunk.work.mall.data.models.UserLoginCredentials;
import homepunk.work.mall.data.storages.remote.api.MallApi;
import rx.Single;

public class RemoteRepositoryImpl implements homepunk.work.mall.data.storages.remote.repository.interfaces.RemoteRepository {
    private MallApi mallApi;
    private String token;

    public RemoteRepositoryImpl(MallApi mallApi) {
        this.mallApi = mallApi;
        this.token = new DataManagerImpl()
                .getLocalManagers()
                .getPreferencesHelper()
                .retrieveAccessToken();
    }

    @Override
    public Single<UserLogin> login(UserLoginCredentials credentials) {
        return mallApi.loginByCredentials(credentials);
    }

    @Override
    public Single<MallUpdate> loadMalls() {
        return mallApi.fetchMalls(token);
    }

    @Override
    public Single<MallDetails> loadMallDetails(int id) {
        return mallApi.fetchMallDetails(id, token);
    }
}
