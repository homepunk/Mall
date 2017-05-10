package homepunk.work.mall.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.presentation.model.Floor;

import static homepunk.work.mall.data.Constants.SerializedNames.Floor.FLOORS_KEY_UPDATE;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class FloorResponse {
    @SerializedName(FLOORS_KEY_UPDATE)
    List<Floor> floors;

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
