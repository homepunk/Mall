package homepunk.work.mall.presentation.model;

import com.google.gson.annotations.SerializedName;

import static homepunk.work.mall.data.Constants.SerializedNames.Placement.PLACEMENT_KEY_COLOR;
import static homepunk.work.mall.data.Constants.SerializedNames.Placement.PLACEMENT_KEY_ID;
import static homepunk.work.mall.data.Constants.SerializedNames.Placement.PLACEMENT_KEY_NAME;
import static homepunk.work.mall.data.Constants.SerializedNames.Placement.PLACEMENT_KEY_SHOP_ID;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class Placement {
    @SerializedName(PLACEMENT_KEY_ID)
    private int id;

    @SerializedName(PLACEMENT_KEY_SHOP_ID)
    private int shopId;

    @SerializedName(PLACEMENT_KEY_NAME)
    private String name;

    @SerializedName(PLACEMENT_KEY_COLOR)
    private String color;

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
