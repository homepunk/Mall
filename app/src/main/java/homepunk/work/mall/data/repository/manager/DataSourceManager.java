package homepunk.work.mall.data.repository.manager;

import android.content.Context;

import homepunk.work.mall.data.repository.datasource.LocalMallDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.PreferencesDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.RemoteMallDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.interfaces.DatabaseMallDataSource;
import homepunk.work.mall.data.repository.datasource.interfaces.MallDataSource;
import homepunk.work.mall.data.repository.datasource.interfaces.PreferencesDataSource;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class DataSourceManager {
    private final Context context;

    public DataSourceManager(Context context) {
        this.context = context;
    }

    public MallDataSource getRemoteDataSource() {
        String userToken = getPreferencesDataSource().retrieveAccessToken();

        return new RemoteMallDataSourceImpl(userToken);
    }

    public DatabaseMallDataSource getDatabaseDataSource() {

        return new LocalMallDataSourceImpl(context);
    }

    public PreferencesDataSource getPreferencesDataSource() {

        return new PreferencesDataSourceImpl();
    }
}
