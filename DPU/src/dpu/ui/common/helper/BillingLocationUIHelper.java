package dpu.ui.common.helper;

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
    }

    public void disable(boolean var) {

    }


    public void generateTable() {
        try {

            Object[] cols = {"Company Name", "Address", "City, P/S", "Phone No", "Contact", "Zip", "Fax"};
            DefaultTableModel defaultTableModel = new DefaultTableModel();
            AddCustomerFrame.tblBillingLocations.setModel(defaultTableModel);
            AddCustomerFrame.tblBillingLocations.setAutoCreateRowSorter(true);
            AddCustomerFrame.tblBillingLocations.setDefaultRenderer(Object.class, new BillingLocationUIHelper.BillingLocationTable());
            if (AddCustomerFrame.lstBillingLocations.size() > 0) {
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
                    AddCustomerFrame.tblBillingLocations.setRowHeight(30);
                }

                defaultTableModel.setDataVector(data, cols);
                AddCustomerFrame.tblBillingLocations.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
                AddCustomerFrame.tblBillingLocations.getTableHeader().setForeground(Color.DARK_GRAY);
                AddCustomerFrame.tblBillingLocations.setIntercellSpacing(new Dimension(0, 0));
                AddCustomerFrame.tblBillingLocations.setShowGrid(false);
                AddCustomerFrame.ScrollPaneForBillingLocations.setViewportView(AddCustomerFrame.tblBillingLocations);
            } else {
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
        AddCustomerFrame.tblBillingLocations.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        AddCustomerFrame.tblBillingLocations.getTableHeader().setForeground(Color.DARK_GRAY);
        AddCustomerFrame.tblBillingLocations.setIntercellSpacing(new Dimension(0, 0));
        AddCustomerFrame.tblBillingLocations.setShowGrid(false);
        AddCustomerFrame.ScrollPaneForBillingLocations.setViewportView(AddCustomerFrame.tblBillingLocations);
    }

    public String save() {
        BillingLocationBean billingLocationBean = new BillingLocationBean();
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
        return msg;

    }

    class BillingLocationTable implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JTextField editor = new JTextField();
            editor.setFont(new Font(Font.SANS_SERIF, 0, 15));
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
            return editor;
        }

    }
}
