package homepunk.work.mall.presentation.viewmodel;

import com.google.gson.annotations.SerializedName;


/**
 * Created by Homepunk on 10.05.2017.
 **/

public class ProductViewModel {
    private static final String PRODUCT_KEY_ID = "id";
    private static final String PRODUCT_KEY_NAME = "name";
    private static final String PRODUCT_KEY_TYPE_IDS = "type_ids";
    private static final String PRODUCT_KEY_IMAGE_URL = "image_url";
    private static final String PRODUCT_KEY_CATEGORY_IDS = "category_ids";
    private static final String PRODUCT_KEY_DESCRIPTION = "description";

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
