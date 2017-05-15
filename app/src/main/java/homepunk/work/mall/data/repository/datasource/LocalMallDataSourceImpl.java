package homepunk.work.mall.data.repository.datasource;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.Floor;
import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.entity.Placement;
import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.data.entity.response.MallDetailsResponse;
import homepunk.work.mall.data.repository.datasource.interfaces.DatabaseMallDataSource;
import rx.Single;

import static homepunk.work.mall.data.database.MallContract.DEFAULT_SORT_ORDER;
import static homepunk.work.mall.data.entity.Mall.CONTENT_URI_MALL;
import static homepunk.work.mall.data.entity.Mall.PROJECTION_MALL;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class LocalMallDataSourceImpl implements DatabaseMallDataSource {
    private ContentResolver resolver;

    public LocalMallDataSourceImpl(Context context) {
        resolver = context.getContentResolver();
    }

    @Override
    public Single<List<Mall>> getMalls() {
        ArrayList<Mall> databaseMalls = new ArrayList<>();
        Cursor cursor = resolver.query(CONTENT_URI_MALL, PROJECTION_MALL, null, null, DEFAULT_SORT_ORDER);

        while (cursor.moveToNext()) {
            databaseMalls.add(new Mall(cursor));
        }

        return Single.just(databaseMalls);
    }

    @Override
    public Single<List<Floor>> getFloorsByMallId(int id) {
        return null;
    }

    @Override
    public Single<List<Shop>> getShopsByMallId(int id) {
        return null;
    }

    @Override
    public Single<List<Product>> getProductsByMallId(int id) {
        return null;
    }

    @Override
    public Single<List<Placement>> getPlacementsByMallId(int id) {
        return null;
    }

    @Override
    public Single<MallDetailsResponse> getMallDetailsById(int id) {
        return null;
    }

    @Override
    public void saveFloors(List<Floor> floors) {
        for (Floor floor : floors) {
            ContentValues values = floor.getContentValues();
            resolver.insert(Floor.CONTENT_URI_FLOOR, values);
        }
    }

    @Override
    public void saveShops(List<Shop> shops) {
        for (Shop shop : shops) {
            ContentValues values = shop.getContentValues();
            resolver.insert(Shop.CONTENT_URI_SHOP, values);
        }
    }

    @Override
    public void savePlacements(List<Placement> placements) {
        for (Placement placement : placements) {
            ContentValues values = placement.getContentValues();
            resolver.insert(Placement.CONTENT_URI_PLACEMENT, values);
        }
    }

    @Override
    public void saveProducts(List<Product> products) {
        for (Product product : products) {
            ContentValues values = product.getContentValues();
            resolver.insert(Product.CONTENT_URI_PRODUCT, values);
        }
    }

    @Override
    public void saveMalls(List<Mall> malls) {
        for (Mall mall : malls) {
            ContentValues values = mall.getContentValues();
            resolver.insert(Mall.CONTENT_URI_MALL, values);
        }
    }
}
