package homepunk.work.mall.presentations.main.presenter.interfaces;

import homepunk.work.mall.presentations.main.view.interfaces.IMallsView;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface IMallsPresenter {
    void setView(IMallsView view);
    void getMalls();
}
