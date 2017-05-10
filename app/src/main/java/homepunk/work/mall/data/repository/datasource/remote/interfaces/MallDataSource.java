package homepunk.work.mall.data.repository.datasource.remote.interfaces;

import homepunk.work.mall.data.entity.MallDetailsResponse;
import homepunk.work.mall.data.entity.MallResponse;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface MallDataSource {
    Single<MallResponse> getMalls();

    Single<MallDetailsResponse> getMallDetails(int id);
}
