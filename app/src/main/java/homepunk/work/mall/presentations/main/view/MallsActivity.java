package homepunk.work.mall.presentations.main.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import homepunk.work.mall.R;
import homepunk.work.mall.presentations.main.adapter.MallAdapter;
import homepunk.work.mall.presentations.main.model.Mall;
import homepunk.work.mall.presentations.main.presenter.MallsPresenter;
import homepunk.work.mall.presentations.main.presenter.interfaces.IMallsPresenter;
import homepunk.work.mall.presentations.main.view.interfaces.IMallsView;

public class MallsActivity extends AppCompatActivity implements IMallsView {
    @Bind(R.id.malls_recycle_view) RecyclerView mallsRecycleView;

    private IMallsPresenter mainMallsPresenter;
    private MallAdapter mallAdapter;
    private List<Mall> malls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malls);

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
        if (malls != null) {
            mallAdapter.updateMalls(malls);
        }
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    private void initUI() {
        ButterKnife.bind(this);

        mainMallsPresenter = new MallsPresenter();
        mainMallsPresenter.setView(this);

        mallAdapter = new MallAdapter(this);
        malls = new ArrayList<>();

        mallAdapter.setList(malls);
        mallsRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mallsRecycleView.setAdapter(mallAdapter);
    }
}
