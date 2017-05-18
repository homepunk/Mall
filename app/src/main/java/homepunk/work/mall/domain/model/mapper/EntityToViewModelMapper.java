package homepunk.work.mall.domain.model.mapper;

import homepunk.work.mall.data.entity.Floor;
import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.entity.Placement;
import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.presentation.viewmodel.FloorViewModel;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import homepunk.work.mall.presentation.viewmodel.PlacementViewModel;
import homepunk.work.mall.presentation.viewmodel.ProductViewModel;
import homepunk.work.mall.presentation.viewmodel.ShopViewModel;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class EntityToViewModelMapper {
    public static MallViewModel transform(Mall mall) {
        return new MallViewModel(mall.getId(),
                mall.getName(),
                mall.getDescription(),
                mall.getLatitude(),
                mall.getLongtitude(),
                mall.getImage());
    }

    public static FloorViewModel transform(Floor floor) {
        return new FloorViewModel(floor.getId(),
                floor.getMallId(),
                floor.getType(),
                floor.getLevel());
    }

    public static PlacementViewModel transform(Placement placement) {
        return new PlacementViewModel(placement.getId(),
                placement.getShopId(),
                placement.getName(),
                placement.getColor());
    }

    public static ShopViewModel transform(Shop shop) {
        return new ShopViewModel(shop.getId(),
                shop.getName(),
                shop.getDescription(),
                shop.getLevel(),
                shop.getColor(),
                shop.getIamgeUrl());
    }

    public static ProductViewModel transform(Product product) {
        return new ProductViewModel(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getImageUrl());
    }
}
