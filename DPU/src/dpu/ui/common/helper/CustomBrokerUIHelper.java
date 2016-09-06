/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common.helper;

import dpu.beans.admin.BorderAgentBean;
import dpu.beans.admin.CustomBrokerBean;
import dpu.dao.admin.BorderAgentDAO;
import dpu.dao.admin.CustomBrokerDAO;
import dpu.dao.admin.impl.BorderAgentDAOImpl;
import dpu.dao.admin.impl.CustomBrokerDAOImpl;
import dpu.ui.common.AddCustomBroker;
import dpu.ui.common.TestCustomBrokersPanel;
import static dpu.ui.common.helper.BorderAgentUIHelper.addUpdateFlag;
import static dpu.ui.common.helper.BorderAgentUIHelper.borderAgentId;
import static dpu.ui.common.helper.BorderAgentUIHelper.lstBorderAgents;
//import static dpu.ui.helper.common.CompanyUIHelper.companyBean;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gagandeep
 */
public class CustomBrokerUIHelper {

    public static List<CustomBrokerBean> lstCustomBrokers = null;
    static public String addUpdateFlag = "add";
    static public int customBrokerId = 0;
    CustomBrokerDAO customBrokerDAO = new CustomBrokerDAOImpl();
    BorderAgentDAO borderAgentDAO = new BorderAgentDAOImpl();
    public static CustomBrokerBean customBrokerBean = new CustomBrokerBean();

    public String delete(int customBrokerIdToBeDeleted) {
        CustomBrokerDAO customBrokerDAO = new CustomBrokerDAOImpl();
        String msg = customBrokerDAO.deleteCustomBroker(customBrokerIdToBeDeleted);
        generateTable();
        return msg;
    }

