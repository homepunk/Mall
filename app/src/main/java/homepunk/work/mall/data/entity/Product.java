package homepunk.work.mall.data.entity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;

import static homepunk.work.mall.data.database.MallContract.CONTENT_AUTHORITY;
import static homepunk.work.mall.data.database.MallContract.ProductEntry.PATH_PRODUCTS;
import static homepunk.work.mall.data.database.MallContract.SCHEME;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class Product implements DatabaseEntity {
    public static final String[] PROJECTION_PRODUCT = {
            COLUMN_ID,
            COLUMN_NAME,
            COLUMN_DESCRIPTION,
            COLUMN_IMAGE};

    private static final String PRODUCT_KEY_ID = "id";
    private static final String PRODUCT_KEY_NAME = "name";
    private static final String PRODUCT_KEY_TYPE_IDS = "type_ids";
    private static final String PRODUCT_KEY_IMAGE_URL = "image_url";
    private static final String PRODUCT_KEY_DESCRIPTION = "description";
    private static final String PRODUCT_KEY_CATEGORY_IDS = "category_ids";

    public static final Uri CONTENT_URI_PRODUCT = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS);
    public static final String CONTENT_TYPE_PRODUCT = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;
    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;

    @SerializedName(PRODUCT_KEY_ID)
    private int id;

    @SerializedName(PRODUCT_KEY_NAME)
    private String name;

    @SerializedName(PRODUCT_KEY_DESCRIPTION)
    private String description;

    @SerializedName(PRODUCT_KEY_IMAGE_URL)
    private String imageUrl;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public ContentValues getContentValues() {
        final ContentValues values = new ContentValues();

        values.put(COLUMN_ID, id);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_IMAGE, imageUrl);

        return values;
    }
}
