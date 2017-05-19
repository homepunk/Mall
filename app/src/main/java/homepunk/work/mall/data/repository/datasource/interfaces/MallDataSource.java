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
import homepunk.work.mall.data.entity.ProductType;
import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.data.entity.ShopCategory;
import homepunk.work.mall.data.entity.ShopProduct;
import homepunk.work.mall.data.entity.ShopType;
import homepunk.work.mall.data.entity.Type;
import homepunk.work.mall.data.entity.TypeCategory;
import io.reactivex.Observable;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface MallDataSource {
    Observable<List<Type>> getTypes(int mallId);

    Observable<List<Shop>> getShops(int mallId);

    Observable<List<Floor>> getMallFloors(int mallId);

    Observable<List<Mall>> getMalls();

    Observable<List<Product>> getProducts(int mallId);

    Observable<List<ShopType>> getShopTypes(int mallId);

    Observable<List<Category>> getCategories(int mallId);

    Observable<List<Placement>> getPlacements(int mallId);

    Observable<List<ProductType>> getProductTypes(int mallId);

    Observable<List<ShopProduct>> getProductShops(int mallId);

    Observable<List<ShopCategory>> getShopCategories(int mallId);

    Observable<List<PlacementShop>> getPlacementShops(int mallId);

    Observable<List<TypeCategory>> getTypeCategories(int mallId);

    Observable<List<ProductCategory>> getProductCategories(int mallId);

    Observable<List<PlacementProduct>> getPlacementProducts(int mallId);

}
