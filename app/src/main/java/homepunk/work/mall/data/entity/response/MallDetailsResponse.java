package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class MallDetailsResponse implements ResponseEntity {
    @SerializedName(KEY_SHOPS)
    private ShopResponse shopResponse;

    @SerializedName(KEY_FLOORS)
    private FloorResponse floorResponse;

    @SerializedName(KEY_PLACEMENTS)
    private PlacementsResponse placementsResponse;

    @SerializedName(KEY_PRODUCTS)
    private ProductsResponse productsResponse;

    @SerializedName(KEY_PLACEMENT_PRODUCTS)
    private List<PlacementProductResponse> placementProductResponse;

    @SerializedName(KEY_SHOP_PRODUCTS)
    private List<ShopProductResponse> shopProductResponse;

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

    public List<PlacementProductResponse> getPlacementProductResponse() {
        return placementProductResponse;
    }

    public void setPlacementProductResponse(List<PlacementProductResponse> placementProductResponse) {
        this.placementProductResponse = placementProductResponse;
    }

    public List<ShopProductResponse> getShopProductResponse() {
        return shopProductResponse;
    }

    public void setShopProductResponse(List<ShopProductResponse> shopProductResponse) {
        this.shopProductResponse = shopProductResponse;
    }
}
