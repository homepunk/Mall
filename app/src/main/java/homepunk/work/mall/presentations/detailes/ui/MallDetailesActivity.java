package homepunk.work.mall.presentations.detailes.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import homepunk.work.mall.R;
import homepunk.work.mall.presentations.detailes.ui.interfaces.IMallDetailesView;
import homepunk.work.mall.presentations.main.model.Mall;

public class MallDetailesActivity extends AppCompatActivity implements IMallDetailesView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
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

    }
}
