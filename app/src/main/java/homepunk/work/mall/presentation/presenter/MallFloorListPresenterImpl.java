package homepunk.work.mall.presentation.presenter;

import android.content.Intent;

import java.util.List;

import homepunk.work.mall.domain.interactors.GetFloorListInteractorImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetFloorListInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.presentation.base.BasePresenter;
import homepunk.work.mall.presentation.presenter.interfaces.MallFloorListPresenter;
import homepunk.work.mall.presentation.view.MallFloorsView;
import homepunk.work.mall.presentation.viewmodel.FloorViewModel;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;

import static homepunk.work.mall.presentation.viewmodel.MallViewModel.MALL_KEY_ID;


/**
 * Created by Homepunk on 24.04.2017.
 **/

public class MallFloorListPresenterImpl extends BasePresenter<MallFloorsView> implements MallFloorListPresenter {
    private GetFloorListInteractor interactor;

    @Override
    public void getFloors() {
        this.interactor = new GetFloorListInteractorImpl(view.getContext());

        MallViewModel mall= getMallFromIntent();

        if (mall != null) {
            interactor.getFloorList(mall.getId(), new MallListener<List<FloorViewModel>>() {
                @Override
                public void onSuccess(List<FloorViewModel> floorViewModels) {
                    if (view != null) {
                        view.onResult(floorViewModels);
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
    }

    private MallViewModel getMallFromIntent() {
        MallViewModel mall = null;

        if (view != null) {
            Intent intent = view.getActivity().getIntent();
            return (MallViewModel) intent.getSerializableExtra(MALL_KEY_ID);
        }

        return mall;
    }
}
