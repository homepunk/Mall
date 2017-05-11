package homepunk.work.mall.domain.repository;

import java.util.List;

import homepunk.work.mall.presentation.viewmodel.FloorViewModel;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public interface FloorRepository {
    List<FloorViewModel> getFloorByMallId(int id);
}
