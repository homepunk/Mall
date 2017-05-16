package homepunk.work.mall.data.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.Category;
import homepunk.work.mall.data.entity.Floor;
import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.entity.Placement;
import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.data.entity.Type;
import homepunk.work.mall.data.entity.TypeCategory;
import homepunk.work.mall.data.entity.mapper.CategoryMapper;
import homepunk.work.mall.data.entity.mapper.ResponseMapper;
import homepunk.work.mall.data.entity.mapper.TypeMapper;
import homepunk.work.mall.data.entity.response.MallDetailsResponse;
import homepunk.work.mall.data.entity.response.PlacementProductResponse;
import homepunk.work.mall.data.entity.response.ShopProductResponse;
import homepunk.work.mall.data.entity.response.TypeCategoryResponse;
import homepunk.work.mall.data.repository.datasource.interfaces.DatabaseMallDataSource;
import homepunk.work.mall.data.repository.datasource.interfaces.MallDataSource;
import homepunk.work.mall.data.repository.manager.DataSourceManager;
import homepunk.work.mall.domain.listeners.SyncListener;
import homepunk.work.mall.domain.repository.SyncRepository;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class SyncRepositoryImpl implements SyncRepository {
    private MallDataSource remoteDataSource;
    private DatabaseMallDataSource localDataSource;

    public SyncRepositoryImpl(Context context) {
        DataSourceManager dataSourceManager = new DataSourceManager(context);

        remoteDataSource = dataSourceManager.getRemoteDataSource();
        localDataSource = dataSourceManager.getDatabaseDataSource();
    }

    @Override
    public void syncAll(SyncListener listener) {
        remoteDataSource.getMalls()
                        .subscribeOn(Schedulers.io())
                        .doOnSuccess(malls -> localDataSource.saveMalls(malls))
                        .flatMapObservable(malls -> Observable.from(malls))
                        .subscribe(mall -> fetchFullMallInfromationAndSaveToDatabase(mall), Timber::e);
    }

    @Override
    public void syncMallUpdates(SyncListener listener) {
        localDataSource.getMalls();
    }

    @Override
    public void syncFloorUpdates(SyncListener listener) {

    }

    @Override
    public void syncPlacementUpdates(SyncListener listener) {

    }

    @Override
    public void syncShopUpdates(SyncListener listener) {

    }

    @Override
    public void syncProductUpdates(SyncListener listener) {

    }

    @Override
    public boolean isLocalStorageExists() {
        try {
            localDataSource.getMalls();
            Timber.i("Local storage exists");
            return true;
        } catch (Exception e) {
            Timber.i("Local storage not exists");
            return false;
        }
    }

    @Override
    public long getLastSyncTimestamp() {

        return 0;
    }

    private void fetchFullMallInfromationAndSaveToDatabase(Mall mall) {
        Timber.i("Fetching " + mall.getName());
        remoteDataSource.getFullMallInformation(mall.getId())
                        .subscribeOn(Schedulers.trampoline())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::saveFullMallInfromation, Timber::e);

        remoteDataSource.getSummaryTypeCategories(mall.getId())
                        .subscribeOn(Schedulers.trampoline())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::saveSummaryTypeCategories, Timber::e);
    }

    private void saveSummaryTypeCategories(TypeCategoryResponse summaryTypeCategories) {
        List<Type> types = ResponseMapper.transform(summaryTypeCategories.getTypeResponse());
        List<Category> categories = ResponseMapper.transform(summaryTypeCategories.getCategoryResponse());
        List<TypeCategory> typeCategories = ResponseMapper.transform(summaryTypeCategories);

        localDataSource.saveTypes(types);
        localDataSource.saveCategories(categories);
        localDataSource.saveTypeCategories(typeCategories);
    }

    private void saveFullMallInfromation(MallDetailsResponse mallDetailsResponse) {
        ArrayList<Floor> floors = (ArrayList<Floor>) mallDetailsResponse.getFloorResponse().getFloors();
        ArrayList<Placement> placements = (ArrayList<Placement>) mallDetailsResponse.getPlacementsResponse().getPlacements();
        ArrayList<Product> products = (ArrayList<Product>) mallDetailsResponse.getProductsResponse().getProducts();
        ArrayList<Shop> shops = (ArrayList<Shop>) mallDetailsResponse.getShopResponse().getShops();
        ArrayList<PlacementProductResponse> placementProductResponse = (ArrayList<PlacementProductResponse>) mallDetailsResponse.getPlacementProductResponse();
        ArrayList<ShopProductResponse> shopProductResponses = (ArrayList<ShopProductResponse>) mallDetailsResponse.getShopProductResponse();

        for (Product product : products){
            localDataSource.saveProductTypes(TypeMapper.transform(product));
            localDataSource.saveProductCategories(CategoryMapper.transform(product));
        }

        for (Shop shop : shops) {
            localDataSource.saveShopTypes(TypeMapper.transform(shop));
            localDataSource.saveShopCategories(CategoryMapper.transform(shop));
        }

        for (PlacementProductResponse response : placementProductResponse) {
            localDataSource.savePlacementProducts(response.getPlacementProducts());
        }

        for (ShopProductResponse shopProductResponse : shopProductResponses) {
            localDataSource.saveShopProducts(shopProductResponse.getShopProducts());
        }

        if (floors.size() > 0) {
            localDataSource.saveFloors(floors);
        }

        if (placements.size() > 0) {
            localDataSource.savePlacements(placements);
        }

        if (products.size() > 0) {
            localDataSource.saveProducts(products);
        }

        if (shops.size() > 0) {
            localDataSource.saveShops(shops);
        }
    }
}
