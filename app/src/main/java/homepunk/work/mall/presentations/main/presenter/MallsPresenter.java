package homepunk.work.mall.presentations.main.presenter;

import homepunk.work.mall.data.remote.repository.interfaces.IRemoteRepository;
import homepunk.work.mall.presentations.main.model.Malls;
import homepunk.work.mall.presentations.main.presenter.interfaces.IMallsPresenter;
import homepunk.work.mall.presentations.main.view.interfaces.IMallsView;
import rx.SingleSubscriber;
import timber.log.Timber;

import static homepunk.work.mall.utils.RxUtils.applyIOSchedulers;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public class MallsPresenter implements IMallsPresenter {
    private IRemoteRepository dataRepository;
    private IMallsView view;

    public MallsPresenter() {
        this.dataRepository = new DataRepository();
    }

    @Override
    public void setView(IMallsView view) {
        this.view = view;
    }

    @Override
    public void getMalls() {
        dataRepository.loadMalls()
                .compose(applyIOSchedulers())
                .subscribe(new SingleSubscriber<Malls>() {
                    @Override
                    public void onSuccess(Malls malls) {
                        if (view != null) {
                            view.onResult(malls.getMalls());
                            Timber.i(malls.toString());
                        }
                    }

                    @Override
                    public void onError(Throwable error) {
                        if (view != null) {
                            view.onError(error.getLocalizedMessage());
                        }
                    }
                });
    }
}
