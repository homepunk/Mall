package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 17.05.2017.
 **/

public abstract class BaseResponse<T> implements ResponseEntity{
    @SerializedName(KEY_UPDATE)
    private List<T> updates;

    @SerializedName(KEY_DELETE)
    private List<Long> deletedIds;

    @SerializedName(KEY_TIMESTAMP)
    private long syncTimeStamp;

    public List<Long> getDeletedIds() {
        return deletedIds;
    }

    public List<T> getUpdates() {
        return updates;
    }

    public long getSyncTimestamp() {
        return syncTimeStamp;
    }
}
