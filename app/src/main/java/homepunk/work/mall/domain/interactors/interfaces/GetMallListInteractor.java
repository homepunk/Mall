package homepunk.work.mall.domain.interactors.interfaces;

import java.util.List;

import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import homepunk.work.mall.domain.listeners.MallListener;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface GetMallListInteractor {
    void getMalls(MallListener<List<MallViewModel>> listener);
}
