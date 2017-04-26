package homepunk.work.mall.data.storages.remote.service;

import homepunk.work.mall.data.models.UserLoginCredentials;
import homepunk.work.mall.data.models.UserLogin;
import homepunk.work.mall.data.models.Mall;
import homepunk.work.mall.data.models.Malls;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Single;

import static homepunk.work.mall.data.Constants.LOGIN_ENDPOINT;
import static homepunk.work.mall.data.Constants.MALLS_ENDPOINT;
import static homepunk.work.mall.data.Constants.MALL_DETAILES_ENDPOINT;

public interface MallApi {
    @POST(LOGIN_ENDPOINT)
    Single<UserLogin> loginByCredentials(@Body UserLoginCredentials credentials);

    @POST(MALLS_ENDPOINT)
    Single<Malls> fetchMalls(@Query("token") String token);

    @GET(MALL_DETAILES_ENDPOINT)
    Single<Mall> fetchMallDetails(@Path("id") int id,
                                  @Query("token") String token);
}
