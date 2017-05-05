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
import homepunk.work.mall.data.models.MallDetails;
import homepunk.work.mall.data.models.Shop;
import homepunk.work.mall.presentation.main.presenters.MallDetailsPresenterImpl;
import homepunk.work.mall.presentation.main.presenters.interfaces.MallDetailsPresenter;
import homepunk.work.mall.presentation.main.adapters.ShopsAdapter;
import homepunk.work.mall.presentation.main.views.interfaces.MallDetailesView;

public class MallDetailsActivity extends AppCompatActivity implements MallDetailesView {
    @Bind(R.id.shops_recycler) RecyclerView shopsRecycler;

    private MallDetailsPresenter detailsPresenter;
    private ShopsAdapter shopAdapter;
    private List<Shop> shops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_details);
        ButterKnife.bind(this);

        initUI();
        initPresenter();

        detailsPresenter.getMallDetails();
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
    public void onResult(MallDetails details) {
        if (details != null) {
            shopAdapter.updateShops(details.getShopUpdate().getShops());
        }
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    private void initUI() {
        shops = new ArrayList<>();

        shopAdapter = new ShopsAdapter(this);
        shopAdapter.setList(shops);

        shopsRecycler.setAdapter(shopAdapter);
        shopsRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initPresenter() {
        detailsPresenter = new MallDetailsPresenterImpl();
        detailsPresenter.init(this);
    }
}
