package homepunk.work.mall.presentations.main.view.interfaces;

import java.util.List;

import homepunk.work.mall.presentations.base.IBaseView;
import homepunk.work.mall.data.models.Mall;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public interface IMallsView extends IBaseView{
    void onResult(List<Mall> malls);
    void onError(String error);
}
