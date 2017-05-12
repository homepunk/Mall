package homepunk.work.mall.data.repository.datasource.interfaces;

import homepunk.work.mall.presentation.viewmodel.UserViewModel;
import homepunk.work.mall.domain.model.UserCredentials;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface LoginDataSource {
    Single<UserViewModel> login(UserCredentials userCredentials);
}
