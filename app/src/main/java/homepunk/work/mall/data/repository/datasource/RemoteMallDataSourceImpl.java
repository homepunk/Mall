package homepunk.work.mall.data.repository.datasource;

import java.util.List;

import homepunk.work.mall.data.api.MallApi;
import homepunk.work.mall.data.api.MallApiConnection;
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
import homepunk.work.mall.data.entity.response.MallDetailsResponse;
import homepunk.work.mall.data.entity.response.MallResponse;
import homepunk.work.mall.data.entity.response.TypeCategoryResponse;
import homepunk.work.mall.data.repository.datasource.interfaces.MallDataSource;
import rx.Single;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class RemoteMallDataSourceImpl implements MallDataSource {
    private MallApi mallApi;
    private String userToken;

    public RemoteMallDataSourceImpl(String userToken) {
        this.mallApi = MallApiConnection.getInstance();
        this.userToken = userToken;
    }

    @Override
    public Single<List<Mall>> getMalls() {
        return mallApi.fetchMalls(userToken)
                      .map(MallResponse::getMalls);
    }

    @Override
    public Single<TypeCategoryResponse> getSummaryTypeCategories(int mallId) {
            return mallApi.fetchTypeCategories(mallId, userToken);
    }

    @Override
    public Single<List<Floor>> getFloors(int mallId) {
        return null;
    }

    @Override
    public Single<List<Shop>> getShops(int mallId) {
        return null;
    }

    @Override
    public Single<List<Product>> getProducts(int mallId) {
        return null;
    }

    @Override
    public Single<List<Placement>> getPlacements(int mallId) {
        return null;
    }

    @Override
    public Single<MallDetailsResponse> getFullMallInformation(int mallId) {
        return mallApi.fetchFullMallInfromation(mallId, userToken);
    }

    @Override
    public Single<List<Type>> getTypes(int mallId) {
        return null;
    }

    @Override
    public Single<List<ShopType>> getShopTypes(int mallId) {
        return null;
    }

    @Override
    public Single<List<Category>> getCategories(int mallId) {
        return null;
    }

    @Override
    public Single<List<ShopProduct>> getProductShops(int mallId) {
        return null;
    }

    @Override
    public Single<List<ProductType>> getProductTypes(int mallId) {
        return null;
    }

    @Override
    public Single<List<ShopCategory>> getShopCategories(int mallId) {
        return null;
    }

    @Override
    public Single<List<TypeCategory>> getTypeCategories(int mallId) {
        return null;
    }

    @Override
    public Single<List<PlacementShop>> getPlacementShops(int mallId) {
        return null;
    }

    @Override
    public Single<List<ProductCategory>> getProductCategories(int mallId) {
        return null;
    }

    @Override
    public Single<List<PlacementProduct>> getPlacementProducts(int mallId) {
        return null;
    }
}
