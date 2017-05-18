package homepunk.work.mall.data;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface Constants {
    interface Messages {
        String ERROR_CONTENT_URI = "Unknown URI ";
        String ERROR_INSERT_ROW = "Failed to insert row into ";
    }
    interface Keys {
        String KEY_MALLS = "malls";
        String KEY_BUNDLE = "bundle_key";
        String KEY_TIMESTAMP = "key_timestamp";
        String KEY_ACCESS_TOKEN = "key_access_token";
        String KEY_MALL_SYNC = "key_mall_sync";
    }

    interface BaseUrl {
        String SWAGGER_URL = "http://dev.sns.ae/api/v3/";
        String SWAGGER_IMAGE_URL = "http://dev.sns.ae/images/malls/";
    }

    interface Endpoint {
        String LOGIN_ENDPOINT = "auth/login";
        String MALL_LIST_ENPOINT = "malls/sync";
        String FULL_MALL_INFORMATION_ENDPOINT = "malls/{id}/sync";
        String TYPE_CATEGORIES_ENDPOINT = "malls/{id}/types-categories";
    }

    interface Preferences {
        long SHARED_PREF_DEF_LONG_VALUE = 0;
        String SHARED_PREF_NAME = "token_store";
        String SHARED_PREF_DEF_STRING_VALUE = "";
    }
}
