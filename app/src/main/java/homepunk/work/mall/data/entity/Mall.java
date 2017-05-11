package homepunk.work.mall.data.entity;

import android.content.ContentValues;
import android.database.Cursor;

import homepunk.work.mall.presentation.viewmodel.MallViewModel;

import static android.provider.BaseColumns._ID;
import static homepunk.work.mall.data.database.MallContract.MallEntry.COLUMN_DESCRIPTION;
import static homepunk.work.mall.data.database.MallContract.MallEntry.COLUMN_IMAGE;
import static homepunk.work.mall.data.database.MallContract.MallEntry.COLUMN_LATITUDE;
import static homepunk.work.mall.data.database.MallContract.MallEntry.COLUMN_LONGTITUDE;
import static homepunk.work.mall.data.database.MallContract.MallEntry.COLUMN_NAME;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public class Mall {
    public int id;
    public String name;
    public String image;
    public String description;
    public double latitude;
    public double longtitude;

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

        values.put(_ID, id);
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
