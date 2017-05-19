package homepunk.work.mall.domain.model.mapper;

import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;

/**
 * Created by Homepunk on 19.05.2017.
 **/

public class ViewModelToEntityMapper {
    public static Mall transform(MallViewModel mall) {
        return new Mall(mall.getId(),
                mall.getName(),
                mall.getFullImagePath(),
                mall.getDescription(),
                mall.getLatitude(),
                mall.getLongtitude());
    }
}
