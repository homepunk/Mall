package homepunk.work.mall.presentations.detailes.ui.interfaces;

import homepunk.work.mall.presentations.base.IBaseView;
import homepunk.work.mall.presentations.main.model.Mall;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface IMallDetailesView extends IBaseView {
    void onResult(Mall mall);
    void onError(String error);
}