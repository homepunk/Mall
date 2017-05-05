package homepunk.work.mall.data.managers;

import homepunk.work.mall.data.managers.interfaces.LocalManager;
import homepunk.work.mall.data.managers.interfaces.RemoteManager;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class DataManagerImpl implements homepunk.work.mall.data.managers.interfaces.DataManager {
    @Override
    public LocalManager getLocalManagers() {
        return new LocalManagerImpl();
    }

    @Override
    public RemoteManager getRemoteManagers() {
        return RemoteManagerImpl.getInstance();
    }
}
