package homepunk.work.mall.domain.listeners;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public interface MallListener <T>{
    void onSuccess(T t);
    void onFailed(Throwable error);
}
