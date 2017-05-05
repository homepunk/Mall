package homepunk.work.mall.data.managers.interfaces;

import homepunk.work.mall.data.storages.local.database.interfaces.DatabaseHelper;
import homepunk.work.mall.data.storages.local.preferences.interfaces.PreferencesHelper;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface LocalManager {
    PreferencesHelper getPreferencesHelper();

    DatabaseHelper getDatabaseHelper();
}
