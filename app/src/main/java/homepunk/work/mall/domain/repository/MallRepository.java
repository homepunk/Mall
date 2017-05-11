package homepunk.work.mall.domain.repository;

import java.util.List;

import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import homepunk.work.mall.presentation.viewmodel.MallDetailsViewModel;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface MallRepository {
    Single<List<MallViewModel>> getMalls();

    Single<MallDetailsViewModel> getMallDetails(int id);
}
