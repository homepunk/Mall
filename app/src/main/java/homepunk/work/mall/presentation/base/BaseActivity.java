package homepunk.work.mall.presentation.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;

import butterknife.ButterKnife;
import homepunk.work.mall.presentation.view.View;

import static homepunk.work.mall.data.Constants.Keys.KEY_BUNDLE;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class BaseActivity extends AppCompatActivity implements View {
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    protected void addFragmentWithExtras(int containerId, Fragment fragment, Serializable extras) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        putExtrasToFragment(extras, fragment);

        fragmentTransaction.add(containerId, fragment);
        fragmentTransaction.commit();
    }

    private void putExtrasToFragment(Serializable extras, Fragment fragment) {
        Bundle bundle = new Bundle();

        bundle.putSerializable(KEY_BUNDLE, extras);
        fragment.setArguments(bundle);
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
