package dpu.dao.admin;

import dpu.beans.admin.ClassBean;
import java.util.List;

public interface ClassDAO {

    List<ClassBean> getAllClasses(String name);

    String addClass(ClassBean obj);

    String updateClass(ClassBean obj);
    String deleteClass(int classId);
    
    
}
