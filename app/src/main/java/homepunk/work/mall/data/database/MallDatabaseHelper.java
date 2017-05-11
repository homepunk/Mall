package homepunk.work.mall.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static homepunk.work.mall.data.database.MallContract.MallEntry.CREATE_TABLE;
import static homepunk.work.mall.data.database.MallContract.MallEntry.TABLE_NAME;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public class MallDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "malls_database";
    private static MallDatabaseHelper instance;

    private MallDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static MallDatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new MallDatabaseHelper(context);
        }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
