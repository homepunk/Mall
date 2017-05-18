package homepunk.work.mall.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.ProductType;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class ProductTypeMapper {
    public static List<ProductType> transform(List<Product> products) {
        List<ProductType> productTypes = new ArrayList<>();

        for (Product product: products) {
            int[] typeIds = product.getTypeIds();

            if (typeIds != null && typeIds.length > 0) {
                for (int typeId : typeIds) {
                    productTypes.add(new ProductType(product.getId(), typeId));
                }
            }
        }

        return productTypes;
    }

}
