package homepunk.work.mall.domain.interactors;

import android.content.Context;

import java.util.List;

import homepunk.work.mall.data.repository.MallRepositoryImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetMallListInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.domain.model.mapper.EntityToViewModelMapper;
import homepunk.work.mall.domain.repository.MallRepository;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class GetMallListInteractorImpl implements GetMallListInteractor {
    MallRepository mallRepository;

    public GetMallListInteractorImpl(Context context) {
        mallRepository = new MallRepositoryImpl(context);
    }

    @Override
    public void getMalls(MallListener<List<MallViewModel>> listener) {
        mallRepository.getMalls()
                      .flatMap(Observable::from)
                      .map(EntityToViewModelMapper::transform)
                      .toList()
                      .observeOn(AndroidSchedulers.mainThread())
                      .subscribe(new Subscriber<List<MallViewModel>>() {
                          @Override
                          public void onCompleted() {

                          }

                          @Override
                          public void onError(Throwable error) {
                              listener.onFailed(error);
                          }

                          @Override
                          public void onNext(List<MallViewModel> mallViewModels) {
                              Timber.i("Recieved malls: " + String.valueOf(mallViewModels.size()));
                              listener.onSuccess(mallViewModels);
                          }
                      });
    }
}
