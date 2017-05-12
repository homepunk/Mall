package homepunk.work.mall.presentation.view;

import java.util.List;

import homepunk.work.mall.presentation.base.BaseView;
import homepunk.work.mall.presentation.viewmodel.FloorViewModel;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface MallFloorsView extends BaseView {
    void onResult(List<FloorViewModel> floors);

    void onError(String error);
}
