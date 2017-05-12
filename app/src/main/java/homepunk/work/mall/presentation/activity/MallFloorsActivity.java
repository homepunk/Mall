package homepunk.work.mall.presentation.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import homepunk.work.mall.R;
import homepunk.work.mall.presentation.base.BaseActivity;
import homepunk.work.mall.presentation.presenter.MallFloorsPresenterImpl;
import homepunk.work.mall.presentation.presenter.interfaces.MallFloorsPresenter;
import homepunk.work.mall.presentation.view.MallFloorsView;
import homepunk.work.mall.presentation.viewmodel.FloorViewModel;

public class MallFloorsActivity extends BaseActivity implements MallFloorsView {
    @Bind(R.id.mall_details_image)
    ImageView mallImage;
    @Bind(R.id.mall_details_description)
    TextView mallDescription;

    private MallFloorsPresenter detailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_details);

        initPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.getFloors();
    }

    @Override
    public void onResult(List<FloorViewModel> floors) {
//        addFragmentWithExtras(R.id.fragments_container, new FloorListFragment(), floors);
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    private void initPresenter() {
        detailsPresenter = new MallFloorsPresenterImpl();
        detailsPresenter.init(this);
    }
}
