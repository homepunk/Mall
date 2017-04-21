package homepunk.work.mall.presentations.main.presenter;

import android.content.Intent;

import homepunk.work.mall.data.rest.repository.MallApiRepository;
import homepunk.work.mall.data.rest.repository.interfaces.IMallApiRepository;
import homepunk.work.mall.presentations.login.models.UserLogin;
import homepunk.work.mall.presentations.main.model.Malls;
import homepunk.work.mall.presentations.main.presenter.interfaces.IMainMallsPresenter;
import homepunk.work.mall.presentations.main.view.interfaces.IMainMallsView;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static homepunk.work.mall.data.Constants.*;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public class MainMallsPresenter implements IMainMallsPresenter{
    private IMallApiRepository mallApiRepository;
    private IMainMallsView view;

    public MainMallsPresenter() {
        this.mallApiRepository = new MallApiRepository();
    }

    @Override
    public void setView(IMainMallsView view) {
        this.view = view;
    }

    @Override
    public void getMalls() {
        String token = getToken();

        if (token == null) {
            return;
        }

        mallApiRepository.fetchMalls(token)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<Malls>() {
                    @Override
                    public void onSuccess(Malls malls) {
                        if (view != null) {
                            view.onResult(malls.getMalls());
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

    private String getToken() {
        if (view == null) {
            return null;
        }

        Intent intent = view.getActivity().getIntent();
        UserLogin user = (UserLogin) intent.getSerializableExtra(MALL_KEY_ID);

        return user != null ? user.getToken() : null;
    }
}
