package homepunk.work.mall.presentation.view;

import java.util.List;

import homepunk.work.mall.presentation.model.Mall;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface MallListView extends BaseView {
    void onResult(List<Mall> malls);

    void onError(String error);
}
