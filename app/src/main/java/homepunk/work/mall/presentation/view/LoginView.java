package homepunk.work.mall.presentation.view;

import homepunk.work.mall.presentation.base.BaseView;
import homepunk.work.mall.presentation.viewmodel.UserLoginViewModel;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public interface LoginView extends BaseView {
    void onLoginSuccess(UserLoginViewModel loginUser);
    void onLoginError(String error);

    void onEmailError();
    void onPasswordError();

    void showProgressDialog(boolean show);
}