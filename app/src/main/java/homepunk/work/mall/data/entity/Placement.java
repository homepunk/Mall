package homepunk.work.mall.data.entity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;

import static homepunk.work.mall.data.database.MallContract.CONTENT_AUTHORITY;
import static homepunk.work.mall.data.database.MallContract.PlacementEntry.PATH_PLACEMENTS;
import static homepunk.work.mall.data.database.MallContract.SCHEME;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class Placement implements DatabaseEntity {
    public static final String[] PROJECTION_PLACEMENT = {
            COLUMN_ID,
            COLUMN_NAME,
            COLUMN_SHOP_ID,
            COLUMN_COLOR};

    private static final String PLACEMENT_KEY_ID = "id";
    private static final String PLACEMENT_KEY_NAME = "name";
    private static final String PLACEMENT_KEY_COLOR = "color";
    private static final String PLACEMENT_KEY_SHOP_ID = "shop_id";
    private static final String PLACEMENT_KEY_TYPE_IDS = "type_ids";
    private static final String PLACEMENT_KEY_CATEGORY_IDS = "category_ids";

    public static final Uri CONTENT_URI_PLACEMENT = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_PLACEMENTS);
    public static final String CONTENT_TYPE_PLACEMENT = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PLACEMENTS;
    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PLACEMENTS;

    @SerializedName(PLACEMENT_KEY_ID)
    private int id;

    @SerializedName(PLACEMENT_KEY_SHOP_ID)
    private int shopId;

    @SerializedName(PLACEMENT_KEY_NAME)
    private String name;

    @SerializedName(PLACEMENT_KEY_COLOR)
    private String color;

    @Override
    public ContentValues getContentValues() {
        final ContentValues values = new ContentValues();

        values.put(COLUMN_ID, id);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_SHOP_ID, shopId);
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
