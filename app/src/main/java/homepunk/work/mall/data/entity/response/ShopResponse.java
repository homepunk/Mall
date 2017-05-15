package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.data.entity.Shop;

/**
 * Created by Homepunk on 05.05.2017.
 **/

public class ShopResponse {
    private static final String SHOPS_KEY_UPDATE = "update";

    @SerializedName(SHOPS_KEY_UPDATE)
    private List<Shop> shops;

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Shop shop : shops) {
            builder.append(shop.toString())
                   .append("\n");
        }

        return builder.toString();
    }
}
