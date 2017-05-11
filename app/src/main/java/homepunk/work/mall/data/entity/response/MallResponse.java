package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.presentation.viewmodel.MallViewModel;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public class MallResponse {
    private static final String MALLS_KEY_UPDATE = "update";

    @SerializedName(MALLS_KEY_UPDATE)
    private List<MallViewModel> malls;

    public List<MallViewModel> getMalls() {
        return malls;
    }

    public void setMalls(List<MallViewModel> malls) {
        this.malls = malls;
    }

    @Override
    public String toString() {
        super.toString();
        StringBuilder sb = new StringBuilder();
        for (MallViewModel mall : malls) {
            sb.append(mall.getName() + "\n ");
        }

        return sb.toString();
    }
}
