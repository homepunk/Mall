package homepunk.work.mall.domain.interactors;

import homepunk.work.mall.data.repository.MallRepositoryImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetMallDetailsInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.domain.repository.MallRepository;
import homepunk.work.mall.presentation.model.Mall;
import homepunk.work.mall.presentation.model.MallDetails;
import rx.SingleSubscriber;

import static homepunk.work.mall.utils.RxUtils.applyIOSchedulers;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class GetMallDetailsInteractorImpl implements GetMallDetailsInteractor {
    private MallRepository mallRepository;

    public GetMallDetailsInteractorImpl() {
        this.mallRepository = new MallRepositoryImpl();
    }

    @Override
    public void getMallDetails(Mall mall, MallListener<MallDetails> listener) {
        mallRepository
                .getMallDetails(mall.getId())
                .map(mallDetails -> {
                    mallDetails.setMall(mall);
                    return mallDetails;
                })
                .compose(applyIOSchedulers())
                .subscribe(new SingleSubscriber<MallDetails>() {
                    @Override
                    public void onSuccess(MallDetails value) {
                        listener.onSuccess(value);
                    }

                    @Override
                    public void onError(Throwable error) {
                        listener.onFailed(error);
                    }
                });
    }
}
