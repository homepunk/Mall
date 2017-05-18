package homepunk.work.mall.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.TypeCategory;
import homepunk.work.mall.data.entity.response.TypeCategoriesResponse;
import homepunk.work.mall.data.entity.response.TypeCategoryResponse;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public class TypeCategoryMapper {
    public static List<TypeCategory> transform(TypeCategoryResponse typeCategoryResponse) {
        List<TypeCategory> typeCategories = new ArrayList<>();
        List<TypeCategoriesResponse> response = typeCategoryResponse.getTypeCategories();

        for (TypeCategoriesResponse typeCategoriesResponse : response) {
            int[] categoryIds = typeCategoriesResponse.getCategoryIds();
            int typeId = typeCategoriesResponse.getTypeId();

            if (categoryIds != null) {
                for (Integer categoryId : categoryIds) {
                    typeCategories.add(new TypeCategory(typeId, categoryId));
                }
            }
        }

        return typeCategories;
    }
}
