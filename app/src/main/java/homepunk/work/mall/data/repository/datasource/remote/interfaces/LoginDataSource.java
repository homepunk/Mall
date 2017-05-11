package homepunk.work.mall.data.repository.datasource.remote.interfaces;

import homepunk.work.mall.presentation.viewmodel.UserLoginViewModel;
import homepunk.work.mall.domain.model.UserLoginCredentials;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface LoginDataSource {
    Single<UserLoginViewModel> login(UserLoginCredentials loginCredentials);
}
