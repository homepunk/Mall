package homepunk.work.mall.presentations.detailes.presenter.interfaces;

import homepunk.work.mall.presentations.detailes.ui.interfaces.IMallDetailesView;
import homepunk.work.mall.presentations.login.models.UserLogin;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface IMallDetailesPresenter {
    void setView(IMallDetailesView view);
    void getMallDetailes(UserLogin user, int id);
}
