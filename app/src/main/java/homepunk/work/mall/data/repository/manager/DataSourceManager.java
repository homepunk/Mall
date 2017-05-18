package homepunk.work.mall.data.repository.manager;

import android.content.Context;

import homepunk.work.mall.data.repository.datasource.LocalMallDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.LoginDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.PreferencesDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.RemoteMallDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.interfaces.DatabaseMallDataSource;
import homepunk.work.mall.data.repository.datasource.interfaces.LoginDataSource;
import homepunk.work.mall.data.repository.datasource.interfaces.MallDataSource;
import homepunk.work.mall.data.repository.datasource.interfaces.PreferencesDataSource;
import homepunk.work.mall.data.repository.datasource.interfaces.RemoteMallDataSource;

import static homepunk.work.mall.data.Constants.Keys.KEY_MALLS;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class DataSourceManager {
    private final Context context;

    public DataSourceManager(Context context) {
        this.context = context;
    }

    public LoginDataSource getLoginDataSource() {
        return new LoginDataSourceImpl(context);
    }

    public RemoteMallDataSource getRemoteDataSource() {
        return new RemoteMallDataSourceImpl(context);
    }

    public DatabaseMallDataSource getDatabaseDataSource() {
        return new LocalMallDataSourceImpl(context);
    }

    public PreferencesDataSource getPreferencesDataSource() {
        return new PreferencesDataSourceImpl();
    }

    public MallDataSource getDataSource() {
        final long timestamp = getPreferencesDataSource().retrieveLastSyncTimestamp(KEY_MALLS);

        return (timestamp == 0) ? getRemoteDataSource() : getDatabaseDataSource();
    }
}
