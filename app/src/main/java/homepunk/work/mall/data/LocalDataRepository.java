package homepunk.work.mall.data;

import homepunk.work.mall.data.interfaces.ILocalDataRepository;
import homepunk.work.mall.data.local.LocalDataManager;
import homepunk.work.mall.data.local.interfaces.ILocalDataManager;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class LocalDataRepository implements ILocalDataRepository{
    private ILocalDataManager localDataManager;

    public LocalDataRepository() {
        this.localDataManager = new LocalDataManager();
    }

    @Override
    public String getUserToken() {
        return localDataManager.getUserToken();
    }

    @Override
    public void saveUserToken(String token) {
        localDataManager.saveUserToken(token);
    }
}
