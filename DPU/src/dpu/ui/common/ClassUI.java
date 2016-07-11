package dpu.ui.common;

import dpu.beans.admin.ClassBean;
import dpu.dao.admin.ClassDAO;
import dpu.dao.admin.impl.ClassDAOImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ClassUI  {

    public String addUpdateFlag = "";
    int classId = 0;
    ClassDAO classDAO = new ClassDAOImpl();
    List<ClassBean> lstClasses = classDAO.getAllClasses("");

    public void clear() {
//        MainFrame.txtClassName.setText("");
    }

    public void disable(boolean val) {
        MainFrame.btnAddClass.setEnabled(val);
//        MainFrame.btnSaveClass.setEnabled(!val);
    }

    public void disableFields(boolean val) {
//        MainFrame.txtClassName.setEditable(val);
    }

    public void generateTable() {
        System.out.println("classes are: " + lstClasses.size());
        Object[][] data = new Object[lstClasses.size()][2];
        for (int i = 0; i < lstClasses.size(); i++) {
            ClassBean obj = lstClasses.get(i);
            data[i][0] = obj.getClassId();
            data[i][1] = obj.getName();
        }
        String[] cols = {"Class Id", "Class"};
        MainFrame.tblClass = new JTable(data, cols);
        MainFrame.jScrollPane3.setViewportView(MainFrame.tblClass);
    }

    public void save() {
        ClassBean obj = new ClassBean();
//        obj.setName(MainFrame.txtClassName.getText());
        ClassDAO classDAO = new ClassDAOImpl();
        String msg = "";
        if (addUpdateFlag.equals("add")) {
            msg = classDAO.addClass(obj);
        } else {
            obj.setClassId(classId);
            msg = classDAO.updateClass(obj);
        }
        JOptionPane.showMessageDialog(null, msg);
        lstClasses = new ClassDAOImpl().getAllClasses("");
        generateTable();
        clear();
        disable(true);
        disableFields(false);
    }

}
