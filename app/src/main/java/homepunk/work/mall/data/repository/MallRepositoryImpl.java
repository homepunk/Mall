package homepunk.work.mall.data.repository;

import java.util.List;

import homepunk.work.mall.data.entity.maper.MallDetailsDataMapper;
import homepunk.work.mall.presentation.model.Mall;
import homepunk.work.mall.data.entity.MallResponse;
import homepunk.work.mall.data.repository.factory.MallDataSourceFactory;
import homepunk.work.mall.domain.repository.MallRepository;
import homepunk.work.mall.presentation.model.MallDetails;
import rx.Single;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class MallRepositoryImpl implements MallRepository {
    private MallDataSourceFactory dataSourceFactory;

    public MallRepositoryImpl() {
        this.dataSourceFactory = new MallDataSourceFactory();
    }

    @Override
    public Single<List<Mall>> getMalls() {
        return dataSourceFactory
                .createDataSource()
                .getMalls()
                .map(MallResponse::getMalls);
    }

    @Override
    public Single<MallDetails> getMallDetails(int id) {
        return dataSourceFactory
                .createDataSource()
                .getMallDetails(id)
                .map(MallDetailsDataMapper::transform);
    }
}
