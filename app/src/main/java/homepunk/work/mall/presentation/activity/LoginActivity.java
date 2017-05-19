package homepunk.work.mall.presentation.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import butterknife.BindView;
import butterknife.OnClick;
import homepunk.work.mall.R;
import homepunk.work.mall.presentation.base.BaseActivity;
import homepunk.work.mall.presentation.presenter.LoginPresenterImpl;
import homepunk.work.mall.presentation.presenter.interfaces.LoginPresenter;
import homepunk.work.mall.presentation.view.LoginView;
import homepunk.work.mall.presentation.viewmodel.UserViewModel;

public class LoginActivity extends BaseActivity implements LoginView {
    @BindView(R.id.login_form)
    ScrollView loginForm;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login_progress)
    ProgressBar progress;
    @BindView(R.id.email)
    AutoCompleteTextView email;

    private int defaultAnimTime;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();
        initPresenter();
        loginPresenter.verifyUserAuthentication();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onLoginSuccess(UserViewModel user) {
        loginPresenter.navigateToMallListActivity();
    }

    @Override
    public void onLoginError(String error) {
        showToast(error);
    }

    @Override
    public void onEmailError() {
        email.setError(getString(R.string.error_invalid_email));
    }

    @Override
    public void onPasswordError() {
        password.setError(getString(R.string.error_incorrect_password));
    }

    @Override
    public void showProgressDialog(boolean show) {
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                loginForm.setVisibility(show ? View.GONE : View.VISIBLE);
            }
        };

        loginForm.setVisibility(show ? View.GONE : View.VISIBLE);
        loginForm.animate()
                .setDuration(defaultAnimTime)
                .alpha(show ? 0 : 1)
                .setListener(animatorListenerAdapter);

        progress.setVisibility(show ? View.VISIBLE : View.GONE);
        progress.animate()
                .setDuration(defaultAnimTime)
                .alpha(show ? 1 : 0)
                .setListener(animatorListenerAdapter);
    }


    @OnClick(R.id.sign_in_button)
    public void onSignInButtonClick() {
        loginPresenter.login(email.getText().toString(), password.getText().toString());
    }

    private void initUI() {
        defaultAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        email.setText(R.string.testEmail);
        password.setText(R.string.testPassword);
    }

    private void initPresenter() {
        loginPresenter = new LoginPresenterImpl();
        loginPresenter.init(this);
    }
}

