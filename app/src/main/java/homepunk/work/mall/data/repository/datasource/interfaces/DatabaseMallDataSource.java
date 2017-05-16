package homepunk.work.mall.data.repository.datasource.interfaces;

import java.util.List;

import homepunk.work.mall.data.entity.Category;
import homepunk.work.mall.data.entity.Floor;
import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.entity.Placement;
import homepunk.work.mall.data.entity.PlacementProduct;
import homepunk.work.mall.data.entity.PlacementShop;
import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.ProductCategory;
import homepunk.work.mall.data.entity.ShopProduct;
import homepunk.work.mall.data.entity.ProductType;
import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.data.entity.ShopCategory;
import homepunk.work.mall.data.entity.ShopType;
import homepunk.work.mall.data.entity.Type;
import homepunk.work.mall.data.entity.TypeCategory;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public interface DatabaseMallDataSource extends MallDataSource {
    void saveFloors(List<Floor> floors);

    void saveShops(List<Shop> shops);

    void saveMalls(List<Mall> malls);

    void saveTypes(List<Type> types);

    void saveProducts(List<Product> products);

    void saveShopTypes(List<ShopType> shopTypes);

    void saveCategories(List<Category> categories);

    void savePlacements(List<Placement> placements);

    void saveShopProducts(List<ShopProduct> shopProducts);

    void saveProductTypes(List<ProductType> productTypes);

    void saveShopCategories(List<ShopCategory> shopCategories);

    void saveTypeCategories(List<TypeCategory> typeCategories);

    void savePlacementShops(List<PlacementShop> placementShops);

    void saveProductCategories(List<ProductCategory> productCategories);

    void savePlacementProducts(List<PlacementProduct> placementProducts);
}
