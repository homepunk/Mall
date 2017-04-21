package homepunk.work.mall.presentations.main.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import homepunk.work.mall.R;
import homepunk.work.mall.presentations.main.model.Mall;
import homepunk.work.mall.presentations.main.presenter.MainMallsPresenter;
import homepunk.work.mall.presentations.main.presenter.interfaces.IMainMallsPresenter;
import homepunk.work.mall.presentations.main.view.interfaces.IMainMallsView;

public class MainMallsActivity extends AppCompatActivity implements IMainMallsView {
    private IMainMallsPresenter mainMallsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mainMallsPresenter.getMalls();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onResult(List<Mall> malls) {
        Toast.makeText(this, malls.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    private void initUI() {
        mainMallsPresenter = new MainMallsPresenter();
        mainMallsPresenter.setView(this);
    }
}
