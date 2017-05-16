package homepunk.work.mall.data.entity;

import android.content.ContentValues;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class ShopType implements DatabaseEntity {
    public static final String PATH_SHOP_TYPE = "shop_type";
    public static final String TABLE_NAME_SHOP_TYPE = "shop_type";

    public static final String[] PROJECTION_SHOP_TYPE = {
            COLUMN_ID_SHOP,
            COLUMN_ID_TYPE
    };

    private int shopId;
    private int typeId;

    public ShopType(int shopId, int typeId) {
        this.shopId = shopId;
        this.typeId = typeId;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_SHOP, shopId);
        values.put(COLUMN_ID_TYPE, typeId);

        return values;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
