package homepunk.work.mall.data;

import homepunk.work.mall.data.interfaces.IDataRepository;
import homepunk.work.mall.data.interfaces.ILocalDataRepository;
import homepunk.work.mall.data.remote.repository.MallApiRepository;
import homepunk.work.mall.data.remote.repository.interfaces.IMallApiRepository;
import homepunk.work.mall.presentations.login.models.LoginCredentials;
import homepunk.work.mall.presentations.login.models.UserLogin;
import homepunk.work.mall.presentations.main.model.Mall;
import homepunk.work.mall.presentations.main.model.Malls;
import rx.Single;
import timber.log.Timber;

public class DataRepository implements IDataRepository {
    private IMallApiRepository networkRepository;
    private ILocalDataRepository localDataRepository;

    public DataRepository() {
        this.localDataRepository = new LocalDataRepository();
        this.networkRepository = new MallApiRepository();
    }

    @Override
    public Single<UserLogin> login(LoginCredentials credentials) {
        return networkRepository.loginByCredentials(credentials);
    }

    @Override
    public Single<Malls> loadMalls() {
        Timber.i("User token: " + localDataRepository.getUserToken());
        return networkRepository.fetchMalls(localDataRepository.getUserToken());
    }

    @Override
    public Single<Mall> loadMallDetails(int id) {
        return networkRepository.fetchMallDetailes(id, localDataRepository.getUserToken());
    }
}
