package homepunk.work.mall.data.storages.local.database.interfaces;

import homepunk.work.mall.data.models.UserLogin;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface IDBHelper {
    void saveUser(UserLogin user);

    UserLogin getUser();
}
