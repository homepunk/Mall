package homepunk.work.mall.presentation.viewmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import static homepunk.work.mall.data.Constants.BaseUrl.SWAGGER_IMAGE_URL;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public class MallViewModel implements Serializable {
    public static final String MALL_KEY_ID = "id";
    private static final String MALL_KEY_NAME = "name";
    private static final String MALL_KEY_IMAGE = "image";

    private static final String MALL_KEY_LATITUDE = "lat";
    private static final String MALL_KEY_LONGTITUDE = "lng";
    private static final String MALL_KEY_DESCRIPTION = "description";

    @SerializedName(MALL_KEY_ID)
    public int id;

    @SerializedName(MALL_KEY_NAME)
    public String name;

    @SerializedName(MALL_KEY_DESCRIPTION)
    public String description;

    @SerializedName(MALL_KEY_LATITUDE)
    public double latitude;

    @SerializedName(MALL_KEY_LONGTITUDE)
    public double longtitude;

    @SerializedName(MALL_KEY_IMAGE)
    public String image;

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