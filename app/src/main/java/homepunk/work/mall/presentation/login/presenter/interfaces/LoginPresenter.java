package homepunk.work.mall.presentation.login.presenter.interfaces;

import homepunk.work.mall.data.models.UserLogin;
import homepunk.work.mall.presentation.login.view.interfaces.LoginView;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface LoginPresenter {
    void init(LoginView view);

    void login(String email, String password);

    void navigateToMainScreen(UserLogin user);
}
