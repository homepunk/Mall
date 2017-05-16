package homepunk.work.mall.data.entity;

import android.content.ContentValues;

import homepunk.work.mall.data.entity.interfaces.DatabaseEntity;
import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class TypeCategory implements DatabaseEntity, ResponseEntity {
    public static final String PATH_TYPE_CATEGORIES = "type_categories";
    public static final String TABLE_NAME_TYPE_CATEGORY = "type_category";

    public static final String[] PROJECTION_TYPE_CATEGORY = {
            COLUMN_ID_TYPE,
            COLUMN_ID_CATEGORY
    };

    private int typeId;
    private int categoryId;

    public TypeCategory(int typeId, int categoryId) {
        this.typeId = typeId;
        this.categoryId = categoryId;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_TYPE, typeId);
        values.put(COLUMN_ID_CATEGORY, categoryId);

        return values;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(typeId)
                .append(" ")
                .append(categoryId)
                .append(" ").toString();
    }
}
