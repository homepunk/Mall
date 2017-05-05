package homepunk.work.mall.data.managers;

import homepunk.work.mall.data.managers.interfaces.RemoteManager;
import homepunk.work.mall.data.storages.remote.repository.RemoteRepositoryImpl;
import homepunk.work.mall.data.storages.remote.repository.interfaces.RemoteRepository;
import homepunk.work.mall.data.storages.remote.api.MallApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static homepunk.work.mall.data.Constants.BaseUrls.SWAGGER_URL;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class RemoteManagerImpl implements RemoteManager {
    private static MallApi mallApi;
    private static OkHttpClient client;
    private static RemoteManagerImpl remoteManagerInstance;

    private RemoteManagerImpl() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient
                .Builder()
                .retryOnConnectionFailure(false)
//                .addInterceptor(interceptor)
                .build();
    }

    public static RemoteManagerImpl getInstance() {
        if (remoteManagerInstance == null) {
            remoteManagerInstance = new RemoteManagerImpl();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(SWAGGER_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            mallApi = retrofit.create(MallApi.class);
        }

        return remoteManagerInstance;
    }

    @Override
    public RemoteRepository getRemoteRepository() {
        return new RemoteRepositoryImpl(mallApi);
    }
}
