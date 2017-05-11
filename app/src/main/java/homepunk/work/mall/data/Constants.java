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
        String KEY_BUNDLE = "bundle_key";
        String KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN";
    }

    interface BaseUrl {
        String SWAGGER_URL = "http://dev.sns.ae/api/v3/";
        String SWAGGER_IMAGE_URL = "http://dev.sns.ae/images/malls/";
    }

    interface Endpoint {
        String LOGIN = "auth/login";
        String MALLS = "malls/sync";
        String MALL_DETAILES = "malls/{id}/sync";
    }

    interface Preferences {
        String SHARED_PREF_DEF_VALUE = "";
        String SHARED_PREF_NAME = "token_store";
    }
}
