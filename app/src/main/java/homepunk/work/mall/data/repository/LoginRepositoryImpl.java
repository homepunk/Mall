package homepunk.work.mall.data.repository;

import homepunk.work.mall.presentation.model.UserLogin;
import homepunk.work.mall.presentation.model.UserLoginCredentials;
import homepunk.work.mall.data.repository.datasource.local.PreferencesDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.local.interfaces.PreferencesDataSource;
import homepunk.work.mall.data.repository.datasource.remote.LoginDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.remote.interfaces.LoginDataSource;
import homepunk.work.mall.domain.repository.LoginRepository;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class LoginRepositoryImpl implements LoginRepository {
    private final LoginDataSource loginDataSource;
    private final PreferencesDataSource preferencesDataSource;

    public LoginRepositoryImpl() {
        loginDataSource = new LoginDataSourceImpl();
        preferencesDataSource = new PreferencesDataSourceImpl();
    }

    @Override
    public Single<UserLogin> login(UserLoginCredentials loginCredentials) {
        return loginDataSource
                .login(loginCredentials)
                .doOnSuccess(userLogin -> preferencesDataSource.storeAccessToken(userLogin.getToken()));
    }
}
