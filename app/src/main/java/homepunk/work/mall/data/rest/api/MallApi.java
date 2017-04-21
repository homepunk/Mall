package homepunk.work.mall.data.rest.api;

import homepunk.work.mall.presentations.login.models.LoginCredentials;
import homepunk.work.mall.presentations.login.models.LoginUser;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Single;

import static homepunk.work.mall.data.Constants.LOGIN_ENDPOINT;

public interface MallApi {
    @POST(LOGIN_ENDPOINT)
    Single<LoginUser> loginByCredentials(@Body LoginCredentials credentials);
}
