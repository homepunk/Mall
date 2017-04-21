package homepunk.work.mall.presentations.main.model;

import com.google.gson.annotations.SerializedName;

import static homepunk.work.mall.data.Constants.MALL_KEY_DESCRIPTION;
import static homepunk.work.mall.data.Constants.MALL_KEY_ID;
import static homepunk.work.mall.data.Constants.MALL_KEY_IMAGE;
import static homepunk.work.mall.data.Constants.MALL_KEY_LATITUDE;
import static homepunk.work.mall.data.Constants.MALL_KEY_LONGTITUDE;
import static homepunk.work.mall.data.Constants.MALL_KEY_NAME;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public class Mall {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
