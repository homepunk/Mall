package homepunk.work.mall.data;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface Constants {
    interface BaseUrls {
        String SWAGGER_URL = "http://dev.sns.ae/api/v3/";
        String SWAGGER_IMAGE_URL = "http://dev.sns.ae/images/malls/";
    }

    interface Endpoints {
        String LOGIN = "auth/login";
        String MALLS = "malls/sync";
        String MALL_DETAILES = "malls/{id}/sync";
    }

    interface SerializedNames {
        interface Mall {
            String MALLS_KEY_UPDATE = "update";
            String MALL_KEY_ID = "id";
            String MALL_KEY_NAME = "name";
            String MALL_KEY_DESCRIPTION = "description";
            String MALL_KEY_LATITUDE = "lat";
            String MALL_KEY_LONGTITUDE = "lng";
            String MALL_KEY_IMAGE = "image";
        }

        interface MallDetails {
            String MALL_DETAILS_ID = "id";
            String MALL_DETAILS_NAME = "name";
            String MALL_DETAILS_DESCRIPTION = "description";
            String MALL_DETAILS_IMAGE = "image";
            String MALL_DETAILS_IMAGE_URL = "iamge_url";
            String MALL_DETAILS_FLOORS = "floors";
            String MALL_DETAILS_SHOPS = "shops";
        }

        interface Shops {
            String SHOPS_UPDATE = "update";

            String SHOP_ID = "id";
            String SHOP_NAME = "name";
            String SHOP_DESCRIPTION = "description";
            String SHOP_LEVEL = "level";
            String SHOP_COLOR = "color";
            String SHOP_IMAGE_URL = "image_url";
            String SHOP_CATEGORY_IDS = "category_ids";
            String SHOP_TYPE_IDS = "type_ids";
        }

        interface Floor {
            String FLOOR_ID = "id";
            String FLOOR_LEVEL = "level";
            String FLOOR_TYPE = "indoors";
            String FLOOR_MALL_ID = "mall_id";
            String FLOOR_WIDTH = "width";
            String FLOOR_HEIGHT = "height";
        }

        interface User {
            String USER_PHOTO_PATH = "photo_url";
            String USER_KEY_STATUS = "status";
            String USER_KEY_TOKEN = "token";
            String USER_KEY_FIRST_NAME = "first_name";
            String USER_KEY_LAST_NAME = "last_name";
            String USER_KEY_EMAIL = "email";
            String USER_KEY_ID = "id";

            String USER_PHOTO_LANDSCAPE_PATH = "photo_landscape_url";
        }
    }

    interface Preferences {
        String KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN";
        String SHARED_PREF_DEF_VALUE = "";
        String SHARED_PREF_NAME = "token_store";
    }
}
