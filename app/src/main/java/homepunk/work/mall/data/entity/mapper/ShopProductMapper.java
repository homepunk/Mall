package homepunk.work.mall.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.ShopProduct;
import homepunk.work.mall.data.entity.response.ShopProductResponse;

/**
 * Created by Homepunk on 17.05.2017.
 **/

public class ShopProductMapper {
    public static List<ShopProduct> transform(List<ShopProductResponse> shopProductResponse) {
        List<ShopProduct> shopProducts = new ArrayList<>();

        for (ShopProductResponse response : shopProductResponse) {
            int shopId = response.getShopId();
            int[] productIds = response.getProductIds();

            for (int productId : productIds) {
                shopProducts.add(new ShopProduct(shopId, productId));
            }
        }

        return shopProducts;
    }
}
