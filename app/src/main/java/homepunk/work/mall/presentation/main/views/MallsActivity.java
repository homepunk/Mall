package homepunk.work.mall.presentation.main.views;

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
import homepunk.work.mall.data.models.Mall;
import homepunk.work.mall.presentation.main.adapters.MallAdapter;
import homepunk.work.mall.presentation.main.adapters.RecyclerClickListener;
import homepunk.work.mall.presentation.main.presenters.MallsPresenterImpl;
import homepunk.work.mall.presentation.main.presenters.interfaces.MallsPresenter;
import homepunk.work.mall.presentation.main.views.interfaces.MallsView;

public class MallsActivity extends AppCompatActivity implements MallsView {
    @Bind(R.id.malls_recycle_view) RecyclerView mallsRecycler;

    private MallsPresenter mainMallsPresenter;
    private MallAdapter mallAdapter;
    private List<Mall> malls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malls);

        initUI();
        initPresenter();
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

        malls = new ArrayList<>();

        mallAdapter = new MallAdapter(this);
        mallAdapter.setList(malls);

        mallsRecycler.setAdapter(mallAdapter);
        mallsRecycler.setLayoutManager(new LinearLayoutManager(this));
        mallsRecycler.addOnItemTouchListener(new RecyclerClickListener(this, (view, position) -> {
            mainMallsPresenter.navigateToMallDetails(malls.get(position).getId());
        }));
    }

    private void initPresenter() {
        mainMallsPresenter = new MallsPresenterImpl();
        mainMallsPresenter.init(this);
    }
}
