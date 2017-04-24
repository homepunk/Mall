package homepunk.work.mall.presentations.login.presenter.interfaces;

import homepunk.work.mall.presentations.login.models.UserLogin;
import homepunk.work.mall.presentations.login.view.interfaces.ILoginView;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface ILoginPresenter {
    void setView(ILoginView view);

    void login(String email, String password);

    void navigateToMainScreen(UserLogin user);
}
