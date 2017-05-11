package homepunk.work.mall.data.repository.datasource.remote;

import android.content.Context;
import android.text.TextUtils;

import homepunk.work.mall.data.api.MallApi;
import homepunk.work.mall.data.api.MallApiConnection;
import homepunk.work.mall.data.entity.response.MallDetailsResponse;
import homepunk.work.mall.data.entity.response.MallResponse;
import homepunk.work.mall.data.repository.datasource.local.DatabaseMallDataSourceImpl;
import homepunk.work.mall.data.repository.datasource.remote.interfaces.MallDataSource;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class RestMallDataSourceImpl implements MallDataSource {
    private MallApi mallApi;
    private DatabaseMallDataSourceImpl mallDataSource;
    private String token;

    public RestMallDataSourceImpl(Context context, String userToken) {
        mallApi = MallApiConnection.getInstance();
        mallDataSource = new DatabaseMallDataSourceImpl(context);

        token = userToken;
    }

    @Override
    public Single<MallResponse> getMalls() {
        if (TextUtils.isEmpty(token)) {
//            TODO return custom exception
            return null;
        }

        return mallApi.fetchMalls(token);
    }

    @Override
    public Single<MallDetailsResponse> getMallDetails(int id) {
        return mallApi.fetchMallDetails(id, token);
    }
}
