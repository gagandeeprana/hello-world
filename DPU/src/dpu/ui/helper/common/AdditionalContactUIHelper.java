package dpu.ui.helper.common;

import dpu.beans.admin.AdditionalContactBean;
import dpu.dao.admin.AdditionalContactDAO;
import dpu.dao.admin.impl.AdditionalContactDAOImpl;
import dpu.ui.common.AddAdditionalContact;
import static dpu.ui.common.AddAdditionalContact.ddlStatus;
import dpu.ui.common.AddCustomerFrame;
import java.awt.Color;
//import static dpu.ui.common.TestAdditionalContactPanel.mainTabbedPane;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class AdditionalContactUIHelper {

    public static String addUpdateFlag = "add";
    static int additionalContactId = 0;
    AdditionalContactDAO additionalContactDAO = new AdditionalContactDAOImpl();
    List<AdditionalContactBean> lstAdditionalContacts = null;
    int additionalContactIdToBeDeleted = 0;
    String msg = "";
    public static AdditionalContactBean additionalContactBean = null;

    public void clear() {
    }

    public void disable(boolean var) {

    }

    public void generateTable() {
        Object[] cols = {"Customer Name", "Phone", "Ext", "Cell Phone", "Email", "Fax"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        AddCustomerFrame.tblAdditionalContacts.setModel(defaultTableModel);
        AddCustomerFrame.tblAdditionalContacts.setAutoCreateRowSorter(true);
        AddCustomerFrame.tblAdditionalContacts.setDefaultRenderer(Object.class, new AdditionalContactUIHelper.AdditionalContactTable());
        if (AddCustomerFrame.lstAdditionalContacts.size() > 0) {

            Object[][] data = new Object[AddCustomerFrame.lstAdditionalContacts.size()][6];
            for (int i = 0; i < AddCustomerFrame.lstAdditionalContacts.size(); i++) {
                AdditionalContactBean obj = AddCustomerFrame.lstAdditionalContacts.get(i);
                data[i][0] = obj.getCustomerName();
                data[i][1] = obj.getPhone();
                data[i][2] = obj.getExt();
                data[i][3] = obj.getPhone();
                data[i][4] = obj.getEmail();
                data[i][5] = obj.getFax();
                AddCustomerFrame.tblAdditionalContacts.setRowHeight(30);
            }
            defaultTableModel.setDataVector(data, cols);
            AddCustomerFrame.tblAdditionalContacts.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            AddCustomerFrame.tblAdditionalContacts.getTableHeader().setForeground(Color.DARK_GRAY);
            AddCustomerFrame.tblAdditionalContacts.setIntercellSpacing(new Dimension(0, 0));
            AddCustomerFrame.tblAdditionalContacts.setShowGrid(false);
            AddCustomerFrame.ScrollPanetblAdditionalContacts.setViewportView(AddCustomerFrame.tblAdditionalContacts);
        } else {
            generateEmptyTable();
        }
    }

    public void generateEmptyTable() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        AddCustomerFrame.tblAdditionalContacts.setModel(defaultTableModel);
        AddCustomerFrame.tblAdditionalContacts.setDefaultRenderer(Object.class, new AdditionalContactUIHelper.AdditionalContactTable());
        Object[][] data = new Object[7][6];
        for (int i = 0; i < 7; i++) {
            data[i][0] = "";
            data[i][1] = "";
            data[i][2] = "";
            data[i][3] = "";
            data[i][4] = "";
            data[i][5] = "";
            AddCustomerFrame.tblAdditionalContacts.setRowHeight(30);
        }
        Object[] cols = {"Customer Name", "Phone", "Ext", "Cell Phone", "Email", "Fax"};
        defaultTableModel.setDataVector(data, cols);
        AddCustomerFrame.tblAdditionalContacts.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        AddCustomerFrame.tblAdditionalContacts.getTableHeader().setForeground(Color.DARK_GRAY);
        AddCustomerFrame.tblAdditionalContacts.setIntercellSpacing(new Dimension(0, 0));
        AddCustomerFrame.tblAdditionalContacts.setShowGrid(false);
        AddCustomerFrame.ScrollPanetblAdditionalContacts.setViewportView(AddCustomerFrame.tblAdditionalContacts);
    }

    public String save() {
        AdditionalContactBean additionalContactBean = new AdditionalContactBean();
        additionalContactBean.setCustomerName(AddAdditionalContact.txtCustomer.getText());
        additionalContactBean.setPosition(AddAdditionalContact.txtPosition.getText());
        additionalContactBean.setPhone(AddAdditionalContact.txtPhone.getText());
        additionalContactBean.setExt(AddAdditionalContact.txtExt.getText());
        additionalContactBean.setFax(AddAdditionalContact.txtFax.getText());
        additionalContactBean.setPrefix(AddAdditionalContact.txtPrefix.getText());
        additionalContactBean.setCellular(AddAdditionalContact.txtCellular.getText());
        if (AddAdditionalContact.ddlStatus.getSelectedIndex() == 0) {
            additionalContactBean.setStatus(0);
        } else {
            additionalContactBean.setStatus(1);
        }
        additionalContactBean.setEmail(AddAdditionalContact.txtEmail.getText());
        AdditionalContactDAO additionalContactDAO = new AdditionalContactDAOImpl();
        String msg = "";
        if (addUpdateFlag.equals("add")) {
            msg = additionalContactDAO.addAdditionalContact(additionalContactBean);
        } else {
            additionalContactBean.setAdditionalContactId(additionalContactId);
            msg = additionalContactDAO.updateAdditionalContact(additionalContactBean);
        }
        disable(true);
        generateTable();
        return msg;
    }

    public void saveToList(int index, AdditionalContactBean additionalContactBean) {
        try {
            if (additionalContactBean != null) {
                if (index == AddCustomerFrame.lstAdditionalContacts.size()) {
                    System.out.println("11111111111");
                    additionalContactBean = new AdditionalContactBean();
                    additionalContactBean.setCustomerName(AddAdditionalContact.txtCustomer.getText());
                    additionalContactBean.setPosition(AddAdditionalContact.txtPosition.getText());
                    additionalContactBean.setPhone(AddAdditionalContact.txtPhone.getText());
                    additionalContactBean.setExt(AddAdditionalContact.txtExt.getText());
                    additionalContactBean.setFax(AddAdditionalContact.txtFax.getText());
                    additionalContactBean.setPrefix(AddAdditionalContact.txtPrefix.getText());
                    additionalContactBean.setCellular(AddAdditionalContact.txtCellular.getText());
                    if (AddAdditionalContact.ddlStatus.getSelectedIndex() == 0) {
                        additionalContactBean.setStatus(1);
                    } else {
                        additionalContactBean.setStatus(0);
                    }
                    additionalContactBean.setEmail(AddAdditionalContact.txtEmail.getText());
                    AddCustomerFrame.lstAdditionalContacts.add(index, additionalContactBean);
                    AdditionalContactWorkingHoursUIHelper.mapWorkingHours.put(additionalContactBean, AdditionalContactWorkingHoursUIHelper.listOfWorkingHours);

                } else if (additionalContactBean.getAdditionalContactId() != 0) {
                    for (AdditionalContactBean additionalContactBeanFromLst : AddCustomerFrame.lstAdditionalContacts) {
                        if (additionalContactBeanFromLst.getAdditionalContactId() == additionalContactBean.getAdditionalContactId()) {
                            additionalContactBeanFromLst.setCustomerName(AddAdditionalContact.txtCustomer.getText());
                            additionalContactBeanFromLst.setPosition(AddAdditionalContact.txtPosition.getText());
                            additionalContactBeanFromLst.setPhone(AddAdditionalContact.txtPhone.getText());
                            additionalContactBeanFromLst.setExt(AddAdditionalContact.txtExt.getText());
                            additionalContactBeanFromLst.setFax(AddAdditionalContact.txtFax.getText());
                            additionalContactBeanFromLst.setPrefix(AddAdditionalContact.txtPrefix.getText());
                            additionalContactBeanFromLst.setCellular(AddAdditionalContact.txtCellular.getText());
                            if (AddAdditionalContact.ddlStatus.getSelectedIndex() == 0) {
                                additionalContactBeanFromLst.setStatus(1);
                            } else {
                                additionalContactBeanFromLst.setStatus(0);
                            }
                            additionalContactBeanFromLst.setEmail(AddAdditionalContact.txtEmail.getText());
                        }
                    }
                } else {
                    AddCustomerFrame.lstAdditionalContacts.remove(index);
                    additionalContactBean = new AdditionalContactBean();
                    additionalContactBean.setCustomerName(AddAdditionalContact.txtCustomer.getText());
                    additionalContactBean.setPosition(AddAdditionalContact.txtPosition.getText());
                    additionalContactBean.setPhone(AddAdditionalContact.txtPhone.getText());
                    additionalContactBean.setExt(AddAdditionalContact.txtExt.getText());
                    additionalContactBean.setFax(AddAdditionalContact.txtFax.getText());
                    additionalContactBean.setPrefix(AddAdditionalContact.txtPrefix.getText());
                    additionalContactBean.setCellular(AddAdditionalContact.txtCellular.getText());

                    if (AddAdditionalContact.ddlStatus.getSelectedIndex() == 0) {
                        additionalContactBean.setStatus(1);
                    } else {
                        additionalContactBean.setStatus(0);
                    }
                    additionalContactBean.setEmail(AddAdditionalContact.txtEmail.getText());
                    AddCustomerFrame.lstAdditionalContacts.add(index, additionalContactBean);
                }
                generateTable();
            } else {
                JOptionPane.showMessageDialog(null, "Your AdditionalContact Object is null : ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Your AdditionalContact Object is null Becoz Of: " + e);
        }
    }

    public String delete(int additionalContactIdToBeDeleted) {
        AdditionalContactDAO additionalContactDAO = new AdditionalContactDAOImpl();
        String msg = additionalContactDAO.deleteAdditionalContact(additionalContactIdToBeDeleted);
        disable(true);
        generateTable();
        return msg;
    }

    public String update(AdditionalContactBean additionalContactBean) {
        AdditionalContactDAO additionalContactDAO = new AdditionalContactDAOImpl();
        String msg = additionalContactDAO.updateAdditionalContact(additionalContactBean);
        disable(true);
        generateTable();
        return msg;
    }

    public void showData(AdditionalContactBean additionalContactBean) {
        this.additionalContactBean = additionalContactBean;
        AddAdditionalContact.txtCustomer.setText(additionalContactBean.getCustomerName());
        AddAdditionalContact.txtPosition.setText(additionalContactBean.getPosition());
        AddAdditionalContact.txtPhone.setText(additionalContactBean.getPhone());
        AddAdditionalContact.txtExt.setText(additionalContactBean.getExt());
        AddAdditionalContact.txtFax.setText(additionalContactBean.getFax());
        AddAdditionalContact.txtPrefix.setText(additionalContactBean.getPrefix());
        AddAdditionalContact.txtCellular.setText(additionalContactBean.getCellular());
        if (additionalContactBean.getStatus() == 0) {
            ddlStatus.setSelectedIndex(1);
        } else {
            ddlStatus.setSelectedIndex(0);
        }
        AddAdditionalContact.txtEmail.setText(additionalContactBean.getEmail());
    }

    class AdditionalContactTable implements TableCellRenderer {

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
