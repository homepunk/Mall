package homepunk.work.mall.domain.interactors.interfaces;

import homepunk.work.mall.presentation.viewmodel.MallViewModel;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public interface SyncUpdatesInteractor {
    void syncMall(MallViewModel mall);

    void syncMallList();
}
