package homepunk.work.mall.data.entity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;
import homepunk.work.mall.presentation.viewmodel.MallViewModel;

import static homepunk.work.mall.data.database.MallContract.CONTENT_AUTHORITY;
import static homepunk.work.mall.data.database.MallContract.MallEntry.PATH_MALLS;
import static homepunk.work.mall.data.database.MallContract.SCHEME;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public class Mall implements DatabaseEntity {
    public static final String[] PROJECTION_MALL = {
            COLUMN_ID,
            COLUMN_NAME,
            COLUMN_DESCRIPTION,
            COLUMN_IMAGE,
            COLUMN_LATITUDE,
            COLUMN_LONGTITUDE};

    public static final Uri CONTENT_URI_MALL = Uri.parse(SCHEME + CONTENT_AUTHORITY + "/" + PATH_MALLS);
    public static final String CONTENT_TYPE_MALL = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MALLS;
    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MALLS;

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

    public Mall(MallViewModel mallViewModel) {
        id = mallViewModel.getId();
        name = mallViewModel.getName();
        image = mallViewModel.getFullImagePath();
        description = mallViewModel.getDescription();
        latitude = mallViewModel.getLatitude();
        longtitude = mallViewModel.getLongtitude();
    }

    public Mall(int id, String name, String image, String description, double latitude, double longtitude) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public Mall(final Cursor cursor) {
        this.id = cursor.getInt(0);
        this.name = cursor.getString(1);
        this.description = cursor.getString(2);
        this.image = cursor.getString(3);
        this.latitude = cursor.getDouble(4);
        this.longtitude = cursor.getDouble(5);
    }

    public ContentValues getContentValues() {
        final ContentValues values = new ContentValues();

        values.put(COLUMN_ID, id);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_IMAGE, image);
        values.put(COLUMN_LATITUDE, latitude);
        values.put(COLUMN_LONGTITUDE, longtitude);

        return values;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @Override
    public String toString() {
        return getName() + " " + getId();
    }
}
