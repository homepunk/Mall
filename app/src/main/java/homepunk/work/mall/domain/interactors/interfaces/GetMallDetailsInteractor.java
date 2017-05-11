package homepunk.work.mall.domain.interactors.interfaces;

import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import homepunk.work.mall.presentation.viewmodel.MallDetailsViewModel;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface GetMallDetailsInteractor {
    void getMallDetails(MallViewModel mall, MallListener<MallDetailsViewModel> listener);
}
