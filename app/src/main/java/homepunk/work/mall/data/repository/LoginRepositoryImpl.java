package homepunk.work.mall.data.repository;

import android.content.Context;

import homepunk.work.mall.data.repository.datasource.interfaces.LoginDataSource;
import homepunk.work.mall.data.repository.datasource.interfaces.PreferencesDataSource;
import homepunk.work.mall.data.repository.manager.DataSourceManager;
import homepunk.work.mall.domain.model.UserCredentials;
import homepunk.work.mall.domain.repository.LoginRepository;
import homepunk.work.mall.presentation.viewmodel.UserViewModel;
import rx.Single;
import rx.schedulers.Schedulers;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class LoginRepositoryImpl implements LoginRepository {
    private final LoginDataSource loginDataSource;
    private final PreferencesDataSource preferencesDataSource;

    public LoginRepositoryImpl(Context context) {
        loginDataSource = new DataSourceManager(context).getLoginDataSource();
        preferencesDataSource = new DataSourceManager(context).getPreferencesDataSource();
    }

    @Override
    public Single<UserViewModel> login(UserCredentials loginCredentials) {
        return loginDataSource
                .login(loginCredentials)
                .subscribeOn(Schedulers.io());
    }
}
