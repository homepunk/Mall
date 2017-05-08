package homepunk.work.mall.domain.repositorys;

import java.util.List;

import homepunk.work.mall.data.models.Mall;
import homepunk.work.mall.data.models.MallDetails;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface MallRepository {
    Single<List<Mall>> getMalls();

    Single<MallDetails> getMallDetails(int id);
}
