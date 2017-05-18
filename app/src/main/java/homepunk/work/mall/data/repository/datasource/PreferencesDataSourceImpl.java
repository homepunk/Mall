package homepunk.work.mall.data.repository.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import homepunk.work.mall.data.repository.datasource.interfaces.PreferencesDataSource;
import homepunk.work.mall.presentation.MallApplication;

import static homepunk.work.mall.data.Constants.Keys.KEY_ACCESS_TOKEN;
import static homepunk.work.mall.data.Constants.Preferences.SHARED_PREF_DEF_LONG_VALUE;
import static homepunk.work.mall.data.Constants.Preferences.SHARED_PREF_DEF_STRING_VALUE;
import static homepunk.work.mall.data.Constants.Preferences.SHARED_PREF_NAME;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class PreferencesDataSourceImpl implements PreferencesDataSource {
    private final SharedPreferences sharedPreferences;

    public PreferencesDataSourceImpl() {
        sharedPreferences = MallApplication.getContext().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);;
    }

    @Override
    public void storeAccessToken(String token) {
        sharedPreferences.edit().remove(KEY_ACCESS_TOKEN).apply();
        sharedPreferences.edit().putString(KEY_ACCESS_TOKEN, token).apply();
    }

    @Override
    public String retrieveAccessToken() {
        return sharedPreferences.getString(KEY_ACCESS_TOKEN, SHARED_PREF_DEF_STRING_VALUE);
    }

    @Override
    public void storeLastSyncTimestamp(long timestamp, String key) {
        sharedPreferences.edit().remove(key).apply();
        sharedPreferences.edit().putLong(key, timestamp).apply();
    }

    @Override
    public long retrieveLastSyncTimestamp(String key) {
        return sharedPreferences.getLong(key, SHARED_PREF_DEF_LONG_VALUE);
    }
}
