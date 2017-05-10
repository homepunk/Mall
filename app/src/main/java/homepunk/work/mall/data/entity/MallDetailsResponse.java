package homepunk.work.mall.data.entity;

import com.google.gson.annotations.SerializedName;

import static homepunk.work.mall.data.Constants.SerializedNames.MallDetails.DETAILS_KEY_FLOORS;
import static homepunk.work.mall.data.Constants.SerializedNames.MallDetails.DETAILS_KEY_PLACEMENTS;
import static homepunk.work.mall.data.Constants.SerializedNames.MallDetails.DETAILS_KEY_PRODUCTS;
import static homepunk.work.mall.data.Constants.SerializedNames.MallDetails.DETAILS_KEY_SHOPS;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class MallDetailsResponse {
    @SerializedName(DETAILS_KEY_SHOPS)
    private ShopResponse shopResponse;

    @SerializedName(DETAILS_KEY_FLOORS)
    private FloorResponse floorResponse;

    @SerializedName(DETAILS_KEY_PLACEMENTS)
    private PlacementsResponse placementsResponse;

    @SerializedName(DETAILS_KEY_PRODUCTS)
    private ProductsResponse productsResponse;

    public ShopResponse getShopResponse() {
        return shopResponse;
    }

    public void setShopResponse(ShopResponse shopResponse) {
        this.shopResponse = shopResponse;
    }

    public FloorResponse getFloorResponse() {
        return floorResponse;
    }

    public void setFloorResponse(FloorResponse floorResponse) {
        this.floorResponse = floorResponse;
    }

    public PlacementsResponse getPlacementsResponse() {
        return placementsResponse;
    }

    public void setPlacementsResponse(PlacementsResponse placementsResponse) {
        this.placementsResponse = placementsResponse;
    }

    public ProductsResponse getProductsResponse() {
        return productsResponse;
    }

    public void setProductsResponse(ProductsResponse productsResponse) {
        this.productsResponse = productsResponse;
    }
}
