package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.data.entity.Placement;


/**
 * Created by Homepunk on 10.05.2017.
 **/

public class PlacementsResponse {
    private static final String PLACEMENT_KEY_UPDATE = "update";

    @SerializedName(PLACEMENT_KEY_UPDATE)
    List<Placement> placements;

    public List<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }
}
