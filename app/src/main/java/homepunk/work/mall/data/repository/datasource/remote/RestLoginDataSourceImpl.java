package homepunk.work.mall.data.repository.datasource.remote;

import homepunk.work.mall.data.repository.datasource.remote.interfaces.LoginDataSource;
import homepunk.work.mall.presentation.viewmodel.UserLoginViewModel;
import homepunk.work.mall.domain.model.UserLoginCredentials;
import homepunk.work.mall.data.api.MallApi;
import homepunk.work.mall.data.api.MallApiConnection;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class RestLoginDataSourceImpl implements LoginDataSource {
    private MallApi mallApi;

    public RestLoginDataSourceImpl() {
        mallApi = MallApiConnection.getInstance();
    }

    @Override
    public Single<UserLoginViewModel> login(UserLoginCredentials loginCredentials) {
        return mallApi.loginByCredentials(loginCredentials);
    }

}
