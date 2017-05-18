package homepunk.work.mall.presentation.presenter.interfaces;

import homepunk.work.mall.presentation.view.LoginView;
import homepunk.work.mall.presentation.viewmodel.UserViewModel;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface LoginPresenter extends Presenter<LoginView> {
    void login(String email, String password);

    void navigateToMainScreen(UserViewModel user);
}
