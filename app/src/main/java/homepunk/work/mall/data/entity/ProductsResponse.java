package homepunk.work.mall.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.presentation.model.Product;

import static homepunk.work.mall.data.Constants.SerializedNames.Product.PRODUCTS_KEY_UPDATE;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class ProductsResponse {
    @SerializedName(PRODUCTS_KEY_UPDATE)
    List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
