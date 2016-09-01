/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.helper.common;

import dpu.beans.admin.StandardChargesBean;
import dpu.ui.common.AddCustomerFrame;
import dpu.ui.common.TestStandardCharges;
import static dpu.ui.helper.common.CompanyUIHelper.lstCompanies;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.nio.file.Files.delete;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import properties.ReadFromPropertiesFile;

/**
 *
 * @author gagandeep.rana
 */
public class StandardChargesUIHelper {

    public static List<StandardChargesBean> lstStandardCharges = new ArrayList();

    public class ButtonRenderer extends JCheckBox implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setToolTipText("Delete Company...");
            if (isSelected) {
                setForeground(table.getSelectionForeground());
//                setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
                setBackground(Color.WHITE);
                setContentAreaFilled(false);
            } else {
                setForeground(table.getForeground());
//                setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
                setContentAreaFilled(false);
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
//                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
            } else {
                button.setForeground(table.getForeground());
//                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
            }
//            companyIdToBeDeleted = lstCompanies.get(row).getCompanyId();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {

//                msg = delete(companyIdToBeDeleted);
                JOptionPane.showMessageDialog(null, "AA");
            }
            isPushed = false;
            return new String(label);
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            try {
                super.fireEditingStopped();
            } catch (Exception e) {
                System.out.println("CompanyUIHelper : fireEditingStopped() : " + e);
            }
        }
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
                data[i][1] = obj.getChargeType1();
                data[i][2] = obj.getDescription();
                data[i][3] = obj.getBaseCharge();
                data[i][4] = obj.getMaxCharge();
//                data[i][5] = obj.get
//                data[i][6] = "";
//                data[i][7] = "";
                AddCustomerFrame.tblAdditionalContacts.setRowHeight(30);
            }
            defaultTableModel.setDataVector(data, cols);
            AddCustomerFrame.tblAdditionalContacts.getTableHeader().setBackground(Color.red);

            AddCustomerFrame.tblAdditionalContacts.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            AddCustomerFrame.tblAdditionalContacts.getTableHeader().setForeground(Color.DARK_GRAY);
//            AddCustomerFrame.tblAdditionalContacts.getColumn(" ").setCellRenderer(new ButtonRenderer());
//            AddCustomerFrame.tblAdditionalContacts.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
//            AddCustomerFrame.tblAdditionalContacts.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
//            AddCustomerFrame.tblAdditionalContacts.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
//            AddCustomerFrame.tblAdditionalContacts.getColumn(" ").setMaxWidth(25);
//            AddCustomerFrame.tblAdditionalContacts.getColumn("  ").setMaxWidth(25);
            AddCustomerFrame.tblAdditionalContacts.setIntercellSpacing(new Dimension(0, 0));
            AddCustomerFrame.tblAdditionalContacts.setShowGrid(false);
            AddCustomerFrame.ScrollPanetblAdditionalContacts.setViewportView(AddCustomerFrame.tblAdditionalContacts);
        } else {
            generateEmptyTable();
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
