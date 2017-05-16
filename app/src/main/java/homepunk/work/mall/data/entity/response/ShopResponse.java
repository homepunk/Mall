package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 05.05.2017.
 **/

public class ShopResponse implements ResponseEntity {
    @SerializedName(KEY_UPDATE)
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
