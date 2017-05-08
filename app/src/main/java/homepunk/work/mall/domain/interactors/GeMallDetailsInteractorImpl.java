package homepunk.work.mall.domain.interactors;

import homepunk.work.mall.data.models.MallDetails;
import homepunk.work.mall.data.repository.MallRepositoryImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetMallDetailsInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.domain.repositorys.MallRepository;
import rx.SingleSubscriber;

import static homepunk.work.mall.utils.RxUtils.applyIOSchedulers;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class GeMallDetailsInteractorImpl implements GetMallDetailsInteractor {
    private MallRepository mallRepository;

    public GeMallDetailsInteractorImpl() {
        this.mallRepository = new MallRepositoryImpl();
    }

    @Override
    public void getMallDetails(int id, MallListener<MallDetails> listener) {
            mallRepository
                    .getMallDetails(id)
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
