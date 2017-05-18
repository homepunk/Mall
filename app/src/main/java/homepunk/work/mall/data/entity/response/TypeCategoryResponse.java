package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.data.entity.Type;
import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class TypeCategoryResponse implements ResponseEntity {
    @SerializedName(KEY_TYPES)
    private TypeResponse types;

    @SerializedName(KEY_CATEGORIES)
    private CategoryResponse categories;

    @SerializedName(KEY_TYPE_CATEGORIES)
    private List<TypeCategoriesResponse> typeCategories;

    public BaseResponse<Type> getTypes() {
        return types;
    }

    public void setTypes(TypeResponse types) {
        this.types = types;
    }

    public CategoryResponse getCategories() {
        return categories;
    }

    public void setCategories(CategoryResponse categories) {
        this.categories = categories;
    }

    public List<TypeCategoriesResponse> getTypeCategories() {
        return typeCategories;
    }

    public void setTypeCategories(List<TypeCategoriesResponse> typeCategories) {
        this.typeCategories = typeCategories;
    }
}
