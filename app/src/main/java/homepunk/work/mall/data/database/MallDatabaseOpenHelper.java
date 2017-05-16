package homepunk.work.mall.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import homepunk.work.mall.data.database.MallContract.CategoryEntry;
import homepunk.work.mall.data.database.MallContract.TypeCategoryEntry;
import homepunk.work.mall.data.database.MallContract.TypeEntry;

import static homepunk.work.mall.data.database.MallContract.*;
import static homepunk.work.mall.data.database.MallContract.FloorEntry;
import static homepunk.work.mall.data.database.MallContract.MallEntry;
import static homepunk.work.mall.data.database.MallContract.PlacementEntry;
import static homepunk.work.mall.data.database.MallContract.ProductEntry;
import static homepunk.work.mall.data.database.MallContract.ShopEntry;
import static homepunk.work.mall.data.entity.Category.TABLE_NAME_CATEGORY;
import static homepunk.work.mall.data.entity.Floor.TABLE_NAME_FLOOR;
import static homepunk.work.mall.data.entity.Mall.TABLE_NAME_MALL;
import static homepunk.work.mall.data.entity.Placement.TABLE_NAME_PLACEMENT;
import static homepunk.work.mall.data.entity.PlacementProduct.TABLE_NAME_PLACEMENT_PRODUCT;
import static homepunk.work.mall.data.entity.PlacementShop.TABLE_NAME_PLACEMENT_SHOP;
import static homepunk.work.mall.data.entity.Product.TABLE_NAME_PRODUCT;
import static homepunk.work.mall.data.entity.ProductCategory.TABLE_NAME_PRODUCT_CATEGORY;
import static homepunk.work.mall.data.entity.ShopProduct.TABLE_NAME_SHOP_PRODUCT;
import static homepunk.work.mall.data.entity.ProductType.TABLE_NAME_PRODUCT_TYPE;
import static homepunk.work.mall.data.entity.Shop.TABLE_NAME_SHOP;
import static homepunk.work.mall.data.entity.ShopCategory.TABLE_NAME_SHOP_CATEGORY;
import static homepunk.work.mall.data.entity.ShopType.TABLE_NAME_SHOP_TYPE;
import static homepunk.work.mall.data.entity.Type.TABLE_NAME_TYPE;
import static homepunk.work.mall.data.entity.TypeCategory.TABLE_NAME_TYPE_CATEGORY;

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
        db.execSQL(MallEntry.CREATE_TABLE);
        db.execSQL(ShopEntry.CREATE_TABLE);
        db.execSQL(TypeEntry.CREATE_TABLE);
        db.execSQL(FloorEntry.CREATE_TABLE);
        db.execSQL(ProductEntry.CREATE_TABLE);
        db.execSQL(CategoryEntry.CREATE_TABLE);
        db.execSQL(ShopTypeEntry.CREATE_TABLE);
        db.execSQL(PlacementEntry.CREATE_TABLE);
        db.execSQL(ProductTypeEntry.CREATE_TABLE);
        db.execSQL(ShopProductEntry.CREATE_TABLE);
        db.execSQL(ShopCategoryEntry.CREATE_TABLE);
        db.execSQL(TypeCategoryEntry.CREATE_TABLE);
        db.execSQL(PlacementShopEntry.CREATE_TABLE);
        db.execSQL(ProductCategoryEntry.CREATE_TABLE);
        db.execSQL(PlacementProductEntry.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SHOP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MALL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_TYPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_FLOOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PRODUCT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SHOP_TYPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PLACEMENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PRODUCT_TYPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SHOP_PRODUCT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SHOP_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_TYPE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PLACEMENT_SHOP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PRODUCT_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PLACEMENT_PRODUCT);

        onCreate(db);
    }
}
