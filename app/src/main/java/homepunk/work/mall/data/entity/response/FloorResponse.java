package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.data.entity.Floor;
import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class FloorResponse implements ResponseEntity {
    @SerializedName(KEY_UPDATE)
    List<Floor> floors;

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
