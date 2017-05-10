package homepunk.work.mall.presentation.view;

import homepunk.work.mall.presentation.model.MallDetails;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface MallDetailesView extends BaseView {
    void onResult(MallDetails details);

    void onError(String error);
}
