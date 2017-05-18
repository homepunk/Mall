package homepunk.work.mall.data.entity;

import android.content.ContentValues;
import android.database.Cursor;

import com.google.gson.annotations.SerializedName;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;
import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class Placement implements DatabaseEntity, ResponseEntity {
    public static final String PATH_PLACEMENTS = "placements";
    public static final String TABLE_NAME_PLACEMENT = "placement";

    public static final String[] PROJECTION_PLACEMENT = {
            COLUMN_ID,
            COLUMN_NAME,
            COLUMN_ID_SHOP,
            COLUMN_COLOR
    };

    @SerializedName(KEY_ID)
    private int id;

    @SerializedName(KEY_NAME)
    private String name;

    @SerializedName(KEY_SHOP_ID)
    private int shopId;

    @SerializedName(KEY_COLOR)
    private String color;

    public Placement(Cursor cursor) {
        this.id = cursor.getInt(0);
        this.name = cursor.getString(1);
        this.shopId = cursor.getInt(2);
        this.color = cursor.getString(3);
    }

    @Override
    public ContentValues getContentValues() {
        final ContentValues values = new ContentValues();

        values.put(COLUMN_ID, id);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_ID_SHOP, shopId);
        values.put(COLUMN_COLOR, color);

        return values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
