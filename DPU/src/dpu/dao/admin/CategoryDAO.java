package dpu.dao.admin;

import dpu.beans.admin.CategoryBean;
import dpu.entity.admin.Category;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface CategoryDAO {
    List<Category> getAllCategory();

    List<CategoryBean> getAllCategories(String categoryName);

    int addCategory(CategoryBean obj);

    String updateCategory(CategoryBean obj);

    String deleteCategory(int categoryId);
}
