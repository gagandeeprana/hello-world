/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common;

import dpu.beans.admin.ClassBean;
import dpu.dao.admin.ClassDAO;
import dpu.dao.admin.impl.ClassDAOImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author gagandeep.rana
 */
public class ClassUI {

    public String addUpdateFlag = "";
    int classId = 0;
    List<ClassBean> lstClasses = new ClassDAOImpl().getAllClasses("");

    public void clear() {
        txtClassName.setText("");
    }

    public void disable(boolean val) {
        btnAddClass.setEnabled(val);
        btnSaveClass.setEnabled(!val);
    }

    public void disableFields(boolean val) {
        txtClassName.setEditable(val);
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
        tblClass = new JTable(data, cols);
        jScrollPane3.setViewportView(tblClass);
    }

    public void save() {
        ClassBean obj = new ClassBean();
        obj.setName(txtClassName.getText());
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
