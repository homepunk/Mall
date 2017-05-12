package homepunk.work.mall.data.repository.datasource;

import homepunk.work.mall.data.repository.datasource.interfaces.LoginDataSource;
import homepunk.work.mall.presentation.viewmodel.UserViewModel;
import homepunk.work.mall.domain.model.UserCredentials;
import homepunk.work.mall.data.api.MallApi;
import homepunk.work.mall.data.api.MallApiConnection;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class RemoteLoginDataSourceImpl implements LoginDataSource {
    private MallApi mallApi;

    public RemoteLoginDataSourceImpl() {
        mallApi = MallApiConnection.getInstance();
    }

    @Override
    public Single<UserViewModel> login(UserCredentials userCredentials) {
        return mallApi.loginByCredentials(userCredentials);
    }

}
