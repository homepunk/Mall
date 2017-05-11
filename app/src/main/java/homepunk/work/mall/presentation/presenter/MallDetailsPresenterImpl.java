package homepunk.work.mall.presentation.presenter;

import android.content.Intent;

import homepunk.work.mall.domain.interactors.GetMallDetailsInteractorImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetMallDetailsInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.presentation.presenter.interfaces.MallDetailsPresenter;
import homepunk.work.mall.presentation.view.MallDetailesView;
import homepunk.work.mall.presentation.viewmodel.MallDetailsViewModel;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import timber.log.Timber;

import static homepunk.work.mall.presentation.viewmodel.MallViewModel.MALL_KEY_ID;


/**
 * Created by Homepunk on 24.04.2017.
 **/

public class MallDetailsPresenterImpl implements MallDetailsPresenter {
    private MallDetailesView view;
    private GetMallDetailsInteractor interactor;

    public MallDetailsPresenterImpl() {
    }

    @Override
    public void init(MallDetailesView view) {
        this.view = view;
        this.interactor = new GetMallDetailsInteractorImpl(view.getContext());
    }

    @Override
    public void getMallDetails() {
        MallViewModel mall= getMallFromIntent();

        if (mall != null) {
            interactor.getMallDetails(mall, new MallListener<MallDetailsViewModel>() {
                @Override
                public void onSuccess(MallDetailsViewModel mallDetails) {
                    if (view != null) {
                        Timber.i(mallDetails.toString());
                        view.onResult(mallDetails);
                    }

                }

                @Override
                public void onFailed(Throwable error) {
                    if (view != null) {
                        Timber.e(error);
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
