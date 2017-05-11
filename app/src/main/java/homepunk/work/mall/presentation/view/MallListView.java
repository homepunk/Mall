package homepunk.work.mall.presentation.view;

import java.util.List;

import homepunk.work.mall.presentation.base.BaseView;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface MallListView extends BaseView {
    void onResult(List<MallViewModel> malls);

    void onError(String error);
}
