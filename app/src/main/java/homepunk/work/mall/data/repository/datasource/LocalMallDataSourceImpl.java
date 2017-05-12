package homepunk.work.mall.data.repository.datasource;

import android.content.ContentResolver;
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
import static homepunk.work.mall.data.database.MallContract.MallEntry.CONTENT_URI;
import static homepunk.work.mall.data.database.MallContract.MallEntry.PROJECTION;

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
        Cursor cursor = resolver.query(CONTENT_URI, PROJECTION, null, null, DEFAULT_SORT_ORDER);

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

    }

    @Override
    public void saveShops(List<Shop> shops) {

    }

    @Override
    public void savePlacements(List<Placement> placements) {

    }

    @Override
    public void saveProducts(List<Product> products) {

    }

    @Override
    public void saveMalls(List<Mall> malls) {

    }
}
