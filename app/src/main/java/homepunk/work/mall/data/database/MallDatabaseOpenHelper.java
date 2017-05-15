package homepunk.work.mall.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static homepunk.work.mall.data.database.MallContract.*;
import static homepunk.work.mall.data.database.MallContract.FloorEntry;
import static homepunk.work.mall.data.database.MallContract.MallEntry;
import static homepunk.work.mall.data.database.MallContract.PlacementEntry;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.TABLE_NAME_FLOOR;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.TABLE_NAME_MALL;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.TABLE_NAME_PLACEMENT;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.TABLE_NAME_PRODUCT;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.TABLE_NAME_SHOP;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public class MallDatabaseOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "malls_database";

    private static MallDatabaseOpenHelper instance;

    private MallDatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static MallDatabaseOpenHelper getInstance(Context context) {
        if (instance == null) {
            instance = new MallDatabaseOpenHelper(context);
        }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ShopEntry.CREATE_TABLE);
        db.execSQL(MallEntry.CREATE_TABLE);
        db.execSQL(FloorEntry.CREATE_TABLE);
        db.execSQL(ProductEntry.CREATE_TABLE);
        db.execSQL(PlacementEntry.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SHOP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MALL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_FLOOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PRODUCT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PLACEMENT);

        onCreate(db);
    }
}
