package homepunk.work.mall.data.managers.interfaces;

import homepunk.work.mall.data.storages.local.database.interfaces.IDBHelper;
import homepunk.work.mall.data.storages.local.preferences.interfaces.ISharedPreferencesHelper;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface ILocalManager {
    ISharedPreferencesHelper getSharedPreferencesHelper();

    IDBHelper getDBHelper();
}
