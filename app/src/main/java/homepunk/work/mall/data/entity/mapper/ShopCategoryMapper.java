package homepunk.work.mall.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.data.entity.ShopCategory;

/**
 * Created by Homepunk on 17.05.2017.
 **/

public class ShopCategoryMapper {
    public static List<ShopCategory> transform(List<Shop> shops) {
        List<ShopCategory> shopCategories = new ArrayList<>();
        for (Shop shop : shops) {
            int[] categoryIds = shop.getCategoryIds();

            if (categoryIds != null && categoryIds.length > 0) {
                for (int categoryId : categoryIds) {
                    shopCategories.add(new ShopCategory(shop.getId(), categoryId));
                }
            }
        }

        return shopCategories;
    }
}
