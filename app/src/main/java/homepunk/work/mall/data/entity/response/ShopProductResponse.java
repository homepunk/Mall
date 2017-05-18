package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 17.05.2017.
 **/

public class ShopProductResponse implements ResponseEntity {
    @SerializedName(KEY_SHOP_ID)
    private int shopId;

    @SerializedName(KEY_PRODUCT_IDS)
    private int[] productIds;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int[] getProductIds() {
        return productIds;
    }

    public void setProductIds(int[] productIds) {
        this.productIds = productIds;
    }
}
