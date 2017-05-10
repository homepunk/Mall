package homepunk.work.mall.presentation.presenter.interfaces;

import homepunk.work.mall.presentation.model.Mall;
import homepunk.work.mall.presentation.view.MallListView;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface MallListPresenter extends BasePresenter<MallListView> {
    void getMalls();

    void navigateToMallDetails(Mall mall);
}
