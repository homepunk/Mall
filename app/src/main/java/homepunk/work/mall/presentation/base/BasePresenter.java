package homepunk.work.mall.presentation.base;

import homepunk.work.mall.presentation.presenter.interfaces.Presenter;
import homepunk.work.mall.presentation.view.View;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public abstract class BasePresenter <T extends View> implements Presenter<T> {
    protected T view;

    @Override
    public void init(T view) {
        this.view = view;
    }

    @Override
    public void terminate() {
        this.view = null;
    }
}
