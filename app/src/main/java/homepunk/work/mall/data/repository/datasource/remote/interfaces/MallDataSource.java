package homepunk.work.mall.data.repository.datasource.remote.interfaces;

import homepunk.work.mall.data.entity.response.MallDetailsResponse;
import homepunk.work.mall.data.entity.response.MallResponse;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface MallDataSource {
    Single<MallResponse> getMalls();

    Single<MallDetailsResponse> getMallDetails(int id);
}
