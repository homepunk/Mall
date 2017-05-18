package homepunk.work.mall.data.entity;

import android.content.ContentValues;
import android.database.Cursor;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class ShopProduct implements DatabaseEntity {
    public static final String PATH_SHOP_PRODUCTS = "shop_products";
    public static final String TABLE_NAME_SHOP_PRODUCT = "shop_product";

    public static final String[] PROJECTION_SHOP_PRODUCT = {
            COLUMN_ID_SHOP,
            COLUMN_ID_PRODUCT
    };

    private int shopId;
    private int productId;

    public ShopProduct(int shopId, int productId) {
        this.shopId = shopId;
        this.productId = productId;
    }

    public ShopProduct(Cursor cursor) {
        this.shopId = cursor.getInt(0);
        this.productId = cursor.getInt(1);
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_SHOP, shopId);
        values.put(COLUMN_ID_PRODUCT, productId);

        return values;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
}
