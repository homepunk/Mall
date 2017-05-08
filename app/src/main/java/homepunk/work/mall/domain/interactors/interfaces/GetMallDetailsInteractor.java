package homepunk.work.mall.domain.interactors.interfaces;

import homepunk.work.mall.data.models.MallDetails;
import homepunk.work.mall.domain.listeners.MallListener;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface GetMallDetailsInteractor {
    void getMallDetails(int id, MallListener<MallDetails> listener);
}
