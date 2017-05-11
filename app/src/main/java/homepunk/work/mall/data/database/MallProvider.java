package homepunk.work.mall.data.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static homepunk.work.mall.data.Constants.Messages.ERROR_CONTENT_URI;
import static homepunk.work.mall.data.Constants.Messages.ERROR_INSERT_ROW;
import static homepunk.work.mall.data.database.MallContract.DEFAULT_SORT_ORDER;
import static homepunk.work.mall.data.database.MallContract.MallEntry;
import static homepunk.work.mall.data.database.MallContract.MallEntry.TABLE_NAME;
import static homepunk.work.mall.data.database.MallContract.transformProjectionToHashMap;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public class MallProvider extends ContentProvider {
    private static final int MALL = 100;

    private static final UriMatcher matcher = buildUriMatcher();

    private MallDatabaseHelper databaseHelper;

    private static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, MallContract.PATH_MALL, MALL);

        return uriMatcher;
    }

    @Override
    public boolean onCreate() {
        databaseHelper = MallDatabaseHelper.getInstance(getContext());

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        final SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        final SQLiteDatabase database = databaseHelper.getReadableDatabase();
        final int match = matcher.match(uri);
        String orederBy = null;

        switch (match) {
            case MALL: {
                queryBuilder.setTables(TABLE_NAME);
                queryBuilder.setProjectionMap(transformProjectionToHashMap(MallEntry.PROJECTION));
                orederBy = DEFAULT_SORT_ORDER;
                break;
            }
            default:
                throw new IllegalArgumentException(ERROR_CONTENT_URI + uri);
        }

        Cursor cursor = queryBuilder.query(database, projection, selection, selectionArgs, null, null, orederBy);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        final int match = matcher.match(uri);

        switch (match) {
            case MALL:
                return MallEntry.CONTENT_TYPE;
            default:
                throw new IllegalArgumentException(ERROR_CONTENT_URI + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues initialValues) {
        final int match = matcher.match(uri);
        final ContentValues values = getValuesFromInitial(initialValues);
        final SQLiteDatabase database = databaseHelper.getWritableDatabase();
        long rowId = -1;
        Uri rowUri = Uri.EMPTY;

        switch (match) {
            case MALL: {
                rowId = database.insert(TABLE_NAME, null, values);
                if (rowId > 0) {
                    rowUri = ContentUris.withAppendedId(MallEntry.CONTENT_URI, rowId);
                    notifyProviderOnChange(rowUri);
                } else {
                    throw new SQLException(ERROR_INSERT_ROW + uri);
                }
                break;
            }
        }

        return rowUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase database = databaseHelper.getWritableDatabase();
        final int match = matcher.match(uri);
        if (selection == null) {
            selection = "1";
        }

        switch (match) {
            case MALL: {

            }
        }
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase database = databaseHelper.getWritableDatabase();
        final int match = matcher.match(uri);
        int count;

        switch (match) {
            case MALL: {
                count = database.update(TABLE_NAME, values, selection, selectionArgs);
                break;
            }

            default:
                throw new IllegalArgumentException(ERROR_CONTENT_URI + uri);
        }

        notifyProviderOnChange(uri);
        return count;
    }

    private ContentValues getValuesFromInitial(ContentValues initialValues) {
        if (initialValues != null) {
            return new ContentValues(initialValues);
        } else {
            return new ContentValues();
        }
    }

    private void notifyProviderOnChange(Uri uri) {
        getContext().getContentResolver().notifyChange(uri, null);
    }

}
