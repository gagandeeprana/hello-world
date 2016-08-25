package dpu.ui.helper.common;

import dpu.beans.admin.AdditionalContactBean;
import dpu.beans.admin.BillingLocationBean;
import dpu.beans.admin.CompanyBean;
import dpu.beans.admin.WorkingHoursAdditionalContactBean;
import dpu.dao.admin.AdditionalContactDAO;
import dpu.dao.admin.BillingLocationDAO;
import dpu.dao.admin.CompanyDAO;
import dpu.dao.admin.WorkingHoursAdditionalContactDAO;
import dpu.dao.admin.impl.AdditionalContactDAOImpl;
import dpu.dao.admin.impl.BillingLocationDAOImpl;
import dpu.dao.admin.impl.CompanyDAOImpl;
import dpu.dao.admin.impl.WorkingHoursAdditionalContactDAOImpl;
import dpu.ui.common.AddCustomerFrame;
import dpu.ui.common.TestCompanyPanel;
import static dpu.ui.helper.common.AdditionalContactWorkingHoursUIHelper.mapWorkingHours;
import java.awt.Color;
//import static dpu.ui.common.TestCompanyPanel.mainTabbedPane;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CompanyUIHelper {

    static public String addUpdateFlag = "";
    public static int companyId = 0;
    CompanyDAO companyDAO = new CompanyDAOImpl();
    public static List<CompanyBean> lstCompanies = null;
    int companyIdToBeDeleted = 0;
    String msg = "";
    public static CompanyBean companyBean = new CompanyBean();

    public void clear() {
        TestCompanyPanel.txtCompanySearch.setText("");
    }

    public void disable(boolean var) {
//        TestCompanyPanel.tblCompany.setEnabled(var);
//        TestCompanyPanel.lblAddManageCompany.setEnabled(var);
//        TestCompanyPanel.btnPrint.setEnabled(var);
//        TestCompanyPanel.txtCompanySearch.setEnabled(var);
    }

