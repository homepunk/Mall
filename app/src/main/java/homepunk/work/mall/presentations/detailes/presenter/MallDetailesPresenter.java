package homepunk.work.mall.presentations.detailes.presenter;

import homepunk.work.mall.data.remote.repository.MallApiRepository;
import homepunk.work.mall.data.remote.repository.interfaces.IMallApiRepository;
import homepunk.work.mall.presentations.detailes.presenter.interfaces.IMallDetailesPresenter;
import homepunk.work.mall.presentations.detailes.ui.interfaces.IMallDetailesView;
import homepunk.work.mall.presentations.login.models.UserLogin;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class MallDetailesPresenter implements IMallDetailesPresenter {
    private IMallDetailesView view;
    private IMallApiRepository mallApiRepository;

    public MallDetailesPresenter() {
        this.mallApiRepository = new MallApiRepository();
    }

    @Override
    public void setView(IMallDetailesView view) {
        this.view = view;
    }

    @Override
    public void getMallDetailes(UserLogin user, int id) {

    }
}
