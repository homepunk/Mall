package homepunk.work.mall.data.managers;

import homepunk.work.mall.data.managers.interfaces.ILocalManager;
import homepunk.work.mall.data.managers.interfaces.IModuleManager;
import homepunk.work.mall.data.managers.interfaces.IRemoteManager;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class ModuleManager implements IModuleManager {
    @Override
    public ILocalManager getLocalManagers() {
        return new LocalManager();
    }

    @Override
    public IRemoteManager getRemoteManagers() {
        return new RemoteManager();
    }
}
