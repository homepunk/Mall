package homepunk.work.mall.presentation.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import homepunk.work.mall.domain.interactors.SyncUpdatesInteractorImpl;
import homepunk.work.mall.domain.interactors.interfaces.SyncUpdatesInteractor;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import timber.log.Timber;

import static homepunk.work.mall.data.Constants.Keys.KEY_MALL;

public class MallSyncService extends Service {
    private SyncUpdatesInteractor syncUpdatesInteractor;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.i("Service created");
        syncUpdatesInteractor = new SyncUpdatesInteractorImpl(getApplicationContext());
    }

    @Override
    public void onDestroy() {
        Timber.i("Service destroyed");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MallViewModel mall = (MallViewModel) intent.getSerializableExtra(KEY_MALL);

        if (mall != null) {
            Timber.e("Syncing mall...");
            syncUpdatesInteractor.syncMall(mall);
        } else {
            Timber.i("Syncing mall list...");
            syncUpdatesInteractor.syncMallList();
        }

        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Timber.i("onBind called");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
