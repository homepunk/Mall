package homepunk.work.mall.presentations.details.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import homepunk.work.mall.R;
import homepunk.work.mall.presentations.details.presenter.interfaces.IMallDetailsPresenter;
import homepunk.work.mall.presentations.details.ui.interfaces.IMallDetailesView;
import homepunk.work.mall.presentations.main.model.Mall;

public class MallDetailsActivity extends AppCompatActivity implements IMallDetailesView {
    private IMallDetailsPresenter mallDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_details);
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
    public void onResult(Mall mall) {

    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


}
