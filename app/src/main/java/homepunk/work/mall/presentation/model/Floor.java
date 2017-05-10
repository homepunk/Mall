package homepunk.work.mall.presentation.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import static homepunk.work.mall.data.Constants.SerializedNames.Floor.FLOOR_KEY_ID;
import static homepunk.work.mall.data.Constants.SerializedNames.Floor.FLOOR_KEY_LEVEL;
import static homepunk.work.mall.data.Constants.SerializedNames.Floor.FLOOR_KEY_MALL_ID;
import static homepunk.work.mall.data.Constants.SerializedNames.Floor.FLOOR_KEY_TYPE;

/**
 * Created by Homepunk on 05.05.2017.
 **/

public class Floor implements Serializable {
    @SerializedName(FLOOR_KEY_ID)
    private int id;

    @SerializedName(FLOOR_KEY_TYPE)
    private String type;

    @SerializedName(FLOOR_KEY_LEVEL)
    private String level;

    @SerializedName(FLOOR_KEY_MALL_ID)
    private int mallId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getMallId() {
        return mallId;
    }

    public void setMallId(int mallId) {
        this.mallId = mallId;
    }

}
