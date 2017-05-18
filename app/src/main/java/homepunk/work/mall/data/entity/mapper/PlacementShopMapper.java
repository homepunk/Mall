package homepunk.work.mall.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.Placement;
import homepunk.work.mall.data.entity.PlacementShop;

/**
 * Created by Homepunk on 17.05.2017.
 **/

public class PlacementShopMapper {
    public static List<PlacementShop> transform(List<Placement> placements) {
        final List<PlacementShop> placementShops = new ArrayList<>();

        for (Placement placement : placements) {
            placementShops.add(new PlacementShop(placement.getId(), placement.getShopId()));
        }

        return placementShops;
    }
}
