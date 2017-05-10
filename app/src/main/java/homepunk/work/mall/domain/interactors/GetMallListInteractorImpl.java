package homepunk.work.mall.domain.interactors;

import java.util.List;

import homepunk.work.mall.presentation.model.Mall;
import homepunk.work.mall.data.repository.MallRepositoryImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetMallListInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.domain.repository.MallRepository;
import rx.SingleSubscriber;

import static homepunk.work.mall.utils.RxUtils.applyIOSchedulers;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class GetMallListInteractorImpl implements GetMallListInteractor {
    MallRepository mallRepository;

    public GetMallListInteractorImpl() {
        mallRepository = new MallRepositoryImpl();
    }

    @Override
    public void getMalls(MallListener<List<Mall>> listener) {
        mallRepository
                .getMalls()
                .compose(applyIOSchedulers())
                .subscribe(new SingleSubscriber<List<Mall>>() {
                    @Override
                    public void onSuccess(List<Mall> value) {
                        listener.onSuccess(value);
                    }

                    @Override
                    public void onError(Throwable error) {
                        listener.onFailed(error);
                    }
                });
    }
}
