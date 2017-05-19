package homepunk.work.mall.presentation.presenter;

import android.content.Intent;

import java.util.List;

import homepunk.work.mall.domain.interactors.GetMallListInteractorImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetMallListInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.presentation.base.BasePresenter;
import homepunk.work.mall.presentation.presenter.interfaces.MallListPresenter;
import homepunk.work.mall.presentation.service.MallSyncService;
import homepunk.work.mall.presentation.view.MallListView;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import homepunk.work.mall.utils.NavigationUtils;
import timber.log.Timber;

public class MallListPresenterImpl extends BasePresenter<MallListView> implements MallListPresenter {
    private GetMallListInteractor interactor;

    @Override
    public void getMalls() {
        interactor = new GetMallListInteractorImpl(view.getContext());

        interactor.getMalls(new MallListener<List<MallViewModel>>() {
            @Override
            public void onSuccess(List<MallViewModel> malls) {
                if (view != null) {
                    view.onResult(malls);

                    startSyncService();
                }
            }

            @Override
            public void onFailed(Throwable error) {
                if (view != null) {
                    Timber.e(error.getLocalizedMessage());
                    view.onError(error.getLocalizedMessage());
                }
            }
        });
    }

    @Override
    public void navigateToMallDetails(MallViewModel mall) {
        NavigationUtils.navigateToMallActivity(view.getContext(), mall);
    }

    private void startSyncService() {
        if (view != null) {
            Intent intent = new Intent(view.getContext(), MallSyncService.class);

            view.getContext().startService(intent);
        }
    }
}
