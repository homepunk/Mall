package homepunk.work.mall.data.local.interfaces;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface ISharedPreferencesRepository {
    void storeAccessToken(String token);
    String retrieveAccessToken();
}
