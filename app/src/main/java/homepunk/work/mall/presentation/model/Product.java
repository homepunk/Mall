package homepunk.work.mall.presentation.model;

import com.google.gson.annotations.SerializedName;

import static homepunk.work.mall.data.Constants.SerializedNames.Product.PRODUCT_KEY_DESCRIPTION;
import static homepunk.work.mall.data.Constants.SerializedNames.Product.PRODUCT_KEY_ID;
import static homepunk.work.mall.data.Constants.SerializedNames.Product.PRODUCT_KEY_IMAGE_URL;
import static homepunk.work.mall.data.Constants.SerializedNames.Product.PRODUCT_KEY_NAME;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class Product {
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
}
