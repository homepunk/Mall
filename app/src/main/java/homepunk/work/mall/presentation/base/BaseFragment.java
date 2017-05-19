package homepunk.work.mall.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.Serializable;

import butterknife.ButterKnife;
import homepunk.work.mall.presentation.viewmodel.MallDetailsViewModel;

import static homepunk.work.mall.data.Constants.Keys.KEY_BUNDLE;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public abstract class BaseFragment extends Fragment {
    protected MallDetailsViewModel mallDetails;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mallDetails = (MallDetailsViewModel) getExtrasFromBundle();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    private Serializable getExtrasFromBundle() {
        Bundle bundle = getArguments();
        return bundle != null ? bundle.getSerializable(KEY_BUNDLE) : null;
    }

    protected void showErrorToast(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }


    public abstract int getLayoutResId();
}
