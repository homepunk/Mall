package homepunk.work.mall.data.models;

import com.google.gson.annotations.SerializedName;

import static homepunk.work.mall.data.Constants.SerializedNames.MallDetails.MALL_DETAILS_DESCRIPTION;
import static homepunk.work.mall.data.Constants.SerializedNames.MallDetails.MALL_DETAILS_ID;
import static homepunk.work.mall.data.Constants.SerializedNames.MallDetails.MALL_DETAILS_IMAGE;
import static homepunk.work.mall.data.Constants.SerializedNames.MallDetails.MALL_DETAILS_IMAGE_URL;
import static homepunk.work.mall.data.Constants.SerializedNames.MallDetails.MALL_DETAILS_NAME;
import static homepunk.work.mall.data.Constants.SerializedNames.MallDetails.MALL_DETAILS_SHOPS;

/**
 * Created by Homepunk on 05.05.2017.
 **/

public class MallDetails {
    @SerializedName(MALL_DETAILS_ID)
    private int id;

    @SerializedName(MALL_DETAILS_NAME)
    private String name;

    @SerializedName(MALL_DETAILS_DESCRIPTION)
    private String description;

    @SerializedName(MALL_DETAILS_IMAGE)
    private String image;

    @SerializedName(MALL_DETAILS_IMAGE_URL)
    private String imageUrl;

    @SerializedName(MALL_DETAILS_SHOPS)
    private ShopUpdate shopUpdate;

//    @SerializedName(MALL_DETAILS_FLOORS)
//    private List<Floor> floors;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ShopUpdate getShopUpdate() {
        return shopUpdate;
    }

    public void setShopUpdate(ShopUpdate shopUpdate) {
        this.shopUpdate = shopUpdate;
    }
}
