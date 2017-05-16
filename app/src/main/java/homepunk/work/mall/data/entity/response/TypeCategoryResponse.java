package homepunk.work.mall.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import homepunk.work.mall.data.entity.interfaces.ResponseEntity;

/**
 * Created by Homepunk on 16.05.2017.
 **/

public class TypeCategoryResponse implements ResponseEntity {
    @SerializedName(KEY_TYPES)
    private TypeResponse typeResponse;

    @SerializedName(KEY_CATEGORIES)
    private CategoryResponse categoryResponse;

    @SerializedName(KEY_TYPE_CATEGORIES)
    private List<TypeCategoriesResponse> typeCategoriesResponse;

    public TypeResponse getTypeResponse() {
        return typeResponse;
    }

    public void setTypeResponse(TypeResponse typeResponse) {
        this.typeResponse = typeResponse;
    }

    public CategoryResponse getCategoryResponse() {
        return categoryResponse;
    }

    public void setCategoryResponse(CategoryResponse categoryResponse) {
        this.categoryResponse = categoryResponse;
    }

    public List<TypeCategoriesResponse> getTypeCategoriesResponse() {
        return typeCategoriesResponse;
    }

    public void setTypeCategoriesResponse(List<TypeCategoriesResponse> typeCategoriesResponse) {
        this.typeCategoriesResponse = typeCategoriesResponse;
    }
}
