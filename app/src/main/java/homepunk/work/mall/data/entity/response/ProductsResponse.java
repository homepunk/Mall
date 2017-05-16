package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class ProductsResponse implements ResponseEntity{
    @SerializedName(KEY_UPDATE)
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
