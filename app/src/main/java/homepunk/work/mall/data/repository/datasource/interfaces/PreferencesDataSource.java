package homepunk.work.mall.data.repository.datasource.interfaces;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface PreferencesDataSource {
    void storeAccessToken(String token);

    String retrieveAccessToken();

    void storeLastSyncTimestamp(long timestamp, String key);

    long retrieveLastSyncTimestamp(String key);
}
