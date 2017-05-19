package homepunk.work.mall.presentation.viewmodel;

import java.io.Serializable;

import static homepunk.work.mall.data.Constants.BaseUrl.SWAGGER_IMAGE_URL;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public class MallViewModel implements Serializable {
    public int id;
    public double latitude;
    public double longtitude;
    public String name;
    public String description;
    public String image;

    public MallViewModel(int id, String name, String description, double latitude, double longtitude, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public String getFullImagePath() {
        return new StringBuilder()
                .append(SWAGGER_IMAGE_URL)
                .append(image)
                .toString();
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(getName())
                .append(" (")
                .append(getId())
                .append(")\n")
                .toString();
    }
}
