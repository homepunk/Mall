package homepunk.work.mall.presentation.login.view.interfaces;

import homepunk.work.mall.presentation.base.BaseView;
import homepunk.work.mall.data.models.UserLogin;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface LoginView extends BaseView {
    void onLoginSuccess(UserLogin loginUser);
    void onLoginError(String error);

    void onEmailError();
    void onPasswordError();

    void showProgressDialog(boolean show);
}
