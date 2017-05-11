package homepunk.work.mall.domain.interactors;

import android.content.Context;

import homepunk.work.mall.data.repository.MallRepositoryImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetMallDetailsInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.domain.repository.MallRepository;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import homepunk.work.mall.presentation.viewmodel.MallDetailsViewModel;
import rx.SingleSubscriber;

import static homepunk.work.mall.utils.RxUtils.applyIOSchedulers;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class GetMallDetailsInteractorImpl implements GetMallDetailsInteractor {
    private MallRepository mallRepository;

    public GetMallDetailsInteractorImpl(Context context) {
        this.mallRepository = new MallRepositoryImpl(context);
    }

    @Override
    public void getMallDetails(MallViewModel mall, MallListener<MallDetailsViewModel> listener) {
        mallRepository
                .getMallDetails(mall.getId())
                .map(mallDetails -> {
                    mallDetails.setMall(mall);
                    return mallDetails;
                })
                .compose(applyIOSchedulers())
                .subscribe(new SingleSubscriber<MallDetailsViewModel>() {
                    @Override
                    public void onSuccess(MallDetailsViewModel value) {
                        listener.onSuccess(value);
                    }

                    @Override
                    public void onError(Throwable error) {
                        listener.onFailed(error);
                    }
                });
    }
}
