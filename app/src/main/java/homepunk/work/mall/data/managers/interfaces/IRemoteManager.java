package homepunk.work.mall.data.managers.interfaces;

import homepunk.work.mall.data.remote.repository.interfaces.IRemoteRepository;

public interface IRemoteManager {
    IRemoteRepository getRemoteRepository();
}
