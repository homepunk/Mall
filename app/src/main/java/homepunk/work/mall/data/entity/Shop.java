package homepunk.work.mall.data.entity;

import android.content.ContentValues;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;
import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class Shop implements DatabaseEntity, ResponseEntity {
    public static final String PATH_SHOPS = "shops";
    public static final String TABLE_NAME_SHOP = "shop";

    public static final String[] PROJECTION_SHOP = {
            COLUMN_ID,
            COLUMN_NAME,
            COLUMN_DESCRIPTION,
            COLUMN_LEVEL,
            COLUMN_COLOR,
            COLUMN_IMAGE
    };

    @SerializedName(KEY_ID)
    private int id;

    @SerializedName(KEY_NAME)
    private String name;

    @SerializedName(KEY_LEVEL)
    private String level;

    @SerializedName(KEY_COLOR)
    private String color;

    @SerializedName(KEY_IMAGE_URL)
    private String iamgeUrl;

    @SerializedName(KEY_DESCRIPTION)
    private String description;

    @SerializedName(KEY_FLOOR_ID)
    private int floorId;

    @SerializedName(KEY_TYPE_IDS)
    private int[] typeIds;

    @SerializedName(KEY_CATEGORY_IDS)
    private int[] categoryIds;

    private List<ShopType> shopType;

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
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
