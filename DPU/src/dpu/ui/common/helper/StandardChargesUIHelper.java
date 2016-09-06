/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common.helper;

import dpu.beans.admin.CustomBrokerBean;
import dpu.beans.admin.StandardChargesBean;
import dpu.dao.admin.CustomBrokerDAO;
import dpu.dao.admin.StandardChargesDAO;
import dpu.dao.admin.impl.CustomBrokerDAOImpl;
import dpu.dao.admin.impl.StandardChargesDAOImpl;
import dpu.ui.common.AddCustomBroker;
import dpu.ui.common.AddStandardAccessorialCharge;
import dpu.ui.common.TestStandardCharges;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author gagandeep.rana
 */
public class StandardChargesUIHelper {

    public static List<StandardChargesBean> lstStandardCharges = new ArrayList();
    StandardChargesDAO standardChargesDAO = new StandardChargesDAOImpl();
    public static int standardChargesId = 0;
    public static String addUpdateFlag = "add";

    public class ButtonRenderer extends JCheckBox implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
            if (column == 5) {
                int i = lstStandardCharges.get(row).getIncludeChargeAmount();
                setSelected(check_CheckBoxes(i));
            }
            if (column == 6) {
                int i = lstStandardCharges.get(row).getCalculateFuelSurcharge();
                setSelected(check_CheckBoxes(i));
            }
            if (column == 7) {
                int i = lstStandardCharges.get(row).getIncludeDriverPayroll();
                setSelected(check_CheckBoxes(i));
            }
            if (row % 2 == 0) {
                setBackground(Color.WHITE);
            } else {
                setBackground(Color.LIGHT_GRAY);
            }
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    public class ButtonEditor extends DefaultCellEditor {

        protected JCheckBox button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JCheckBox();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {

            }
            isPushed = false;
            return new String(label);
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    public String delete(int standardChargesIdToBeDeleted) {
        String msg = standardChargesDAO.deleteStandardCharges(standardChargesIdToBeDeleted);
        lstStandardCharges = standardChargesDAO.getAllStandardCharges(TestStandardCharges.txtSearch.getText());
        generateTable();
        return msg;
    }

    public void showData(StandardChargesBean standardChargesBean) {
        AddStandardAccessorialCharge.txtCode.setText(standardChargesBean.getCode());
        AddStandardAccessorialCharge.ddlChargeType1.setSelectedIndex(standardChargesBean.getChargeType1() - 1);
        AddStandardAccessorialCharge.txtDescription.setText(standardChargesBean.getDescription());
        AddStandardAccessorialCharge.ddlAmountas.setSelectedIndex(standardChargesBean.getAmountAs() - 1);
        AddStandardAccessorialCharge.txtBaseCharge.setText(standardChargesBean.getBaseCharge());
        AddStandardAccessorialCharge.txtMaxCharge.setText(standardChargesBean.getMaxCharge());
        AddStandardAccessorialCharge.ddlChargeType2.setSelectedIndex(standardChargesBean.getChargeType2() - 1);
        AddStandardAccessorialCharge.ddlStatus.setSelectedIndex(standardChargesBean.getStatus() == 1 ? 0 : 1);
        AddStandardAccessorialCharge.chk1.setSelected(standardChargesBean.getIncludeChargeAmount() == 1 ? true : false);
        AddStandardAccessorialCharge.chk2.setSelected(standardChargesBean.getCalculateFuelSurcharge() == 1 ? true : false);
        AddStandardAccessorialCharge.chk3.setSelected(standardChargesBean.getIncludeDriverPayroll() == 1 ? true : false);
    }

    public void generateTable() {
        Object[] cols = {"Code", "Type", "Description", "Rate", "Maximum", "Apply Comm", "Apply F/S", "Driver Pay", "Charge Type"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestStandardCharges.tblStandardCharges.setModel(defaultTableModel);
        TestStandardCharges.tblStandardCharges.setAutoCreateRowSorter(true);
        TestStandardCharges.tblStandardCharges.setDefaultRenderer(Object.class, new StandardChargesUIHelper.StandardChargesTable());
        if (lstStandardCharges.size() > 0) {
            Object[][] data = new Object[lstStandardCharges.size()][9];
            for (int i = 0; i < lstStandardCharges.size(); i++) {
                StandardChargesBean obj = lstStandardCharges.get(i);
                data[i][0] = obj.getCode();
                data[i][1] = checkChargeType1(obj.getChargeType1());
                data[i][2] = obj.getDescription();
                data[i][3] = "$ " + obj.getBaseCharge();
                data[i][4] = "$ " + obj.getMaxCharge();
                data[i][5] = "";
                data[i][6] = "";
                data[i][7] = "";
                data[i][8] = checkChargeType2(obj.getChargeType2());
                TestStandardCharges.tblStandardCharges.setRowHeight(30);
            }
            defaultTableModel.setDataVector(data, cols);
            TestStandardCharges.tblStandardCharges.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            TestStandardCharges.tblStandardCharges.getColumn("Apply Comm").setCellRenderer(new StandardChargesUIHelper.ButtonRenderer());
            TestStandardCharges.tblStandardCharges.getColumn("Apply Comm").setCellEditor(new StandardChargesUIHelper.ButtonEditor(new JCheckBox()));
            TestStandardCharges.tblStandardCharges.getColumn("Apply F/S").setCellRenderer(new StandardChargesUIHelper.ButtonRenderer());
            TestStandardCharges.tblStandardCharges.getColumn("Apply F/S").setCellEditor(new StandardChargesUIHelper.ButtonEditor(new JCheckBox()));
            TestStandardCharges.tblStandardCharges.getColumn("Driver Pay").setCellRenderer(new StandardChargesUIHelper.ButtonRenderer());
            TestStandardCharges.tblStandardCharges.getColumn("Driver Pay").setCellEditor(new StandardChargesUIHelper.ButtonEditor(new JCheckBox()));
            TestStandardCharges.tblStandardCharges.getTableHeader().setForeground(Color.DARK_GRAY);
            TestStandardCharges.tblStandardCharges.setIntercellSpacing(new Dimension(0, 0));
            TestStandardCharges.tblStandardCharges.setShowGrid(false);
            TestStandardCharges.jScrollPane9.setViewportView(TestStandardCharges.tblStandardCharges);
        } else {
            generateEmptyTable();
        }
    }

    private String checkChargeType1(int i) {
        switch (i) {
            case 1:
                return "Exta Charge";
            case 2:
                return "Fuel Surcharge";
            case 3:
                return "Freight Rate";
            case 4:
                return "Tax Item";
            default:
                return "ChargeType1";
        }
    }

    private String checkChargeType2(int i) {
        switch (i) {
            case 1:
                return "Related to Revenue and Expense";
            case 2:
                return "Related to Revenue Only";
            case 3:
                return "Related to Expense Only";
            default:
                return "ChargeType2";
        }
    }

    private boolean check_CheckBoxes(int i) {
        switch (i) {
            case 0:
                return false;
            case 1:
                return true;
            default:
                return false;
        }
    }

    public void generateEmptyTable() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestStandardCharges.tblStandardCharges.setModel(defaultTableModel);
        TestStandardCharges.tblStandardCharges.setDefaultRenderer(Object.class, new StandardChargesUIHelper.StandardChargesTable());
        Object[][] data = new Object[7][9];
        for (int i = 0; i < 7; i++) {
            data[i][0] = "";
            data[i][1] = "";
            data[i][2] = "";
            data[i][3] = "";
            data[i][4] = "";
            data[i][5] = "";
            data[i][6] = "";
            data[i][7] = "";
            data[i][8] = "";
            TestStandardCharges.tblStandardCharges.setRowHeight(30);
        }
        Object[] cols = {"Code", "Type", "Description", "Rate", "Maximum", "Apply Comm", "Apply F/S", "Driver Pay", "Charge Type"};

        defaultTableModel.setDataVector(data, cols);
        TestStandardCharges.tblStandardCharges.getTableHeader().setBackground(Color.red);

        TestStandardCharges.tblStandardCharges.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        TestStandardCharges.tblStandardCharges.getTableHeader().setForeground(Color.DARK_GRAY);
        TestStandardCharges.tblStandardCharges.setIntercellSpacing(new Dimension(0, 0));
        TestStandardCharges.tblStandardCharges.setShowGrid(false);
        TestStandardCharges.jScrollPane9.setViewportView(TestStandardCharges.tblStandardCharges);
    }

    public void save() {
        StandardChargesBean standardChargesBean = new StandardChargesBean();
        standardChargesBean.setCode(AddStandardAccessorialCharge.txtCode.getText());
        standardChargesBean.setChargeType1(AddStandardAccessorialCharge.ddlChargeType1.getSelectedIndex() + 1);
        standardChargesBean.setDescription(AddStandardAccessorialCharge.txtDescription.getText());
        standardChargesBean.setAmountAs(AddStandardAccessorialCharge.ddlAmountas.getSelectedIndex() + 1);
        standardChargesBean.setBaseCharge(AddStandardAccessorialCharge.txtBaseCharge.getText());
        standardChargesBean.setMaxCharge(AddStandardAccessorialCharge.txtMaxCharge.getText());
        standardChargesBean.setChargeType2(AddStandardAccessorialCharge.ddlChargeType2.getSelectedIndex() + 1);
        standardChargesBean.setStatus(AddStandardAccessorialCharge.ddlStatus.getSelectedIndex() == 0 ? 1 : 0);
        standardChargesBean.setIncludeChargeAmount(AddStandardAccessorialCharge.chk1.isSelected() ? 1 : 0);
        standardChargesBean.setCalculateFuelSurcharge(AddStandardAccessorialCharge.chk2.isSelected() ? 1 : 0);
        standardChargesBean.setIncludeDriverPayroll(AddStandardAccessorialCharge.chk3.isSelected() ? 1 : 0);
        String msg = "";
        if (StandardChargesUIHelper.addUpdateFlag.equals("add")) {
            msg = standardChargesDAO.addStandardCharges(standardChargesBean);
        } else {
            standardChargesBean.setStandardChargesId(standardChargesId);
            msg = standardChargesDAO.updateStandardCharges(standardChargesBean);
        }
        lstStandardCharges = standardChargesDAO.getAllStandardCharges(TestStandardCharges.txtSearch.getText());
        generateTable();
        JOptionPane.showMessageDialog(null, msg);
    }

    class StandardChargesTable extends DefaultTableCellRenderer {

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
