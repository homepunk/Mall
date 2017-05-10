package homepunk.work.mall.presentation.presenter;

import android.content.Intent;

import homepunk.work.mall.domain.interactors.GetMallDetailsInteractorImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetMallDetailsInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.presentation.model.Mall;
import homepunk.work.mall.presentation.model.MallDetails;
import homepunk.work.mall.presentation.presenter.interfaces.MallDetailsPresenter;
import homepunk.work.mall.presentation.view.MallDetailesView;
import timber.log.Timber;

import static homepunk.work.mall.data.Constants.SerializedNames.Mall.MALL_KEY_ID;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class MallDetailsPresenterImpl implements MallDetailsPresenter {
    private MallDetailesView view;
    private GetMallDetailsInteractor interactor;

    public MallDetailsPresenterImpl() {
        this.interactor = new GetMallDetailsInteractorImpl();
    }

    @Override
    public void init(MallDetailesView view) {
        this.view = view;
    }

    @Override
    public void getMallDetails() {
        Mall mall= getMallFromIntent();

        if (mall != null) {
            interactor.getMallDetails(mall, new MallListener<MallDetails>() {
                @Override
                public void onSuccess(MallDetails mallDetails) {
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

    private Mall getMallFromIntent() {
        Mall mall = null;

        if (view != null) {
            Intent intent = view.getActivity().getIntent();
            return (Mall) intent.getSerializableExtra(MALL_KEY_ID);
        }

        return mall;
    }
}
