package homepunk.work.mall.domain.repository;

import homepunk.work.mall.domain.listeners.SyncListener;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public interface SyncRepository {
    void syncAll(SyncListener listener);

    void syncMallUpdates(SyncListener listener);

    void syncFloorUpdates(SyncListener listener);

    void syncPlacementUpdates(SyncListener listener);

    void syncShopUpdates(SyncListener listener);

    void syncProductUpdates(SyncListener listener);

    boolean isLocalStorageExists();

    long getLastSyncTimestamp();
}
