package homepunk.work.mall.presentations.main.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static homepunk.work.mall.data.Constants.MALLS_KEY_UPDATE;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public class Malls {
    @SerializedName(MALLS_KEY_UPDATE)
    private List<Mall> malls;

    public List<Mall> getMalls() {
        return malls;
    }

    public void setMalls(List<Mall> malls) {
        this.malls = malls;
    }
}