    public void generateTable() {
        Object[] cols = {"Custom Broker", "Contact Name", "Phone No.", "Ext", "Fax", "Email", "Website"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        lstCustomBrokers = customBrokerDAO.getAllCustomBrokers(TestCustomBrokersPanel.txtCustomBrokerSearch.getText());
        TestCustomBrokersPanel.tblCustomBroker.setModel(defaultTableModel);
        TestCustomBrokersPanel.tblCustomBroker.setAutoCreateRowSorter(true);
        TestCustomBrokersPanel.tblCustomBroker.setDefaultRenderer(Object.class, new CustomBrokerUIHelper.CustomBrokerTable());
        if (lstCustomBrokers.size() > 0) {
            Object[][] data = new Object[lstCustomBrokers.size()][7];
            for (int i = 0; i < lstCustomBrokers.size(); i++) {
                CustomBrokerBean obj = lstCustomBrokers.get(i);
                data[i][0] = obj.getCustomBroker();
                data[i][1] = obj.getContactName();
                data[i][2] = obj.getPhone();
                data[i][3] = obj.getExt();
                data[i][4] = obj.getFaxNo();
                data[i][5] = obj.getEmail();
                data[i][6] = obj.getWebsite();
                TestCustomBrokersPanel.tblCustomBroker.setRowHeight(30);
            }
            TestCustomBrokersPanel.tblCustomBroker.setColumnSelectionAllowed(false);
            defaultTableModel.setDataVector(data, cols);
            TestCustomBrokersPanel.tblCustomBroker.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            TestCustomBrokersPanel.tblCustomBroker.getTableHeader().setForeground(Color.DARK_GRAY);
            TestCustomBrokersPanel.tblCustomBroker.setIntercellSpacing(new Dimension(0, 0));
            TestCustomBrokersPanel.tblCustomBroker.setShowGrid(false);
            TestCustomBrokersPanel.jScrollPane4.setViewportView(TestCustomBrokersPanel.tblCustomBroker);
        } else {
            generateEmptyTable();
        }
    }

    private void generateEmptyTable() {
        Object[] cols = {"Custom Broker", "Contact Name", "Phone No.", "Ext", "Fax", "Email", "Website"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestCustomBrokersPanel.tblCustomBroker.setModel(defaultTableModel);
        TestCustomBrokersPanel.tblCustomBroker.setAutoCreateRowSorter(true);
        TestCustomBrokersPanel.tblCustomBroker.setDefaultRenderer(Object.class, new CustomBrokerUIHelper.CustomBrokerTable());
        Object[][] data = new Object[7][7];
        for (int i = 0; i < 7; i++) {
            data[i][0] = "";
            data[i][1] = "";
            data[i][2] = "";
            data[i][3] = "";
            data[i][4] = "";
            data[i][5] = "";
            data[i][6] = "";

            TestCustomBrokersPanel.tblCustomBroker.setRowHeight(30);
        }
        TestCustomBrokersPanel.tblCustomBroker.setColumnSelectionAllowed(false);

        defaultTableModel.setDataVector(data, cols);

        TestCustomBrokersPanel.tblCustomBroker.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        TestCustomBrokersPanel.tblCustomBroker.getTableHeader().setForeground(Color.DARK_GRAY);
        TestCustomBrokersPanel.tblCustomBroker.setIntercellSpacing(new Dimension(0, 0));
        TestCustomBrokersPanel.tblCustomBroker.setShowGrid(false);
        TestCustomBrokersPanel.jScrollPane4.setViewportView(TestCustomBrokersPanel.tblCustomBroker);
    }

    public String save() {
        String msg = "";
        customBrokerBean.setCustomBroker(AddCustomBroker.txtCustomBroker.getText());
        customBrokerBean.setContactName(AddCustomBroker.txtContact.getText());
        customBrokerBean.setPhone(AddCustomBroker.txtPhone.getText());
        customBrokerBean.setExt(AddCustomBroker.txtExt.getText());
        customBrokerBean.setFaxNo(AddCustomBroker.txtFax.getText());
        if (AddCustomBroker.ddlStatus.getSelectedIndex() == 0) {
            customBrokerBean.setStatus(1);
        } else {
            customBrokerBean.setStatus(0);
        }
        customBrokerBean.setEmail(AddCustomBroker.txtEmail.getText());
        customBrokerBean.setWebsite(AddCustomBroker.txtWebsite.getText());
        if (addUpdateFlag.equals("add")) {
            msg = customBrokerDAO.addCustomBroker(customBrokerBean);
            customBrokerId = customBrokerDAO.getMaxCustomBrokerId();
            if (lstBorderAgents != null && !lstBorderAgents.isEmpty()) {
                for (BorderAgentBean borderAgentBean : lstBorderAgents) {
                    borderAgentBean.setCustomBrokerId(customBrokerId);
                    borderAgentDAO.addBorderAgent(borderAgentBean);
                }
            }
        } else {
            customBrokerBean.setCustomBrokerId(customBrokerId);
            msg = customBrokerDAO.updateCustomBroker(customBrokerBean);
            if (lstBorderAgents != null && !lstBorderAgents.isEmpty()) {
                for (BorderAgentBean borderAgentBean : lstBorderAgents) {
                    if (borderAgentBean.getBorderAgentId() == 0) {
                        borderAgentBean.setCustomBrokerId(customBrokerId);
                        borderAgentDAO.addBorderAgent(borderAgentBean);
                    } else {
                        borderAgentBean.setCustomBrokerId(customBrokerId);
                        borderAgentDAO.updateBorderAgent(borderAgentBean);
                    }
                }
            }
        }
        generateTable();
        return msg;
    }

    public void showData(CustomBrokerBean customBrokerBean) {
        AddCustomBroker.txtCustomBroker.setText(customBrokerBean.getCustomBroker());
        AddCustomBroker.txtContact.setText(customBrokerBean.getContactName());
        AddCustomBroker.txtPhone.setText(customBrokerBean.getPhone());
        AddCustomBroker.txtExt.setText(customBrokerBean.getExt());
        AddCustomBroker.txtFax.setText(customBrokerBean.getFaxNo());
        AddCustomBroker.txtEmail.setText(customBrokerBean.getEmail());
        AddCustomBroker.txtWebsite.setText(customBrokerBean.getWebsite());
        if (customBrokerBean.getStatus() == 0) {
            AddCustomBroker.ddlStatus.setSelectedIndex(1);
        } else {
            AddCustomBroker.ddlStatus.setSelectedIndex(0);
        }
    }

    class CustomBrokerTable extends DefaultTableCellRenderer {

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
