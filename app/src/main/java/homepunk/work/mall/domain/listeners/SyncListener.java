package homepunk.work.mall.domain.listeners;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public interface SyncListener {
    void onSyncSuccess();

    void onSyncFailed();
}
