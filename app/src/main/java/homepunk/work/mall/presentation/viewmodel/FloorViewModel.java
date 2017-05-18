package homepunk.work.mall.presentation.viewmodel;

import java.io.Serializable;

/**
 * Created by Homepunk on 05.05.2017.
 **/

public class FloorViewModel implements Serializable {
    private int id;
    private int mallId;
    private String type;
    private String level;

    public FloorViewModel(int id, int mallId, String type, String level) {
        this.id = id;
        this.mallId = mallId;
        this.type = type;
        this.level = level;
    }

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
