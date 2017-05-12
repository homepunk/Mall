package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.data.entity.Mall;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public class MallResponse {
    private static final String MALLS_KEY_UPDATE = "update";
    private static final String MALLS_KEY_TIMESTAMP = "timestamp";

    @SerializedName(MALLS_KEY_TIMESTAMP)
    private long timestamp;

    @SerializedName(MALLS_KEY_UPDATE)
    private List<Mall> malls;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

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
            sb.append(mall.getName() + "\n ");
        }

        return sb.toString();
    }
}
