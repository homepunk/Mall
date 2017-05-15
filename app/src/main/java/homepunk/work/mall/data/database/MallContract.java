package homepunk.work.mall.data.database;

import java.util.HashMap;

import static homepunk.work.mall.data.entity.Mall.COLUMN_DESCRIPTION;
import static homepunk.work.mall.data.entity.Mall.COLUMN_ID;
import static homepunk.work.mall.data.entity.Mall.COLUMN_IMAGE;
import static homepunk.work.mall.data.entity.Mall.COLUMN_LATITUDE;
import static homepunk.work.mall.data.entity.Mall.COLUMN_LONGTITUDE;
import static homepunk.work.mall.data.entity.Mall.COLUMN_NAME;
import static homepunk.work.mall.data.entity.Mall.TABLE_NAME_MALL;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_COLOR;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_LEVEL;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_MALL_ID;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_SHOP_ID;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_TYPE;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.TABLE_NAME_FLOOR;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.TABLE_NAME_PLACEMENT;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.TABLE_NAME_PRODUCT;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.TABLE_NAME_SHOP;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public class MallContract {
    public static final String CONTENT_AUTHORITY = "homepunk.work.mall";
    public static final String SCHEME = "content://";

    public static final String DEFAULT_SORT_ORDER = "name ASC";

    public static HashMap<String, String> transformProjectionToHashMap(String[] projection) {
        HashMap<String, String> projectionMap = new HashMap<>();

        for (String column : projection) {
            projectionMap.put(column, column);
        }

        return projectionMap;
    }

    public static final class MallEntry {
        public static final String PATH_MALLS = "malls";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_MALL + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT NOT NULL DEFAULT ' ',"
                + COLUMN_DESCRIPTION + " TEXT NOT NULL DEFAULT ' ',"
                + COLUMN_IMAGE + " TEXT ,"
                + COLUMN_LATITUDE + " REAL NOT NULL ,"
                + COLUMN_LONGTITUDE + " REAL NOT NULL"
                + ")";
    }

    public static final class FloorEntry {
        public static final String PATH_FLOORS = "floors";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_FLOOR + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_MALL_ID + " INTEGER NOT NULL, "
                + COLUMN_LEVEL + " TEXT NOT NULL DEFAULT ' ',"
                + COLUMN_TYPE + " TEXT , "
                + " FOREIGN KEY (" + COLUMN_MALL_ID
                + ") REFERENCES " + TABLE_NAME_MALL + "(" + COLUMN_ID + ")"
                + ")";
    }

    public static final class PlacementEntry {
        public static final String PATH_PLACEMENTS = "placements";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_PLACEMENT + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT, "
                + COLUMN_SHOP_ID + " INTEGER NOT NULL, "
                + COLUMN_COLOR + " TEXT"
                + ")";
    }

    public static final class ProductEntry {
        public static final String PATH_PRODUCTS = "products";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_PRODUCT + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT, "
                + COLUMN_DESCRIPTION + " TEXT, "
                + COLUMN_IMAGE + " TEXT"
                + ")";
    }

    public static final class ShopEntry {
        public static final String PATH_SHOPS = "shops";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_SHOP + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT ,"
                + COLUMN_DESCRIPTION + " TEXT ,"
                + COLUMN_LEVEL + " TEXT ,"
                + COLUMN_COLOR + " TEXT ,"
                + COLUMN_IMAGE + " TEXT"
                + ")";
    }
}
