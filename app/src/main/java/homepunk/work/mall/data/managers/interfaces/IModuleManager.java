package homepunk.work.mall.data.managers.interfaces;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public interface IModuleManager {
    ILocalManager getLocalManagers();

    IRemoteManager getRemoteManagers();
}
