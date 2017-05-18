package homepunk.work.mall.data.repository.datasource;

import android.content.Context;

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
import homepunk.work.mall.data.entity.mapper.PlacementProductMapper;
import homepunk.work.mall.data.entity.mapper.PlacementShopMapper;
import homepunk.work.mall.data.entity.mapper.ProductCategoryMapper;
import homepunk.work.mall.data.entity.mapper.ProductTypeMapper;
import homepunk.work.mall.data.entity.mapper.ShopCategoryMapper;
import homepunk.work.mall.data.entity.mapper.ShopProductMapper;
import homepunk.work.mall.data.entity.mapper.ShopTypeMapper;
import homepunk.work.mall.data.entity.mapper.TypeCategoryMapper;
import homepunk.work.mall.data.entity.response.BaseResponse;
import homepunk.work.mall.data.entity.response.MallResponse;
import homepunk.work.mall.data.entity.response.MallSyncResponse;
import homepunk.work.mall.data.entity.response.TypeCategoryResponse;
import homepunk.work.mall.data.repository.datasource.interfaces.DatabaseMallDataSource;
import homepunk.work.mall.data.repository.datasource.interfaces.PreferencesDataSource;
import homepunk.work.mall.data.repository.datasource.interfaces.RemoteMallDataSource;
import homepunk.work.mall.data.repository.manager.DataSourceManager;
import rx.Observable;
import rx.Single;
import rx.schedulers.Schedulers;
import timber.log.Timber;

import static homepunk.work.mall.data.Constants.Keys.KEY_MALLS;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class RemoteMallDataSourceImpl implements RemoteMallDataSource {
    private MallApi mallApi;
    private String userToken;
    private PreferencesDataSource preferencesDataSource;
    private DatabaseMallDataSource localDataSource;

    public RemoteMallDataSourceImpl(Context context) {
        DataSourceManager dataSourceManager = new DataSourceManager(context);

        this.mallApi = MallApiConnection.getInstance(context);
        this.localDataSource = dataSourceManager.getDatabaseDataSource();
        this.preferencesDataSource = dataSourceManager.getPreferencesDataSource();
        this.userToken = preferencesDataSource.retrieveAccessToken();
    }

    @Override
    public Observable<List<Type>> getTypes(int mallId) {
        return null;
    }

    @Override
    public Observable<List<Shop>> getShops(int mallId) {
        return getMallSyncReponse(mallId).map(response -> response.getShops().getUpdates()).toObservable();
    }

    @Override
    public Observable<List<Floor>> getFloors(int mallId) {
        Timber.i("Fetching floors for mall with id: " + String.valueOf(mallId));

        return getMallSyncReponse(mallId).map(response -> response.getFloors().getUpdates()).toObservable();
    }

    @Override
    public Observable<List<Product>> getProducts(int mallId) {
        return getMallSyncReponse(mallId).map(response -> response.getProducts().getUpdates()).toObservable();
    }

    @Override
    public Observable<List<ShopType>> getShopTypes(int mallId) {
        return null;
    }

    @Override
    public Observable<List<Category>> getCategories(int mallId) {
        return null;
    }

    @Override
    public Observable<List<Placement>> getPlacements(int mallId) {
        return null;
    }

    @Override
    public Observable<List<ProductType>> getProductTypes(int mallId) {
        return null;
    }

    @Override
    public Observable<List<ShopProduct>> getProductShops(int mallId) {
        return null;
    }

    @Override
    public Observable<List<TypeCategory>> getTypeCategories(int mallId) {
        return null;
    }

    @Override
    public Observable<List<ShopCategory>> getShopCategories(int mallId) {
        return null;
    }

    @Override
    public Observable<List<PlacementShop>> getPlacementShops(int mallId) {
        return null;
    }

    @Override
    public Observable<List<ProductCategory>> getProductCategories(int mallId) {
        return null;
    }

    @Override
    public Observable<List<PlacementProduct>> getPlacementProducts(int mallId) {
        return null;
    }

    @Override
    public Observable<List<Mall>> getMalls() {
        Timber.i("From Remote");
        return getMallsResponse().map(BaseResponse::getUpdates).toObservable();
    }

    @Override
    public Single<MallResponse> getMallsResponse() {
        long timestamp = preferencesDataSource.retrieveLastSyncTimestamp(KEY_MALLS);
        Timber.i("Fetching by token: " + userToken + " with malls Timestamp: " + timestamp);

        return mallApi.fetchMalls(timestamp, userToken)
                .subscribeOn(Schedulers.io())
                .doOnSuccess(response -> {
                    localDataSource.saveMalls(response.getUpdates());
                    preferencesDataSource.storeLastSyncTimestamp(response.getSyncTimestamp(), KEY_MALLS);
                });
    }

    @Override
    public Single<MallSyncResponse> getMallSyncReponse(int id) {
        final long timestamp = preferencesDataSource.retrieveLastSyncTimestamp(String.valueOf(id));
        Timber.i("Fetching " + id + " with timestamp: " + timestamp);

        return mallApi.fetchFullMallInfromation(timestamp, id, userToken)
                .subscribeOn(Schedulers.io())
                .doOnSuccess(response -> {
                    saveAllMallResponseRecords(response);
                    preferencesDataSource.storeLastSyncTimestamp(response.getTimeStamp(), String.valueOf(id));
                });
    }

    @Override
    public Single<TypeCategoryResponse> getTypeCategoryResponse(int id) {
        return mallApi.fetchTypeCategories(id, userToken)
                .doOnSuccess(this::saveAllTypeCategoriesResponseRecords);
    }

    private void saveAllTypeCategoriesResponseRecords(TypeCategoryResponse response) {
        localDataSource.saveTypes(response.getTypes().getUpdates());
        localDataSource.saveCategories(response.getCategories().getUpdates());
        localDataSource.saveTypeCategories(TypeCategoryMapper.transform(response));
    }

    private void saveAllMallResponseRecords(MallSyncResponse response) {
        Timber.i("Saving all mall records to database...");
        localDataSource.saveShops(response.getShops().getUpdates());
        localDataSource.saveFloors(response.getFloors().getUpdates());
        localDataSource.saveProducts(response.getProducts().getUpdates());
        localDataSource.savePlacements(response.getPlacements().getUpdates());
        localDataSource.saveShopProducts(ShopProductMapper.transform(response.getShopProducts()));
        localDataSource.saveShopTypes(ShopTypeMapper.transform(response.getShops().getUpdates()));
        localDataSource.saveProductTypes(ProductTypeMapper.transform(response.getProducts().getUpdates()));
        localDataSource.saveShopCategories(ShopCategoryMapper.transform(response.getShops().getUpdates()));
        localDataSource.savePlacementProducts(PlacementProductMapper.transform(response.getPlacementProducts()));
        localDataSource.saveProductCategories(ProductCategoryMapper.transform(response.getProducts().getUpdates()));
        localDataSource.savePlacementShops(PlacementShopMapper.transform(response.getPlacements().getUpdates()));
    }
}
