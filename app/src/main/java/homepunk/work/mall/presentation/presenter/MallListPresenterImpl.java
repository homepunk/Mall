package homepunk.work.mall.presentation.presenter;

import java.util.List;

import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import homepunk.work.mall.domain.interactors.GetMallListInteractorImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetMallListInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.presentation.presenter.interfaces.MallListPresenter;
import homepunk.work.mall.presentation.view.MallListView;
import homepunk.work.mall.utils.NavigationUtils;
import timber.log.Timber;

public class MallListPresenterImpl implements MallListPresenter {
    private GetMallListInteractor interactor;
    private MallListView view;

    public MallListPresenterImpl() {
    }

    @Override
    public void init(MallListView view) {
        this.view = view;
        this.interactor = new GetMallListInteractorImpl(view.getContext());
    }

    @Override
    public void getMalls() {
        interactor.getMalls(new MallListener<List<MallViewModel>>() {
            @Override
            public void onSuccess(List<MallViewModel> malls) {
                if (view != null) {
                    view.onResult(malls);
                }
            }

            @Override
            public void onFailed(Throwable error) {
                if (view != null) {
                    Timber.i(error.getLocalizedMessage());
                    view.onError(error.getLocalizedMessage());
                }
            }
        });
    }

    @Override
    public void navigateToMallDetails(MallViewModel mall) {
        NavigationUtils.navigateToMallDetails(view.getContext(), mall);
    }
}
