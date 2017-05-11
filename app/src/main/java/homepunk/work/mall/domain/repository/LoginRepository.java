package homepunk.work.mall.domain.repository;

import homepunk.work.mall.presentation.viewmodel.UserLoginViewModel;
import homepunk.work.mall.domain.model.UserLoginCredentials;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface LoginRepository {
    Single<UserLoginViewModel> login(UserLoginCredentials loginCredentials);
}
