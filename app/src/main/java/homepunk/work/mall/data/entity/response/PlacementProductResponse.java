package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.PlacementProduct;
import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class PlacementProductResponse implements ResponseEntity {
    @SerializedName(KEY_PLACEMENT_ID)
    private int placementId;

    @SerializedName(KEY_PRODUCT_IDS)
    private int[] productIds;

    public List<PlacementProduct> getPlacementProducts() {
        List<PlacementProduct> placementProducts = new ArrayList<>();
        for (int productId : productIds) {
            placementProducts.add(new PlacementProduct(placementId, productId));
        }

        return placementProducts;
    }

    public int getPlacementId() {
        return placementId;
    }

    public void setPlacementId(int placementId) {
        this.placementId = placementId;
    }

    public int[] getProductIds() {
        return productIds;
    }

    public void setProductIds(int[] productIds) {
        this.productIds = productIds;
    }
}
