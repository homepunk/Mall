package homepunk.work.mall.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import homepunk.work.mall.data.entity.Category;
import homepunk.work.mall.data.entity.Type;
import homepunk.work.mall.data.entity.TypeCategory;
import homepunk.work.mall.data.entity.response.CategoryResponse;
import homepunk.work.mall.data.entity.response.TypeCategoriesResponse;
import homepunk.work.mall.data.entity.response.TypeCategoryResponse;
import homepunk.work.mall.data.entity.response.TypeResponse;
import timber.log.Timber;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public class ResponseMapper {
    public static List<TypeCategory> transform(TypeCategoryResponse typeCategoryResponse) {
        List<TypeCategory> typeCategories = new ArrayList<>();
        List<TypeCategoriesResponse> response = typeCategoryResponse.getTypeCategoriesResponse();

        for (TypeCategoriesResponse typeCategoriesResponse : response) {
            int[] categoryIds = typeCategoriesResponse.getCategoryIds();
            int typeId = typeCategoriesResponse.getTypeId();

            if (categoryIds != null) {
                for (Integer categoryId : categoryIds) {
                    typeCategories.add(new TypeCategory(typeId, categoryId));
                }
            }
        }

        Timber.i(String.valueOf(typeCategories.size()));
        return typeCategories;
    }

    public static List<Category> transform(CategoryResponse categoryResponse) {
        if (categoryResponse.getCategories() != null) {
            return categoryResponse.getCategories();
        }

        return new ArrayList<>();
    }

    public static List<Type> transform(TypeResponse typeResponse) {
        if (typeResponse.getTypes() != null) {
            return typeResponse.getTypes();
        }

        return new ArrayList<>();
    }
}
