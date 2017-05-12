package homepunk.work.mall.data.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.repository.datasource.interfaces.DatabaseMallDataSource;
import homepunk.work.mall.data.repository.datasource.interfaces.MallDataSource;
import homepunk.work.mall.data.repository.manager.DataSourceManager;
import homepunk.work.mall.domain.listeners.SyncListener;
import homepunk.work.mall.domain.repository.SyncRepository;

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
                .doOnSuccess(malls -> localDataSource.saveMalls(malls));
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

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public long getLastSyncTimestamp() {

        return 0;
    }

    private void saveMallIds(List<Mall> malls) {
        ArrayList<Integer> mallIds = new ArrayList<>();

        for (Mall mall : malls) {
            mallIds.add(mall.getId());
        }
    }
}
