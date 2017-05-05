package homepunk.work.mall.presentation.main.presenters;

import android.content.Intent;

import homepunk.work.mall.data.managers.DataManagerImpl;
import homepunk.work.mall.data.managers.interfaces.DataManager;
import homepunk.work.mall.data.models.MallDetails;
import homepunk.work.mall.presentation.main.views.interfaces.MallDetailesView;
import homepunk.work.mall.presentation.main.presenters.interfaces.MallDetailsPresenter;
import homepunk.work.mall.utils.RxUtils;
import rx.SingleSubscriber;
import timber.log.Timber;

import static homepunk.work.mall.data.Constants.SerializedNames.Mall.MALL_KEY_ID;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class MallDetailsPresenterImpl implements MallDetailsPresenter {
    private MallDetailesView view;
    private DataManager moduleManager;

    public MallDetailsPresenterImpl() {
        this.moduleManager = new DataManagerImpl();
    }

    @Override
    public void init(MallDetailesView view) {
        this.view = view;
    }

    @Override
    public void getMallDetails() {
        int id = getIdFromIntent();

        if (id != 0) {
            moduleManager.getRemoteManagers()
                    .getRemoteRepository()
                    .loadMallDetails(id)
                    .compose(RxUtils.applyIOSchedulers())
                    .subscribe(new SingleSubscriber<MallDetails>() {
                        @Override
                        public void onSuccess(MallDetails mallDetails) {
                            if (view != null) {
                                view.onResult(mallDetails);
                            }
                        }

                        @Override
                        public void onError(Throwable error) {
                            if (view != null) {
                                Timber.e(error);
                                view.onError(error.getLocalizedMessage());
                            }
                        }
                    });
        }
    }

    private int getIdFromIntent() {
        int id = 0;

        if (view != null) {
            Intent intent = view.getActivity().getIntent();
            return (int) intent.getSerializableExtra(MALL_KEY_ID);
        }

        return id;
    }
}
