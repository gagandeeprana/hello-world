package dpu.ui.helper.common;

import dpu.beans.admin.AdditionalContactBean;
import dpu.beans.admin.BillingLocationBean;
import dpu.beans.admin.CompanyBean;
import dpu.dao.admin.AdditionalContactDAO;
import dpu.dao.admin.BillingLocationDAO;
import dpu.dao.admin.CompanyDAO;
import dpu.dao.admin.impl.AdditionalContactDAOImpl;
import dpu.dao.admin.impl.BillingLocationDAOImpl;
import dpu.dao.admin.impl.CompanyDAOImpl;
import dpu.ui.common.AddCustomerFrame;
import dpu.ui.common.TestCompanyPanel;
import java.awt.Color;
//import static dpu.ui.common.TestCompanyPanel.mainTabbedPane;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class CompanyUIHelper {

    static public String addUpdateFlag = "";
    static int companyId = 0;
    CompanyDAO companyDAO = new CompanyDAOImpl();
    List<CompanyBean> lstCompanies = null;
    int companyIdToBeDeleted = 0;
    String msg = "";
    CompanyBean companyBean = null;

    public void clear() {
        TestCompanyPanel.txtCompanySearch.setText("");
    }

    public void disable(boolean var) {
        TestCompanyPanel.tblCompany.setEnabled(var);
        TestCompanyPanel.lblAddManageCompany.setEnabled(var);
        TestCompanyPanel.btnPrint.setEnabled(var);
        TestCompanyPanel.txtCompanySearch.setEnabled(var);
    }

    public class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
                setBackground(Color.WHITE);
                setContentAreaFilled(false);
            } else {
                setForeground(table.getForeground());
                setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
                setContentAreaFilled(false);
            }
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    public class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
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
                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
            } else {
                button.setForeground(table.getForeground());
                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
            }
            companyIdToBeDeleted = lstCompanies.get(row).getCompanyId();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                msg = delete();
                JOptionPane.showMessageDialog(null, msg);
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

    public class ButtonRendererUpdate extends JButton implements TableCellRenderer {

        public ButtonRendererUpdate() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
                setBackground(Color.WHITE);
                setContentAreaFilled(false);
            } else {
                setForeground(table.getForeground());
                setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
                setBackground(Color.WHITE);
                setContentAreaFilled(false);
            }
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    public class ButtonEditorUpdate extends DefaultCellEditor {

        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditorUpdate(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
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
                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
            } else {
                button.setForeground(table.getForeground());
                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
            }
            companyIdToBeDeleted = lstCompanies.get(row).getCompanyId();
            companyId = lstCompanies.get(row).getCompanyId();
            companyBean = companyDAO.getCompanyInfoById(companyId);
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                addUpdateFlag = "update";
                AddCustomerFrame addCustomerFrame = new AddCustomerFrame(companyBean);
                addCustomerFrame.setVisible(true);
                disable(false);
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

    public void generateTable() {
        lstCompanies = companyDAO.getAllCompanies(TestCompanyPanel.txtCompanySearch.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestCompanyPanel.tblCompany = new JTable(defaultTableModel);
        TestCompanyPanel.tblCompany.getTableHeader().setBackground(Color.red);
        TestCompanyPanel.tblCompany.setDefaultRenderer(Object.class, new CompanyUIHelper.CompanyTable());
        Object[][] data = new Object[lstCompanies.size()][17];
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
            data[i][15] = "";
            data[i][16] = "";
            TestCompanyPanel.tblCompany.setRowHeight(30);
        }
        Object[] cols = {"Company Id", "Company Name", "Address", "Unit No", "City", "Province/State", "Zip", "Email", "Website", "Contact", "Position", "Phone", "Ext", "Fax", "Pager", " ", "  "};

        defaultTableModel.setDataVector(data, cols);
        TestCompanyPanel.tblCompany.getTableHeader().setBackground(Color.red);

        TestCompanyPanel.tblCompany.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        TestCompanyPanel.tblCompany.getTableHeader().setForeground(Color.DARK_GRAY);
        TestCompanyPanel.tblCompany.getColumn(" ").setCellRenderer(new ButtonRenderer());
        TestCompanyPanel.tblCompany.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        TestCompanyPanel.tblCompany.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        TestCompanyPanel.tblCompany.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        TestCompanyPanel.tblCompany.getColumn(" ").setMaxWidth(25);
        TestCompanyPanel.tblCompany.getColumn("  ").setMaxWidth(25);
        TestCompanyPanel.tblCompany.setIntercellSpacing(new Dimension(0, 0));
        TestCompanyPanel.tblCompany.setShowGrid(false);
        TestCompanyPanel.jScrollPane4.setViewportView(TestCompanyPanel.tblCompany);

    }

    public String save() {
        CompanyBean companyBean = new CompanyBean();
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
        CompanyDAO companyDAO = new CompanyDAOImpl();
        AdditionalContactDAO additionalContactDAO = new AdditionalContactDAOImpl();
        BillingLocationDAO billingLocationDAO = new BillingLocationDAOImpl();

        String msg = "";
        if (addUpdateFlag.equals("add")) {
            msg = companyDAO.addCompany(companyBean);
            if (AddCustomerFrame.lstAdditionalContacts.size() > 0) {
                int contactId = companyDAO.getMaxCompanyId();
                for (AdditionalContactBean additionalContactBean : AddCustomerFrame.lstAdditionalContacts) {
                    additionalContactBean.setContactId(contactId);
                    additionalContactDAO.addAdditionalContact(additionalContactBean);
                }
            }
            if (AddCustomerFrame.lstBillingLocations.size() > 0) {
                int contactId = companyDAO.getMaxCompanyId();
                for (BillingLocationBean billingLocationBean : AddCustomerFrame.lstBillingLocations) {
                    billingLocationBean.setCompanyId(contactId);
                    billingLocationDAO.addBillingLocation(billingLocationBean);
                }
            }

        } else {
            companyBean.setCompanyId(companyId);
            msg = companyDAO.updateCompany(companyBean);
            if (AddCustomerFrame.lstAdditionalContacts.size() > 0) {
                for (AdditionalContactBean additionalContactBean : AddCustomerFrame.lstAdditionalContacts) {
                    for (int i = 0; i < AddCustomerFrame.lstAdditionalContactsFromDb.size(); i++) {
                        if (additionalContactBean.getAdditionalContactId() == AddCustomerFrame.lstAdditionalContactsFromDb.get(i).getAdditionalContactId()) {
                            int contactId = companyId;
                            additionalContactBean.setContactId(contactId);
                            additionalContactDAO.updateAdditionalContact(additionalContactBean);
                        } 
                    }
                }
                for (AdditionalContactBean additionalContactBean : AddCustomerFrame.lstAdditionalContacts) {
                    for (int i = 0; i < AddCustomerFrame.lstAdditionalContactsFromDb.size(); i++) {
                        if (additionalContactBean.getAdditionalContactId() == AddCustomerFrame.lstAdditionalContactsFromDb.get(i).getAdditionalContactId()) {
                            int contactId = companyId;
                            additionalContactBean.setContactId(contactId);
                            additionalContactDAO.updateAdditionalContact(additionalContactBean);
                        } 
                    }
                }
            }
            if (AddCustomerFrame.lstBillingLocations.size() > 0) {
                int contactId = companyId;
                for (BillingLocationBean billingLocationBean : AddCustomerFrame.lstBillingLocations) {
                    billingLocationBean.setCompanyId(contactId);
                    billingLocationDAO.updateBillingLocation(billingLocationBean);
                }
            }
        }
        disable(true);
        generateTable();
//        TestCompanyPanel.mainTabbedPane.setEnabled(true);
//        TestCompanyPanel.companyPanel.setEnabled(true);
        return msg;
    }

    public String delete() {
        CompanyDAO companyDAO = new CompanyDAOImpl();
        String msg = companyDAO.deleteCompany(companyIdToBeDeleted);
        disable(true);
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

    class CompanyTable implements TableCellRenderer {

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
