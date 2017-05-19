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
import static homepunk.work.mall.data.database.MallContract.CategoryEntry.CONTENT_TYPE_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.CategoryEntry.CONTENT_URI_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.DEFAULT_SORT_ORDER;
import static homepunk.work.mall.data.database.MallContract.FloorEntry.CONTENT_TYPE_FLOOR;
import static homepunk.work.mall.data.database.MallContract.FloorEntry.CONTENT_URI_FLOOR;
import static homepunk.work.mall.data.database.MallContract.MallEntry.CONTENT_TYPE_MALL;
import static homepunk.work.mall.data.database.MallContract.MallEntry.CONTENT_URI_MALL;
import static homepunk.work.mall.data.database.MallContract.PlacementEntry.CONTENT_TYPE_PLACEMENT;
import static homepunk.work.mall.data.database.MallContract.PlacementEntry.CONTENT_URI_PLACEMENT;
import static homepunk.work.mall.data.database.MallContract.PlacementProductEntry.CONTENT_TYPE_PLACEMENT_PRODUCT;
import static homepunk.work.mall.data.database.MallContract.PlacementProductEntry.CONTENT_URI_PLACEMENT_PRODUCT;
import static homepunk.work.mall.data.database.MallContract.PlacementShopEntry.CONTENT_TYPE_PLACEMENT_SHOP;
import static homepunk.work.mall.data.database.MallContract.PlacementShopEntry.CONTENT_URI_PLACEMENT_SHOP;
import static homepunk.work.mall.data.database.MallContract.ProductCategoryEntry.CONTENT_TYPE_PRODUCT_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.ProductCategoryEntry.CONTENT_URI_PRODUCT_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.ProductEntry.CONTENT_TYPE_PRODUCT;
import static homepunk.work.mall.data.database.MallContract.ProductEntry.CONTENT_URI_PRODUCT;
import static homepunk.work.mall.data.database.MallContract.ProductTypeEntry.CONTENT_TYPE_PRODUCT_TYPE;
import static homepunk.work.mall.data.database.MallContract.ProductTypeEntry.CONTENT_URI_PRODUCT_TYPE;
import static homepunk.work.mall.data.database.MallContract.ShopCategoryEntry.CONTENT_TYPE_SHOP_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.ShopCategoryEntry.CONTENT_URI_SHOP_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.ShopEntry.CONTENT_TYPE_SHOP;
import static homepunk.work.mall.data.database.MallContract.ShopEntry.CONTENT_URI_SHOP;
import static homepunk.work.mall.data.database.MallContract.ShopProductEntry.CONTENT_TYPE_PRODUCT_SHOP;
import static homepunk.work.mall.data.database.MallContract.ShopProductEntry.CONTENT_URI_SHOP_PRODUCT;
import static homepunk.work.mall.data.database.MallContract.ShopTypeEntry.CONTENT_TYPE_SHOP_TYPE;
import static homepunk.work.mall.data.database.MallContract.ShopTypeEntry.CONTENT_URI_SHOP_TYPE;
import static homepunk.work.mall.data.database.MallContract.TypeCategoryEntry.CONTENT_TYPE_TYPE_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.TypeCategoryEntry.CONTENT_URI_TYPE_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.TypeEntry.CONTENT_TYPE_TYPE;
import static homepunk.work.mall.data.database.MallContract.TypeEntry.CONTENT_URI_TYPE;
import static homepunk.work.mall.data.database.MallContract.transformProjectionToHashMap;
import static homepunk.work.mall.data.entity.Category.PATH_CATEGORIES;
import static homepunk.work.mall.data.entity.Category.PROJECTION_CATEGORY;
import static homepunk.work.mall.data.entity.Category.TABLE_NAME_CATEGORY;
import static homepunk.work.mall.data.entity.Floor.PATH_FLOORS;
import static homepunk.work.mall.data.entity.Floor.PROJECTION_FLOOR;
import static homepunk.work.mall.data.entity.Floor.TABLE_NAME_FLOOR;
import static homepunk.work.mall.data.entity.Mall.PATH_MALLS;
import static homepunk.work.mall.data.entity.Mall.PROJECTION_MALL;
import static homepunk.work.mall.data.entity.Mall.TABLE_NAME_MALL;
import static homepunk.work.mall.data.entity.Placement.PATH_PLACEMENTS;
import static homepunk.work.mall.data.entity.Placement.PROJECTION_PLACEMENT;
import static homepunk.work.mall.data.entity.Placement.TABLE_NAME_PLACEMENT;
import static homepunk.work.mall.data.entity.PlacementProduct.PATH_PLACEMENT_PRODUCT;
import static homepunk.work.mall.data.entity.PlacementProduct.PROJECTION_PLACEMENT_PRODUCT;
import static homepunk.work.mall.data.entity.PlacementProduct.TABLE_NAME_PLACEMENT_PRODUCT;
import static homepunk.work.mall.data.entity.PlacementShop.PATH_PLACEMENT_SHOP;
import static homepunk.work.mall.data.entity.PlacementShop.PROJECTION_PLACEMENT_SHOP;
import static homepunk.work.mall.data.entity.PlacementShop.TABLE_NAME_PLACEMENT_SHOP;
import static homepunk.work.mall.data.entity.Product.PATH_PRODUCTS;
import static homepunk.work.mall.data.entity.Product.PROJECTION_PRODUCT;
import static homepunk.work.mall.data.entity.Product.TABLE_NAME_PRODUCT;
import static homepunk.work.mall.data.entity.ProductCategory.PATH_PRODUCT_CATEGORY;
import static homepunk.work.mall.data.entity.ProductCategory.PROJECTION_PRODUCT_CATEGORY;
import static homepunk.work.mall.data.entity.ProductCategory.TABLE_NAME_PRODUCT_CATEGORY;
import static homepunk.work.mall.data.entity.ProductType.PATH_PRODUCT_TYPE;
import static homepunk.work.mall.data.entity.ProductType.PROJECTION_PRODUCT_TYPE;
import static homepunk.work.mall.data.entity.ProductType.TABLE_NAME_PRODUCT_TYPE;
import static homepunk.work.mall.data.entity.Shop.PATH_SHOPS;
import static homepunk.work.mall.data.entity.Shop.PROJECTION_SHOP;
import static homepunk.work.mall.data.entity.Shop.TABLE_NAME_SHOP;
import static homepunk.work.mall.data.entity.ShopCategory.PATH_SHOP_CATEGORY;
import static homepunk.work.mall.data.entity.ShopCategory.PROJECTION_SHOP_CATEGORY;
import static homepunk.work.mall.data.entity.ShopCategory.TABLE_NAME_SHOP_CATEGORY;
import static homepunk.work.mall.data.entity.ShopProduct.PATH_SHOP_PRODUCTS;
import static homepunk.work.mall.data.entity.ShopProduct.PROJECTION_SHOP_PRODUCT;
import static homepunk.work.mall.data.entity.ShopProduct.TABLE_NAME_SHOP_PRODUCT;
import static homepunk.work.mall.data.entity.ShopType.PATH_SHOP_TYPE;
import static homepunk.work.mall.data.entity.ShopType.PROJECTION_SHOP_TYPE;
import static homepunk.work.mall.data.entity.ShopType.TABLE_NAME_SHOP_TYPE;
import static homepunk.work.mall.data.entity.Type.PATH_TYPES;
import static homepunk.work.mall.data.entity.Type.PROJECTION_TYPE;
import static homepunk.work.mall.data.entity.Type.TABLE_NAME_TYPE;
import static homepunk.work.mall.data.entity.TypeCategory.PATH_TYPE_CATEGORIES;
import static homepunk.work.mall.data.entity.TypeCategory.PROJECTION_TYPE_CATEGORY;
import static homepunk.work.mall.data.entity.TypeCategory.TABLE_NAME_TYPE_CATEGORY;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public class MallProvider extends ContentProvider {
    private static final int MALL = 100;
    private static final int SHOP = 101;
    private static final int TYPE = 102;
    private static final int FLOOR = 103;
    private static final int PRODUCT = 104;
    private static final int CATEGORY = 105;
    private static final int PLACEMENT = 106;
    private static final int SHOP_TYPE = 107;
    private static final int SHOP_PRODUCT = 108;
    private static final int PRODUCT_TYPE = 109;
    private static final int SHOP_CATEGORY = 110;
    private static final int TYPE_CATEGORY = 111;
    private static final int PLACEMENT_SHOP = 112;
    private static final int PRODUCT_CATEGORY = 113;
    private static final int PLACEMENT_PRODUCT = 114;

    private static final UriMatcher matcher = buildUriMatcher();

    private static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_MALLS, MALL);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_SHOPS, SHOP);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_FLOORS, FLOOR);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_PRODUCTS, PRODUCT);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_PLACEMENTS, PLACEMENT);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_TYPES, TYPE);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_CATEGORIES, CATEGORY);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_TYPE_CATEGORIES, TYPE_CATEGORY);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_PLACEMENT_PRODUCT, PLACEMENT_PRODUCT);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_PLACEMENT_SHOP, PLACEMENT_SHOP);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_PRODUCT_CATEGORY, PRODUCT_CATEGORY);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_PRODUCT_TYPE, PRODUCT_TYPE);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_SHOP_CATEGORY, SHOP_CATEGORY);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_SHOP_PRODUCTS, SHOP_PRODUCT);
        uriMatcher.addURI(MallContract.CONTENT_AUTHORITY, PATH_SHOP_TYPE, SHOP_TYPE);

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
            case TYPE: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_TYPE, PROJECTION_TYPE);
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
            case CATEGORY: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_CATEGORY, PROJECTION_CATEGORY);
                break;
            }
            case SHOP_TYPE: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_SHOP_TYPE, PROJECTION_SHOP_TYPE);
                break;
            }
            case PLACEMENT: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_PLACEMENT, PROJECTION_PLACEMENT);
                break;
            }
            case SHOP_PRODUCT: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_SHOP_PRODUCT, PROJECTION_SHOP_PRODUCT);
                break;
            }
            case PRODUCT_TYPE: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_PRODUCT_TYPE, PROJECTION_PRODUCT_TYPE);
                break;
            }
            case TYPE_CATEGORY: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_TYPE_CATEGORY, PROJECTION_TYPE_CATEGORY);
                break;
            }
            case SHOP_CATEGORY: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_SHOP_CATEGORY, PROJECTION_SHOP_CATEGORY);
                break;
            }
            case PLACEMENT_SHOP: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_PLACEMENT_SHOP, PROJECTION_PLACEMENT_SHOP);
                break;
            }
            case PRODUCT_CATEGORY: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_PRODUCT_CATEGORY, PROJECTION_PRODUCT_CATEGORY);
                break;
            }
            case PLACEMENT_PRODUCT: {
                queryBuilder = getUpdatedQueryBuilder(TABLE_NAME_PLACEMENT_PRODUCT, PROJECTION_PLACEMENT_PRODUCT);
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
            case TYPE: {
                return CONTENT_TYPE_TYPE;
            }
            case FLOOR: {
                return CONTENT_TYPE_FLOOR;
            }
            case PRODUCT: {
                return CONTENT_TYPE_PRODUCT;
            }
            case CATEGORY: {
                return CONTENT_TYPE_CATEGORY;
            }
            case SHOP_TYPE: {
                return CONTENT_TYPE_SHOP_TYPE;
            }
            case PLACEMENT: {
                return CONTENT_TYPE_PLACEMENT;
            }
            case PRODUCT_TYPE: {
                return CONTENT_TYPE_PRODUCT_TYPE;
            }
            case SHOP_PRODUCT: {
                return CONTENT_TYPE_PRODUCT_SHOP;
            }
            case SHOP_CATEGORY: {
                return CONTENT_TYPE_SHOP_CATEGORY;
            }
            case TYPE_CATEGORY: {
                return CONTENT_TYPE_TYPE_CATEGORY;
            }
            case PLACEMENT_SHOP: {
                return CONTENT_TYPE_PLACEMENT_SHOP;
            }
            case PRODUCT_CATEGORY: {
                return CONTENT_TYPE_PRODUCT_CATEGORY;
            }
            case PLACEMENT_PRODUCT: {
                return CONTENT_TYPE_PLACEMENT_PRODUCT;
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
            case TYPE: {
                rowId = database.insert(TABLE_NAME_TYPE, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_TYPE);
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
            case CATEGORY: {
                rowId = database.insert(TABLE_NAME_CATEGORY, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_CATEGORY);
                break;
            }
            case SHOP_TYPE: {
                rowId = database.insert(TABLE_NAME_SHOP_TYPE, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_SHOP_TYPE);
                break;
            }
            case PLACEMENT: {
                rowId = database.insert(TABLE_NAME_PLACEMENT, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_PLACEMENT);
                break;
            }
            case SHOP_PRODUCT: {
                rowId = database.insert(TABLE_NAME_SHOP_PRODUCT, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_SHOP_PRODUCT);
                break;
            }
            case PRODUCT_TYPE: {
                rowId = database.insert(TABLE_NAME_PRODUCT_TYPE, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_PRODUCT_TYPE);
                break;
            }
            case SHOP_CATEGORY: {
                rowId = database.insert(TABLE_NAME_SHOP_CATEGORY, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_SHOP_CATEGORY);
                break;
            }
            case TYPE_CATEGORY: {
                rowId = database.insert(TABLE_NAME_TYPE_CATEGORY, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_TYPE_CATEGORY);
                break;
            }
            case PLACEMENT_SHOP: {
                rowId = database.insert(TABLE_NAME_PLACEMENT_SHOP, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_PLACEMENT_SHOP);
                break;
            }
            case PRODUCT_CATEGORY: {
                rowId = database.insert(TABLE_NAME_PRODUCT_CATEGORY, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_PRODUCT_CATEGORY);
                break;
            }
            case PLACEMENT_PRODUCT: {
                rowId = database.insert(TABLE_NAME_PLACEMENT_PRODUCT, null, values);
                rowUri = getUpdatedRowUri(rowId, CONTENT_URI_PLACEMENT_PRODUCT);
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
            case TYPE: {
                count = database.update(TABLE_NAME_TYPE, values, selection, selectionArgs);
                break;
            }
            case FLOOR: {
                count = database.update(TABLE_NAME_FLOOR, values, selection, selectionArgs);
                break;
            }
            case PLACEMENT: {
                count = database.update(TABLE_NAME_FLOOR, values, selection, selectionArgs);
                break;
            }
            case PRODUCT: {
                count = database.update(TABLE_NAME_PRODUCT, values, selection, selectionArgs);
                break;
            }
            case CATEGORY: {
                count = database.update(TABLE_NAME_CATEGORY, values, selection, selectionArgs);
                break;
            }
            case SHOP_TYPE: {
                count = database.update(TABLE_NAME_SHOP_TYPE, values, selection, selectionArgs);
                break;
            }
            case PRODUCT_TYPE: {
                count = database.update(TABLE_NAME_PRODUCT_TYPE, values, selection, selectionArgs);
                break;
            }
            case SHOP_PRODUCT: {
                count = database.update(TABLE_NAME_SHOP_PRODUCT, values, selection, selectionArgs);
                break;
            }
            case SHOP_CATEGORY: {
                count = database.update(TABLE_NAME_SHOP_CATEGORY, values, selection, selectionArgs);
                break;
            }
            case TYPE_CATEGORY: {
                count = database.update(TABLE_NAME_TYPE_CATEGORY, values, selection, selectionArgs);
                break;
            }
            case PLACEMENT_SHOP: {
                count = database.update(TABLE_NAME_PLACEMENT_SHOP, values, selection, selectionArgs);
                break;
            }
            case PRODUCT_CATEGORY: {
                count = database.update(TABLE_NAME_PRODUCT_CATEGORY, values, selection, selectionArgs);
                break;
            }
            case PLACEMENT_PRODUCT: {
                count = database.update(TABLE_NAME_PLACEMENT_PRODUCT, values, selection, selectionArgs);
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

    public Cursor rawQuery(int id) {
        final SQLiteDatabase database = databaseHelper.getReadableDatabase();

        return  database.rawQuery("SELECT * FROM floor WHERE _id = ?" + String.valueOf(id), new String[]{String.valueOf(id)});
    }
}
