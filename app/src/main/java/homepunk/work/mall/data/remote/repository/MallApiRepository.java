package homepunk.work.mall.data.remote.repository;

import homepunk.work.mall.data.remote.api.MallApi;
import homepunk.work.mall.data.remote.MallApiManager;
import homepunk.work.mall.data.remote.repository.interfaces.IMallApiRepository;
import homepunk.work.mall.presentations.login.models.LoginCredentials;
import homepunk.work.mall.presentations.login.models.UserLogin;
import homepunk.work.mall.presentations.main.model.Malls;
import rx.Single;

public class MallApiRepository implements IMallApiRepository {
    private MallApi mallApi;

    public MallApiRepository() {
        this.mallApi = MallApiManager.getInstance();
    }

    @Override
    public Single<UserLogin> loginByCredentials(LoginCredentials credentials) {
        return mallApi.loginByCredentials(credentials);
    }

    @Override
    public Single<Malls> fetchMalls(String token) {
        return mallApi.fetchMalls(token);
    }
}
