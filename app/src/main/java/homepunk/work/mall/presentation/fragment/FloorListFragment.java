package homepunk.work.mall.presentation.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import homepunk.work.mall.R;
import homepunk.work.mall.presentation.adapter.FloorAdapter;
import homepunk.work.mall.presentation.base.BaseFragment;
import homepunk.work.mall.presentation.presenter.MallFloorListPresenterImpl;
import homepunk.work.mall.presentation.presenter.interfaces.MallFloorListPresenter;
import homepunk.work.mall.presentation.view.MallFloorListView;
import homepunk.work.mall.presentation.viewmodel.FloorViewModel;

public class FloorListFragment extends BaseFragment implements MallFloorListView {
    @BindView(R.id.floor_rv) RecyclerView floorRecycler;

    private FloorAdapter floorAdapter;
    private List<FloorViewModel> floors;
    private MallFloorListPresenter detailsPresenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI();
        initPresenter();

        detailsPresenter.getFloors();
    }

    @Override
    public void onDestroyView() {
        detailsPresenter.terminate();
        super.onDestroyView();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_mall_floor_list;
    }

    @Override
    public void onResult(List<FloorViewModel> floors) {
        floorAdapter.update(floors);
    }

    @Override
    public void onError(String error) {
        showErrorToast(error);
    }

    private void initUI() {
        floorAdapter = new FloorAdapter(getContext());
        floors = new ArrayList<>();

        floorAdapter.setList(floors);
        floorRecycler.setAdapter(floorAdapter);
    }

    private void initPresenter() {
        detailsPresenter = new MallFloorListPresenterImpl();
        detailsPresenter.init(this);
    }
}
