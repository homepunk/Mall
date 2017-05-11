package homepunk.work.mall.data.repository.datasource.local;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.repository.datasource.local.interfaces.DatabaseDataSource;

import static homepunk.work.mall.data.database.MallContract.DEFAULT_SORT_ORDER;
import static homepunk.work.mall.data.database.MallContract.MallEntry.CONTENT_URI;
import static homepunk.work.mall.data.database.MallContract.MallEntry.PROJECTION;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public class DatabaseMallDataSourceImpl implements DatabaseDataSource<Mall> {
    private ContentResolver resolver;

    public DatabaseMallDataSourceImpl(Context context) {
        this.resolver = context.getContentResolver();
    }

    @Override
    public void insert(Mall mall) {
        ContentValues values = mall.getContentValues();
        resolver.insert(CONTENT_URI, values);
    }

    @Override
    public void update(Mall mall) {
        ContentValues values = mall.getContentValues();

    }

    @Override
    public void delete(Mall mall) {

    }

    @Override
    public ArrayList<Mall> getAll() {
        ArrayList<Mall> databaseMalls = new ArrayList<>();
        Cursor cursor = resolver.query(CONTENT_URI, PROJECTION, null, null, DEFAULT_SORT_ORDER);

        while (cursor.moveToNext()) {
            databaseMalls.add(new Mall(cursor));
        }

        return databaseMalls;
    }
}
