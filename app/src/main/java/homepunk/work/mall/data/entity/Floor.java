package homepunk.work.mall.data.entity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;

import static homepunk.work.mall.data.database.MallContract.CONTENT_AUTHORITY;
import static homepunk.work.mall.data.database.MallContract.FloorEntry.PATH_FLOORS;
import static homepunk.work.mall.data.database.MallContract.SCHEME;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class Floor implements DatabaseEntity {
    public static final String[] PROJECTION_FLOOR = {
            COLUMN_ID,
            COLUMN_MALL_ID,
            COLUMN_LEVEL,
            COLUMN_TYPE};

    public static final Uri CONTENT_URI_FLOOR = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_FLOORS);
    public static final String CONTENT_TYPE_FLOOR = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FLOORS;
    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FLOORS;

    private static final String FLOOR_KEY_ID = "id";
    private static final String FLOOR_KEY_LEVEL = "level";
    private static final String FLOOR_KEY_WIDTH = "width";
    private static final String FLOOR_KEY_TYPE = "indoors";
    private static final String FLOOR_KEY_HEIGHT = "height";
    private static final String FLOOR_KEY_MALL_ID = "mall_id";

    @SerializedName(FLOOR_KEY_ID)
    private int id;

    @SerializedName(FLOOR_KEY_MALL_ID)
    private int mallId;

    @SerializedName(FLOOR_KEY_TYPE)
    private String type;

    @SerializedName(FLOOR_KEY_LEVEL)
    private String level;

    public ContentValues getContentValues() {
        final ContentValues values = new ContentValues();

        values.put(COLUMN_ID, id);
        values.put(COLUMN_MALL_ID, mallId);
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
