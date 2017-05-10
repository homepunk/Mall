package homepunk.work.mall.data.entity.maper;

import homepunk.work.mall.data.entity.MallDetailsResponse;
import homepunk.work.mall.presentation.model.MallDetails;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class MallDetailsDataMapper {
    public static MallDetails transform(MallDetailsResponse mallDetailsResponse) {
        MallDetails mallDetails = new MallDetails();

        mallDetails.setFloors(mallDetailsResponse.getFloorResponse().getFloors());
        mallDetails.setPlacements(mallDetailsResponse.getPlacementsResponse().getPlacements());
        mallDetails.setProducts(mallDetailsResponse.getProductsResponse().getProducts());
        mallDetails.setShops(mallDetailsResponse.getShopResponse().getShops());

        return mallDetails;
    }
}
