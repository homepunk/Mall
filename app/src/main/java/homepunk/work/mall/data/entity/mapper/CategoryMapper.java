package homepunk.work.mall.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.ProductCategory;
import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.data.entity.ShopCategory;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class CategoryMapper {
    public static List<ShopCategory> transform(Shop shop) {
        List<ShopCategory> shopCategories = new ArrayList<>();
        int[] categoryIds = shop.getCategoryIds();

        if (categoryIds != null && categoryIds.length > 0) {
            for (int categoryId : categoryIds) {
                shopCategories.add(new ShopCategory(shop.getId(), categoryId));
            }
        }

        return shopCategories;
    }

    public static List<ProductCategory> transform(Product product) {
        List<ProductCategory> productCategories = new ArrayList<>();
        int[] categoryIds = product.getCategoryIds();

        if (categoryIds != null && categoryIds.length > 0) {
            for (int categoryId : categoryIds) {
                productCategories.add(new ProductCategory(product.getId(), categoryId));
            }
        }

        return productCategories;
    }


}
