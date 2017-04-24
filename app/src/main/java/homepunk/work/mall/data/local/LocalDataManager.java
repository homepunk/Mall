package homepunk.work.mall.data.local;

import homepunk.work.mall.data.local.interfaces.ILocalDataManager;
import homepunk.work.mall.data.local.interfaces.ISharedPreferencesRepository;
import homepunk.work.mall.data.local.repository.SharedPreferencesRepository;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class LocalDataManager implements ILocalDataManager {
    private ISharedPreferencesRepository sharedPreferencesRepository;

    public LocalDataManager() {
        this.sharedPreferencesRepository = new SharedPreferencesRepository();
    }

    @Override
    public String getUserToken() {
        return sharedPreferencesRepository.retrieveAccessToken();
    }

    @Override
    public void saveUserToken(String token) {
        sharedPreferencesRepository.storeAccessToken(token);
    }
}
