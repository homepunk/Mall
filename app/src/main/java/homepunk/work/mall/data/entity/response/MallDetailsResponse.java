package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class MallDetailsResponse {
    private static final String DETAILS_KEY_SHOPS = "shops";
    private static final String DETAILS_KEY_FLOORS = "floors";
    private static final String DETAILS_KEY_PRODUCTS = "products";
    private static final String DETAILS_KEY_PLACEMENTS = "placements";

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
