package homepunk.work.mall.data.repository;

import android.content.Context;

import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.repository.datasource.interfaces.DatabaseMallDataSource;
import homepunk.work.mall.data.repository.datasource.interfaces.RemoteMallDataSource;
import homepunk.work.mall.data.repository.manager.DataSourceManager;
import homepunk.work.mall.domain.repository.SyncRepository;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class SyncRepositoryImpl implements SyncRepository {
    private RemoteMallDataSource remoteDataSource;
    private DatabaseMallDataSource localDataSource;

    public SyncRepositoryImpl(Context context) {
        DataSourceManager dataSourceManager = new DataSourceManager(context);

        remoteDataSource = dataSourceManager.getRemoteDataSource();
        localDataSource = dataSourceManager.getDatabaseDataSource();
    }

    @Override
    public void syncMallRecords(Mall mall) {
        remoteDataSource.getMallSyncReponse(mall.getId())
                .subscribeOn(Schedulers.io());

        remoteDataSource.getTypeCategoryResponse(mall.getId())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public void syncMallList() {
        Timber.i("Syncing starts...");
        remoteDataSource.getMallsResponse()
                        .subscribeOn(Schedulers.io());

    }
}