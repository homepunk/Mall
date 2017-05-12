package homepunk.work.mall.data.repository.datasource.interfaces;

import java.util.List;

import homepunk.work.mall.data.entity.Floor;
import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.entity.Placement;
import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.data.entity.response.MallDetailsResponse;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface MallDataSource {
    Single<List<Mall>> getMalls();

    Single<List<Floor>> getFloorsByMallId(int id);

    Single<List<Shop>> getShopsByMallId(int id);

    Single<List<Product>> getProductsByMallId(int id);

    Single<List<Placement>> getPlacementsByMallId(int id);

    Single<MallDetailsResponse> getMallDetailsById(int id);
}
