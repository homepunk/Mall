package homepunk.work.mall.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.presentation.model.Placement;

import static homepunk.work.mall.data.Constants.SerializedNames.Placement.PLACEMENT_KEY_UPDATE;


/**
 * Created by Homepunk on 10.05.2017.
 **/

public class PlacementsResponse {
    @SerializedName(PLACEMENT_KEY_UPDATE)
    List<Placement> placements;

    public List<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }
}
