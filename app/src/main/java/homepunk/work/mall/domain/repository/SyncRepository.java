package homepunk.work.mall.domain.repository;

import homepunk.work.mall.data.entity.Mall;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public interface SyncRepository {
    void syncMallRecords(Mall mall);

    void syncMallList();
}
