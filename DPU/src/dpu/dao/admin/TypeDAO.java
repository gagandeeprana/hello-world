package dpu.dao.admin;

import dpu.beans.admin.TypeBean;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface TypeDAO {

    List<TypeBean> getAllTypes(String typeName);

    int addType(TypeBean obj);

    String updateType(TypeBean obj);

    String deleteType(int typeId);
}
