package homepunk.work.mall.data.storages.local.preferences.interfaces;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface PreferencesHelper {
    void storeAccessToken(String token);
    String retrieveAccessToken();
}
