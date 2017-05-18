package homepunk.work.mall.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.ProductCategory;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class ProductCategoryMapper {
    public static List<ProductCategory> transform(List<Product> products) {
        List<ProductCategory> productCategories = new ArrayList<>();
        for (Product product : products) {
            int[] categoryIds = product.getCategoryIds();

            if (categoryIds != null && categoryIds.length > 0) {
                for (int categoryId : categoryIds) {
                    productCategories.add(new ProductCategory(product.getId(), categoryId));
                }
            }
        }

        return productCategories;
    }


}
