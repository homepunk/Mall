package homepunk.work.mall.data.models;

import com.google.gson.annotations.SerializedName;

import static homepunk.work.mall.data.Constants.SerializedNames.Shops.SHOP_COLOR;
import static homepunk.work.mall.data.Constants.SerializedNames.Shops.SHOP_DESCRIPTION;
import static homepunk.work.mall.data.Constants.SerializedNames.Shops.SHOP_ID;
import static homepunk.work.mall.data.Constants.SerializedNames.Shops.SHOP_IMAGE_URL;
import static homepunk.work.mall.data.Constants.SerializedNames.Shops.SHOP_LEVEL;
import static homepunk.work.mall.data.Constants.SerializedNames.Shops.SHOP_NAME;

/**
 * Created by Homepunk on 05.05.2017.
 **/

public class Shop {
    @SerializedName(SHOP_ID)
    private int id;

    @SerializedName(SHOP_NAME)
    private String name;

    @SerializedName(SHOP_DESCRIPTION)
    private String description;

    @SerializedName(SHOP_LEVEL)
    private String level;

    @SerializedName(SHOP_COLOR)
    private String color;

    @SerializedName(SHOP_IMAGE_URL)
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
