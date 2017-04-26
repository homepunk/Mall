package homepunk.work.mall.data.managers;

import homepunk.work.mall.data.managers.interfaces.ILocalManager;
import homepunk.work.mall.data.storages.local.database.DBHelper;
import homepunk.work.mall.data.storages.local.database.interfaces.IDBHelper;
import homepunk.work.mall.data.storages.local.preferences.SharedPreferencesHelper;
import homepunk.work.mall.data.storages.local.preferences.interfaces.ISharedPreferencesHelper;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class LocalManager implements ILocalManager {

    @Override
    public ISharedPreferencesHelper getSharedPreferencesHelper() {
        return new SharedPreferencesHelper();
    }

    @Override
    public IDBHelper getDBHelper() {
        return new DBHelper();
    }
}