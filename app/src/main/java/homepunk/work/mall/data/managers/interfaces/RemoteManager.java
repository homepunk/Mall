package homepunk.work.mall.data.managers.interfaces;

import homepunk.work.mall.data.storages.remote.repository.interfaces.RemoteRepository;

public interface RemoteManager {
    RemoteRepository getRemoteRepository();
}
