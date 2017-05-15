package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.data.entity.Product;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class ProductsResponse {
    private static final String PRODUCTS_KEY_UPDATE = "update";

    @SerializedName(PRODUCTS_KEY_UPDATE)
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
