package homepunk.work.mall.data.api;

import android.content.Context;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.File;

import okhttp3.Cache;
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
    public static MallApi getInstance(Context context) {
        if (mallApiInstance == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder clientBuilder = new OkHttpClient
                    .Builder()
                    .retryOnConnectionFailure(false)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .addInterceptor(interceptor);

            final File baseDir = context.getCacheDir();

            if (baseDir != null) {
                final File cacheDir = new File(baseDir, "HttpResponseCache");
                clientBuilder.cache(new Cache(cacheDir, 50));
            }

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(SWAGGER_URL)
                    .client(clientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            mallApiInstance = retrofit.create(MallApi.class);
        }

        return mallApiInstance;
    }
}
