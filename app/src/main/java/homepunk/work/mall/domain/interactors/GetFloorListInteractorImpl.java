package homepunk.work.mall.domain.interactors;

import android.content.Context;

import java.util.List;

import homepunk.work.mall.data.repository.MallRepositoryImpl;
import homepunk.work.mall.domain.interactors.interfaces.GetFloorListInteractor;
import homepunk.work.mall.domain.listeners.MallListener;
import homepunk.work.mall.domain.repository.MallRepository;
import homepunk.work.mall.presentation.viewmodel.FloorViewModel;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;
import rx.SingleSubscriber;

import static homepunk.work.mall.utils.RxUtils.applyIOSchedulers;

/**
 * Created by Homepunk on 08.05.2017.
 **/

public class GetFloorListInteractorImpl implements GetFloorListInteractor {
    private MallRepository mallRepository;

    public GetFloorListInteractorImpl(Context context) {
        this.mallRepository = new MallRepositoryImpl(context);
    }

    @Override
    public void getFloorList(MallViewModel mall, MallListener<List<FloorViewModel>> listener) {
        mallRepository
                .getFloorsByMallId(mall.getId())
                .compose(applyIOSchedulers())
                .subscribe(new SingleSubscriber<List<FloorViewModel>>() {
                    @Override
                    public void onSuccess(List<FloorViewModel> floorList) {
                        listener.onSuccess(floorList);
                    }

                    @Override
                    public void onError(Throwable error) {
                        listener.onFailed(error);
                    }
                });
    }
}
