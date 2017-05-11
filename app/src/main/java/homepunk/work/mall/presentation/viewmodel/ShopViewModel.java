package homepunk.work.mall.presentation.viewmodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Homepunk on 05.05.2017.
 **/

public class ShopViewModel {
    private static final String SHOP_KEY_ID = "id";
    private static final String SHOP_KEY_NAME = "name";
    private static final String SHOP_KEY_LEVEL = "level";
    private static final String SHOP_KEY_COLOR = "color";
    private static final String SHOP_KEY_TYPE_IDS = "type_ids";
    private static final String SHOP_KEY_IMAGE_URL = "image_url";
    private static final String SHOP_KEY_DESCRIPTION = "description";
    private static final String SHOP_KEY_CATEGORY_IDS = "category_ids";

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
