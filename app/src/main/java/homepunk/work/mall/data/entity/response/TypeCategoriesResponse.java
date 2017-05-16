package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class TypeCategoriesResponse implements ResponseEntity {
    @SerializedName(KEY_TYPE_ID)
    private int typeId;

    @SerializedName(KEY_CATEGORIES_IDS)
    private int[] categoryIds;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int[] getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(int[] categoryIds) {
        this.categoryIds = categoryIds;
    }
}
