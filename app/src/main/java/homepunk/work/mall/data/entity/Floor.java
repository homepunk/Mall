package homepunk.work.mall.data.entity;

import android.content.ContentValues;

import com.google.gson.annotations.SerializedName;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;
import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class Floor implements DatabaseEntity, ResponseEntity {
    public static final String PATH_FLOORS = "floors";
    public static final String TABLE_NAME_FLOOR = "floor";

    public static final String[] PROJECTION_FLOOR = {
            COLUMN_ID,
            COLUMN_ID_MALL,
            COLUMN_LEVEL,
            COLUMN_TYPE
    };

    @SerializedName(KEY_ID)
    private int id;

    @SerializedName(KEY_MALL_ID)
    private int mallId;

    @SerializedName(KEY_TYPE)
    private String type;

    @SerializedName(KEY_LEVEL)
    private String level;

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID, id);
        values.put(COLUMN_ID_MALL, mallId);
        values.put(COLUMN_LEVEL, level);
        values.put(COLUMN_TYPE, type);

        return values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getMallId() {
        return mallId;
    }

    public void setMallId(int mallId) {
        this.mallId = mallId;
    }
}
