package homepunk.work.mall.data.repository.datasource;

import android.content.Context;

import homepunk.work.mall.data.api.MallApi;
import homepunk.work.mall.data.api.MallApiConnection;
import homepunk.work.mall.data.repository.datasource.interfaces.LoginDataSource;
import homepunk.work.mall.data.repository.datasource.interfaces.PreferencesDataSource;
import homepunk.work.mall.data.repository.manager.DataSourceManager;
import homepunk.work.mall.domain.model.UserCredentials;
import homepunk.work.mall.presentation.viewmodel.UserViewModel;
import io.reactivex.Single;
import timber.log.Timber;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class LoginDataSourceImpl implements LoginDataSource {
    private MallApi mallApi;
    private PreferencesDataSource preferencesDataSource;

    public LoginDataSourceImpl(Context context) {
        mallApi = MallApiConnection.getInstance(context);
        preferencesDataSource = new DataSourceManager(context).getPreferencesDataSource();
    }

    @Override
    public Single<UserViewModel> login(UserCredentials userCredentials) {
        return mallApi.login(userCredentials)
                      .doOnSuccess(userLogin -> {
                          Timber.i("Login token returned: " + userLogin.getToken());
                          preferencesDataSource.storeAccessToken(userLogin.getToken());
                      });
    }

}
