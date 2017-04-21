package homepunk.work.mall.presentations.main.presenter.interfaces;

import homepunk.work.mall.presentations.main.view.interfaces.IMainMallsView;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface IMainMallsPresenter {
    void setView(IMainMallsView view);
    void getMalls();
}
