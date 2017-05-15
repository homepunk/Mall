package homepunk.work.mall.data.entity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;

import static homepunk.work.mall.data.database.MallContract.CONTENT_AUTHORITY;
import static homepunk.work.mall.data.database.MallContract.SCHEME;
import static homepunk.work.mall.data.database.MallContract.ShopEntry.PATH_SHOPS;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class Shop implements DatabaseEntity {
    public static final String[] PROJECTION_SHOP = {
            COLUMN_ID,
            COLUMN_NAME,
            COLUMN_DESCRIPTION,
            COLUMN_LEVEL,
            COLUMN_COLOR,
            COLUMN_IMAGE};

    private static final String SHOP_KEY_ID = "id";
    private static final String SHOP_KEY_NAME = "name";
    private static final String SHOP_KEY_LEVEL = "level";
    private static final String SHOP_KEY_COLOR = "color";
    private static final String SHOP_KEY_TYPE_IDS = "type_ids";
    private static final String SHOP_KEY_IMAGE_URL = "image_url";
    private static final String SHOP_KEY_DESCRIPTION = "description";
    private static final String SHOP_KEY_CATEGORY_IDS = "category_ids";

    public static final Uri CONTENT_URI_SHOP = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_SHOPS);
    public static final String CONTENT_TYPE_SHOP = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHOPS;
    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHOPS;

    @SerializedName(SHOP_KEY_ID)
    private int id;

    @SerializedName(SHOP_KEY_NAME)
    private String name;

    @SerializedName(SHOP_KEY_DESCRIPTION)
    private String description;

    @SerializedName(SHOP_KEY_LEVEL)
    private String level;

    @SerializedName(SHOP_KEY_COLOR)
    private String color;

    @SerializedName(SHOP_KEY_IMAGE_URL)
    private String iamgeUrl;

    @Override
    public ContentValues getContentValues() {
        final ContentValues values = new ContentValues();

        values.put(COLUMN_ID, id);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_LEVEL, level);
        values.put(COLUMN_COLOR, color);
        values.put(COLUMN_IMAGE, iamgeUrl);

        return values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIamgeUrl() {
        return iamgeUrl;
    }

    public void setIamgeUrl(String iamgeUrl) {
        this.iamgeUrl = iamgeUrl;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(id)
                .append(" ")
                .append(name)
                .append(" ")
                .append(level)
                .toString();
    }
}
