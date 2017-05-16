package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.ShopProduct;
import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class ShopProductResponse implements ResponseEntity {
    @SerializedName(KEY_SHOP_ID)
    private int shopId;

    @SerializedName(KEY_PRODUCT_IDS)
    private int[] productIds;

    public List<ShopProduct> getShopProducts() {
        List<ShopProduct> shopProducts = new ArrayList<>();
        for (int productId : productIds) {
            shopProducts.add(new ShopProduct(shopId, productId));
        }

        return shopProducts;
    }


}
