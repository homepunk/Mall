package homepunk.work.mall.data.local;

import homepunk.work.mall.data.local.db.interfaces.IDBRepository;
import homepunk.work.mall.data.local.interfaces.ILocalDataManager;
import homepunk.work.mall.data.local.preferences.interfaces.ISharedPreferencesRepository;
import homepunk.work.mall.data.local.db.DBRepository;
import homepunk.work.mall.data.local.preferences.SharedPreferencesRepository;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class LocalDataManager implements ILocalDataManager {
    @Override
    public ISharedPreferencesRepository getSharedPreferencesRepository() {
        return new SharedPreferencesRepository();
    }

    @Override
    public IDBRepository getDBRepository() {
        return new DBRepository();
    }
}
