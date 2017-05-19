package homepunk.work.mall.domain.interactors;

import android.content.Context;

import java.util.List;

import homepunk.work.mall.data.repository.MallRepositoryImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetFloorListInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.domain.model.mapper.EntityToViewModelMapper;
import homepunk.work.mall.domain.repository.MallRepository;
import homepunk.work.mall.presentation.viewmodel.FloorViewModel;
import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class GetFloorListInteractorImpl implements GetFloorListInteractor {
    private MallRepository mallRepository;

    public GetFloorListInteractorImpl(Context context) {
        this.mallRepository = new MallRepositoryImpl(context);
    }

    @Override
    public void getFloorList(int mallid, MallListener<List<FloorViewModel>> listener) {
        mallRepository.getMallFloors(mallid)
                .subscribeOn(Schedulers.io())
                .flatMap(Observable::fromIterable)
                .map(EntityToViewModelMapper::transform)
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<FloorViewModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<FloorViewModel> floorViewModels) {
                        Timber.i("Recieved " + String.valueOf(floorViewModels.size()));
                        listener.onSuccess(floorViewModels);
                    }

                    @Override
                    public void onError(Throwable error) {
                        listener.onFailed(error);
                    }
                });
    }
}
