package homepunk.work.mall.presentations.login.view.interfaces;

import homepunk.work.mall.presentations.base.IBaseView;
import homepunk.work.mall.presentations.login.models.UserLogin;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface ILoginView extends IBaseView{
    void onLoginSuccess(UserLogin loginUser);
    void onLoginError(String error);

    void onEmailError();
    void onPasswordError();

    void showProgressDialog(boolean show);
}
