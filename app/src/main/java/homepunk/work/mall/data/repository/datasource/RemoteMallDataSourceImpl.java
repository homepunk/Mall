package homepunk.work.mall.data.repository.datasource;

import java.util.List;

import homepunk.work.mall.data.api.MallApi;
import homepunk.work.mall.data.api.MallApiConnection;
import homepunk.work.mall.data.entity.Floor;
import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.entity.Placement;
import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.data.entity.response.MallDetailsResponse;
import homepunk.work.mall.data.entity.response.MallResponse;
import homepunk.work.mall.data.repository.datasource.interfaces.MallDataSource;
import rx.Single;
import timber.log.Timber;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class RemoteMallDataSourceImpl implements MallDataSource {
    private MallApi mallApi;
    private String userToken;

    public RemoteMallDataSourceImpl(String userToken) {
        this.mallApi = MallApiConnection.getInstance();
        this.userToken = userToken;
    }

    @Override
    public Single<List<Mall>> getMalls() {
        return mallApi
                .fetchMalls(userToken)
                .map(MallResponse::getMalls);
    }

    @Override
    public Single<List<Floor>> getFloorsByMallId(int id) {
        return null;
    }

    @Override
    public Single<List<Shop>> getShopsByMallId(int id) {
        return null;
    }

    @Override
    public Single<List<Product>> getProductsByMallId(int id) {
        return null;
    }

    @Override
    public Single<List<Placement>> getPlacementsByMallId(int id) {
        return null;
    }

    @Override
    public Single<MallDetailsResponse> getMallDetailsById(int id) {
        return mallApi.fetchFullMallInfromation(id, userToken)
                .doOnError(Timber::e);
    }
}
