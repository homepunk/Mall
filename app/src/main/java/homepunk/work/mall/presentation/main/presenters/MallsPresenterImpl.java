package homepunk.work.mall.presentation.main.presenters;

import java.util.List;

import homepunk.work.mall.data.models.Mall;
import homepunk.work.mall.domain.interactors.GetMallsInteractorImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetMallsInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.presentation.main.presenters.interfaces.MallsPresenter;
import homepunk.work.mall.presentation.main.views.interfaces.MallsView;
import homepunk.work.mall.utils.NavigationUtils;

public class MallsPresenterImpl implements MallsPresenter {
    private final GetMallsInteractor interactor;
    private MallsView view;

    public MallsPresenterImpl() {
        this.interactor = new GetMallsInteractorImpl();
    }

    @Override
    public void init(MallsView view) {
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
    public void navigateToMallDetails(int id) {
        NavigationUtils.navigateToMallDetails(view.getContext(), id);
    }
}
