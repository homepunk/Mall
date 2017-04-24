package homepunk.work.mall.data;

import homepunk.work.mall.data.interfaces.IDataRepository;
import homepunk.work.mall.data.local.LocalDataManager;
import homepunk.work.mall.data.local.interfaces.ILocalDataManager;
import homepunk.work.mall.data.remote.repository.MallApiRepository;
import homepunk.work.mall.data.remote.repository.interfaces.IMallApiRepository;
import homepunk.work.mall.presentations.login.models.LoginCredentials;
import homepunk.work.mall.presentations.login.models.UserLogin;
import homepunk.work.mall.presentations.main.model.Malls;
import rx.Single;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class DataRepository implements IDataRepository {
    private IMallApiRepository networkRepository;
    private ILocalDataManager localDataManager;

    public DataRepository() {
        this.localDataManager = new LocalDataManager();
        this.networkRepository = new MallApiRepository();
    }

    @Override
    public Single<UserLogin> loginByCredentials(LoginCredentials credentials) {
        return networkRepository.loginByCredentials(credentials);
    }

    @Override
    public Single<Malls> fetchMalls() {
        return networkRepository.fetchMalls(localDataManager.getUserToken());
    }
}
