package homepunk.work.mall.data.entity;

import android.content.ContentValues;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class ShopCategory implements DatabaseEntity {
    public static final String PATH_SHOP_CATEGORY = "shop_category";
    public static final String TABLE_NAME_SHOP_CATEGORY = "shop_category";

    public static final String[] PROJECTION_SHOP_CATEGORY = {
            COLUMN_ID_SHOP,
            COLUMN_ID_CATEGORY
    };

    private int shopId;
    private int categoryId;

    public ShopCategory(int shopId, int categoryId) {
        this.shopId = shopId;
        this.categoryId = categoryId;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_SHOP, shopId);
        values.put(COLUMN_ID_CATEGORY, categoryId);

        return values;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
