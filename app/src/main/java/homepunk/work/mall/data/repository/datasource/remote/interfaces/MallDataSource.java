package homepunk.work.mall.data.repository.datasource.remote.interfaces;

import homepunk.work.mall.data.models.MallDetails;
import homepunk.work.mall.data.models.MallResponse;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface MallDataSource {
    Single<MallResponse> getMalls();

    Single<MallDetails> getMallDetails(int id);
}
