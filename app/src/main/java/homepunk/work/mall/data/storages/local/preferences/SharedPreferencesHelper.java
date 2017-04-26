package homepunk.work.mall.data.storages.local.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import homepunk.work.mall.data.storages.local.preferences.interfaces.ISharedPreferencesHelper;
import homepunk.work.mall.presentations.App;

import static homepunk.work.mall.data.Constants.KEY_ACCESS_TOKEN;
import static homepunk.work.mall.data.Constants.SHARED_PREF_DEF_VALUE;
import static homepunk.work.mall.data.Constants.SHARED_PREF_NAME;

public class SharedPreferencesHelper implements ISharedPreferencesHelper {
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesHelper() {
        this.sharedPreferences = App.getContext().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void storeAccessToken(String token) {
        sharedPreferences.edit().putString(KEY_ACCESS_TOKEN, token).apply();
    }

    @Override
    public String retrieveAccessToken() {
        return sharedPreferences.getString(KEY_ACCESS_TOKEN, SHARED_PREF_DEF_VALUE);
    }
}
