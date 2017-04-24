package homepunk.work.mall.data.local.repository;

import android.content.Context;
import android.content.SharedPreferences;

import homepunk.work.mall.data.local.interfaces.ISharedPreferencesRepository;

import static homepunk.work.mall.data.Constants.KEY_ACCESS_TOKEN;
import static homepunk.work.mall.data.Constants.SHARED_PREF_DEF_VALUE;
import static homepunk.work.mall.data.Constants.SHARED_PREF_NAME;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class SharedPreferencesRepository implements ISharedPreferencesRepository {
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesRepository(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
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
