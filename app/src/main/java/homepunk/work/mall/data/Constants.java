package homepunk.work.mall.data;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface Constants {
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
        String KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN";
        String SHARED_PREF_DEF_VALUE = "";
        String SHARED_PREF_NAME = "token_store";
    }

    interface SerializedNames {
        String KEY_BUNDLE = "bundle_key";

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
            String DETAILS_KEY_FLOORS = "floors";
            String DETAILS_KEY_SHOPS = "shops";
            String DETAILS_KEY_PRODUCTS = "products";
            String DETAILS_KEY_PLACEMENTS = "placements";
        }

        interface Shop {
            String SHOPS_KEY_UPDATE = "update";

            String SHOP_KEY_ID = "id";
            String SHOP_KEY_NAME = "name";
            String SHOP_KEY_DESCRIPTION = "description";
            String SHOP_KEY_LEVEL = "level";
            String SHOP_KEY_COLOR = "color";
            String SHOP_KEY_IMAGE_URL = "image_url";
            String SHOP_KEY_CATEGORY_IDS = "category_ids";
            String SHOP_KEY_TYPE_IDS = "type_ids";
        }

        interface Product {
            String PRODUCTS_KEY_UPDATE = "update";

            String PRODUCT_KEY_ID = "id";
            String PRODUCT_KEY_NAME = "name";
            String PRODUCT_KEY_DESCRIPTION = "description";
            String PRODUCT_KEY_IMAGE_URL = "image_url";
            String PRODUCT_KEY_CATEGORY_IDS = "category_ids";
            String PRODUCT_KEY_TYPE_IDS = "type_ids";
        }

        interface Placement {
            String PLACEMENT_KEY_UPDATE = "update";

            String PLACEMENT_KEY_ID = "id";
            String PLACEMENT_KEY_COLOR = "color";
            String PLACEMENT_KEY_NAME = "name";
            String PLACEMENT_KEY_SHOP_ID = "shop_id";
            String PLACEMENT_KEY_TYPE_IDS = "type_ids";
            String PLACEMENT_KEY_CATEGORY_IDS = "category_ids";
        }

        interface Floor {
            String FLOORS_KEY_UPDATE = "update";

            String FLOOR_KEY_ID = "id";
            String FLOOR_KEY_LEVEL = "level";
            String FLOOR_KEY_TYPE = "indoors";
            String FLOOR_KEY_MALL_ID = "mall_id";
            String FLOOR_KEY_WIDTH = "width";
            String FLOOR_KEY_HEIGHT = "height";

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
}
