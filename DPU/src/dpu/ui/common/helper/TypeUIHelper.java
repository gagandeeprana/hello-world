/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common.helper;

import dpu.beans.admin.TypeBean;
import dpu.dao.admin.TypeDAO;
import dpu.dao.admin.impl.TypeDAOImpl;
import dpu.ui.common.AddTypeFrame;
import dpu.ui.common.TypePanel;
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
public class TypeUIHelper {

    public static List<TypeBean> lstTypes = new ArrayList();
    TypeDAO typeDAO = new TypeDAOImpl();
    public static int typeId = 0;
    public static String addUpdateFlag = "add";

    public String delete(int typeIdToBeDeleted) {
        String msg = typeDAO.deleteType(typeIdToBeDeleted);
        lstTypes = typeDAO.getAllTypes(TypePanel.txtSearch.getText());
        generateTable();
        return msg;
    }

    public void showData(TypeBean typeBean) {
        AddTypeFrame.txt1.setText(typeBean.getTypeName());
    }

    public void generateTable() {
        Object[] cols = {"Type Id", "Type"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TypePanel.tblType.setModel(defaultTableModel);
        TypePanel.tblType.setAutoCreateRowSorter(true);
        TypePanel.tblType.setDefaultRenderer(Object.class, new TypeUIHelper.TypeTable());
        if (lstTypes.size() > 0) {
            Object[][] data = new Object[lstTypes.size()][2];
            for (int i = 0; i < lstTypes.size(); i++) {
                TypeBean obj = lstTypes.get(i);
                data[i][0] = obj.getTypeId();
                data[i][1] = obj.getTypeName();
                TypePanel.tblType.setRowHeight(30);
            }
            defaultTableModel.setDataVector(data, cols);
            TypePanel.tblType.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            TypePanel.tblType.getTableHeader().setForeground(Color.DARK_GRAY);
            TypePanel.tblType.setIntercellSpacing(new Dimension(0, 0));
            TypePanel.tblType.setShowGrid(false);
            TypePanel.jScrollPane9.setViewportView(TypePanel.tblType);
        } else {
            generateEmptyTable();
        }
    }

    public void generateEmptyTable() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TypePanel.tblType.setModel(defaultTableModel);
        TypePanel.tblType.setDefaultRenderer(Object.class, new TypeUIHelper.TypeTable());
        Object[][] data = new Object[7][2];
        for (int i = 0; i < 7; i++) {
            data[i][0] = "";
            data[i][1] = "";
            TypePanel.tblType.setRowHeight(30);
        }
        Object[] cols = {"Type Id", "Type"};

        defaultTableModel.setDataVector(data, cols);
        TypePanel.tblType.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        TypePanel.tblType.getTableHeader().setForeground(Color.DARK_GRAY);
        TypePanel.tblType.setIntercellSpacing(new Dimension(0, 0));
        TypePanel.tblType.setShowGrid(false);
        TypePanel.jScrollPane9.setViewportView(TypePanel.tblType);
    }

    public void save() {
        TypeBean typeBean = new TypeBean();
        typeBean.setTypeName(AddTypeFrame.txt1.getText());
        String msg = "";
        if (TypeUIHelper.addUpdateFlag.equals("add")) {
            int i = typeDAO.addType(typeBean);
            if (i > 0) {
                msg = "New Type Added";
            }
        } else {
            typeBean.setTypeId(typeId);
            msg = typeDAO.updateType(typeBean);
        }
        lstTypes = typeDAO.getAllTypes(TypePanel.txtSearch.getText());
        generateTable();
        JOptionPane.showMessageDialog(null, msg);
    }

    class TypeTable extends DefaultTableCellRenderer {

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
