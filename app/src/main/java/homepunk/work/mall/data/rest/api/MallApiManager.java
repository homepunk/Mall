package homepunk.work.mall.data.rest.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static homepunk.work.mall.data.Constants.BASE_URL;

public class MallApiManager {
    private static MallApi mallApi;
    private static OkHttpClient client;

    private MallApiManager() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient
                .Builder()
                .retryOnConnectionFailure(false)
                .addInterceptor(interceptor)
                .build();
    }

    public static MallApi getInstance() {
        if (mallApi == null) {
            new MallApiManager();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            mallApi = retrofit.create(MallApi.class);
        }

        return mallApi;
    }
}
