package homepunk.work.mall.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.presentation.model.Shop;

import static homepunk.work.mall.data.Constants.SerializedNames.Shop.SHOPS_KEY_UPDATE;

/**
 * Created by Homepunk on 05.05.2017.
 **/

public class ShopResponse {
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
