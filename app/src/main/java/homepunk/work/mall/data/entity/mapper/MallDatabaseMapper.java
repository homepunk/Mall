package homepunk.work.mall.data.entity.mapper;

import java.util.ArrayList;

import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.entity.response.MallResponse;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public class MallDatabaseMapper {
    public static ArrayList<Mall> transform(MallResponse mallResponse) {
        ArrayList<Mall> malls = new ArrayList<>();
        for (MallViewModel mallViewModel : mallResponse.getMalls()) {
            malls.add(new Mall(mallViewModel));
        }

        return malls;
    }
}
