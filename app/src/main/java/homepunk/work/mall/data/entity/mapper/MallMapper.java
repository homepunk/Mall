package homepunk.work.mall.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public class MallMapper {
    public static ArrayList<MallViewModel> transform(List<Mall> malls) {
        ArrayList<MallViewModel> mallViewModels = new ArrayList<>();

        for (Mall mall: malls) {
            MallViewModel mallViewModel = new MallViewModel(mall.getId(),
                    mall.getName(),
                    mall.getDescription(),
                    mall.getLatitude(),
                    mall.getLongtitude(),
                    mall.getImage());

            mallViewModels.add(mallViewModel);
        }

        return mallViewModels;
    }
}
