package homepunk.work.mall.data.database;

import android.content.ContentResolver;
import android.net.Uri;

import java.util.HashMap;

import static homepunk.work.mall.data.entity.Category.PATH_CATEGORIES;
import static homepunk.work.mall.data.entity.Category.TABLE_NAME_CATEGORY;
import static homepunk.work.mall.data.entity.Floor.PATH_FLOORS;
import static homepunk.work.mall.data.entity.Floor.TABLE_NAME_FLOOR;
import static homepunk.work.mall.data.entity.Mall.COLUMN_DESCRIPTION;
import static homepunk.work.mall.data.entity.Mall.COLUMN_ID;
import static homepunk.work.mall.data.entity.Mall.COLUMN_IMAGE;
import static homepunk.work.mall.data.entity.Mall.COLUMN_LATITUDE;
import static homepunk.work.mall.data.entity.Mall.COLUMN_LONGTITUDE;
import static homepunk.work.mall.data.entity.Mall.COLUMN_NAME;
import static homepunk.work.mall.data.entity.Mall.PATH_MALLS;
import static homepunk.work.mall.data.entity.Mall.TABLE_NAME_MALL;
import static homepunk.work.mall.data.entity.Placement.PATH_PLACEMENTS;
import static homepunk.work.mall.data.entity.Placement.TABLE_NAME_PLACEMENT;
import static homepunk.work.mall.data.entity.PlacementProduct.PATH_PLACEMENT_PRODUCT;
import static homepunk.work.mall.data.entity.PlacementProduct.TABLE_NAME_PLACEMENT_PRODUCT;
import static homepunk.work.mall.data.entity.PlacementShop.PATH_PLACEMENT_SHOP;
import static homepunk.work.mall.data.entity.PlacementShop.TABLE_NAME_PLACEMENT_SHOP;
import static homepunk.work.mall.data.entity.Product.PATH_PRODUCTS;
import static homepunk.work.mall.data.entity.Product.TABLE_NAME_PRODUCT;
import static homepunk.work.mall.data.entity.ProductCategory.PATH_PRODUCT_CATEGORY;
import static homepunk.work.mall.data.entity.ProductCategory.TABLE_NAME_PRODUCT_CATEGORY;
import static homepunk.work.mall.data.entity.ShopProduct.PATH_SHOP_PRODUCTS;
import static homepunk.work.mall.data.entity.ShopProduct.TABLE_NAME_SHOP_PRODUCT;
import static homepunk.work.mall.data.entity.ProductType.PATH_PRODUCT_TYPE;
import static homepunk.work.mall.data.entity.ProductType.TABLE_NAME_PRODUCT_TYPE;
import static homepunk.work.mall.data.entity.Shop.PATH_SHOPS;
import static homepunk.work.mall.data.entity.Shop.TABLE_NAME_SHOP;
import static homepunk.work.mall.data.entity.ShopCategory.PATH_SHOP_CATEGORY;
import static homepunk.work.mall.data.entity.ShopCategory.TABLE_NAME_SHOP_CATEGORY;
import static homepunk.work.mall.data.entity.ShopType.PATH_SHOP_TYPE;
import static homepunk.work.mall.data.entity.ShopType.TABLE_NAME_SHOP_TYPE;
import static homepunk.work.mall.data.entity.Type.PATH_TYPES;
import static homepunk.work.mall.data.entity.Type.TABLE_NAME_TYPE;
import static homepunk.work.mall.data.entity.TypeCategory.PATH_TYPE_CATEGORIES;
import static homepunk.work.mall.data.entity.TypeCategory.TABLE_NAME_TYPE_CATEGORY;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_ID_CATEGORY;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_COLOR;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_ID_PLACEMENT;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_ID_PRODUCT;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_LEVEL;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_ID_MALL;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_ID_SHOP;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_TYPE;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_ID_TYPE;

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
        public static final Uri CONTENT_URI_MALL = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_MALLS);
        public static final String CONTENT_TYPE_MALL = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MALLS;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MALLS;

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
        public static final Uri CONTENT_URI_FLOOR = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_FLOORS);
        public static final String CONTENT_TYPE_FLOOR = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FLOORS;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FLOORS;

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_FLOOR + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_ID_MALL + " INTEGER NOT NULL, "
                + COLUMN_LEVEL + " TEXT NOT NULL DEFAULT ' ',"
                + COLUMN_TYPE + " TEXT , "
                + " FOREIGN KEY (" + COLUMN_ID_MALL
                + ") REFERENCES " + TABLE_NAME_MALL + "(" + COLUMN_ID + ")"
                + ")";
    }

    public static final class PlacementEntry {
        public static final Uri CONTENT_URI_PLACEMENT = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_PLACEMENTS);
        public static final String CONTENT_TYPE_PLACEMENT = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PLACEMENTS;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PLACEMENTS;

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_PLACEMENT + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT, "
                + COLUMN_ID_SHOP + " INTEGER NOT NULL, "
                + COLUMN_COLOR + " TEXT"
                + ")";
    }

    public static final class ProductEntry {
        public static final Uri CONTENT_URI_PRODUCT = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS);
        public static final String CONTENT_TYPE_PRODUCT = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_PRODUCT + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT, "
                + COLUMN_DESCRIPTION + " TEXT, "
                + COLUMN_IMAGE + " TEXT"
                + ")";
    }

    public static final class ShopEntry {
        public static final Uri CONTENT_URI_SHOP = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_SHOPS);
        public static final String CONTENT_TYPE_SHOP = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHOPS;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHOPS;

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

    public static final class CategoryEntry {
        public static final Uri CONTENT_URI_CATEGORY = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_CATEGORIES);
        public static final String CONTENT_TYPE_CATEGORY = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CATEGORIES;
        public static final String CONTENT_ITEM_CATEGORY = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CATEGORIES;

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_CATEGORY + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT ,"
                + COLUMN_DESCRIPTION + " TEXT"
                + ")";
    }

    public static final class TypeEntry {
        public static final Uri CONTENT_URI_TYPE = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_TYPES);
        public static final String CONTENT_TYPE_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TYPES;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TYPES;

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_TYPE + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT ,"
                + COLUMN_DESCRIPTION + " TEXT"
                + ")";
    }

    public static final class TypeCategoryEntry {
        public static final Uri CONTENT_URI_TYPE_CATEGORY = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_TYPE_CATEGORIES);
        public static final String CONTENT_TYPE_TYPE_CATEGORY = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TYPE_CATEGORIES;
        public static final String CONTENT_ITEM_TYPE_CATEGORY = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TYPE_CATEGORIES;

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_TYPE_CATEGORY + " ("
                + COLUMN_ID_TYPE + " INTEGER NOT NULL,"
                + COLUMN_ID_CATEGORY + " INTEGER NOT NULL,"
                + " FOREIGN KEY (" + COLUMN_ID_TYPE
                + ") REFERENCES " + TABLE_NAME_TYPE + "(" + COLUMN_ID + "),"
                + " FOREIGN KEY (" + COLUMN_ID_CATEGORY
                + ") REFERENCES " + TABLE_NAME_CATEGORY + "(" + COLUMN_ID + ")"
                + ")";
    }

    public static final class PlacementProductEntry {
        public static final Uri CONTENT_URI_PLACEMENT_PRODUCT= Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_PLACEMENT_PRODUCT);
        public static final String CONTENT_TYPE_PLACEMENT_PRODUCT= ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PLACEMENT_PRODUCT;
        public static final String CONTENT_ITEM_PLACEMENT_PRODUCT= ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PLACEMENT_PRODUCT;

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_PLACEMENT_PRODUCT + " ("
                + COLUMN_ID_PLACEMENT + " INTEGER NOT NULL,"
                + COLUMN_ID_PRODUCT + " INTEGER NOT NULL,"
                + " FOREIGN KEY (" + COLUMN_ID_PLACEMENT
                + ") REFERENCES " + TABLE_NAME_PLACEMENT + "(" + COLUMN_ID + "),"
                + " FOREIGN KEY (" + COLUMN_ID_PRODUCT
                + ") REFERENCES " + TABLE_NAME_PRODUCT + "(" + COLUMN_ID + ")"
                + ")";
    }

    public static final class PlacementShopEntry {
        public static final Uri CONTENT_URI_PLACEMENT_SHOP = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_PLACEMENT_SHOP);
        public static final String CONTENT_TYPE_PLACEMENT_SHOP = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PLACEMENT_SHOP;
        public static final String CONTENT_ITEM_PLACEMENT_SHOP = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PLACEMENT_SHOP;

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_PLACEMENT_SHOP + " ("
                + COLUMN_ID_PLACEMENT + " INTEGER NOT NULL,"
                + COLUMN_ID_SHOP + " INTEGER NOT NULL,"
                + " FOREIGN KEY (" + COLUMN_ID_PLACEMENT
                + ") REFERENCES " + TABLE_NAME_PLACEMENT + "(" + COLUMN_ID + "),"
                + " FOREIGN KEY (" + COLUMN_ID_SHOP
                + ") REFERENCES " + TABLE_NAME_SHOP + "(" + COLUMN_ID + ")"
                + ")";
    }

    public static final class ProductCategoryEntry {
        public static final Uri CONTENT_URI_PRODUCT_CATEGORY = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_PRODUCT_CATEGORY);
        public static final String CONTENT_TYPE_PRODUCT_CATEGORY = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCT_CATEGORY;
        public static final String CONTENT_ITEM_PRODUCT_CATEGORY = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCT_CATEGORY;

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_PRODUCT_CATEGORY + " ("
                + COLUMN_ID_PRODUCT + " INTEGER NOT NULL,"
                + COLUMN_ID_CATEGORY + " INTEGER NOT NULL,"
                + " FOREIGN KEY (" + COLUMN_ID_PRODUCT
                + ") REFERENCES " + TABLE_NAME_PRODUCT + "(" + COLUMN_ID + ")"
                + ")";
    }

    public static final class ShopProductEntry {
        public static final Uri CONTENT_URI_SHOP_PRODUCT = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_SHOP_PRODUCTS);
        public static final String CONTENT_TYPE_PRODUCT_SHOP = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHOP_PRODUCTS;
        public static final String CONTENT_ITEM_PRODUCT_SHOP = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHOP_PRODUCTS;

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_SHOP_PRODUCT + " ("
                + COLUMN_ID_SHOP + " INTEGER NOT NULL,"
                + COLUMN_ID_PRODUCT + " INTEGER NOT NULL,"
                + " FOREIGN KEY (" + COLUMN_ID_PRODUCT
                + ") REFERENCES " + TABLE_NAME_PRODUCT + "(" + COLUMN_ID + "),"
                + " FOREIGN KEY (" + COLUMN_ID_SHOP
                + ") REFERENCES " + TABLE_NAME_SHOP + "(" + COLUMN_ID + ")"
                + ")";
    }

    public static final class ProductTypeEntry {
        public static final Uri CONTENT_URI_PRODUCT_TYPE = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_PRODUCT_TYPE);
        public static final String CONTENT_TYPE_PRODUCT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCT_TYPE;
        public static final String CONTENT_ITEM_PRODUCT_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCT_TYPE;

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_PRODUCT_TYPE + " ("
                + COLUMN_ID_PRODUCT + " INTEGER NOT NULL,"
                + COLUMN_ID_TYPE + " INTEGER NOT NULL,"
                + " FOREIGN KEY (" + COLUMN_ID_PRODUCT
                + ") REFERENCES " + TABLE_NAME_PRODUCT + "(" + COLUMN_ID + ")"
                + ")";
    }

    public static final class ShopTypeEntry {
        public static final Uri CONTENT_URI_SHOP_TYPE = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_SHOP_TYPE);
        public static final String CONTENT_TYPE_SHOP_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHOP_TYPE;
        public static final String CONTENT_ITEM_SHOP_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHOP_TYPE;

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_SHOP_TYPE + " ("
                + COLUMN_ID_SHOP + " INTEGER NOT NULL,"
                + COLUMN_ID_TYPE + " INTEGER NOT NULL,"
                + " FOREIGN KEY (" + COLUMN_ID_SHOP
                + ") REFERENCES " + TABLE_NAME_SHOP + "(" + COLUMN_ID + ")"
                + ")";
    }
    public static final class ShopCategoryEntry {
        public static final Uri CONTENT_URI_SHOP_CATEGORY = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_SHOP_CATEGORY);
        public static final String CONTENT_TYPE_SHOP_CATEGORY = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHOP_CATEGORY;
        public static final String CONTENT_ITEM_SHOP_CATEGORY = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHOP_CATEGORY;

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME_SHOP_CATEGORY + " ("
                + COLUMN_ID_SHOP + " INTEGER NOT NULL,"
                + COLUMN_ID_CATEGORY + " INTEGER NOT NULL,"
                + " FOREIGN KEY (" + COLUMN_ID_SHOP
                + ") REFERENCES " + TABLE_NAME_SHOP + "(" + COLUMN_ID + ")"
                + ")";
    }
}
