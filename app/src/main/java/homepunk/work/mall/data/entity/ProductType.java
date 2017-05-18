package homepunk.work.mall.data.entity;

import android.content.ContentValues;
import android.database.Cursor;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class ProductType implements DatabaseEntity {
    public static final String PATH_PRODUCT_TYPE = "product_type";
    public static final String TABLE_NAME_PRODUCT_TYPE = "product_type";

    public static final String[] PROJECTION_PRODUCT_TYPE = {
            COLUMN_ID_PRODUCT,
            COLUMN_ID_TYPE
    };

    private int productId;
    private int typeId;


    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_PRODUCT, productId);
        values.put(COLUMN_ID_TYPE, typeId);

        return values;
    }

    public ProductType(int productId, int typeId) {
        this.productId = productId;
        this.typeId = typeId;
    }

    public ProductType(Cursor cursor) {
        this.productId = cursor.getInt(0);
        this.typeId = cursor.getInt(1);
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
