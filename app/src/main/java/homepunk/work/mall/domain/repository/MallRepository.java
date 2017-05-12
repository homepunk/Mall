package homepunk.work.mall.domain.repository;

import java.util.List;

import homepunk.work.mall.presentation.viewmodel.FloorViewModel;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import homepunk.work.mall.presentation.viewmodel.PlacementViewModel;
import homepunk.work.mall.presentation.viewmodel.ProductViewModel;
import homepunk.work.mall.presentation.viewmodel.ShopViewModel;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface MallRepository {
    Single<List<MallViewModel>> getMalls();

    Single<List<FloorViewModel>> getFloorsByMallId(int id);

    Single<List<ShopViewModel>> getShopsByMallId(int id);

    Single<List<PlacementViewModel>> getPlacementsByMallId(int id);

    Single<List<ProductViewModel>> getProductsByMallId(int id);
}
