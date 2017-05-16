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
import homepunk.work.mall.data.entity.response.MallDetailsResponse;
import homepunk.work.mall.data.entity.response.TypeCategoryResponse;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface MallDataSource {
    Single<List<Mall>> getMalls();

    Single<TypeCategoryResponse> getSummaryTypeCategories(int mallId);

    Single<List<Floor>> getFloors(int mallId);

    Single<List<Shop>> getShops(int mallId);

    Single<List<Product>> getProducts(int mallId);

    Single<List<Placement>> getPlacements(int mallId);

    Single<MallDetailsResponse> getFullMallInformation(int mallId);

    Single<List<Type>> getTypes(int mallId);

    Single<List<ShopType>> getShopTypes(int mallId);

    Single<List<Category>> getCategories(int mallId);

    Single<List<ShopProduct>> getProductShops(int mallId);

    Single<List<ProductType>> getProductTypes(int mallId);

    Single<List<ShopCategory>> getShopCategories(int mallId);

    Single<List<TypeCategory>> getTypeCategories(int mallId);

    Single<List<PlacementShop>> getPlacementShops(int mallId);

    Single<List<ProductCategory>> getProductCategories(int mallId);

    Single<List<PlacementProduct>> getPlacementProducts(int mallId);
}
