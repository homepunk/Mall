package homepunk.work.mall.presentations.details.presenter;

import homepunk.work.mall.data.managers.ModuleManager;
import homepunk.work.mall.data.managers.interfaces.IModuleManager;
import homepunk.work.mall.presentations.details.presenter.interfaces.IMallDetailsPresenter;
import homepunk.work.mall.presentations.details.ui.interfaces.IMallDetailesView;
import homepunk.work.mall.data.models.Mall;
import homepunk.work.mall.utils.RxUtils;
import rx.SingleSubscriber;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class MallDetailsPresenter implements IMallDetailsPresenter {
    private IMallDetailesView view;
    private IModuleManager moduleManager;

    public MallDetailsPresenter() {
        this.moduleManager = new ModuleManager();
    }

    @Override
    public void setView(IMallDetailesView view) {
        this.view = view;
    }

    @Override
    public void getMallDetailes(int id) {
        moduleManager.getRemoteManagers()
                .getRemoteRepository()
                .loadMallDetails(id)
                .compose(RxUtils.applyIOSchedulers())
                .subscribe(new SingleSubscriber<Mall>() {
                    @Override
                    public void onSuccess(Mall mall) {
                        if (view != null) {
                            view.onResult(mall);
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
