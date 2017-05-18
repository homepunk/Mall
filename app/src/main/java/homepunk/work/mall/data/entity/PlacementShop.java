package homepunk.work.mall.data.entity;

import android.content.ContentValues;
import android.database.Cursor;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class PlacementShop implements DatabaseEntity {
    public static final String PATH_PLACEMENT_SHOP = "placement_shop";
    public static final String TABLE_NAME_PLACEMENT_SHOP = "placement_shop";

    public static final String[] PROJECTION_PLACEMENT_SHOP = {
            COLUMN_ID_PLACEMENT,
            COLUMN_ID_SHOP
    };

    private int placementId;
    private int shopId;

    public PlacementShop(int placementId, int shopId) {
        this.placementId = placementId;
        this.shopId = shopId;
    }

    public PlacementShop(Cursor cursor) {
        this.placementId = cursor.getInt(0);
        this.shopId = cursor.getInt(1);
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_PLACEMENT, placementId);
        values.put(COLUMN_ID_SHOP, shopId);

        return values;
    }

    public int getPlacementId() {
        return placementId;
    }

    public void setPlacementId(int placementId) {
        this.placementId = placementId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
}
