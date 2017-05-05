package homepunk.work.mall.presentation.main.presenters;

import android.content.Context;
import android.content.Intent;

import homepunk.work.mall.data.managers.DataManagerImpl;
import homepunk.work.mall.data.managers.interfaces.DataManager;
import homepunk.work.mall.data.models.MallUpdate;
import homepunk.work.mall.presentation.main.views.MallDetailsActivity;
import homepunk.work.mall.presentation.main.presenters.interfaces.MallsPresenter;
import homepunk.work.mall.presentation.main.views.interfaces.MallsView;
import rx.SingleSubscriber;
import timber.log.Timber;

import static homepunk.work.mall.data.Constants.SerializedNames.Mall.MALL_KEY_ID;
import static homepunk.work.mall.utils.RxUtils.applyIOSchedulers;

public class MallsPresenterImpl implements MallsPresenter {
    private DataManager dataManager;
    private MallsView view;

    public MallsPresenterImpl() {
        this.dataManager = new DataManagerImpl();
    }

    @Override
    public void init(MallsView view) {
        this.view = view;
    }

    @Override
    public void getMalls() {
        dataManager.getRemoteManagers()
                .getRemoteRepository()
                .loadMalls()
                .compose(applyIOSchedulers())
                .subscribe(new SingleSubscriber<MallUpdate>() {
                    @Override
                    public void onSuccess(MallUpdate mallUpdate) {
                        if (view != null) {
                            view.onResult(mallUpdate.getMalls());
                            Timber.i(mallUpdate.toString());
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

    @Override
    public void navigateToMallDetails(int id) {
        Context context = view.getContext();
        Intent intent = new Intent(context, MallDetailsActivity.class);

        intent.putExtra(MALL_KEY_ID, id);
        context.startActivity(intent);
    }
}
