package homepunk.work.mall.data.rest.repository;

import homepunk.work.mall.data.rest.api.MallApi;
import homepunk.work.mall.data.rest.api.MallApiManager;
import homepunk.work.mall.data.rest.repository.interfaces.IMallApiRepository;
import homepunk.work.mall.presentations.login.models.LoginCredentials;
import homepunk.work.mall.presentations.login.models.LoginUser;
import rx.Single;

public class MallApiRepository implements IMallApiRepository {
    private MallApi mallApi;

    public MallApiRepository() {
        this.mallApi = MallApiManager.getInstance();
    }

    @Override
    public Single<LoginUser> loginByCredentials(LoginCredentials credentials) {
        return mallApi.loginByCredentials(credentials);
    }
}
