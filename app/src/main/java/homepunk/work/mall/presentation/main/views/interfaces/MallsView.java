package homepunk.work.mall.presentation.main.views.interfaces;

import java.util.List;

import homepunk.work.mall.presentation.base.BaseView;
import homepunk.work.mall.data.models.Mall;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface MallsView extends BaseView {
    void onResult(List<Mall> malls);
    void onError(String error);
}
