package homepunk.work.mall.data.repository.datasource.remote;

import android.text.TextUtils;

import homepunk.work.mall.data.entity.MallDetailsResponse;
import homepunk.work.mall.data.entity.MallResponse;
import homepunk.work.mall.data.api.MallApi;
import homepunk.work.mall.data.api.MallApiConnection;
import homepunk.work.mall.data.repository.datasource.remote.interfaces.MallDataSource;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class MallApiDataSourceImpl implements MallDataSource {
    private MallApi mallApi;
    private String token;

    public MallApiDataSourceImpl(String userToken) {
        mallApi = MallApiConnection.getMallApiInstance();
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
