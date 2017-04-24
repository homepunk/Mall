package homepunk.work.mall.presentations.main.presenter;

import android.content.Intent;

import homepunk.work.mall.data.local.repository.SharedPreferencesRepository;
import homepunk.work.mall.data.local.interfaces.ISharedPreferencesRepository;
import homepunk.work.mall.data.remote.repository.MallApiRepository;
import homepunk.work.mall.data.remote.repository.interfaces.IMallApiRepository;
import homepunk.work.mall.presentations.App;
import homepunk.work.mall.presentations.login.models.UserLogin;
import homepunk.work.mall.presentations.main.model.Malls;
import homepunk.work.mall.presentations.main.presenter.interfaces.IMallsPresenter;
import homepunk.work.mall.presentations.main.view.interfaces.IMallsView;
import rx.SingleSubscriber;
import timber.log.Timber;

import static homepunk.work.mall.data.Constants.MALL_KEY_ID;
import static homepunk.work.mall.utils.RxUtils.applyIOSchedulers;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public class MallsPresenter implements IMallsPresenter {
    private IMallApiRepository mallApiRepository;
    private ISharedPreferencesRepository sharedPreferencesRepository;
    private IMallsView view;

    public MallsPresenter() {
        this.mallApiRepository = new MallApiRepository();
    }

    @Override
    public void setView(IMallsView view) {
        this.view = view;
    }

    @Override
    public void getMalls() {
        String token = getToken();
        sharedPreferencesRepository = new SharedPreferencesRepository(App.getContext());
        Timber.i("Retrieved token from shared prefs: " + sharedPreferencesRepository.retrieveAccessToken());

        if (token == null) {
            return;
        }

        mallApiRepository.fetchMalls(token)
                .compose(applyIOSchedulers())
                .subscribe(new SingleSubscriber<Malls>() {
                    @Override
                    public void onSuccess(Malls malls) {
                        if (view != null) {
                            view.onResult(malls.getMalls());
                            Timber.i(malls.toString());
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
