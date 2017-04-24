package homepunk.work.mall.presentations.login.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import homepunk.work.mall.R;
import homepunk.work.mall.presentations.login.models.UserLogin;
import homepunk.work.mall.presentations.login.presenter.LoginPresenter;
import homepunk.work.mall.presentations.login.presenter.interfaces.ILoginPresenter;
import homepunk.work.mall.presentations.login.view.interfaces.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    @Bind(R.id.login_form) View loginForm;
    @Bind(R.id.password) EditText password;
    @Bind(R.id.login_progress) View progress;
    @Bind(R.id.email) AutoCompleteTextView email;

    private int defaultAnimTime;
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initUI();
    }

    @Override
    public void onLoginSuccess(UserLogin user) {
        loginPresenter.navigateToMainScreen(user);
    }

    @Override
    public void onLoginError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
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
        loginPresenter.login(email.getText().toString(),
                             password.getText().toString());
    }

    private void initUI() {
        defaultAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        loginPresenter = new LoginPresenter();
        loginPresenter.setView(this);

        email.setText(R.string.testEmail);
        password.setText(R.string.testPassword);

    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public Context getContext() {
        return this;
    }
}

