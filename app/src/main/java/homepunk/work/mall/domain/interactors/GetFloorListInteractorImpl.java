package homepunk.work.mall.domain.interactors;

import android.content.Context;

import java.util.List;

import homepunk.work.mall.data.repository.MallRepositoryImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetFloorListInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.domain.model.mapper.EntityToViewModelMapper;
import homepunk.work.mall.domain.repository.MallRepository;
import homepunk.work.mall.presentation.viewmodel.FloorViewModel;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
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
        Timber.i("Get floors for mall with id: " + String.valueOf(mallid));

        mallRepository.getMallFloors(mallid)
                      .flatMap(Observable::from)
                      .map(EntityToViewModelMapper::transform)
                      .toList()
                      .observeOn(AndroidSchedulers.mainThread())
                      .subscribe(new Observer<List<FloorViewModel>>() {
                          @Override
                          public void onCompleted() {

                          }

                          @Override
                          public void onError(Throwable error) {
                            listener.onFailed(error);
                          }

                          @Override
                          public void onNext(List<FloorViewModel> floorViewModels) {
                            Timber.i("Recieved " + String.valueOf(floorViewModels.size()));
                            listener.onSuccess(floorViewModels);
                          }
                      });
    }
}
