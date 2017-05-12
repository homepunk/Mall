package homepunk.work.mall.domain.interactors.interfaces;

import java.util.List;

import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.presentation.viewmodel.FloorViewModel;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface GetFloorListInteractor {
    void getFloorList(MallViewModel mall, MallListener<List<FloorViewModel>> listener);
}
