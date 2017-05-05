package homepunk.work.mall.presentation.main.presenters.interfaces;

import homepunk.work.mall.presentation.main.views.interfaces.MallsView;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface MallsPresenter {
    void init(MallsView view);
    void getMalls();
    void navigateToMallDetails(int id);
}
