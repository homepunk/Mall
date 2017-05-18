package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 17.05.2017.
 **/

public class PlacementProductResponse implements ResponseEntity {
    @SerializedName(KEY_PLACEMENTS)
    private int placementId;

    @SerializedName(KEY_PRODUCT_IDS)
    private int[] productIds;

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
