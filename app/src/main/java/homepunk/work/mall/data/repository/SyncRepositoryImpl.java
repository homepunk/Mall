package homepunk.work.mall.data.repository;

import android.content.Context;

import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.repository.datasource.interfaces.RemoteMallDataSource;
import homepunk.work.mall.data.repository.manager.DataSourceManager;
import homepunk.work.mall.domain.listeners.SyncListener;
import homepunk.work.mall.domain.repository.SyncRepository;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class SyncRepositoryImpl implements SyncRepository {
    private RemoteMallDataSource remoteDataSource;

    public SyncRepositoryImpl(Context context) {
        DataSourceManager dataSourceManager = new DataSourceManager(context);

        remoteDataSource = dataSourceManager.getRemoteDataSource();
    }

    @Override
    public void sync(SyncListener listener) {
        Timber.i("Syncing...");
        remoteDataSource.getMallsResponse()
                        .subscribeOn(Schedulers.io());
    }

    private void syncMallRecords(Mall mall) {
        remoteDataSource.getMallSyncReponse(mall.getId())
                .subscribeOn(Schedulers.io());

        remoteDataSource.getTypeCategoryResponse(mall.getId())
                .subscribeOn(Schedulers.trampoline());
    }
}