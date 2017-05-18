package homepunk.work.mall.data.entity;

import android.content.ContentValues;
import android.database.Cursor;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class ProductCategory implements DatabaseEntity {
    public static final String PATH_PRODUCT_CATEGORY = "product_category";
    public static final String TABLE_NAME_PRODUCT_CATEGORY = "product_category";

    public static final String[] PROJECTION_PRODUCT_CATEGORY = {
            COLUMN_ID_PRODUCT,
            COLUMN_ID_CATEGORY
    };

    private int productId;
    private int categoryId;

    public ProductCategory(int productId, int categoryId) {
        this.productId = productId;
        this.categoryId = categoryId;
    }

    public ProductCategory(Cursor cursor) {
        this.productId = cursor.getInt(0);
        this.categoryId = cursor.getInt(1);
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_PRODUCT, productId);
        values.put(COLUMN_ID_CATEGORY, categoryId);

        return values;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
