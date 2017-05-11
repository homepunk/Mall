package homepunk.work.mall.data.repository.factory;

import android.content.Context;

import homepunk.work.mall.data.repository.datasource.local.DatabaseMallDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.local.PreferencesDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.local.interfaces.DatabaseDataSource;
import homepunk.work.mall.data.repository.datasource.local.interfaces.PreferencesDataSource;
import homepunk.work.mall.data.repository.datasource.remote.RestMallDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.remote.interfaces.MallDataSource;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class MallDataSourceFactory {
    private final Context context;
    private PreferencesDataSource preferencesDataSource;
    private DatabaseDataSource databaseDataSource;

    public MallDataSourceFactory(Context context) {
        this.context = context;
        this.preferencesDataSource = new PreferencesDataSourceImpl();
    }

    public MallDataSource createDataSource() {
//        TODO: creating data source logic (sync by timestrap)

        databaseDataSource = new DatabaseMallDataSourceImpl(context);
        return new RestMallDataSourceImpl(context, preferencesDataSource.retrieveAccessToken());
    }
}
