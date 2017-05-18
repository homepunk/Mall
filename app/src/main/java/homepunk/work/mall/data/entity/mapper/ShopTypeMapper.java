package homepunk.work.mall.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.data.entity.ShopType;

/**
 * Created by Homepunk on 17.05.2017.
 **/

public class ShopTypeMapper {
    public static List<ShopType> transform(List<Shop> shops) {
        List<ShopType> shopTypes = new ArrayList<>();

        for (Shop shop : shops) {
            int[] typeIds = shop.getTypeIds();

            if (typeIds != null && typeIds.length > 0) {
                for (int typeId : typeIds) {
                    shopTypes.add(new ShopType(shop.getId(), typeId));
                }
            }
        }

        return shopTypes;
    }
}
