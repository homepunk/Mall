package homepunk.work.mall.presentation.presenter.interfaces;

import homepunk.work.mall.presentation.view.LoginView;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface LoginPresenter extends Presenter<LoginView> {
    void login(String email, String password);

    void navigateToMallListActivity();

    void verifyUserAuthentication();
}
