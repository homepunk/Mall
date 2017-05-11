package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.presentation.viewmodel.FloorViewModel;

/**
 * Created by Homepunk on 10.05.2017.
 **/

public class FloorResponse {
    private static final String FLOORS_KEY_UPDATE = "update";

    @SerializedName(FLOORS_KEY_UPDATE)
    List<FloorViewModel> floors;

    public List<FloorViewModel> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorViewModel> floors) {
        this.floors = floors;
    }
}
