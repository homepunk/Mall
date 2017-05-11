package homepunk.work.mall.presentation.viewmodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class PlacementViewModel {
    private static final String PLACEMENT_KEY_ID = "id";
    private static final String PLACEMENT_KEY_NAME = "name";
    private static final String PLACEMENT_KEY_COLOR = "color";
    private static final String PLACEMENT_KEY_SHOP_ID = "shop_id";
    private static final String PLACEMENT_KEY_TYPE_IDS = "type_ids";
    private static final String PLACEMENT_KEY_CATEGORY_IDS = "category_ids";

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
