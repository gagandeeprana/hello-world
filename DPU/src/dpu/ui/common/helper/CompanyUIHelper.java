package dpu.ui.common.helper;

import dpu.dao.admin.CompanyDAO;
import dpu.dao.admin.impl.CompanyDAOImpl;
import dpu.beans.admin.AdditionalContactBean;
import dpu.beans.admin.BillingLocationBean;
import dpu.beans.admin.CompanyBean;
import dpu.beans.admin.WorkingHoursAdditionalContactBean;
import dpu.dao.admin.AdditionalContactDAO;
import dpu.dao.admin.BillingLocationDAO;
import dpu.dao.admin.WorkingHoursAdditionalContactDAO;
import dpu.dao.admin.impl.AdditionalContactDAOImpl;
import dpu.dao.admin.impl.BillingLocationDAOImpl;
import dpu.dao.admin.impl.WorkingHoursAdditionalContactDAOImpl;
import dpu.ui.common.AddCustomerFrame;
import dpu.ui.common.TestCompanyPanel;
import static dpu.ui.common.helper.AdditionalContactWorkingHoursUIHelper.mapWorkingHours;
import java.awt.Color;
//import static dpu.ui.common.TestCompanyPanel.mainTabbedPane;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CompanyUIHelper {

   
    CompanyDAO companyDAO = new CompanyDAOImpl();
    public CompanyBean companyBean = new CompanyBean();
    static public String addUpdateFlag = "";
    public static int companyId = 0;
    public static List<CompanyBean> lstCompanies = null;
    int companyIdToBeDeleted = 0;
    String msg = "";
//    static Logger logger = Logger.getLogger(CompanyUIHelper.class);

    public void clear() {
        TestCompanyPanel.txtCompanySearch.setText("");
    }

    public void disable(boolean var) {
    }

    public void generateTable() {
        Object[] cols = {"Company Id", "Company Name", "Address", "Unit No", "City", "Province/State", "Zip", "Email", "Website", "Contact", "Position", "Phone", "Ext", "Fax", "Pager"};
        lstCompanies = companyDAO.getAllCompanies(TestCompanyPanel.txtCompanySearch.getText());
        System.out.println("size: " + lstCompanies.size());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
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
                TestCompanyPanel.tblCompany.setRowHeight(30);
            }
            TestCompanyPanel.tblCompany.setColumnSelectionAllowed(false);
            defaultTableModel.setDataVector(data, cols);
            TestCompanyPanel.tblCompany.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            TestCompanyPanel.tblCompany.getTableHeader().setForeground(Color.DARK_GRAY);
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
        AdditionalContactDAO additionalContactDAO = new AdditionalContactDAOImpl();
        BillingLocationDAO billingLocationDAO = new BillingLocationDAOImpl();

        String msg = "";
        int maxAdditionalContactId = 0;
        int maxCompanyId = 0;
        if (addUpdateFlag.equals("add")) {
            maxCompanyId = companyDAO.addCompany(companyBean);
            if (AddCustomerFrame.lstAdditionalContacts.size() > 0) {
                for (int i = 0; i < AddCustomerFrame.lstAdditionalContacts.size(); i++) {
                    AdditionalContactBean additionalContactBean = AddCustomerFrame.lstAdditionalContacts.get(i);
//                    additionalContactBean.setContactId(contactId);
                    additionalContactDAO.addAdditionalContact(additionalContactBean);
                    maxAdditionalContactId = additionalContactDAO.getMaxAdditionalContactId();
                    if (AdditionalContactWorkingHoursUIHelper.mapWorkingHours != null && !AdditionalContactWorkingHoursUIHelper.mapWorkingHours.isEmpty()) {
                        WorkingHoursAdditionalContactDAO workDAO = new WorkingHoursAdditionalContactDAOImpl();
                        List<WorkingHoursAdditionalContactBean> listOfWorkingHours = mapWorkingHours.get(additionalContactBean);
                        if (listOfWorkingHours != null && !listOfWorkingHours.isEmpty()) {
                            for (WorkingHoursAdditionalContactBean work : listOfWorkingHours) {
                                work.setAdditionalContactId(maxAdditionalContactId);
                                workDAO.addWorkingHours(work);
                            }
                        }
                    }
                }
            }
            if (AddCustomerFrame.lstBillingLocations.size() > 0) {
                CompanyBean companyBean = companyDAO.getCompanyInfoById(maxCompanyId);
                for (BillingLocationBean billingLocationBean : AddCustomerFrame.lstBillingLocations) {
                    billingLocationBean.setCompanyBean(companyBean);
                    billingLocationDAO.addBillingLocation(billingLocationBean);
                }
            }

            AddCustomerFrame.lstAdditionalContacts = new ArrayList<>();
            AddCustomerFrame.lstAdditionalContacts = new ArrayList<>();
            AdditionalContactWorkingHoursUIHelper.mapWorkingHours = new HashMap();
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
//                    billingLocationBean.setCompanyId(contactId);
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
        generateTable();
        return msg;
    }

    public String update(CompanyBean companyBean) {
        CompanyDAO companyDAO = new CompanyDAOImpl();
        String msg = companyDAO.updateCompany(companyBean);
        disable(true);
        generateTable();
        return msg;
    }

    class CompanyTable extends DefaultTableCellRenderer {

        @Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
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
