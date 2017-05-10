package homepunk.work.mall.presentation.presenter.interfaces;

import homepunk.work.mall.presentation.model.UserLogin;
import homepunk.work.mall.presentation.view.LoginView;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface LoginPresenter extends BasePresenter<LoginView> {
    void login(String email, String password);

    void navigateToMainScreen(UserLogin user);
}
