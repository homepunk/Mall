package homepunk.work.mall.presentations.details.ui.interfaces;

import homepunk.work.mall.presentations.base.IBaseView;
import homepunk.work.mall.data.models.Mall;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface IMallDetailesView extends IBaseView {
    void onResult(Mall mall);
    void onError(String error);
}
