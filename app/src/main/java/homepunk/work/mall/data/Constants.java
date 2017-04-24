package homepunk.work.mall.data;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public class Constants {
//    User login serializable names
    public static final String USER_KEY_STATUS = "status";
    public static final String USER_KEY_TOKEN = "token";
    public static final String USER_KEY_FIRST_NAME = "first_name";
    public static final String USER_KEY_LAST_NAME = "last_name";
    public static final String USER_KEY_EMAIL = "email";
    public static final String USER_KEY_ID = "id";
    public static final String USER_PHOTO_PATH = "photo_url";
    public static final String USER_PHOTO_LANDSCAPE_PATH = "photo_landscape_url";

//    Swagger urls
    public static final String BASE_URL = "http://dev.sns.ae/api/v3/";
    public static final String MALL_IMAGE_BASE_URL = "http://dev.sns.ae/images/malls/";

    public static final String LOGIN_ENDPOINT = "auth/login";
    public static final String MALLS_ENDPOINT = "malls/sync";
    public static final String MALL_DETAILES_ENDPOINT = "malls/{id}";

//    Mall serializable names
    public static final String MALLS_KEY_UPDATE = "update";
    public static final String MALL_KEY_ID = "id";
    public static final String MALL_KEY_NAME = "name";
    public static final String MALL_KEY_DESCRIPTION = "description";
    public static final String MALL_KEY_LATITUDE = "lat";


    public static final String MALL_KEY_LONGTITUDE = "lng";
    public static final String MALL_KEY_IMAGE = "image";

//    Shared preferences key
    public static final String KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN";
    public static final String SHARED_PREF_DEF_VALUE = "";
    public static final String SHARED_PREF_NAME = "token_store";
}
