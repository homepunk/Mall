package homepunk.work.mall.data.repository;

import android.content.Context;

import java.util.List;

import homepunk.work.mall.data.entity.Floor;
import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.entity.Placement;
import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.data.repository.datasource.interfaces.DatabaseMallDataSource;
import homepunk.work.mall.data.repository.datasource.interfaces.MallDataSource;
import homepunk.work.mall.data.repository.manager.DataSourceManager;
import homepunk.work.mall.domain.repository.MallRepository;
import io.reactivex.Observable;
import timber.log.Timber;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class MallRepositoryImpl implements MallRepository {
    private MallDataSource dataSource;
    private DatabaseMallDataSource localDataSource;

    public MallRepositoryImpl(Context context) {
        this.dataSource = new DataSourceManager(context).getRemoteDataSource();
        this.localDataSource = new DataSourceManager(context).getDatabaseDataSource();
    }

    @Override
    public Observable<List<Mall>> getMalls() {
        return localDataSource.getMalls()
                .flatMap(malls -> {
                    if (malls.size() > 0) {
                        Timber.i("Malls from local storage");
                        return io.reactivex.Observable.just(malls);
                    } else {
                        Timber.i("Malls from remote storage");
                        return dataSource.getMalls();
                    }
                });

    }

    @Override
    public Observable<List<Shop>> getMallShops(int id) {
        return dataSource.getShops(id);
    }


    @Override
    public Observable<List<Floor>> getMallFloors(int id) {
        return localDataSource.getMallFloors(id)
                .flatMap(floors -> {
                    if (floors.size() > 0) {
                        Timber.i("Floors from local storage");
                        return Observable.just(floors);
                    } else {
                        Timber.i("Floors from remote storage");
                        return dataSource.getMallFloors(id);
                    }
                });
    }

    @Override
    public Observable<List<Product>> getMallProducts(int id) {
        return dataSource.getProducts(id);
    }

    @Override
    public Observable<List<Placement>> getMallPlacements(int id) {
        return dataSource.getPlacements(id);
    }
}
