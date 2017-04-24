package homepunk.work.mall.utils;

import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class RxUtils {
    public static <T> Single.Transformer<T, T> applyIOSchedulers() {
        return single -> single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
