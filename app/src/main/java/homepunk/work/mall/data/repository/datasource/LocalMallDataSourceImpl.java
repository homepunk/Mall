package homepunk.work.mall.data.repository.datasource;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.Category;
import homepunk.work.mall.data.entity.Floor;
import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.entity.Placement;
import homepunk.work.mall.data.entity.PlacementProduct;
import homepunk.work.mall.data.entity.PlacementShop;
import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.ProductCategory;
import homepunk.work.mall.data.entity.ProductType;
import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.data.entity.ShopCategory;
import homepunk.work.mall.data.entity.ShopProduct;
import homepunk.work.mall.data.entity.ShopType;
import homepunk.work.mall.data.entity.Type;
import homepunk.work.mall.data.entity.TypeCategory;
import homepunk.work.mall.data.repository.datasource.interfaces.DatabaseMallDataSource;
import io.reactivex.Observable;

import static homepunk.work.mall.data.database.MallContract.CategoryEntry.CONTENT_URI_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.DEFAULT_SORT_ORDER;
import static homepunk.work.mall.data.database.MallContract.FloorEntry.CONTENT_URI_FLOOR;
import static homepunk.work.mall.data.database.MallContract.MallEntry.CONTENT_URI_MALL;
import static homepunk.work.mall.data.database.MallContract.PlacementEntry.CONTENT_URI_PLACEMENT;
import static homepunk.work.mall.data.database.MallContract.PlacementProductEntry.CONTENT_URI_PLACEMENT_PRODUCT;
import static homepunk.work.mall.data.database.MallContract.PlacementShopEntry.CONTENT_URI_PLACEMENT_SHOP;
import static homepunk.work.mall.data.database.MallContract.ProductCategoryEntry.CONTENT_URI_PRODUCT_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.ProductEntry.CONTENT_URI_PRODUCT;
import static homepunk.work.mall.data.database.MallContract.ProductTypeEntry.CONTENT_URI_PRODUCT_TYPE;
import static homepunk.work.mall.data.database.MallContract.ShopCategoryEntry.CONTENT_URI_SHOP_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.ShopEntry.CONTENT_URI_SHOP;
import static homepunk.work.mall.data.database.MallContract.ShopProductEntry.CONTENT_URI_SHOP_PRODUCT;
import static homepunk.work.mall.data.database.MallContract.ShopTypeEntry.CONTENT_URI_SHOP_TYPE;
import static homepunk.work.mall.data.database.MallContract.TypeCategoryEntry.CONTENT_URI_TYPE_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.TypeEntry.CONTENT_URI_TYPE;
import static homepunk.work.mall.data.entity.Category.PROJECTION_CATEGORY;
import static homepunk.work.mall.data.entity.Floor.PROJECTION_FLOOR;
import static homepunk.work.mall.data.entity.Mall.PROJECTION_MALL;
import static homepunk.work.mall.data.entity.Placement.PROJECTION_PLACEMENT;
import static homepunk.work.mall.data.entity.Shop.PROJECTION_SHOP;
import static homepunk.work.mall.data.entity.ShopType.PROJECTION_SHOP_TYPE;
import static homepunk.work.mall.data.entity.Type.PROJECTION_TYPE;
import static homepunk.work.mall.data.entity.interfaces.DatabaseEntity.COLUMN_ID_MALL;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class LocalMallDataSourceImpl implements DatabaseMallDataSource {
    private ContentResolver resolver;

    public LocalMallDataSourceImpl(Context context) {
        resolver = context.getContentResolver();
    }

    @Override
    public void saveFloors(List<Floor> floors) {
        if (floors.size() > 0) {
            for (Floor floor : floors) {
                ContentValues values = floor.getContentValues();
                resolver.insert(CONTENT_URI_FLOOR, values);
            }
        }
    }

    @Override
    public void saveShops(List<Shop> shops) {
        if (shops.size() > 0) {
            for (Shop shop : shops) {
                ContentValues values = shop.getContentValues();
                resolver.insert(CONTENT_URI_SHOP, values);
            }
        }
    }

    @Override
    public void savePlacements(List<Placement> placements) {
        if (placements.size() > 0) {
            for (Placement placement : placements) {
                ContentValues values = placement.getContentValues();
                resolver.insert(CONTENT_URI_PLACEMENT, values);
            }
        }
    }

    @Override
    public void saveShopProducts(List<ShopProduct> shopProducts) {
        if (shopProducts.size() > 0) {
            for (ShopProduct shopProduct : shopProducts) {
                ContentValues values = shopProduct.getContentValues();
                resolver.insert(CONTENT_URI_SHOP_PRODUCT, values);
            }
        }
    }

    @Override
    public void saveProductTypes(List<ProductType> productTypes) {
        if (productTypes.size() > 0) {
            for (ProductType productType : productTypes) {
                ContentValues values = productType.getContentValues();
                resolver.insert(CONTENT_URI_PRODUCT_TYPE, values);
            }
        }
    }

    @Override
    public void saveShopCategories(List<ShopCategory> shopCategories) {
        if (shopCategories.size() > 0) {
            for (ShopCategory shopCategory : shopCategories) {
                ContentValues values = shopCategory.getContentValues();
                resolver.insert(CONTENT_URI_SHOP_CATEGORY, values);
            }
        }
    }

    @Override
    public void saveProducts(List<Product> products) {
        if (products.size() > 0) {
            for (Product product : products) {
                ContentValues values = product.getContentValues();
                resolver.insert(CONTENT_URI_PRODUCT, values);
            }
        }
    }

    @Override
    public void saveShopTypes(List<ShopType> shopTypes) {
        if (shopTypes.size() > 0) {
            for (ShopType shopType : shopTypes) {
                ContentValues values = shopType.getContentValues();
                resolver.insert(CONTENT_URI_SHOP_TYPE, values);
            }
        }
    }

    @Override
    public void saveMalls(List<Mall> malls) {
        if (malls.size() > 0) {
            for (Mall mall : malls) {
                if (mall != null) {
                    ContentValues values = mall.getContentValues();
                    resolver.insert(CONTENT_URI_MALL, values);
                }
            }
        }
    }

    @Override
    public void saveTypes(List<Type> types) {
        if (types.size() > 0) {
            for (Type type : types) {
                if (type != null) {
                    ContentValues values = type.getContentValues();
                    resolver.insert(CONTENT_URI_TYPE, values);
                }
            }
        }
    }

    @Override
    public void saveCategories(List<Category> categories) {
        if (categories.size() > 0) {
            for (Category category : categories) {
                if (category != null) {
                    ContentValues values = category.getContentValues();
                    resolver.insert(CONTENT_URI_CATEGORY, values);
                }
            }
        }
    }

    @Override
    public void saveTypeCategories(List<TypeCategory> typeCategories) {
        for (TypeCategory typeCategory : typeCategories) {
            if (typeCategory != null) {
                ContentValues values = typeCategory.getContentValues();
                resolver.insert(CONTENT_URI_TYPE_CATEGORY, values);
            }
        }
    }

    @Override
    public void savePlacementShops(List<PlacementShop> placementShops) {
        if (placementShops.size() > 0) {
            for (PlacementShop placementShop : placementShops) {
                ContentValues values = placementShop.getContentValues();
                resolver.insert(CONTENT_URI_PLACEMENT_SHOP, values);
            }
        }
    }

    @Override
    public void saveProductCategories(List<ProductCategory> productCategories) {
        if (productCategories.size() > 0) {
            for (ProductCategory productCategory : productCategories) {
                ContentValues values = productCategory.getContentValues();
                resolver.insert(CONTENT_URI_PRODUCT_CATEGORY, values);
            }
        }
    }

    @Override
    public void savePlacementProducts(List<PlacementProduct> placementProducts) {
        if (placementProducts.size() > 0) {
            for (PlacementProduct placementProduct : placementProducts) {
                ContentValues values = placementProduct.getContentValues();
                resolver.insert(CONTENT_URI_PLACEMENT_PRODUCT, values);
            }
        }
    }

    @Override
    public Observable<List<Mall>> getMalls() {
        List<Mall> databaseMalls = new ArrayList<>();
        Cursor cursor = resolver.query(CONTENT_URI_MALL, PROJECTION_MALL, null, null, DEFAULT_SORT_ORDER);

        while (cursor.moveToNext()) {
            databaseMalls.add(new Mall(cursor));
        }

        return Observable.just(databaseMalls);
    }

    @Override
    public Observable<List<Type>> getTypes(int mallId) {
        List<Type> databaseTypes = new ArrayList<>();
        Cursor cursor = resolver.query(CONTENT_URI_TYPE, PROJECTION_TYPE, null, null, DEFAULT_SORT_ORDER);

        while (cursor.moveToNext()) {
            databaseTypes.add(new Type(cursor));
        }

        return Observable.just(databaseTypes);
    }

    @Override
    public Observable<List<Shop>> getShops(int mallId) {
        List<Shop> databaseShops = new ArrayList<>();
        Cursor cursor = resolver.query(CONTENT_URI_SHOP, PROJECTION_SHOP, null, null, DEFAULT_SORT_ORDER);

        while (cursor.moveToNext()) {
            databaseShops.add(new Shop(cursor));
        }

        return Observable.just(databaseShops);
    }

    @Override
    public Observable<List<Floor>> getMallFloors(int id) {
        List<Floor> databaseFloors = new ArrayList<>();
        Cursor cursor = resolver.query(CONTENT_URI_FLOOR, PROJECTION_FLOOR, COLUMN_ID_MALL + " = ?", new String[]{String.valueOf(id)}, DEFAULT_SORT_ORDER);

        while (cursor.moveToNext()) {
            databaseFloors.add(new Floor(cursor));
        }

        return Observable.just(databaseFloors);
    }

    @Override
    public Observable<List<Product>> getProducts(int mallId) {
        List<Product> databaseProducts = new ArrayList<>();
        Cursor cursor = resolver.query(CONTENT_URI_MALL, PROJECTION_MALL, null, null, DEFAULT_SORT_ORDER);

        while (cursor.moveToNext()) {
            databaseProducts.add(new Product(cursor));
        }

        return Observable.just(databaseProducts);
    }

    @Override
    public Observable<List<ShopType>> getShopTypes(int mallId) {
        List<ShopType> databaseShopTypes = new ArrayList<>();
        Cursor cursor = resolver.query(CONTENT_URI_SHOP_TYPE, PROJECTION_SHOP_TYPE, null, null, DEFAULT_SORT_ORDER);

        while (cursor.moveToNext()) {
            databaseShopTypes.add(new ShopType(cursor));
        }

        return Observable.just(databaseShopTypes);
    }

    @Override
    public Observable<List<Category>> getCategories(int mallId) {
        List<Category> databaseCategories = new ArrayList<>();
        Cursor cursor = resolver.query(CONTENT_URI_CATEGORY, PROJECTION_CATEGORY, null, null, DEFAULT_SORT_ORDER);

        while (cursor.moveToNext()) {
            databaseCategories.add(new Category(cursor));
        }

        return Observable.just(databaseCategories);
    }

    @Override
    public Observable<List<Placement>> getPlacements(int mallId) {
        List<Placement> databasePlacements = new ArrayList<>();
        Cursor cursor = resolver.query(CONTENT_URI_PLACEMENT, PROJECTION_PLACEMENT, null, null, DEFAULT_SORT_ORDER);

        while (cursor.moveToNext()) {
            databasePlacements.add(new Placement(cursor));
        }

        return Observable.just(databasePlacements);
    }

    @Override
    public Observable<List<ProductType>> getProductTypes(int mallId) {
        return null;
    }

    @Override
    public Observable<List<ShopProduct>> getProductShops(int mallId) {
        return null;
    }

    @Override
    public Observable<List<ShopCategory>> getShopCategories(int mallId) {
        return null;
    }

    @Override
    public Observable<List<PlacementShop>> getPlacementShops(int mallId) {
        return null;
    }

    @Override
    public Observable<List<TypeCategory>> getTypeCategories(int mallId) {
        return null;
    }

    @Override
    public Observable<List<ProductCategory>> getProductCategories(int mallId) {
        return null;
    }

    @Override
    public Observable<List<PlacementProduct>> getPlacementProducts(int mallId) {
        return null;
    }
}
