package homepunk.work.mall.presentation.presenter.interfaces;

import homepunk.work.mall.presentation.view.MallListView;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface MallListPresenter extends Presenter<MallListView> {
    void getMalls();

    void navigateToMallDetails(MallViewModel mall);
}
