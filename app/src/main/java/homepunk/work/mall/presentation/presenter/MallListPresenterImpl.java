package homepunk.work.mall.presentation.presenter;

import java.util.List;

import homepunk.work.mall.presentation.model.Mall;
import homepunk.work.mall.domain.interactors.GetMallListInteractorImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetMallListInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.presentation.presenter.interfaces.MallListPresenter;
import homepunk.work.mall.presentation.view.MallListView;
import homepunk.work.mall.utils.NavigationUtils;

public class MallListPresenterImpl implements MallListPresenter {
    private final GetMallListInteractor interactor;
    private MallListView view;

    public MallListPresenterImpl() {
        this.interactor = new GetMallListInteractorImpl();
    }

    @Override
    public void init(MallListView view) {
        this.view = view;
    }

    @Override
    public void getMalls() {
        interactor.getMalls(new MallListener<List<Mall>>() {
            @Override
            public void onSuccess(List<Mall> malls) {
                if (view != null) {
                    view.onResult(malls);
                }
            }

            @Override
            public void onFailed(Throwable error) {
                if (view != null) {
                    view.onError(error.getLocalizedMessage());
                }
            }
        });
    }

    @Override
    public void navigateToMallDetails(Mall mall) {
        NavigationUtils.navigateToMallDetails(view.getContext(), mall);
    }
}
