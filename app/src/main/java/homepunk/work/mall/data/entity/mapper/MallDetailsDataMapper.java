package homepunk.work.mall.data.entity.mapper;

import homepunk.work.mall.data.entity.response.MallDetailsResponse;
import homepunk.work.mall.presentation.viewmodel.MallDetailsViewModel;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class MallDetailsDataMapper {
    public static MallDetailsViewModel transform(MallDetailsResponse mallDetailsResponse) {
        MallDetailsViewModel mallDetails = new MallDetailsViewModel();

        mallDetails.setFloors(mallDetailsResponse.getFloorResponse().getFloors());
        mallDetails.setPlacements(mallDetailsResponse.getPlacementsResponse().getPlacements());
        mallDetails.setProducts(mallDetailsResponse.getProductsResponse().getProducts());
        mallDetails.setShops(mallDetailsResponse.getShopResponse().getShops());

        return mallDetails;
    }
}
