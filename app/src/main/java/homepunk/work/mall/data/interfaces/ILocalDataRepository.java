package homepunk.work.mall.data.interfaces;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface ILocalDataRepository {
    String getUserToken();
    void saveUserToken(String token);
}
