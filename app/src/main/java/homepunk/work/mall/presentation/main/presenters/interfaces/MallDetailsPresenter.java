package homepunk.work.mall.presentation.main.presenters.interfaces;

import homepunk.work.mall.presentation.main.views.interfaces.MallDetailesView;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface MallDetailsPresenter {
    void init(MallDetailesView view);
    void getMallDetails();
}
