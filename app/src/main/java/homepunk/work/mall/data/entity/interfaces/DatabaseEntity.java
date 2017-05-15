package homepunk.work.mall.data.entity.interfaces;

import android.content.ContentValues;

/**
 * Created by Homepunk on 15.05.2017.
 **/

public interface DatabaseEntity {
    String TABLE_NAME_FLOOR = "floor";
    String TABLE_NAME_PLACEMENT = "placement";
    String TABLE_NAME_MALL = "mall";
    String TABLE_NAME_SHOP = "shop";
    String TABLE_NAME_PRODUCT = "product";

    String COLUMN_ID = "_id";
    String COLUMN_TYPE = "indoors";
    String COLUMN_NAME = "name";
    String COLUMN_IMAGE = "image";
    String COLUMN_LEVEL = "level";
    String COLUMN_WIDTH = "width";
    String COLUMN_HEGHT = "height";
    String COLUMN_COLOR = "color";
    String COLUMN_MALL_ID = "mall_id";
    String COLUMN_SHOP_ID = "shop_id";
    String COLUMN_LATITUDE = "lat";
    String COLUMN_LONGTITUDE = "lng";
    String COLUMN_DESCRIPTION = "description";

    ContentValues getContentValues();
}
