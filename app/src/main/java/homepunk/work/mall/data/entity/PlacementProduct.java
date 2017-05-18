package homepunk.work.mall.data.entity;

import android.content.ContentValues;
import android.database.Cursor;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class PlacementProduct implements DatabaseEntity {
    public static final String PATH_PLACEMENT_PRODUCT = "placement_products";
    public static final String TABLE_NAME_PLACEMENT_PRODUCT = "placement_product";

    public static final String[] PROJECTION_PLACEMENT_PRODUCT = {
            COLUMN_ID_PLACEMENT,
            COLUMN_ID_PRODUCT
    };

    private int placementId;
    private int productId;

    public PlacementProduct(int placementId, int productId) {
        this.placementId = placementId;
        this.productId = productId;
    }

    public PlacementProduct(Cursor cursor) {
        this.placementId = cursor.getInt(0);
        this.productId = cursor.getInt(1);
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_PLACEMENT, placementId);
        values.put(COLUMN_ID_PRODUCT, productId);

        return values;
    }

    public int getPlacementId() {
        return placementId;
    }

    public void setPlacementId(int placementId) {
        this.placementId = placementId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
