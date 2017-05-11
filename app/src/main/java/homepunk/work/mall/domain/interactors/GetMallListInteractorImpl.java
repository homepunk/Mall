package homepunk.work.mall.domain.interactors;

import android.content.Context;

import java.util.List;

import homepunk.work.mall.presentation.viewmodel.MallViewModel;
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

    public GetMallListInteractorImpl(Context context) {
        mallRepository = new MallRepositoryImpl(context);
    }

    @Override
    public void getMalls(MallListener<List<MallViewModel>> listener) {
        mallRepository
                .getMalls()
                .compose(applyIOSchedulers())
                .subscribe(new SingleSubscriber<List<MallViewModel>>() {
                    @Override
                    public void onSuccess(List<MallViewModel> value) {
                        listener.onSuccess(value);
                    }

                    @Override
                    public void onError(Throwable error) {
                        listener.onFailed(error);
                    }
                });
    }
}
