package homepunk.work.mall.data.managers.interfaces;

import homepunk.work.mall.data.storages.remote.repository.interfaces.IRemoteRepository;

public interface IRemoteManager {
    IRemoteRepository getRemoteRepository();
}
