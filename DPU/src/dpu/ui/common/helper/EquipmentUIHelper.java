/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common.helper;

import dpu.beans.admin.EquipmentBean;
import dpu.dao.admin.EquipmentDAO;
import dpu.dao.admin.impl.EquipmentDAOImpl;
import dpu.ui.common.AddEquipmentFrame;
import dpu.ui.common.EquipmentPanel;
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
public class EquipmentUIHelper {

    public static List<EquipmentBean> lstEquipments = new ArrayList();
    EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
    public static int equipmentId = 0;
    public static String addUpdateFlag = "add";

    public String delete(int equipmentIdToBeDeleted) {
        String msg = equipmentDAO.deleteEquipment(equipmentIdToBeDeleted);
        lstEquipments = equipmentDAO.getAllEquipments(EquipmentPanel.txtSearch.getText());
        generateTable();
        return msg;
    }

    public void showData(EquipmentBean equipmentBean) {
        AddEquipmentFrame.ddl1.setSelectedItem(equipmentBean.getEquipmentName());
        AddEquipmentFrame.txt1.setText(equipmentBean.getDescription());
    }

    public void generateTable() {
        Object[] cols = {"Equipment Type", "Description"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        EquipmentPanel.tblEquipment.setModel(defaultTableModel);
        EquipmentPanel.tblEquipment.setAutoCreateRowSorter(true);
        EquipmentPanel.tblEquipment.setDefaultRenderer(Object.class, new EquipmentUIHelper.EquipmentTable());
        if (lstEquipments.size() > 0) {
            Object[][] data = new Object[lstEquipments.size()][2];
            for (int i = 0; i < lstEquipments.size(); i++) {
                EquipmentBean obj = lstEquipments.get(i);
                data[i][0] = obj.getEquipmentName();
                data[i][1] = obj.getDescription();
                EquipmentPanel.tblEquipment.setRowHeight(30);
            }
            defaultTableModel.setDataVector(data, cols);
            EquipmentPanel.tblEquipment.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            EquipmentPanel.tblEquipment.getTableHeader().setForeground(Color.DARK_GRAY);
            EquipmentPanel.tblEquipment.setIntercellSpacing(new Dimension(0, 0));
            EquipmentPanel.tblEquipment.setShowGrid(false);
            EquipmentPanel.jScrollPane9.setViewportView(EquipmentPanel.tblEquipment);
        } else {
            generateEmptyTable();
        }
    }

    public void generateEmptyTable() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        EquipmentPanel.tblEquipment.setModel(defaultTableModel);
        EquipmentPanel.tblEquipment.setDefaultRenderer(Object.class, new EquipmentUIHelper.EquipmentTable());
        Object[][] data = new Object[7][2];
        for (int i = 0; i < 7; i++) {
            data[i][0] = "";
            data[i][1] = "";
            EquipmentPanel.tblEquipment.setRowHeight(30);
        }
        Object[] cols = {"Equipment Type", "Description"};

        defaultTableModel.setDataVector(data, cols);
        EquipmentPanel.tblEquipment.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        EquipmentPanel.tblEquipment.getTableHeader().setForeground(Color.DARK_GRAY);
        EquipmentPanel.tblEquipment.setIntercellSpacing(new Dimension(0, 0));
        EquipmentPanel.tblEquipment.setShowGrid(false);
        EquipmentPanel.jScrollPane9.setViewportView(EquipmentPanel.tblEquipment);
    }

    public void save() {
        EquipmentBean equipmentBean = new EquipmentBean();
        equipmentBean.setEquipmentName(AddEquipmentFrame.ddl1.getSelectedItem().toString());
        equipmentBean.setDescription(AddEquipmentFrame.txt1.getText());
        String msg = "";
        if (EquipmentUIHelper.addUpdateFlag.equals("add")) {
            int i = equipmentDAO.addEquipment(equipmentBean);
            if (i > 0) {
                msg = "New Equipment Added";
            }
        } else {
            equipmentBean.setEquipmentId(equipmentId);
            msg = equipmentDAO.updateEquipment(equipmentBean);
        }
        lstEquipments = equipmentDAO.getAllEquipments(EquipmentPanel.txtSearch.getText());
        generateTable();
        JOptionPane.showMessageDialog(null, msg);
    }

    class EquipmentTable extends DefaultTableCellRenderer {

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
