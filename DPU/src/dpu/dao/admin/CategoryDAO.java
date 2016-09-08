package dpu.dao.admin;

import dpu.beans.admin.CategoryBean;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface CategoryDAO {

    List<CategoryBean> getAllCategories(String categoryName);

    int addCategory(CategoryBean obj);

    String updateCategory(CategoryBean obj);

    String deleteCategory(int categoryId);
}
