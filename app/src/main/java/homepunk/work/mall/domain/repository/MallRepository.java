package homepunk.work.mall.domain.repository;

import java.util.List;

import homepunk.work.mall.data.entity.Floor;
import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.entity.Placement;
import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.Shop;
import rx.Observable;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface MallRepository {
    Observable<List<Mall>> getMalls();

    Observable<List<Shop>> getMallShops(int id);

    Observable<List<Floor>> getMallFloors(int id);

    Observable<List<Product>> getMallProducts(int id);

    Observable<List<Placement>> getMallPlacements(int id);
}
