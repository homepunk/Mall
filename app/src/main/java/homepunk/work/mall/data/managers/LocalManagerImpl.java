package homepunk.work.mall.data.managers;

import homepunk.work.mall.data.managers.interfaces.LocalManager;
import homepunk.work.mall.data.storages.local.database.DatabaseHelperImpl;
import homepunk.work.mall.data.storages.local.database.interfaces.DatabaseHelper;
import homepunk.work.mall.data.storages.local.preferences.PreferencesHelperImpl;
import homepunk.work.mall.data.storages.local.preferences.interfaces.PreferencesHelper;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class LocalManagerImpl implements LocalManager {

    @Override
    public PreferencesHelper getPreferencesHelper() {
        return new PreferencesHelperImpl();
    }

    @Override
    public DatabaseHelper getDatabaseHelper() {
        return new DatabaseHelperImpl();
    }
}