package homepunk.work.mall.presentation.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import homepunk.work.mall.R;
import homepunk.work.mall.presentation.fragment.FloorListFragment;
import homepunk.work.mall.presentation.model.MallDetails;
import homepunk.work.mall.presentation.presenter.MallDetailsPresenterImpl;
import homepunk.work.mall.presentation.presenter.interfaces.MallDetailsPresenter;
import homepunk.work.mall.presentation.view.MallDetailesView;
import homepunk.work.mall.utils.PicassoUtils;

public class MallDetailsActivity extends BaseActivity implements MallDetailesView {
    @Bind(R.id.mall_details_image) ImageView mallImage;
    @Bind(R.id.mall_details_description) TextView mallDescription;

    private MallDetailsPresenter detailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_details);

        initPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.getMallDetails();
    }

    @Override
    public void onResult(MallDetails details) {
        if (details != null) {
            PicassoUtils.load(getContext(), details.getMall().getFullImagePath(), mallImage);
            mallDescription.setText(details.getMall().getName());
            addFragmentWithExtras(R.id.fragments_container, new FloorListFragment(), details);
        }
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    private void initPresenter() {
        detailsPresenter = new MallDetailsPresenterImpl();
        detailsPresenter.init(this);
    }
}
