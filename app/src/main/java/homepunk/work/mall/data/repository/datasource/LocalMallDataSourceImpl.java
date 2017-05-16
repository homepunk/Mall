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
import homepunk.work.mall.data.entity.ShopProduct;
import homepunk.work.mall.data.entity.ProductType;
import homepunk.work.mall.data.entity.Shop;
import homepunk.work.mall.data.entity.ShopCategory;
import homepunk.work.mall.data.entity.ShopType;
import homepunk.work.mall.data.entity.Type;
import homepunk.work.mall.data.entity.TypeCategory;
import homepunk.work.mall.data.entity.response.MallDetailsResponse;
import homepunk.work.mall.data.entity.response.TypeCategoryResponse;
import homepunk.work.mall.data.repository.datasource.interfaces.DatabaseMallDataSource;
import rx.Single;
import timber.log.Timber;

import static homepunk.work.mall.data.database.MallContract.CategoryEntry.CONTENT_URI_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.DEFAULT_SORT_ORDER;
import static homepunk.work.mall.data.database.MallContract.FloorEntry.CONTENT_URI_FLOOR;
import static homepunk.work.mall.data.database.MallContract.MallEntry.CONTENT_URI_MALL;
import static homepunk.work.mall.data.database.MallContract.PlacementEntry.CONTENT_URI_PLACEMENT;
import static homepunk.work.mall.data.database.MallContract.PlacementProductEntry.CONTENT_URI_PLACEMENT_PRODUCT;
import static homepunk.work.mall.data.database.MallContract.PlacementShopEntry.CONTENT_URI_PLACEMENT_SHOP;
import static homepunk.work.mall.data.database.MallContract.ProductCategoryEntry.CONTENT_URI_PRODUCT_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.ProductEntry.CONTENT_URI_PRODUCT;
import static homepunk.work.mall.data.database.MallContract.ShopProductEntry.CONTENT_URI_SHOP_PRODUCT;
import static homepunk.work.mall.data.database.MallContract.ProductTypeEntry.CONTENT_URI_PRODUCT_TYPE;
import static homepunk.work.mall.data.database.MallContract.ShopCategoryEntry.CONTENT_URI_SHOP_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.ShopEntry.CONTENT_URI_SHOP;
import static homepunk.work.mall.data.database.MallContract.ShopTypeEntry.CONTENT_URI_SHOP_TYPE;
import static homepunk.work.mall.data.database.MallContract.TypeCategoryEntry.CONTENT_URI_TYPE_CATEGORY;
import static homepunk.work.mall.data.database.MallContract.TypeEntry.CONTENT_URI_TYPE;
import static homepunk.work.mall.data.entity.Mall.PROJECTION_MALL;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class LocalMallDataSourceImpl implements DatabaseMallDataSource {
    private ContentResolver resolver;

    public LocalMallDataSourceImpl(Context context) {
        resolver = context.getContentResolver();
    }

    @Override
    public Single<List<Mall>> getMalls() {
        ArrayList<Mall> databaseMalls = new ArrayList<>();
        Cursor cursor = resolver.query(CONTENT_URI_MALL, PROJECTION_MALL, null, null, DEFAULT_SORT_ORDER);

        while (cursor.moveToNext()) {
            databaseMalls.add(new Mall(cursor));
        }

        return Single.just(databaseMalls);
    }

    @Override
    public Single<TypeCategoryResponse> getSummaryTypeCategories(int mallId) {
        return null;
    }

    @Override
    public Single<List<Floor>> getFloors(int mallId) {
        return null;
    }

    @Override
    public Single<List<Shop>> getShops(int mallId) {
        return null;
    }

    @Override
    public Single<List<Product>> getProducts(int mallId) {
        return null;
    }

    @Override
    public Single<List<Placement>> getPlacements(int mallId) {
        return null;
    }

    @Override
    public Single<MallDetailsResponse> getFullMallInformation(int mallId) {
        return null;
    }

    @Override
    public Single<List<Type>> getTypes(int mallId) {
        return null;
    }

    @Override
    public Single<List<ShopType>> getShopTypes(int mallId) {
        return null;
    }

    @Override
    public Single<List<Category>> getCategories(int mallId) {
        return null;
    }

    @Override
    public Single<List<ShopProduct>> getProductShops(int mallId) {
        return null;
    }

    @Override
    public Single<List<ProductType>> getProductTypes(int mallId) {
        return null;
    }

    @Override
    public Single<List<ShopCategory>> getShopCategories(int mallId) {
        return null;
    }

    @Override
    public Single<List<TypeCategory>> getTypeCategories(int mallId) {
        return null;
    }

    @Override
    public Single<List<PlacementShop>> getPlacementShops(int mallId) {
        return null;
    }

    @Override
    public Single<List<ProductCategory>> getProductCategories(int mallId) {
        return null;
    }

    @Override
    public Single<List<PlacementProduct>> getPlacementProducts(int mallId) {
        return null;
    }

    @Override
    public void saveFloors(List<Floor> floors) {
        for (Floor floor : floors) {
            ContentValues values = floor.getContentValues();
            resolver.insert(CONTENT_URI_FLOOR, values);
        }
    }

    @Override
    public void saveShops(List<Shop> shops) {
        for (Shop shop : shops) {
            ContentValues values = shop.getContentValues();
            resolver.insert(CONTENT_URI_SHOP, values);
        }
    }

    @Override
    public void savePlacements(List<Placement> placements) {
        for (Placement placement : placements) {
            ContentValues values = placement.getContentValues();
            resolver.insert(CONTENT_URI_PLACEMENT, values);
        }
    }

    @Override
    public void saveShopProducts(List<ShopProduct> shopProducts) {
        for (ShopProduct shopProduct : shopProducts) {
            ContentValues values = shopProduct.getContentValues();
            resolver.insert(CONTENT_URI_SHOP_PRODUCT, values);
        }
    }

    @Override
    public void saveProductTypes(List<ProductType> productTypes) {
        for (ProductType productType : productTypes) {
            ContentValues values = productType.getContentValues();
            resolver.insert(CONTENT_URI_PRODUCT_TYPE, values);
        }
    }

    @Override
    public void saveShopCategories(List<ShopCategory> shopCategories) {
        for (ShopCategory shopCategory : shopCategories) {
            ContentValues values = shopCategory.getContentValues();
            resolver.insert(CONTENT_URI_SHOP_CATEGORY, values);
        }
    }

    @Override
    public void saveProducts(List<Product> products) {
        for (Product product : products) {
            ContentValues values = product.getContentValues();
            resolver.insert(CONTENT_URI_PRODUCT, values);
        }
    }

    @Override
    public void saveShopTypes(List<ShopType> shopTypes) {
        for (ShopType shopType : shopTypes) {
            ContentValues values = shopType.getContentValues();
            resolver.insert(CONTENT_URI_SHOP_TYPE, values);
        }
    }

    @Override
    public void saveMalls(List<Mall> malls) {
        for (Mall mall : malls) {
            if (mall != null) {
                Timber.i("Saving mall " + mall.getName());
                ContentValues values = mall.getContentValues();
                resolver.insert(CONTENT_URI_MALL, values);
            } else {
                Timber.e("mall is null");
            }
        }
    }

    @Override
    public void saveTypes(List<Type> types) {
        for (Type type : types) {
            if (type != null) {
                ContentValues values = type.getContentValues();
                resolver.insert(CONTENT_URI_TYPE, values);
            }
        }
    }

    @Override
    public void saveCategories(List<Category> categories) {
        for (Category category : categories) {
            if (category != null) {
                ContentValues values = category.getContentValues();
                resolver.insert(CONTENT_URI_CATEGORY, values);
            }
        }
    }

    @Override
    public void saveTypeCategories(List<TypeCategory> typeCategories) {
        Timber.i("Type category saving");
        for (TypeCategory typeCategory : typeCategories) {
            if (typeCategory != null) {
                ContentValues values = typeCategory.getContentValues();
                resolver.insert(CONTENT_URI_TYPE_CATEGORY, values);
            }
        }
    }

    @Override
    public void savePlacementShops(List<PlacementShop> placementShops) {
        for (PlacementShop placementShop : placementShops) {
            ContentValues values = placementShop.getContentValues();
            resolver.insert(CONTENT_URI_PLACEMENT_SHOP, values);
        }
    }

    @Override
    public void saveProductCategories(List<ProductCategory> productCategories) {
        for (ProductCategory productCategory : productCategories) {
            ContentValues values = productCategory.getContentValues();
            resolver.insert(CONTENT_URI_PRODUCT_CATEGORY, values);
        }
    }

    @Override
    public void savePlacementProducts(List<PlacementProduct> placementProducts) {
        for (PlacementProduct placementProduct : placementProducts) {
            ContentValues values = placementProduct.getContentValues();
            resolver.insert(CONTENT_URI_PLACEMENT_PRODUCT, values);
        }
    }
}
