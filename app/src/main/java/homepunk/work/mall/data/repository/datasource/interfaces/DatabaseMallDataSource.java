package homepunk.work.mall.data.repository.datasource.interfaces;

import java.util.List;

import homepunk.work.mall.data.entity.Floor;
import homepunk.work.mall.data.entity.Mall;
import homepunk.work.mall.data.entity.Placement;
import homepunk.work.mall.data.entity.Product;
import homepunk.work.mall.data.entity.Shop;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public interface DatabaseMallDataSource extends MallDataSource {
    void saveFloors(List<Floor> floors);

    void saveShops(List<Shop> shops);

    void savePlacements(List<Placement> placements);

    void saveProducts(List<Product> products);

    void saveMalls(List<Mall> malls);
}
