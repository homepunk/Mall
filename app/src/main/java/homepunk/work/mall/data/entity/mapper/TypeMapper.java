package homepunk.work.mall.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.ProductType;
import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.data.entity.ShopType;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class TypeMapper {
    public static List<ShopType> transform(Shop shop) {
        List<ShopType> shopTypes = new ArrayList<>();
        int[] typeIds = shop.getTypeIds();

        if (typeIds != null && typeIds.length > 0) {
            for (int typeId : typeIds) {
                shopTypes.add(new ShopType(shop.getId(), typeId));
            }
        }

        return shopTypes;
    }

    public static List<ProductType> transform(Product product) {
        List<ProductType> productTypes = new ArrayList<>();
        int[] typeIds = product.getTypeIds();

        if (typeIds != null && typeIds.length > 0) {
            for (int typeId : typeIds) {
                productTypes.add(new ProductType(product.getId(), typeId));
            }
        }

        return productTypes;
    }

}
