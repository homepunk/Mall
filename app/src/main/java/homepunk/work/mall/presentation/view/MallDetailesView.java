package homepunk.work.mall.presentation.view;

import homepunk.work.mall.presentation.base.BaseView;
import homepunk.work.mall.presentation.viewmodel.MallDetailsViewModel;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface MallDetailesView extends BaseView {
    void onResult(MallDetailsViewModel details);

    void onError(String error);
}
