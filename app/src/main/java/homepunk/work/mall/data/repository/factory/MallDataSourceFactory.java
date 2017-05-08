package homepunk.work.mall.data.repository.factory;

import homepunk.work.mall.data.repository.datasource.local.PreferencesDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.local.interfaces.PreferencesDataSource;
import homepunk.work.mall.data.repository.datasource.remote.MallApiDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.remote.interfaces.MallDataSource;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class MallDataSourceFactory {
    private PreferencesDataSource preferencesDataSource;

    public MallDataSourceFactory() {
        this.preferencesDataSource = new PreferencesDataSourceImpl();
    }

    public MallDataSource createDataSource() {
        return new MallApiDataSourceImpl(preferencesDataSource.retrieveAccessToken());
    }
}
