package homepunk.work.mall.presentation.main.views.interfaces;

import homepunk.work.mall.data.models.MallDetails;
import homepunk.work.mall.presentation.base.BaseView;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface MallDetailesView extends BaseView {
    void onResult(MallDetails details);
    void onError(String error);
}
