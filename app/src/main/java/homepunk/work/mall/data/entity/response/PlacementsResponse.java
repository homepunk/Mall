package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.data.entity.Placement;
import homepunk.work.mall.data.entity.interfaces.ResponseEntity;


/**
 * Created by Homepunk on 10.05.2017.
 **/

public class PlacementsResponse implements ResponseEntity{
    @SerializedName(KEY_UPDATE)
    List<Placement> placements;

    public List<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }
}
