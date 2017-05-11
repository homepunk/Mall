package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.presentation.viewmodel.ProductViewModel;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class ProductsResponse {
    private static final String PRODUCTS_KEY_UPDATE = "update";

    @SerializedName(PRODUCTS_KEY_UPDATE)
    private List<ProductViewModel> products;

    public List<ProductViewModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductViewModel> products) {
        this.products = products;
    }
}
