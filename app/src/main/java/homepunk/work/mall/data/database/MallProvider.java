package homepunk.work.mall.data.database;

import android.content.ContentProvider;
import android.content.ContentResolver;
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
import static homepunk.work.mall.data.database.MallContract.FloorEntry.PATH_FLOORS;
import static homepunk.work.mall.data.database.MallContract.MallEntry.PATH_MALLS;
import static homepunk.work.mall.data.database.MallContract.PlacementEntry.PATH_PLACEMENTS;
import static homepunk.work.mall.data.database.MallContract.ProductEntry.PATH_PRODUCTS;
import static homepunk.work.mall.data.database.MallContract.ShopEntry.PATH_SHOPS;
import static homepunk.work.mall.data.database.MallContract.transformProjectionToHashMap;
import static homepunk.work.mall.data.entity.Floor.CONTENT_TYPE_FLOOR;
import static homepunk.work.mall.data.entity.Floor.CONTENT_URI_FLOOR;
import static homepunk.work.mall.data.entity.Floor.PROJECTION_FLOOR;
import static homepunk.work.mall.data.entity.Mall.CONTENT_TYPE_MALL;
import static homepunk.work.mall.data.entity.Mall.CONTENT_URI_MALL;
import static homepunk.work.mall.data.entity.Mall.PROJECTION_MALL;
import static homepunk.work.mall.data.entity.Mall.TABLE_NAME_MALL;
import static homepunk.work.mall.data.entity.Placement.CONTENT_TYPE_PLACEMENT;
import static homepunk.work.mall.data.entity.Placement.CONTENT_URI_PLACEMENT;
import static homepunk.work.mall.data.entity.Placement.PROJECTION_PLACEMENT;
import static homepunk.work.mall.data.entity.Product.CONTENT_TYPE_PRODUCT;
import static homepunk.work.mall.data.entity.Product.CONTENT_URI_PRODUCT;
import static homepunk.work.mall.data.entity.Product.PROJECTION_PRODUCT;
import static homepunk.work.mall.data.entity.Shop.CONTENT_TYPE_SHOP;
import static homepunk.work.mall.data.entity.Shop.CONTENT_URI_SHOP;
import static homepunk.work.mall.data.entity.Shop.PROJECTION_SHOP;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.TABLE_NAME_FLOOR;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.TABLE_NAME_PLACEMENT;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.TABLE_NAME_PRODUCT;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.TABLE_NAME_SHOP;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public class MallProvider extends ContentProvider {
    private static final int MALL = 100;
    private static final int SHOP = 101;
    private static final int FLOOR = 102;
    private static final int PRODUCT = 103;
    private static final int PLACEMENT = 104;

    private static final UriMatcher matcher = buildUriMatcher();

    private static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_MALLS, MALL);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_SHOPS, SHOP);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_FLOORS, FLOOR);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_PRODUCTS, PRODUCT);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_PLACEMENTS, PLACEMENT);

        return uriMatcher;
    }

    private MallDatabaseOpenHelper databaseHelper;
    private ContentResolver resolver;

    @Override
    public boolean onCreate() {
        databaseHelper = MallDatabaseOpenHelper.getInstance(getContext());
        resolver = getContext().getContentResolver();

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        final SQLiteDatabase database = databaseHelper.getReadableDatabase();
        final int match = matcher.match(uri);
        SQLiteQueryBuilder queryBuilder;

        switch (match) {
            case MALL: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_MALL, PROJECTION_MALL);
                break;
            }
            case SHOP: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_SHOP, PROJECTION_SHOP);
                break;
            }
            case FLOOR: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_FLOOR, PROJECTION_FLOOR);
                break;
            }
            case PRODUCT: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_PRODUCT, PROJECTION_PRODUCT);
                break;
            }
            case PLACEMENT: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_PLACEMENT, PROJECTION_PLACEMENT);
                break;
            }
            default:
                throw new IllegalArgumentException(ERROR_CONTENT_URI + uri);
        }

        Cursor cursor = queryBuilder.query(database, projection, selection, selectionArgs, null, null, DEFAULT_SORT_ORDER);
        cursor.setNotificationUri(resolver, uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        final int match = matcher.match(uri);

        switch (match) {
            case MALL: {
                return CONTENT_TYPE_MALL;
            }
            case SHOP: {
                return CONTENT_TYPE_SHOP;
            }
            case FLOOR: {
                return CONTENT_TYPE_FLOOR;
            }
            case PRODUCT: {
                return CONTENT_TYPE_PRODUCT;
            }
            case PLACEMENT: {
                return CONTENT_TYPE_PLACEMENT;
            }
            default: {
                throw new IllegalArgumentException(ERROR_CONTENT_URI + uri);
            }
        }
    }


    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final SQLiteDatabase database = databaseHelper.getWritableDatabase();
        final int match = matcher.match(uri);
        long rowId;
        Uri rowUri = Uri.EMPTY;

        if (values == null) {
            values = new ContentValues();
        }

        switch (match) {
            case MALL: {
                rowId = database.insert(TABLE_NAME_MALL, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_MALL);
                break;
            }
            case SHOP: {
                rowId = database.insert(TABLE_NAME_SHOP, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_SHOP);
                break;
            }
            case FLOOR: {
                rowId = database.insert(TABLE_NAME_FLOOR, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_FLOOR);
                break;
            }
            case PRODUCT: {
                rowId = database.insert(TABLE_NAME_PRODUCT, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_PRODUCT);
                break;
            }
            case PLACEMENT: {
                rowId = database.insert(TABLE_NAME_PLACEMENT, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_PLACEMENT);
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
                count = database.update(TABLE_NAME_MALL, values, selection, selectionArgs);
                break;
            }
            case SHOP: {
                count = database.update(TABLE_NAME_SHOP, values, selection, selectionArgs);
                break;
            }
            case FLOOR: {
                count = database.update(TABLE_NAME_FLOOR, values, selection, selectionArgs);
                break;
            }
            case PRODUCT: {
                count = database.update(TABLE_NAME_PRODUCT, values, selection, selectionArgs);
                break;
            }
            case PLACEMENT: {
                count = database.update(TABLE_NAME_FLOOR, values, selection, selectionArgs);
                break;
            }

            default:
                throw new IllegalArgumentException(ERROR_CONTENT_URI + uri);
        }

        notifyProviderOnChange(uri);
        return count;
    }

    private Uri getUpdatedRowUri(long rowId, Uri entityUri) {
        Uri rowUri;

        if (rowId > 0) {
            rowUri = ContentUris.withAppendedId(entityUri, rowId);
            notifyProviderOnChange(rowUri);
        } else {
            throw new SQLException(ERROR_INSERT_ROW + entityUri);
        }

        return rowUri;
    }

    private SQLiteQueryBuilder getUpdatedQueryBuilder(String tableName, String[] projection) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        queryBuilder.setTables(tableName);
        queryBuilder.setProjectionMap(transformProjectionToHashMap(projection));

        return queryBuilder;
    }

    private void notifyProviderOnChange(Uri uri) {
        resolver.notifyChange(uri, null);
    }

}
