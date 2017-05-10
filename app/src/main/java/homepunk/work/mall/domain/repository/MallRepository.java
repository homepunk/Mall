package homepunk.work.mall.domain.repository;

import java.util.List;

import homepunk.work.mall.presentation.model.Mall;
import homepunk.work.mall.presentation.model.MallDetails;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface MallRepository {
    Single<List<Mall>> getMalls();


    Single<MallDetails> getMallDetails(int id);
}
