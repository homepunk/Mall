package homepunk.work.mall.presentations.detailes.presenter.interfaces;

import homepunk.work.mall.presentations.detailes.ui.interfaces.IMallDetailesView;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface IMallDetailesPresenter {
    void setView(IMallDetailesView view);
    void getMallDetailes(int id);
}
