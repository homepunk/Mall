package homepunk.work.mall.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

import butterknife.ButterKnife;
import homepunk.work.mall.presentation.model.MallDetails;

import static homepunk.work.mall.data.Constants.SerializedNames.KEY_BUNDLE;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public abstract class BaseFragment extends Fragment {
    protected MallDetails mallDetails;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mallDetails = (MallDetails) getExtrasFromBundle();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    private Serializable getExtrasFromBundle() {
        Bundle bundle = getArguments();
        return bundle != null ? bundle.getSerializable(KEY_BUNDLE) : null;
    }


    public abstract int getLayoutResId();
}
