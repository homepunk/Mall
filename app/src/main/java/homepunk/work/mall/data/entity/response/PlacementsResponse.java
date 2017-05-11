package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.presentation.viewmodel.PlacementViewModel;


/**
 * Created by Homepunk on 10.05.2017.
 **/

public class PlacementsResponse {
    private static final String PLACEMENT_KEY_UPDATE = "update";

    @SerializedName(PLACEMENT_KEY_UPDATE)
    List<PlacementViewModel> placements;

    public List<PlacementViewModel> getPlacements() {
        return placements;
    }

    public void setPlacements(List<PlacementViewModel> placements) {
        this.placements = placements;
    }
}
