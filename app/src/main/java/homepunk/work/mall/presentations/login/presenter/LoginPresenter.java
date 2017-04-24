package homepunk.work.mall.presentations.login.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import homepunk.work.mall.data.remote.repository.interfaces.IRemoteRepository;
import homepunk.work.mall.presentations.login.models.LoginCredentials;
import homepunk.work.mall.presentations.login.models.UserLogin;
import homepunk.work.mall.presentations.login.presenter.interfaces.ILoginPresenter;
import homepunk.work.mall.presentations.login.view.interfaces.ILoginView;
import homepunk.work.mall.presentations.main.view.MallsActivity;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static homepunk.work.mall.data.Constants.USER_KEY_ID;


public class LoginPresenter implements ILoginPresenter {
    private ILoginView view;
    private IRemoteRepository dataRepository;
    private ILocalDataRepository localDataRepository;

    public LoginPresenter() {
        this.dataRepository= new DataRepository();
        this.localDataRepository = new LocalDataRepository();
    }

    @Override
    public void setView(ILoginView view) {
        this.view = view;
    }

    @Override
    public void navigateToMainScreen(UserLogin user) {
        Context context = view.getContext();
        Intent intent = new Intent(context, MallsActivity.class);

        intent.putExtra(USER_KEY_ID, user);

        context.startActivity(intent);
    }

    @Override
    public void login(String email, String password) {
        if (view == null) {
            return;
        }

        boolean error = false;
        view.showProgressDialog(true);

        if (TextUtils.isEmpty(email) || email.length() < 3) {
            error = true;
            view.onEmailError();
            view.showProgressDialog(false);
        }

        if (TextUtils.isEmpty(password) || password.length() < 4) {
            error = true;
            view.onPasswordError();
            view.showProgressDialog(false);
        }

        if (!error) {
            dataRepository
                    .login(new LoginCredentials(email, password))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleSubscriber<UserLogin>() {
                        @Override
                        public void onSuccess(UserLogin user) {
                            if (view != null) {
                                view.onLoginSuccess(user);
                                view.showProgressDialog(false);

                                localDataRepository.saveUserToken(user.getToken());
                            }
                        }

                        @Override
                        public void onError(Throwable error) {
                            if (view != null) {
                                view.onLoginError(error.getLocalizedMessage());
                                view.showProgressDialog(false);
                            }
                        }
                    });
        }
    }
}
