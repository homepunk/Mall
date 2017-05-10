package homepunk.work.mall.domain.interactors.interfaces;

import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.presentation.model.Mall;
import homepunk.work.mall.presentation.model.MallDetails;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface GetMallDetailsInteractor {
    void getMallDetails(Mall mall, MallListener<MallDetails> listener);
}
