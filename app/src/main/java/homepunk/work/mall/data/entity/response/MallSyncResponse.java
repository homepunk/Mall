package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class MallSyncResponse implements ResponseEntity {
    @SerializedName(KEY_SHOPS)
    private ShopResponse shops;

    @SerializedName(KEY_FLOORS)
    private FloorResponse floors;

    @SerializedName(KEY_PRODUCTS)
    private ProductResponse products;

    @SerializedName(KEY_TIMESTAMP)
    private long timeStamp;

    @SerializedName(KEY_PLACEMENTS)
    private PlacementResponse placements;

    @SerializedName(KEY_SHOP_PRODUCTS)
    private List<ShopProductResponse> shopProducts;

    @SerializedName(KEY_PLACEMENT_PRODUCTS)
    private List<PlacementProductResponse> placementProducts;

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public ShopResponse getShops() {
        return shops;
    }

    public void setShops(ShopResponse shops) {
        this.shops = shops;
    }

    public FloorResponse getFloors() {
        return floors;
    }

    public void setFloors(FloorResponse floors) {
        this.floors = floors;
    }

    public ProductResponse getProducts() {
        return products;
    }

    public void setProducts(ProductResponse products) {
        this.products = products;
    }

    public PlacementResponse getPlacements() {
        return placements;
    }

    public void setPlacements(PlacementResponse placements) {
        this.placements = placements;
    }

    public List<ShopProductResponse> getShopProducts() {
        return shopProducts;
    }

    public void setShopProducts(List<ShopProductResponse> shopProducts) {
        this.shopProducts = shopProducts;
    }

    public List<PlacementProductResponse> getPlacementProducts() {
        return placementProducts;
    }

    public void setPlacementProducts(List<PlacementProductResponse> placementProducts) {
        this.placementProducts = placementProducts;
    }
}
