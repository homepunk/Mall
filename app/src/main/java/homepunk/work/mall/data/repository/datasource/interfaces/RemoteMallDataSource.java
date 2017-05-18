package homepunk.work.mall.data.repository.datasource.interfaces;

import homepunk.work.mall.data.entity.response.MallResponse;
import homepunk.work.mall.data.entity.response.MallSyncResponse;
import homepunk.work.mall.data.entity.response.TypeCategoryResponse;
import rx.Single;

/**
 * Created by Homepunk on 18.05.2017.
 **/

public interface RemoteMallDataSource extends MallDataSource {
    Single<MallSyncResponse> getMallSyncReponse(int mallId);

    Single<TypeCategoryResponse> getTypeCategoryResponse(int mallId);

    Single<MallResponse> getMallsResponse();

}
