package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.presentation.viewmodel.ShopViewModel;

/**
 * Created by Homepunk on 05.05.2017.
 **/

public class ShopResponse {
    private static final String SHOPS_KEY_UPDATE = "update";

    @SerializedName(SHOPS_KEY_UPDATE)
    private List<ShopViewModel> shops;

    public List<ShopViewModel> getShops() {
        return shops;
    }

    public void setShops(List<ShopViewModel> shops) {
        this.shops = shops;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (ShopViewModel shop : shops) {
            builder.append(shop.toString())
                   .append("\n");
        }

        return builder.toString();
    }
}
