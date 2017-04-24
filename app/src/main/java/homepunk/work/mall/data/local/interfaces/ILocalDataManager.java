package homepunk.work.mall.data.local.interfaces;

import homepunk.work.mall.data.local.db.interfaces.IDBRepository;
import homepunk.work.mall.data.local.preferences.interfaces.ISharedPreferencesRepository;

public interface ILocalDataManager {
    ISharedPreferencesRepository getSharedPreferencesRepository();

    IDBRepository getDBRepository();
}
