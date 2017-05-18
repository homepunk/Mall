package homepunk.work.mall.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.PlacementProduct;
import homepunk.work.mall.data.entity.response.PlacementProductResponse;

/**
 * Created by Homepunk on 17.05.2017.
 **/

public class PlacementProductMapper {
    public static List<PlacementProduct> transform(List<PlacementProductResponse> placementProductResponses) {
        List<PlacementProduct> placementProducts = new ArrayList<>();

        for (PlacementProductResponse response : placementProductResponses) {
            int placementId = response.getPlacementId();
            int[] productIds = response.getProductIds();

            for (int productId : productIds) {
                placementProducts.add(new PlacementProduct(placementId, productId));
            }
        }

        return placementProducts;
    }
}
