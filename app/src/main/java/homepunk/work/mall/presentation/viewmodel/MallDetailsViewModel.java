package homepunk.work.mall.presentation.viewmodel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class MallDetailsViewModel implements Serializable {
    private MallViewModel mall;
    private List<ShopViewModel> shops;
    private List<PlacementViewModel> placements;
    private List<ProductViewModel> products;
    private List<FloorViewModel> floors;

    public MallViewModel getMall() {
        return mall;
    }

    public void setMall(MallViewModel mall) {
        this.mall = mall;
    }

    public List<ShopViewModel> getShops() {
        return shops;
    }

    public void setShops(List<ShopViewModel> shops) {
        this.shops = shops;
    }

    public List<PlacementViewModel> getPlacements() {
        return placements;
    }

    public void setPlacements(List<PlacementViewModel> placements) {
        this.placements = placements;
    }

    public List<ProductViewModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductViewModel> products) {
        this.products = products;
    }

    public List<FloorViewModel> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorViewModel> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("MallViewModel: ")
                .append(mall.toString())
                .append("Floors: ")
                .append(getFloors().size())
                .append("\n")
                .append("Shops: ")
                .append(getShops().size())
                .append("\n")
                .append("Products: ")
                .append(getProducts().size())
                .append("\n")
                .append("Placements: ")
                .append(getPlacements().size())
                .toString();
    }
}
