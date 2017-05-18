package homepunk.work.mall.presentation.presenter.interfaces;

/**
 * Created by Homepunk on 18.05.2017.
 **/

public interface Presenter<T> {
    void init(T view);

    void terminate();
}
