package homepunk.work.mall.domain.repository;

import homepunk.work.mall.domain.listeners.SyncListener;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public interface SyncRepository {
    void sync(SyncListener listener);
}
