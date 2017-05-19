package homepunk.work.mall.domain.repository;

import homepunk.work.mall.domain.model.UserCredentials;
import homepunk.work.mall.presentation.viewmodel.UserViewModel;
import io.reactivex.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface LoginRepository {
    Single<UserViewModel> login(UserCredentials loginCredentials);

    boolean isUserAuthenticated();
}
