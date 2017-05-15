package homepunk.work.mall.domain.interactors;

import android.content.Context;

import homepunk.work.mall.data.repository.SyncRepositoryImpl;
import homepunk.work.mall.domain.interactors.interfaces.SyncUpdatesInteractor;
import homepunk.work.mall.domain.listeners.SyncListener;
import homepunk.work.mall.domain.repository.SyncRepository;
import timber.log.Timber;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class SyncUpdatesInteractorImpl implements SyncUpdatesInteractor {
    private SyncRepository syncRepository;

    public SyncUpdatesInteractorImpl(Context context) {
        syncRepository = new SyncRepositoryImpl(context);
    }

    @Override
    public void syncAll() {
            syncRepository.syncAll(new SyncListener() {
                @Override
                public void onSyncSuccess() {
                    Timber.i("success");
                }

                @Override
                public void onSyncFailed() {
                    Timber.e("error");
                }
            });
    }
}