//    public class ButtonRenderer extends JButton implements TableCellRenderer {
//
//        public ButtonRenderer() {
//            setOpaque(true);
//        }
//
//        public Component getTableCellRendererComponent(JTable table, Object value,
//                boolean isSelected, boolean hasFocus, int row, int column) {
//            setToolTipText("Delete Company...");
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
//                button.setForeground(table.getSelectionForeground());
//                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
//            } else {
//                button.setForeground(table.getForeground());
//                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
//            }
//            companyIdToBeDeleted = lstCompanies.get(row).getCompanyId();
//            label = (value == null) ? "" : value.toString();
//            button.setText(label);
//            isPushed = true;
//            return button;
//        }
//
//        public Object getCellEditorValue() {
//            if (isPushed) {
//
//                msg = delete(companyIdToBeDeleted);
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
//            try {
//                super.fireEditingStopped();
//            } catch (Exception e) {
//                System.out.println("CompanyUIHelper : fireEditingStopped() : " + e);
//            }
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
//            setToolTipText("Edit Company...");
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
//                button.setForeground(table.getSelectionForeground());
//                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
//            } else {
//                button.setForeground(table.getForeground());
//                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
//            }
//            companyIdToBeDeleted = lstCompanies.get(row).getCompanyId();
//            companyId = lstCompanies.get(row).getCompanyId();
//            companyBean = companyDAO.getCompanyInfoById(companyId);
//            label = (value == null) ? "" : value.toString();
//            button.setText(label);
//            isPushed = true;
//            return button;
//        }
//
//        public Object getCellEditorValue() {
//            if (isPushed) {
//                addUpdateFlag = "update";
//                AddCustomerFrame addCustomerFrame = new AddCustomerFrame(companyBean);
//                addCustomerFrame.setVisible(true);
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
        Object[] cols = {"Company Id", "Company Name", "Address", "Unit No", "City", "Province/State", "Zip", "Email", "Website", "Contact", "Position", "Phone", "Ext", "Fax", "Pager"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        lstCompanies = companyDAO.getAllCompanies(TestCompanyPanel.txtCompanySearch.getText());
        TestCompanyPanel.tblCompany.setModel(defaultTableModel);
        TestCompanyPanel.tblCompany.setAutoCreateRowSorter(true);
        TestCompanyPanel.tblCompany.setDefaultRenderer(Object.class, new CompanyUIHelper.CompanyTable());
        if (lstCompanies.size() > 0) {
            Object[][] data = new Object[lstCompanies.size()][15];
            for (int i = 0; i < lstCompanies.size(); i++) {
                CompanyBean obj = lstCompanies.get(i);
                data[i][0] = obj.getCompanyId();
                data[i][1] = obj.getCompanyName();
                data[i][2] = obj.getAddress();
                data[i][3] = obj.getUnitNo();
                data[i][4] = obj.getCity();
                data[i][5] = obj.getProvinceState();
                data[i][6] = obj.getZip();
                data[i][7] = obj.getEmail();
                data[i][8] = obj.getWebsite();
                data[i][9] = obj.getContact();
                data[i][10] = obj.getPosition();
                data[i][11] = obj.getPhone();
                data[i][12] = obj.getExt();
                data[i][13] = obj.getFax();
                data[i][14] = obj.getPager();
//                data[i][15] = "";
//                data[i][16] = "";
                TestCompanyPanel.tblCompany.setRowHeight(30);
            }
            TestCompanyPanel.tblCompany.setColumnSelectionAllowed(false);

            defaultTableModel.setDataVector(data, cols);
            TestCompanyPanel.tblCompany.getTableHeader().setBackground(Color.red);

            TestCompanyPanel.tblCompany.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            TestCompanyPanel.tblCompany.getTableHeader().setForeground(Color.DARK_GRAY);
//            TestCompanyPanel.tblCompany.getColumn(" ").setCellRenderer(new ButtonRenderer());
//            TestCompanyPanel.tblCompany.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
//            TestCompanyPanel.tblCompany.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
//            TestCompanyPanel.tblCompany.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
//            TestCompanyPanel.tblCompany.getColumn(" ").setMaxWidth(25);
//            TestCompanyPanel.tblCompany.getColumn("  ").setMaxWidth(25);
            TestCompanyPanel.tblCompany.setIntercellSpacing(new Dimension(0, 0));
            TestCompanyPanel.tblCompany.setShowGrid(false);
            TestCompanyPanel.jScrollPane4.setViewportView(TestCompanyPanel.tblCompany);
        } else {
            generateEmptyTable();
        }
    }

    private void generateEmptyTable() {
        Object[] cols = {"Company Id", "Company Name", "Address", "Unit No", "City", "Province/State", "Zip", "Email", "Website", "Contact", "Position", "Phone", "Ext", "Fax", "Pager"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestCompanyPanel.tblCompany.setModel(defaultTableModel);
        TestCompanyPanel.tblCompany.setDefaultRenderer(Object.class, new CompanyUIHelper.CompanyTable());
        Object[][] data = new Object[7][17];
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
            data[i][9] = "";
            data[i][10] = "";
            data[i][11] = "";
            data[i][12] = "";
            data[i][13] = "";
            data[i][14] = "";
            data[i][15] = "";
            data[i][16] = "";
            TestCompanyPanel.tblCompany.setRowHeight(30);
        }
        TestCompanyPanel.tblCompany.setColumnSelectionAllowed(false);

        defaultTableModel.setDataVector(data, cols);

        TestCompanyPanel.tblCompany.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        TestCompanyPanel.tblCompany.getTableHeader().setForeground(Color.DARK_GRAY);
        TestCompanyPanel.tblCompany.setIntercellSpacing(new Dimension(0, 0));
        TestCompanyPanel.tblCompany.setShowGrid(false);
        TestCompanyPanel.jScrollPane4.setViewportView(TestCompanyPanel.tblCompany);
    }

    public String save() {
        companyBean.setCompanyName(AddCustomerFrame.txtCompanyName.getText());
        companyBean.setAddress(AddCustomerFrame.txtAddress.getText());
        companyBean.setUnitNo(AddCustomerFrame.txtUnitNo.getText());
        companyBean.setCity(AddCustomerFrame.txtCity.getText());
        companyBean.setProvinceState(AddCustomerFrame.txtProvinceState.getText());
        companyBean.setZip(AddCustomerFrame.txtZip.getText());
        companyBean.setEmail(AddCustomerFrame.txtEmail.getText());
        companyBean.setWebsite(AddCustomerFrame.txtWebsite.getText());
        companyBean.setContact(AddCustomerFrame.txtContact.getText());
        companyBean.setPosition(AddCustomerFrame.txtPosition.getText());
        companyBean.setPhone(AddCustomerFrame.txtPhone.getText());
        companyBean.setExt(AddCustomerFrame.txtExt.getText());
        companyBean.setFax(AddCustomerFrame.txtFax.getText());
        companyBean.setPrefix(AddCustomerFrame.txtPrefix.getText());
        companyBean.setTollfree(AddCustomerFrame.txtTollFree.getText());
        companyBean.setCellular(AddCustomerFrame.txtCellular.getText());
        companyBean.setPager(AddCustomerFrame.txtPager.getText());
        companyBean.setAfterHours(AddCustomerFrame.txtAfterHours.getText());
        CompanyDAO companyDAO = new CompanyDAOImpl();
        AdditionalContactDAO additionalContactDAO = new AdditionalContactDAOImpl();
        BillingLocationDAO billingLocationDAO = new BillingLocationDAOImpl();

        String msg = "";
        int maxAdditionalContactId = 0;
        if (addUpdateFlag.equals("add")) {
            msg = companyDAO.addCompany(companyBean);
            if (AddCustomerFrame.lstAdditionalContacts.size() > 0) {
                int contactId = companyDAO.getMaxCompanyId();
                for (AdditionalContactBean additionalContactBean : AddCustomerFrame.lstAdditionalContacts) {
                    additionalContactBean.setContactId(contactId);
                    additionalContactDAO.addAdditionalContact(additionalContactBean);
                    maxAdditionalContactId = additionalContactDAO.getMaxAdditionalContactId();
                }
            }
            if (AddCustomerFrame.lstBillingLocations.size() > 0) {
                int contactId = companyDAO.getMaxCompanyId();
                for (BillingLocationBean billingLocationBean : AddCustomerFrame.lstBillingLocations) {
                    billingLocationBean.setCompanyId(contactId);
                    billingLocationDAO.addBillingLocation(billingLocationBean);
                }
            }
            if (AdditionalContactWorkingHoursUIHelper.mapWorkingHours != null && !AdditionalContactWorkingHoursUIHelper.mapWorkingHours.isEmpty()) {
                WorkingHoursAdditionalContactDAO workDAO = new WorkingHoursAdditionalContactDAOImpl();
                Iterator<String> mapIterator = mapWorkingHours.keySet().iterator();
                while (mapIterator.hasNext()) {
                    String workingDay = mapIterator.next();
                    WorkingHoursAdditionalContactBean work = mapWorkingHours.get(workingDay);
                    work.setAdditionalContactId(maxAdditionalContactId);
                    workDAO.addWorkingHours(work);
                }
            }
        } else {
            companyBean.setCompanyId(companyId);
            msg = companyDAO.updateCompany(companyBean);
            if (AddCustomerFrame.lstAdditionalContacts.size() > 0) {
                int contactId = companyId;
                for (AdditionalContactBean additionalContactBean : AddCustomerFrame.lstAdditionalContacts) {
                    additionalContactBean.setContactId(contactId);
                    if (additionalContactBean.getAdditionalContactId() != 0) {
                        for (int i = 0; i < AddCustomerFrame.lstAdditionalContactsFromDb.size(); i++) {
                            if (additionalContactBean.getAdditionalContactId() == AddCustomerFrame.lstAdditionalContactsFromDb.get(i).getAdditionalContactId()) {
                                additionalContactDAO.updateAdditionalContact(additionalContactBean);
                            }
                        }
                    } else {
                        additionalContactDAO.addAdditionalContact(additionalContactBean);
                    }
                }
            }
            if (AddCustomerFrame.lstBillingLocations.size() > 0) {
                int contactId = companyId;
                for (BillingLocationBean billingLocationBean : AddCustomerFrame.lstBillingLocations) {
                    billingLocationBean.setCompanyId(contactId);
                    if (billingLocationBean.getBillingLocationId() != 0) {
                        for (int i = 0; i < AddCustomerFrame.lstBillingLocationsFromDb.size(); i++) {
                            if (billingLocationBean.getBillingLocationId() == AddCustomerFrame.lstBillingLocationsFromDb.get(i).getBillingLocationId()) {
                                billingLocationDAO.updateBillingLocation(billingLocationBean);
                            }
                        }
                    } else {
                        billingLocationDAO.addBillingLocation(billingLocationBean);
                    }
                }
            }
        }
        disable(true);
        generateTable();
//        TestCompanyPanel.mainTabbedPane.setEnabled(true);
//        TestCompanyPanel.companyPanel.setEnabled(true);
        return msg;
    }

    public String delete(int companyIdToBeDeleted) {
        CompanyDAO companyDAO = new CompanyDAOImpl();
        String msg = companyDAO.deleteCompany(companyIdToBeDeleted);
//        disable(true);
        generateTable();
//        TestCompanyPanel.mainTabbedPane.setEnabled(true);
//        TestCompanyPanel.companyPanel.setEnabled(true);
        return msg;
    }

    public String update(CompanyBean companyBean) {
        CompanyDAO companyDAO = new CompanyDAOImpl();
        String msg = companyDAO.updateCompany(companyBean);
        disable(true);
        generateTable();
//        TestCompanyPanel.mainTabbedPane.setEnabled(true);
//        TestCompanyPanel.companyPanel.setEnabled(true);
        return msg;
    }

    class CompanyTable extends DefaultTableCellRenderer {

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
