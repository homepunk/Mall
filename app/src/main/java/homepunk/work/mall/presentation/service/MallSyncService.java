package homepunk.work.mall.presentation.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import homepunk.work.mall.domain.interactors.SyncUpdatesInteractorImpl;
import homepunk.work.mall.domain.interactors.interfaces.SyncUpdatesInteractor;
import homepunk.work.mall.domain.listeners.SyncListener;
import timber.log.Timber;

public class MallSyncService extends Service {
    private SyncUpdatesInteractor syncUpdatesInteractor;

    @Override
    public void onCreate() {
        super.onCreate();

        syncUpdatesInteractor = new SyncUpdatesInteractorImpl(getApplicationContext());
    }

    @Override
    public void onDestroy() {
        Timber.i("Service destroyed");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        syncUpdatesInteractor.syncMallUpdates(new SyncListener() {
            @Override
            public void onSyncSuccess() {
                Timber.i("Sync successfully");
                stopSelf();
            }

            @Override
            public void onSyncFailed() {
                stopSelf();
            }
        });

        return Service.START_STICKY;

    }

    @Override
    public IBinder onBind(Intent intent) {
        Timber.i("onBind called");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
