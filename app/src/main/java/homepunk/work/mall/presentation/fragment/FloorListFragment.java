package homepunk.work.mall.presentation.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.Bind;
import homepunk.work.mall.R;
import homepunk.work.mall.presentation.adapter.FloorAdapter;

public class FloorListFragment extends BaseFragment {
    @Bind(R.id.floor_rv) RecyclerView floorRecycler;

    private FloorAdapter floorAdapter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI();
    }

    private void initUI() {
        floorAdapter = new FloorAdapter(getContext());
        floorAdapter.setList(mallDetails.getFloors());

        floorRecycler.setAdapter(floorAdapter);
        floorRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_floor_list;
    }
}
