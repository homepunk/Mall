package homepunk.work.mall.data.entity.interfaces;

import android.content.ContentValues;
import android.provider.BaseColumns;

/**
 * Created by Homepunk on 15.05.2017.
 **/

public interface DatabaseEntity extends BaseColumns {
    String COLUMN_ID = "_id";
    String COLUMN_TYPE = "indoors";
    String COLUMN_NAME = "name";
    String COLUMN_IMAGE = "image";
    String COLUMN_LEVEL = "level";
    String COLUMN_WIDTH = "width";
    String COLUMN_ID_TYPE = "type_id";
    String COLUMN_ID_CATEGORY = "category_id";
    String COLUMN_HEGHT = "height";
    String COLUMN_COLOR = "color";
    String COLUMN_ID_MALL = "mall_id";
    String COLUMN_ID_SHOP = "shop_id";
    String COLUMN_LATITUDE = "lat";
    String COLUMN_LONGTITUDE = "lng";
    String COLUMN_DESCRIPTION = "description";
    String COLUMN_ID_PRODUCT = "product_id";
    String COLUMN_ID_PLACEMENT = "placement_id";

    ContentValues getContentValues();
}
