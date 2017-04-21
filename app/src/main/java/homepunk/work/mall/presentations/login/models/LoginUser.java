package homepunk.work.mall.presentations.login.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import static homepunk.work.mall.data.Constants.KEY_EMAIL;
import static homepunk.work.mall.data.Constants.KEY_FIRST_NAME;
import static homepunk.work.mall.data.Constants.KEY_ID;
import static homepunk.work.mall.data.Constants.KEY_LAST_NAME;
import static homepunk.work.mall.data.Constants.KEY_STATUS;
import static homepunk.work.mall.data.Constants.KEY_TOKEN;
import static homepunk.work.mall.data.Constants.PHOTO_LANDSCAPE_PATH;
import static homepunk.work.mall.data.Constants.PHOTO_PATH;

/**
 * Created by Homepunk on 21.04.2017.
 **/

public class LoginUser implements Serializable{
    @SerializedName(KEY_STATUS)
    private String status;

    @SerializedName(KEY_TOKEN)
    private String token;

    @SerializedName(KEY_FIRST_NAME)
    private String firstName;

    @SerializedName(KEY_LAST_NAME)
    private String LastName;

    @SerializedName(KEY_EMAIL)
    private String email;

    @SerializedName(PHOTO_PATH)
    private String photoPath;

    @SerializedName(PHOTO_LANDSCAPE_PATH)
    private String photoLanscapePath;

    @SerializedName(KEY_ID)
    private int id;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPhotoLanscapePath() {
        return photoLanscapePath;
    }

    public void setPhotoLanscapePath(String photoLanscapePath) {
        this.photoLanscapePath = photoLanscapePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
