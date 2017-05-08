package homepunk.work.mall.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static homepunk.work.mall.data.Constants.SerializedNames.Mall.MALLS_KEY_UPDATE;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public class MallResponse {
    @SerializedName(MALLS_KEY_UPDATE)
    private List<Mall> malls;

    public List<Mall> getMalls() {
        return malls;
    }

    public void setMalls(List<Mall> malls) {
        this.malls = malls;
    }

    @Override
    public String toString() {
        super.toString();
        StringBuilder sb = new StringBuilder();
        for (Mall mall : malls) {
            sb.append(mall.getName() +  "\n ");
        }

        return sb.toString();
    }
}
