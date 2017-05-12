package homepunk.work.mall.data.repository;

import homepunk.work.mall.presentation.viewmodel.UserViewModel;
import homepunk.work.mall.domain.model.UserCredentials;
import homepunk.work.mall.data.repository.datasource.PreferencesDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.interfaces.PreferencesDataSource;
import homepunk.work.mall.data.repository.datasource.RemoteLoginDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.interfaces.LoginDataSource;
import homepunk.work.mall.domain.repository.LoginRepository;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class LoginRepositoryImpl implements LoginRepository {
    private final LoginDataSource loginDataSource;
    private final PreferencesDataSource preferencesDataSource;

    public LoginRepositoryImpl() {
        loginDataSource = new RemoteLoginDataSourceImpl();
        preferencesDataSource = new PreferencesDataSourceImpl();
    }

    @Override
    public Single<UserViewModel> login(UserCredentials loginCredentials) {
        return loginDataSource
                .login(loginCredentials)
                .doOnSuccess(userLogin -> preferencesDataSource.storeAccessToken(userLogin.getToken()));
    }
}
