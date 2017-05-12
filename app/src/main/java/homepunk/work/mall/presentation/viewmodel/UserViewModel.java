package homepunk.work.mall.presentation.viewmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import timber.log.Timber;

/**
 * Created by Homepunk on 10.05.2017.
 **/
public class UserViewModel implements Serializable {
    public static final String USER_KEY_ID = "id";
    private static final String USER_KEY_EMAIL = "email";
    private static final String USER_KEY_TOKEN = "token";
    private static final String USER_KEY_STATUS = "status";
    private static final String USER_PHOTO_PATH = "photo_url";
    private static final String USER_KEY_LAST_NAME = "last_name";
    private static final String USER_KEY_FIRST_NAME = "first_name";
    private static final String USER_PHOTO_LANDSCAPE_PATH = "photo_landscape_url";

    @SerializedName(USER_KEY_STATUS)
    private String status;

    @SerializedName(USER_KEY_TOKEN)
    private String token;

    @SerializedName(USER_KEY_FIRST_NAME)
    private String firstName;

    @SerializedName(USER_KEY_LAST_NAME)
    private String LastName;

    @SerializedName(USER_KEY_EMAIL)
    private String email;

    @SerializedName(USER_PHOTO_PATH)
    private String photoPath;

    @SerializedName(USER_PHOTO_LANDSCAPE_PATH)
    private String photoLanscapePath;

    @SerializedName(USER_KEY_ID)
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
        Timber.i("User token is: " + token);
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
