package dpu.ui.helper.common;

import dpu.beans.admin.AdditionalContactBean;
import dpu.beans.admin.BillingLocationBean;
import dpu.dao.admin.BillingLocationDAO;
import dpu.dao.admin.impl.BillingLocationDAOImpl;
import dpu.ui.common.AddBillingLocation;
import dpu.ui.common.AddCustomerFrame;
import static dpu.ui.common.AddCustomerFrame.lstBillingLocations;
import static dpu.ui.common.AddCustomerFrame.tblBillingLocations;
import dpu.ui.common.TestCompanyPanel;
import java.awt.Color;
//import static dpu.ui.common.TestBillingLocationPanel.mainTabbedPane;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import properties.ReadFromPropertiesFile;

public class BillingLocationUIHelper {

    public static String addUpdateFlag = "add";
    static int billingLocationId = 0;
    BillingLocationDAO billingLocationDAO = new BillingLocationDAOImpl();
    List<BillingLocationBean> lstBillingLocations = new ArrayList<>();
    int billingLocationIdToBeDeleted = 0;
    String msg = "";
    BillingLocationBean billingLocationBean = null;

    public void clear() {
//        TestBillingLocationPanel.txtBillingLocationSearch.setText("");
    }

    public void disable(boolean var) {
//        TestBillingLocationPanel.tblBillingLocation.setEnabled(var);
//        TestBillingLocationPanel.lblAddManageBillingLocation.setEnabled(var);
//        TestBillingLocationPanel.lblPrintManageBillingLocation.setEnabled(var);
//        TestBillingLocationPanel.txtBillingLocationSearch.setEnabled(var);
    }

//    public class ButtonRenderer extends JButton implements TableCellRenderer {
//
//        public ButtonRenderer() {
//            setOpaque(true);
//        }
//
//        public Component getTableCellRendererComponent(JTable table, Object value,
//                boolean isSelected, boolean hasFocus, int row, int column) {
//            setToolTipText("Delete Billing Location...");
//            if (isSelected) {
//                setForeground(table.getSelectionForeground());
//                setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
//                setBackground(Color.WHITE);
//                setContentAreaFilled(false);
//            } else {
//                setForeground(table.getForeground());
//                setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
//                setContentAreaFilled(false);
//            }
//            setText((value == null) ? "" : value.toString());
//            return this;
//        }
//    }
//
//    public class ButtonEditor extends DefaultCellEditor {
//
//        protected JButton button;
//        private String label;
//        private boolean isPushed;
//        int row = 0;
//
//        public ButtonEditor(JCheckBox checkBox) {
//            super(checkBox);
//            button = new JButton();
//            button.setOpaque(true);
//            button.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    fireEditingStopped();
//                }
//            });
//        }
//
//        public Component getTableCellEditorComponent(JTable table, Object value,
//                boolean isSelected, int row, int column) {
//            if (isSelected) {
//                this.row = row;
//                button.setForeground(table.getSelectionForeground());
//                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
//            } else {
//                button.setForeground(table.getForeground());
//                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
//            }
////            billingLocationIdToBeDeleted = lstCompanies.get(row).getBillingLocationId();
//            label = (value == null) ? "" : value.toString();
//            button.setText(label);
//            isPushed = true;
//            return button;
//        }
//
//        public Object getCellEditorValue() {
//            if (isPushed) {
//                BillingLocationBean billingLocationBean = AddCustomerFrame.lstBillingLocations.get(row);
//                if (billingLocationBean.getBillingLocationId() != 0) {
//                    AddCustomerFrame.lstBillingLocations.remove(row);
//                    msg = delete(billingLocationBean.getBillingLocationId());
//                } else {
//                    AddCustomerFrame.lstBillingLocations.remove(row);
//                    msg = "Billing Location Deleted Successfully";
//                    generateTable();
//                }
//                JOptionPane.showMessageDialog(null, msg);
//            }
//            isPushed = false;
//            return new String(label);
//        }
//
//        public boolean stopCellEditing() {
//            isPushed = false;
//            return super.stopCellEditing();
//        }
//
//        protected void fireEditingStopped() {
//            super.fireEditingStopped();
//        }
//    }
//
//    public class ButtonRendererUpdate extends JButton implements TableCellRenderer {
//
//        public ButtonRendererUpdate() {
//            setOpaque(true);
//        }
//
//        public Component getTableCellRendererComponent(JTable table, Object value,
//                boolean isSelected, boolean hasFocus, int row, int column) {
//            setToolTipText("Edit Billing Location...");
//            if (isSelected) {
//                setForeground(table.getSelectionForeground());
//                setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
//                setBackground(Color.WHITE);
//                setContentAreaFilled(false);
//            } else {
//                setForeground(table.getForeground());
//                setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
//                setBackground(Color.WHITE);
//                setContentAreaFilled(false);
//            }
//            setText((value == null) ? "" : value.toString());
//            return this;
//        }
//    }
//
//    public class ButtonEditorUpdate extends DefaultCellEditor {
//
//        protected JButton button;
//        private String label;
//        private boolean isPushed;
//        int row = 0;
//
//        public ButtonEditorUpdate(JCheckBox checkBox) {
//            super(checkBox);
//            button = new JButton();
//            button.setOpaque(true);
//            button.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    fireEditingStopped();
//                }
//            });
//        }
//
//        public Component getTableCellEditorComponent(JTable table, Object value,
//                boolean isSelected, int row, int column) {
//            if (isSelected) {
//                this.row = row;
//                button.setForeground(table.getSelectionForeground());
//                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
//            } else {
//                button.setForeground(table.getForeground());
//                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
//            }
//            label = (value == null) ? "" : value.toString();
//            button.setText(label);
//            isPushed = true;
//            return button;
//        }
//
//        public Object getCellEditorValue() {
//            if (isPushed) {
//                addUpdateFlag = "update";
//                BillingLocationBean billingLocationBean = new BillingLocationBean();
//                billingLocationBean = AddCustomerFrame.lstBillingLocations.get(row);
//                AddBillingLocation addBillingLocation = new AddBillingLocation(row, billingLocationBean);
//                addBillingLocation.setVisible(true);
//                disable(false);
//            }
//            isPushed = false;
//            return new String(label);
//        }
//
//        public boolean stopCellEditing() {
//            isPushed = false;
//            return super.stopCellEditing();
//        }
//
//        protected void fireEditingStopped() {
//            super.fireEditingStopped();
//        }
//    }
    public void generateTable() {
        try {

            Object[] cols = {"Company Name", "Address", "City, P/S", "Phone No", "Contact", "Zip", "Fax"};
            DefaultTableModel defaultTableModel = new DefaultTableModel();
            AddCustomerFrame.tblBillingLocations.setModel(defaultTableModel);
            AddCustomerFrame.tblBillingLocations.setAutoCreateRowSorter(true);
            AddCustomerFrame.tblBillingLocations.setDefaultRenderer(Object.class, new BillingLocationUIHelper.BillingLocationTable());
            if (AddCustomerFrame.lstBillingLocations.size() > 0) {
//        lstBillingLocations = AddCustomerFrame.lstBillingLocations;
//        AddCustomerFrame.tblBillingLocations = new JTable(defaultTableModel);
//            AddCustomerFrame.tblBillingLocations.getTableHeader().setBackground(Color.red);
                Object[][] data = new Object[AddCustomerFrame.lstBillingLocations.size()][7];
                for (int i = 0; i < AddCustomerFrame.lstBillingLocations.size(); i++) {
                    BillingLocationBean obj = AddCustomerFrame.lstBillingLocations.get(i);
                    data[i][0] = obj.getName();
                    data[i][1] = obj.getAddress();
                    data[i][2] = obj.getCity() + " , " + obj.getProvinceState();
                    data[i][3] = obj.getPhone();
                    data[i][4] = obj.getContact();
                    data[i][5] = obj.getZip();
                    data[i][6] = obj.getFax();
//                    data[i][7] = "";
//                    data[i][8] = "";
                    AddCustomerFrame.tblBillingLocations.setRowHeight(30);
                }

                defaultTableModel.setDataVector(data, cols);
                AddCustomerFrame.tblBillingLocations.getTableHeader().setBackground(Color.red);

                AddCustomerFrame.tblBillingLocations.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
                AddCustomerFrame.tblBillingLocations.getTableHeader().setForeground(Color.DARK_GRAY);
//                AddCustomerFrame.tblBillingLocations.getColumn(" ").setCellRenderer(new ButtonRenderer());
//                AddCustomerFrame.tblBillingLocations.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
//                AddCustomerFrame.tblBillingLocations.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
//                AddCustomerFrame.tblBillingLocations.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
//                AddCustomerFrame.tblBillingLocations.getColumn(" ").setMaxWidth(25);
//                AddCustomerFrame.tblBillingLocations.getColumn("  ").setMaxWidth(25);
                AddCustomerFrame.tblBillingLocations.setIntercellSpacing(new Dimension(0, 0));
                AddCustomerFrame.tblBillingLocations.setShowGrid(false);
                AddCustomerFrame.ScrollPaneForBillingLocations.setViewportView(AddCustomerFrame.tblBillingLocations);
            } else {
//            AddCustomerFrame.tblBillingLocations = new JTable(new Object[][]{}, cols);
                generateEmptyTable();
            }
        } catch (Exception e) {
            System.out.println("BillingLocationUIHelper : generateTable() : " + e);
        }
    }

