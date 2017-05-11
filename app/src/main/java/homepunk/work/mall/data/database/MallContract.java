package homepunk.work.mall.data.database;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

import java.util.HashMap;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public class MallContract {
    public static final String CONTENT_AUTHORITY = "homepunk.work.mall";
    public static final String SCHEME = "content://";

    public static final String DEFAULT_SORT_ORDER = "name ASC";

    public static final String PATH_MALL = "mall";

    public static final class MallEntry implements BaseColumns {
        public static final String TABLE_NAME = "Mall";

        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_LATITUDE = "lat";
        public static final String COLUMN_LONGTITUDE = "lng";
        public static final String COLUMN_DESCRIPTION = "description";

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MALL;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MALL;
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_MALL);

        public static final String[] PROJECTION = {
                _ID,
                COLUMN_NAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGE,
                COLUMN_LATITUDE,
                COLUMN_LONGTITUDE};

        public static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " ("
                + _ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT NOT NULL DEFAULT '',"
                + COLUMN_DESCRIPTION + " TEXT NOT NULL DEFAULT '',"
                + COLUMN_IMAGE + " TEXT NOT NULL DEFAULT '',"
                + COLUMN_LATITUDE + " REAL NOT NULL ,"
                + COLUMN_LONGTITUDE + " REAL NOT NULL"
                + ")";
    }

    public static HashMap<String, String> transformProjectionToHashMap(String[] projection) {
        HashMap<String, String> projectionMap = new HashMap<>();

        for (String column : projection) {
            projectionMap.put(column, column);
        }

        return projectionMap;
    }
}
