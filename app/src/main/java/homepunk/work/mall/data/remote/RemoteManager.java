package homepunk.work.mall.data.remote;

import homepunk.work.mall.data.remote.repository.interfaces.IRemoteRepository;
import homepunk.work.mall.data.managers.interfaces.IRemoteManager;
import homepunk.work.mall.data.remote.service.MallApi;
import homepunk.work.mall.data.remote.repository.RemoteRepository;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static homepunk.work.mall.data.Constants.BASE_URL;

public class RemoteManager implements IRemoteManager {
    private static MallApi mallApi;
    private static OkHttpClient client;

    public RemoteManager() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient
                .Builder()
                .retryOnConnectionFailure(false)
//                .addInterceptor(interceptor)
                .build();

        mallApi = getInstance();
    }

    private MallApi getInstance() {
        if (mallApi == null) {
            new RemoteManager();

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

    @Override
    public IRemoteRepository getRemoteRepository() {
        return new RemoteRepository(mallApi);
    }
}
