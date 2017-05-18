package homepunk.work.mall.data.entity;

import android.content.ContentValues;
import android.database.Cursor;

import com.google.gson.annotations.SerializedName;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;
import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class Product implements DatabaseEntity, ResponseEntity {
    public static final String PATH_PRODUCTS = "products";
    public static final String TABLE_NAME_PRODUCT = "product";

    public static final String[] PROJECTION_PRODUCT = {
            COLUMN_ID,
            COLUMN_NAME,
            COLUMN_DESCRIPTION,
            COLUMN_IMAGE
    };

    @SerializedName(KEY_ID)
    private int id;

    @SerializedName(KEY_NAME)
    private String name;

    @SerializedName(KEY_IMAGE_URL)
    private String imageUrl;

    @SerializedName(KEY_DESCRIPTION)
    private String description;

    @SerializedName(KEY_TYPE_IDS)
    private int[] typeIds;

    @SerializedName(KEY_CATEGORY_IDS)
    private int[] categoryIds;

    public Product(Cursor cursor) {
        id = cursor.getInt(0);
        name = cursor.getString(1);
        description = cursor.getString(2);
        imageUrl = cursor.getString(3);
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int[] getTypeIds() {
        return typeIds;
    }

    public void setTypeIds(int[] typeIds) {
        this.typeIds = typeIds;
    }

    public int[] getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(int[] categoryIds) {
        this.categoryIds = categoryIds;
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
