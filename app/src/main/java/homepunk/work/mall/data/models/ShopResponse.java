package homepunk.work.mall.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static homepunk.work.mall.data.Constants.SerializedNames.Shops.SHOPS_UPDATE;

/**
 * Created by Homepunk on 05.05.2017.
 **/

public class ShopResponse {
    @SerializedName(SHOPS_UPDATE)
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
