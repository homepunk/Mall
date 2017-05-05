package homepunk.work.mall.data.storages.remote.api;

import homepunk.work.mall.data.models.MallDetails;
import homepunk.work.mall.data.models.MallUpdate;
import homepunk.work.mall.data.models.UserLogin;
import homepunk.work.mall.data.models.UserLoginCredentials;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Single;

import static homepunk.work.mall.data.Constants.Endpoints.LOGIN;
import static homepunk.work.mall.data.Constants.Endpoints.MALLS;
import static homepunk.work.mall.data.Constants.Endpoints.MALL_DETAILES;

public interface MallApi {
    @POST(LOGIN)
    Single<UserLogin> loginByCredentials(@Body UserLoginCredentials credentials);

    @POST(MALLS)
    Single<MallUpdate> fetchMalls(@Query("token") String token);

    @POST(MALL_DETAILES)
    Single<MallDetails> fetchMallDetails(@Path("id") int id,
                                                                      @Query("token") String token);
}
