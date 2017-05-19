package homepunk.work.mall.presentation.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import homepunk.work.mall.R;
import homepunk.work.mall.presentation.adapter.MallAdapter;
import homepunk.work.mall.presentation.base.BaseActivity;
import homepunk.work.mall.presentation.listener.RecyclerClickListener;
import homepunk.work.mall.presentation.presenter.MallListPresenterImpl;
import homepunk.work.mall.presentation.presenter.interfaces.MallListPresenter;
import homepunk.work.mall.presentation.view.MallListView;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;

public class MallListActivity extends BaseActivity implements MallListView {
    @BindView(R.id.malls_recycle_view)
    RecyclerView mallsRecycler;

    private MallListPresenter mainMallsPresenter;
    private MallAdapter mallAdapter;
    private List<MallViewModel> malls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_list);

        initUI();
        initPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mainMallsPresenter.getMalls();
    }

    @Override
    public void onResult(List<MallViewModel> malls) {
        mallAdapter.update(malls);
    }

    @Override
    public void onError(String error) {
        showToast(error);
    }

    private void initUI() {
        malls = new ArrayList<>();

        mallAdapter = new MallAdapter(this);
        mallAdapter.setList(malls);

        mallsRecycler.setAdapter(mallAdapter);
        mallsRecycler.addOnItemTouchListener(new RecyclerClickListener(this, (view, position) -> mainMallsPresenter.navigateToMallDetails(malls.get(position))));
    }

    private void initPresenter() {
        mainMallsPresenter = new MallListPresenterImpl();
        mainMallsPresenter.init(this);
    }
}
