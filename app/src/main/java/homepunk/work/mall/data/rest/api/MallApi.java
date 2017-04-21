package homepunk.work.mall.data.rest.api;

import homepunk.work.mall.presentations.login.models.LoginCredentials;
import homepunk.work.mall.presentations.login.models.UserLogin;
import homepunk.work.mall.presentations.main.model.Malls;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Single;

import static homepunk.work.mall.data.Constants.LOGIN_ENDPOINT;
import static homepunk.work.mall.data.Constants.MALLS_ENDPOINT;

public interface MallApi {
    @POST(LOGIN_ENDPOINT)
    Single<UserLogin> loginByCredentials(@Body LoginCredentials credentials);

    @POST(MALLS_ENDPOINT)
    Single<Malls> fetchMalls(@Query("token") String token);
}
