package homepunk.work.mall.domain.interactors;

import android.content.Context;

import homepunk.work.mall.data.repository.SyncRepositoryImpl;
import homepunk.work.mall.domain.interactors.interfaces.SyncUpdatesInteractor;
import homepunk.work.mall.domain.repository.SyncRepository;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;

import static homepunk.work.mall.domain.model.mapper.ViewModelToEntityMapper.transform;

/**
 * Created by Homepunk on 12.05.2017.
 **/

public class SyncUpdatesInteractorImpl implements SyncUpdatesInteractor {
    private SyncRepository syncRepository;

    public SyncUpdatesInteractorImpl(Context context) {
        syncRepository = new SyncRepositoryImpl(context);
    }

    @Override
    public void syncMall(MallViewModel mall) {
        syncRepository.syncMallRecords(transform(mall));
    }

    @Override
    public void syncMallList() {
        syncRepository.syncMallList();
    }
}
