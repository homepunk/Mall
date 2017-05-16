package homepunk.work.mall.data.entity;

import android.content.ContentValues;

import com.google.gson.annotations.SerializedName;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;
import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class Type implements DatabaseEntity, ResponseEntity {
    public static final String PATH_TYPES = "types";
    public static final String TABLE_NAME_TYPE = "type";

    public static final String[] PROJECTION_TYPE = {
            COLUMN_ID,
            COLUMN_NAME,
            COLUMN_DESCRIPTION
    };

    @SerializedName(KEY_ID)
    private int id;

    @SerializedName(KEY_NAME)
    private String name;

    @SerializedName(KEY_DESCRIPTION)
    private String description;

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

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID, id);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DESCRIPTION, description);

        return values;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(id)
                .append(" ")
                .append(name)
                .append(" ").toString();
    }
}
