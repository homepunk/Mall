package homepunk.work.mall.data.local.db;

import homepunk.work.mall.data.local.db.interfaces.IDBRepository;
import homepunk.work.mall.presentations.login.models.UserLogin;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class DBRepository implements IDBRepository {
    @Override
    public void saveUser(UserLogin user) {

    }

    @Override
    public UserLogin getUser() {
        return null;
    }
}
