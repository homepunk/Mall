package homepunk.work.mall.data.api;

import homepunk.work.mall.data.entity.MallDetailsResponse;
import homepunk.work.mall.data.entity.MallResponse;
import homepunk.work.mall.presentation.model.UserLogin;
import homepunk.work.mall.presentation.model.UserLoginCredentials;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Single;

import static homepunk.work.mall.data.Constants.Endpoint.LOGIN;
import static homepunk.work.mall.data.Constants.Endpoint.MALLS;
import static homepunk.work.mall.data.Constants.Endpoint.MALL_DETAILES;

public interface MallApi {
    @POST(LOGIN)
    Single<UserLogin> loginByCredentials(@Body UserLoginCredentials credentials);

    @POST(MALLS)
    Single<MallResponse> fetchMalls(@Query("token") String token);

    @POST(MALL_DETAILES)
    Single<MallDetailsResponse> fetchMallDetails(@Path("id") int id,
                                                 @Query("token") String token);
}
