package homepunk.work.mall.presentation.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class MallDetails implements Serializable {
    private Mall mall;
    private List<Shop> shops;
    private List<Placement> placements;
    private List<Product> products;
    private List<Floor> floors;

    public Mall getMall() {
        return mall;
    }

    public void setMall(Mall mall) {
        this.mall = mall;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public List<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Mall: ")
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
