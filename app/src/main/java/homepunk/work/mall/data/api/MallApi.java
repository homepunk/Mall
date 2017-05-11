package homepunk.work.mall.data.api;

import homepunk.work.mall.data.entity.response.MallDetailsResponse;
import homepunk.work.mall.data.entity.response.MallResponse;
import homepunk.work.mall.presentation.viewmodel.UserLoginViewModel;
import homepunk.work.mall.domain.model.UserLoginCredentials;
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
    Single<UserLoginViewModel> loginByCredentials(@Body UserLoginCredentials credentials);

    @POST(MALLS)
    Single<MallResponse> fetchMalls(@Query("token") String token);

    @POST(MALL_DETAILES)
    Single<MallDetailsResponse> fetchMallDetails(@Path("id") int id,
                                                 @Query("token") String token);
}
