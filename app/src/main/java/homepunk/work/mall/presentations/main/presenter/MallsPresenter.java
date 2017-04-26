package homepunk.work.mall.presentations.main.presenter;

import homepunk.work.mall.data.managers.ModuleManager;
import homepunk.work.mall.data.managers.interfaces.IModuleManager;
import homepunk.work.mall.data.models.Malls;
import homepunk.work.mall.presentations.main.presenter.interfaces.IMallsPresenter;
import homepunk.work.mall.presentations.main.view.interfaces.IMallsView;
import rx.SingleSubscriber;
import timber.log.Timber;

import static homepunk.work.mall.utils.RxUtils.applyIOSchedulers;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public class MallsPresenter implements IMallsPresenter {
    private IModuleManager moduleManager;
    private IMallsView view;

    public MallsPresenter() {
        this.moduleManager = new ModuleManager();
    }

    @Override
    public void setView(IMallsView view) {
        this.view = view;
    }

    @Override
    public void getMalls() {
        moduleManager.getRemoteManagers()
                .getRemoteRepository()
                .loadMalls()
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
