package homepunk.work.mall.domain.repository;

import homepunk.work.mall.presentation.viewmodel.UserViewModel;
import homepunk.work.mall.domain.model.UserCredentials;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface LoginRepository {
    Single<UserViewModel> login(UserCredentials loginCredentials);
}
