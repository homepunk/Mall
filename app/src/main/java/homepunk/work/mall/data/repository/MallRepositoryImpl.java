package homepunk.work.mall.data.repository;

import android.content.Context;

import java.util.List;

import homepunk.work.mall.data.entity.mapper.MallDetailsDataMapper;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import homepunk.work.mall.data.entity.response.MallResponse;
import homepunk.work.mall.data.repository.factory.MallDataSourceFactory;
import homepunk.work.mall.domain.repository.MallRepository;
import homepunk.work.mall.presentation.viewmodel.MallDetailsViewModel;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class MallRepositoryImpl implements MallRepository {
    private MallDataSourceFactory dataSourceFactory;

    public MallRepositoryImpl(Context context) {
        this.dataSourceFactory = new MallDataSourceFactory(context);
    }

    @Override
    public Single<List<MallViewModel>> getMalls() {

        return dataSourceFactory
                .createDataSource()
                .getMalls()
                .map(MallResponse::getMalls);
    }

    @Override
    public Single<MallDetailsViewModel> getMallDetails(int id) {
        return dataSourceFactory
                .createDataSource()
                .getMallDetails(id)
                .map(MallDetailsDataMapper::transform);
    }
}
