package homepunk.work.mall.data.repository.datasource.remote;

import homepunk.work.mall.data.models.UserLogin;
import homepunk.work.mall.data.models.UserLoginCredentials;
import homepunk.work.mall.data.remote.MallApi;
import homepunk.work.mall.data.remote.MallApiConnection;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class LoginDataSourceImpl implements homepunk.work.mall.data.repository.datasource.remote.interfaces.LoginDataSource {
    private MallApi mallApi;

    public LoginDataSourceImpl() {
        mallApi = MallApiConnection.getMallApiInstance();
    }

    @Override
    public Single<UserLogin> login(UserLoginCredentials loginCredentials) {
        return mallApi.loginByCredentials(loginCredentials);
    }

}
