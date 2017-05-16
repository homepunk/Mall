package homepunk.work.mall.data.api;

import homepunk.work.mall.data.entity.response.MallDetailsResponse;
import homepunk.work.mall.data.entity.response.MallResponse;
import homepunk.work.mall.data.entity.response.TypeCategoryResponse;
import homepunk.work.mall.domain.model.UserCredentials;
import homepunk.work.mall.presentation.viewmodel.UserViewModel;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Single;

import static homepunk.work.mall.data.Constants.Endpoint.LOGIN_ENDPOINT;
import static homepunk.work.mall.data.Constants.Endpoint.MALL_LIST_ENPOINT;
import static homepunk.work.mall.data.Constants.Endpoint.FULL_MALL_INFORMATION_ENDPOINT;
import static homepunk.work.mall.data.Constants.Endpoint.TYPE_CATEGORIES_ENDPOINT;

public interface MallApi {
    String PATH_ID = "id";
    String QUERY_TOKEN = "token";

    @POST(LOGIN_ENDPOINT)
    Single<UserViewModel> loginByCredentials(@Body UserCredentials credentials);

    @POST(MALL_LIST_ENPOINT)
    Single<MallResponse> fetchMalls(@Query(QUERY_TOKEN) String token);

    @POST(TYPE_CATEGORIES_ENDPOINT)
    Single<TypeCategoryResponse> fetchTypeCategories(@Path(PATH_ID) int id,
                                                     @Query(QUERY_TOKEN) String token);

    @POST(FULL_MALL_INFORMATION_ENDPOINT)
    Single<MallDetailsResponse> fetchFullMallInfromation(@Path(PATH_ID) int id,
                                                         @Query(QUERY_TOKEN) String token);
}