    public void generateEmptyTable() {
        Object[] cols = {"Company Name", "Address", "City, P/S", "Phone No", "Contact", "Zip", "Fax"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        AddCustomerFrame.tblBillingLocations.setModel(defaultTableModel);
        AddCustomerFrame.tblBillingLocations.setDefaultRenderer(Object.class, new BillingLocationUIHelper.BillingLocationTable());
        Object[][] data = new Object[7][7];
        for (int i = 0; i < 7; i++) {
            data[i][0] = "";
            data[i][1] = "";
            data[i][2] = "";
            data[i][3] = "";
            data[i][4] = "";
            data[i][5] = "";
            data[i][6] = "";
            AddCustomerFrame.tblBillingLocations.setRowHeight(30);
        }
        defaultTableModel.setDataVector(data, cols);
        AddCustomerFrame.tblBillingLocations.getTableHeader().setBackground(Color.red);
        AddCustomerFrame.tblBillingLocations.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        AddCustomerFrame.tblBillingLocations.getTableHeader().setForeground(Color.DARK_GRAY);
        AddCustomerFrame.tblBillingLocations.setIntercellSpacing(new Dimension(0, 0));
        AddCustomerFrame.tblBillingLocations.setShowGrid(false);
        AddCustomerFrame.ScrollPaneForBillingLocations.setViewportView(AddCustomerFrame.tblBillingLocations);
    }

    public String save() {
        BillingLocationBean billingLocationBean = new BillingLocationBean();
//        billingLocationBean.setContactId(AddBillingLocation.txtCustomer.getText());
        billingLocationBean.setName(AddBillingLocation.txtName.getText());
        billingLocationBean.setAddress(AddBillingLocation.txtAddress.getText());
        billingLocationBean.setUnitNo(AddBillingLocation.txtUnitNo.getText());
        billingLocationBean.setCity(AddBillingLocation.txtCity.getText());
        billingLocationBean.setProvinceState(AddBillingLocation.txtProvinceState.getText());
        billingLocationBean.setZip(AddBillingLocation.txtZip.getText());
        billingLocationBean.setArCDN(AddBillingLocation.txtArCDN.getText());
        billingLocationBean.setArUS(AddBillingLocation.txtArUS.getText());
        billingLocationBean.setContact(AddBillingLocation.txtContact.getText());
        billingLocationBean.setPosition(AddBillingLocation.txtPosition.getText());
        billingLocationBean.setEmail(AddBillingLocation.txtEmail.getText());
        billingLocationBean.setCellular(AddBillingLocation.txtCellular.getText());
        billingLocationBean.setPhone(AddBillingLocation.txtPhone.getText());
        billingLocationBean.setExt(AddBillingLocation.txtExt.getText());
        billingLocationBean.setFax(AddBillingLocation.txtFax.getText());
        billingLocationBean.setPrefix(AddBillingLocation.txtPrefix.getText());
        billingLocationBean.setTollfree(AddBillingLocation.txtTollFree.getText());
        if (AddBillingLocation.ddlStatus.getSelectedIndex() == 0) {
            billingLocationBean.setStatus(1);
        } else {
            billingLocationBean.setStatus(0);
        }
        BillingLocationDAO billingLocationDAO = new BillingLocationDAOImpl();
        String msg = "";
        if (addUpdateFlag.equals("add")) {
            msg = billingLocationDAO.addBillingLocation(billingLocationBean);
        } else {
            billingLocationBean.setBillingLocationId(billingLocationId);
            msg = billingLocationDAO.updateBillingLocation(billingLocationBean);
        }
        disable(true);
        generateTable();
//        TestBillingLocationPanel.mainTabbedPane.setEnabled(true);
//        TestBillingLocationPanel.billingLocationPanel.setEnabled(true);
        return msg;
    }

    public void saveToList(int index, BillingLocationBean billingLocationBean) {
        if (index == AddCustomerFrame.lstBillingLocations.size()) {
            billingLocationBean = new BillingLocationBean();
            billingLocationBean.setName(AddBillingLocation.txtName.getText());
            billingLocationBean.setAddress(AddBillingLocation.txtAddress.getText());
            billingLocationBean.setUnitNo(AddBillingLocation.txtUnitNo.getText());
            billingLocationBean.setCity(AddBillingLocation.txtCity.getText());
            billingLocationBean.setProvinceState(AddBillingLocation.txtProvinceState.getText());
            billingLocationBean.setZip(AddBillingLocation.txtZip.getText());
            billingLocationBean.setArCDN(AddBillingLocation.txtArCDN.getText());
            billingLocationBean.setArUS(AddBillingLocation.txtArUS.getText());
            billingLocationBean.setContact(AddBillingLocation.txtContact.getText());
            billingLocationBean.setPosition(AddBillingLocation.txtPosition.getText());
            billingLocationBean.setEmail(AddBillingLocation.txtEmail.getText());
            billingLocationBean.setCellular(AddBillingLocation.txtCellular.getText());
            billingLocationBean.setPhone(AddBillingLocation.txtPhone.getText());
            billingLocationBean.setExt(AddBillingLocation.txtExt.getText());
            billingLocationBean.setFax(AddBillingLocation.txtFax.getText());
            billingLocationBean.setPrefix(AddBillingLocation.txtPrefix.getText());
            billingLocationBean.setTollfree(AddBillingLocation.txtTollFree.getText());
            if (AddBillingLocation.ddlStatus.getSelectedIndex() == 0) {
                billingLocationBean.setStatus(1);
            } else {
                billingLocationBean.setStatus(0);
            }
            AddCustomerFrame.lstBillingLocations.add(index, billingLocationBean);
        } else if (billingLocationBean.getBillingLocationId() != 0) {
            for (BillingLocationBean billingLocationBeanFromLst : AddCustomerFrame.lstBillingLocations) {
                if (billingLocationBeanFromLst.getBillingLocationId() == billingLocationBean.getBillingLocationId()) {
                    billingLocationBeanFromLst.setName(AddBillingLocation.txtName.getText());
                    billingLocationBeanFromLst.setAddress(AddBillingLocation.txtAddress.getText());
                    billingLocationBeanFromLst.setUnitNo(AddBillingLocation.txtUnitNo.getText());
                    billingLocationBeanFromLst.setCity(AddBillingLocation.txtCity.getText());
                    billingLocationBeanFromLst.setProvinceState(AddBillingLocation.txtProvinceState.getText());
                    billingLocationBeanFromLst.setZip(AddBillingLocation.txtZip.getText());
                    billingLocationBeanFromLst.setArCDN(AddBillingLocation.txtArCDN.getText());
                    billingLocationBeanFromLst.setArUS(AddBillingLocation.txtArUS.getText());
                    billingLocationBeanFromLst.setContact(AddBillingLocation.txtContact.getText());
                    billingLocationBeanFromLst.setPosition(AddBillingLocation.txtPosition.getText());
                    billingLocationBeanFromLst.setEmail(AddBillingLocation.txtEmail.getText());
                    billingLocationBeanFromLst.setCellular(AddBillingLocation.txtCellular.getText());
                    billingLocationBeanFromLst.setPhone(AddBillingLocation.txtPhone.getText());
                    billingLocationBeanFromLst.setExt(AddBillingLocation.txtExt.getText());
                    billingLocationBeanFromLst.setFax(AddBillingLocation.txtFax.getText());
                    billingLocationBeanFromLst.setPrefix(AddBillingLocation.txtPrefix.getText());
                    billingLocationBeanFromLst.setTollfree(AddBillingLocation.txtTollFree.getText());
                    if (AddBillingLocation.ddlStatus.getSelectedIndex() == 0) {
                        billingLocationBeanFromLst.setStatus(1);
                    } else {
                        billingLocationBeanFromLst.setStatus(0);
                    }
                }
            }
        } else {
            AddCustomerFrame.lstBillingLocations.remove(index);
            billingLocationBean = new BillingLocationBean();
            billingLocationBean.setName(AddBillingLocation.txtName.getText());
            billingLocationBean.setAddress(AddBillingLocation.txtAddress.getText());
            billingLocationBean.setUnitNo(AddBillingLocation.txtUnitNo.getText());
            billingLocationBean.setCity(AddBillingLocation.txtCity.getText());
            billingLocationBean.setProvinceState(AddBillingLocation.txtProvinceState.getText());
            billingLocationBean.setZip(AddBillingLocation.txtZip.getText());
            billingLocationBean.setArCDN(AddBillingLocation.txtArCDN.getText());
            billingLocationBean.setArUS(AddBillingLocation.txtArUS.getText());
            billingLocationBean.setContact(AddBillingLocation.txtContact.getText());
            billingLocationBean.setPosition(AddBillingLocation.txtPosition.getText());
            billingLocationBean.setEmail(AddBillingLocation.txtEmail.getText());
            billingLocationBean.setCellular(AddBillingLocation.txtCellular.getText());
            billingLocationBean.setPhone(AddBillingLocation.txtPhone.getText());
            billingLocationBean.setExt(AddBillingLocation.txtExt.getText());
            billingLocationBean.setFax(AddBillingLocation.txtFax.getText());
            billingLocationBean.setPrefix(AddBillingLocation.txtPrefix.getText());
            billingLocationBean.setTollfree(AddBillingLocation.txtTollFree.getText());
            if (AddBillingLocation.ddlStatus.getSelectedIndex() == 0) {
                billingLocationBean.setStatus(1);
            } else {
                billingLocationBean.setStatus(0);
            }
            AddCustomerFrame.lstBillingLocations.add(index, billingLocationBean);
        }
        generateTable();
    }

    public String delete(int billingLocationIdToBeDeleted) {
        BillingLocationDAO billingLocationDAO = new BillingLocationDAOImpl();
        String msg = billingLocationDAO.deleteBillingLocation(billingLocationIdToBeDeleted);
//        disable(true);
        generateTable();
//        TestBillingLocationPanel.mainTabbedPane.setEnabled(true);
//        TestBillingLocationPanel.billingLocationPanel.setEnabled(true);
        return msg;
    }

    public String update(BillingLocationBean billingLocationBean) {
        BillingLocationDAO billingLocationDAO = new BillingLocationDAOImpl();
        String msg = billingLocationDAO.updateBillingLocation(billingLocationBean);
        disable(true);
        generateTable();
//        TestBillingLocationPanel.mainTabbedPane.setEnabled(true);
//        TestBillingLocationPanel.billingLocationPanel.setEnabled(true);
        return msg;

    }

    class BillingLocationTable implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JTextField editor = new JTextField();
            editor.setFont(new Font(Font.SANS_SERIF, 0, 15));
            editor.setBorder(null);
            if (value != null) {
                //here space is given to provide some left margin while showing data on textfield..
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
            return editor;
        }

    }
}
