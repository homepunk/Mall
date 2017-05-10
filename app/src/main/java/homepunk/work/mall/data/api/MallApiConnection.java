package homepunk.work.mall.data.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static homepunk.work.mall.data.Constants.BaseUrl.SWAGGER_URL;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class MallApiConnection {
    private static MallApi mallApiInstance;

    public static MallApi getMallApiInstance() {
        if (mallApiInstance == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient
                    .Builder()
                    .retryOnConnectionFailure(false)
                    .addInterceptor(interceptor)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(SWAGGER_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            mallApiInstance = retrofit.create(MallApi.class);
        }

        return mallApiInstance;
    }
}
