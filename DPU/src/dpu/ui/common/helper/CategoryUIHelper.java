/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common.helper;

import dpu.beans.admin.CategoryBean;
import dpu.dao.admin.CategoryDAO;
import dpu.dao.admin.impl.CategoryDAOImpl;
import dpu.ui.common.AddCategoryFrame;
import dpu.ui.common.CategoryPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gagandeep.rana
 */
public class CategoryUIHelper {

    public static List<CategoryBean> lstCategories = new ArrayList();
    CategoryDAO categoryDAO = new CategoryDAOImpl();
    public static int categoryId = 0;
    public static String addUpdateFlag = "add";

    public String delete(int categoryIdToBeDeleted) {
        String msg = categoryDAO.deleteCategory(categoryIdToBeDeleted);
        lstCategories = categoryDAO.getAllCategories(CategoryPanel.txtSearch.getText());
        generateTable();
        return msg;
    }

    public void showData(CategoryBean categoryBean) {
//        AddCategoryFrame.txt1.setText(categoryBean.getCategoryName());
    }

    public void generateTable() {
        Object[] cols = {"Type", "Category Name"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        CategoryPanel.tblCategory.setModel(defaultTableModel);
        CategoryPanel.tblCategory.setAutoCreateRowSorter(true);
        CategoryPanel.tblCategory.setDefaultRenderer(Object.class, new CategoryUIHelper.CategoryTable());
        if (lstCategories.size() > 0) {
            Object[][] data = new Object[lstCategories.size()][2];
            for (int i = 0; i < lstCategories.size(); i++) {
                CategoryBean obj = lstCategories.get(i);
                data[i][0] = obj.getTypeBean().getTypeName();
                data[i][1] = obj.getCategoryName();
                CategoryPanel.tblCategory.setRowHeight(30);
            }
            defaultTableModel.setDataVector(data, cols);
            CategoryPanel.tblCategory.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            CategoryPanel.tblCategory.getTableHeader().setForeground(Color.DARK_GRAY);
            CategoryPanel.tblCategory.setIntercellSpacing(new Dimension(0, 0));
            CategoryPanel.tblCategory.setShowGrid(false);
            CategoryPanel.jScrollPane9.setViewportView(CategoryPanel.tblCategory);
        } else {
            generateEmptyTable();
        }
    }

    public void generateEmptyTable() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        CategoryPanel.tblCategory.setModel(defaultTableModel);
        CategoryPanel.tblCategory.setDefaultRenderer(Object.class, new CategoryUIHelper.CategoryTable());
        Object[][] data = new Object[7][2];
        for (int i = 0; i < 7; i++) {
            data[i][0] = "";
            data[i][1] = "";
            CategoryPanel.tblCategory.setRowHeight(30);
        }
        Object[] cols = {"Type", "Category Name"};

        defaultTableModel.setDataVector(data, cols);
        CategoryPanel.tblCategory.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        CategoryPanel.tblCategory.getTableHeader().setForeground(Color.DARK_GRAY);
        CategoryPanel.tblCategory.setIntercellSpacing(new Dimension(0, 0));
        CategoryPanel.tblCategory.setShowGrid(false);
        CategoryPanel.jScrollPane9.setViewportView(CategoryPanel.tblCategory);
    }

    public void save() {
        CategoryBean categoryBean = new CategoryBean();
//        categoryBean.setCategoryName(AddCategoryFrame.txt1.getText());
        String msg = "";
        if (CategoryUIHelper.addUpdateFlag.equals("add")) {
            int i = categoryDAO.addCategory(categoryBean);
            if (i > 0) {
                msg = "New Category Added";
            }
        } else {
            categoryBean.setCategoryId(categoryId);
            msg = categoryDAO.updateCategory(categoryBean);
        }
        lstCategories = categoryDAO.getAllCategories(CategoryPanel.txtSearch.getText());
        generateTable();
        JOptionPane.showMessageDialog(null, msg);
    }

    class CategoryTable extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JTextField editor = new JTextField();
            editor.setFont(new Font(Font.SANS_SERIF, 0, 15));
            editor.setEditable(false);
            editor.setBorder(null);
            if (value != null) {
                editor.setText("   " + value.toString());
            }
            if (row % 2 == 0) {
                Border border = BorderFactory.createLineBorder(Color.WHITE, 4);
                editor.setBorder(border);

            } else {
                Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4);
                editor.setBorder(border);
            }
            editor.setBackground((row % 2 == 0) ? Color.white : Color.LIGHT_GRAY);
            if (isSelected) {
                Border border = BorderFactory.createLineBorder(Color.CYAN, 4);
                editor.setBorder(border);
                editor.setBackground(Color.CYAN);
            }
            return editor;
        }
    }
}