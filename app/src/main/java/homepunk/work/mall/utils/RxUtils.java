package homepunk.work.mall.utils;


import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class RxUtils {
    public static <T> SingleTransformer<T, T> applyIOSchedulers() {
        return single -> single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
