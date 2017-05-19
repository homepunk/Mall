package homepunk.work.mall.presentation.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import homepunk.work.mall.R;
import homepunk.work.mall.presentation.base.BaseActivity;
import homepunk.work.mall.presentation.fragment.FloorListFragment;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import homepunk.work.mall.utils.PicassoUtils;

import static homepunk.work.mall.data.Constants.Keys.KEY_MALL;

public class MallActivity extends BaseActivity  {
    @BindView(R.id.mall_image)
    ImageView mallImage;
    @BindView(R.id.mall_description)
    TextView mallDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);

        initUI();
        addFragment(R.id.fragments_container, new FloorListFragment());
    }

    private void initUI() {
        MallViewModel mall = (MallViewModel) getIntentExtra(KEY_MALL);

        PicassoUtils.load(getContext(), mall.getFullImagePath(), mallImage);
        mallDescription.setText(mall.getDescription());
    }
}
