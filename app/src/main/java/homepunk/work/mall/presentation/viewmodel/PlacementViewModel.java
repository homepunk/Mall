package homepunk.work.mall.presentation.viewmodel;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class PlacementViewModel {
    private int id;
    private int shopId;
    private String name;
    private String color;

    public PlacementViewModel(int id, int shopId, String name, String color) {
        this.id = id;
        this.shopId = shopId;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
