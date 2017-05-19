package homepunk.work.mall.presentation.presenter.interfaces;

import homepunk.work.mall.presentation.view.MallFloorListView;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface MallFloorListPresenter extends Presenter<MallFloorListView> {
    void getFloors();
}
