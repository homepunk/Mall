package homepunk.work.mall.data.local.db.interfaces;

import homepunk.work.mall.presentations.login.models.UserLogin;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface IDBRepository {
    void saveUser(UserLogin user);

    UserLogin getUser();
}
