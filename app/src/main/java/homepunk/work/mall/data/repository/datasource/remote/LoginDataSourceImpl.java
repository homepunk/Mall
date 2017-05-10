package homepunk.work.mall.data.repository.datasource.remote;

import homepunk.work.mall.data.repository.datasource.remote.interfaces.LoginDataSource;
import homepunk.work.mall.presentation.model.UserLogin;
import homepunk.work.mall.presentation.model.UserLoginCredentials;
import homepunk.work.mall.data.api.MallApi;
import homepunk.work.mall.data.api.MallApiConnection;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class LoginDataSourceImpl implements LoginDataSource {
    private MallApi mallApi;

    public LoginDataSourceImpl() {
        mallApi = MallApiConnection.getMallApiInstance();
    }

    @Override
    public Single<UserLogin> login(UserLoginCredentials loginCredentials) {
        return mallApi.loginByCredentials(loginCredentials);
    }

}
