package homepunk.work.mall.data.api;

import homepunk.work.mall.data.entity.response.MallResponse;
import homepunk.work.mall.data.entity.response.MallSyncResponse;
import homepunk.work.mall.data.entity.response.TypeCategoryResponse;
import homepunk.work.mall.domain.model.UserCredentials;
import homepunk.work.mall.presentation.viewmodel.UserViewModel;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static homepunk.work.mall.data.Constants.Endpoint.FULL_MALL_INFORMATION_ENDPOINT;
import static homepunk.work.mall.data.Constants.Endpoint.LOGIN_ENDPOINT;
import static homepunk.work.mall.data.Constants.Endpoint.MALL_LIST_ENPOINT;
import static homepunk.work.mall.data.Constants.Endpoint.TYPE_CATEGORIES_ENDPOINT;

public interface MallApi {
    String PATH_ID = "id";
    String TIMESTAMP = "since";
    String QUERY_TOKEN = "token";

    @POST(LOGIN_ENDPOINT)
    Single<UserViewModel> login(@Body UserCredentials credentials);

    @FormUrlEncoded
    @POST(MALL_LIST_ENPOINT)
    Single<MallResponse> fetchMalls(@Field(TIMESTAMP) long since,
                                    @Query(QUERY_TOKEN) String token);

    @POST(TYPE_CATEGORIES_ENDPOINT)
    Single<TypeCategoryResponse> fetchTypeCategories(@Path(PATH_ID) int id,
                                                     @Query(QUERY_TOKEN) String token);
    @FormUrlEncoded
    @POST(FULL_MALL_INFORMATION_ENDPOINT)
    Single<MallSyncResponse> fetchFullMallInfromation(@Field(TIMESTAMP) long since,
                                                      @Path(PATH_ID) int id,
                                                      @Query(QUERY_TOKEN) String token);
}
