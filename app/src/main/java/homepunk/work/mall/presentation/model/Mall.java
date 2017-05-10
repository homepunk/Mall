package homepunk.work.mall.presentation.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import static homepunk.work.mall.data.Constants.BaseUrl.SWAGGER_IMAGE_URL;
import static homepunk.work.mall.data.Constants.SerializedNames.Mall.MALL_KEY_DESCRIPTION;
import static homepunk.work.mall.data.Constants.SerializedNames.Mall.MALL_KEY_ID;
import static homepunk.work.mall.data.Constants.SerializedNames.Mall.MALL_KEY_IMAGE;
import static homepunk.work.mall.data.Constants.SerializedNames.Mall.MALL_KEY_LATITUDE;
import static homepunk.work.mall.data.Constants.SerializedNames.Mall.MALL_KEY_LONGTITUDE;
import static homepunk.work.mall.data.Constants.SerializedNames.Mall.MALL_KEY_NAME;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public class Mall implements Serializable {
    @SerializedName(MALL_KEY_ID)
    private int id;

    @SerializedName(MALL_KEY_NAME)
    private String name;

    @SerializedName(MALL_KEY_DESCRIPTION)
    private String description;

    @SerializedName(MALL_KEY_LATITUDE)
    private double latitude;

    @SerializedName(MALL_KEY_LONGTITUDE)
    private double longtitude;

    @SerializedName(MALL_KEY_IMAGE)
    private String image;

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
