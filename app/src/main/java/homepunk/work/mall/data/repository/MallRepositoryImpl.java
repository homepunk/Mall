package homepunk.work.mall.data.repository;

import android.content.Context;

import java.util.List;

import homepunk.work.mall.data.entity.mapper.DatabaseMapper;
import homepunk.work.mall.data.repository.datasource.interfaces.MallDataSource;
import homepunk.work.mall.data.repository.manager.DataSourceManager;
import homepunk.work.mall.domain.repository.MallRepository;
import homepunk.work.mall.presentation.viewmodel.FloorViewModel;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import homepunk.work.mall.presentation.viewmodel.PlacementViewModel;
import homepunk.work.mall.presentation.viewmodel.ProductViewModel;
import homepunk.work.mall.presentation.viewmodel.ShopViewModel;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class MallRepositoryImpl implements MallRepository {
    private MallDataSource dataSource;

    public MallRepositoryImpl(Context context) {
        this.dataSource = new DataSourceManager(context).getDatabaseDataSource();
    }

    @Override
    public Single<List<MallViewModel>> getMalls() {
        return dataSource.getMalls()
                         .map(DatabaseMapper::transform);
    }

    @Override
    public Single<List<FloorViewModel>> getFloorsByMallId(int id) {
        return null;
    }

    @Override
    public Single<List<ShopViewModel>> getShopsByMallId(int id) {
        return null;
    }

    @Override
    public Single<List<PlacementViewModel>> getPlacementsByMallId(int id) {
        return null;
    }

    @Override
    public Single<List<ProductViewModel>> getProductsByMallId(int id) {
        return null;
    }

}
