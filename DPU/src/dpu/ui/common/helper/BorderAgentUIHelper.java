/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common.helper;

import dpu.beans.admin.BorderAgentBean;
import dpu.dao.admin.BorderAgentDAO;
import dpu.dao.admin.impl.BorderAgentDAOImpl;
import dpu.ui.common.AddBorderAgent;
import dpu.ui.common.AddCustomBroker;
import static dpu.ui.common.helper.BorderAgentUIHelper.lstBorderAgents;
import static dpu.ui.common.helper.CustomBrokerUIHelper.addUpdateFlag;
import static dpu.ui.common.helper.CustomBrokerUIHelper.customBrokerBean;
import static dpu.ui.common.helper.CustomBrokerUIHelper.customBrokerId;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
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
public class BorderAgentUIHelper {

    public static List<BorderAgentBean> lstBorderAgents = new ArrayList();
    static public String addUpdateFlag = "add";
    static public int borderAgentId = 0;
    BorderAgentDAO borderAgentDAO = new BorderAgentDAOImpl();
    public static BorderAgentBean borderAgentBean = new BorderAgentBean();

    public void generateTable() {
        Object[] cols = {"Office/Agent", "Border Crossing"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        AddCustomBroker.tblBorderAgents.setModel(defaultTableModel);
        AddCustomBroker.tblBorderAgents.setAutoCreateRowSorter(true);
        AddCustomBroker.tblBorderAgents.setDefaultRenderer(Object.class, new BorderAgentUIHelper.BorderAgentTable());
        if (lstBorderAgents != null && lstBorderAgents.size() > 0) {
            Object[][] data = new Object[lstBorderAgents.size()][2];
            for (int i = 0; i < lstBorderAgents.size(); i++) {
                BorderAgentBean obj = lstBorderAgents.get(i);
                data[i][0] = obj.getBorderAgent();
                data[i][1] = obj.getBorderCrossing();
                AddCustomBroker.tblBorderAgents.setRowHeight(30);
            }
            AddCustomBroker.tblBorderAgents.setColumnSelectionAllowed(false);
            defaultTableModel.setDataVector(data, cols);
            AddCustomBroker.tblBorderAgents.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            AddCustomBroker.tblBorderAgents.getTableHeader().setForeground(Color.DARK_GRAY);
            AddCustomBroker.tblBorderAgents.setIntercellSpacing(new Dimension(0, 0));
            AddCustomBroker.tblBorderAgents.setShowGrid(false);
            AddCustomBroker.jScrollPane1.setViewportView(AddCustomBroker.tblBorderAgents);
        } else {
            generateEmptyTable();
        }
    }

    private void generateEmptyTable() {
        Object[] cols = {"Office/Agent", "Border Crossing"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        AddCustomBroker.tblBorderAgents.setModel(defaultTableModel);
        AddCustomBroker.tblBorderAgents.setAutoCreateRowSorter(true);
        AddCustomBroker.tblBorderAgents.setDefaultRenderer(Object.class, new BorderAgentUIHelper.BorderAgentTable());
        Object[][] data = new Object[7][2];
        for (int i = 0; i < 7; i++) {
            data[i][0] = "";
            data[i][1] = "";

            AddCustomBroker.tblBorderAgents.setRowHeight(30);
        }
        AddCustomBroker.tblBorderAgents.setColumnSelectionAllowed(false);
        defaultTableModel.setDataVector(data, cols);
        AddCustomBroker.tblBorderAgents.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        AddCustomBroker.tblBorderAgents.getTableHeader().setForeground(Color.DARK_GRAY);
        AddCustomBroker.tblBorderAgents.setIntercellSpacing(new Dimension(0, 0));
        AddCustomBroker.tblBorderAgents.setShowGrid(false);
        AddCustomBroker.jScrollPane1.setViewportView(AddCustomBroker.tblBorderAgents);
    }

    public void saveToList(int index, BorderAgentBean borderAgentBean) {
        if (borderAgentBean == null) {
            borderAgentBean = new BorderAgentBean();
            borderAgentBean.setCode(AddBorderAgent.txtCode.getText());
            borderAgentBean.setBorderAgent(AddBorderAgent.txtBorderAgent.getText());
            borderAgentBean.setBorderCrossing(AddBorderAgent.txtBorderCrossing.getText());
            borderAgentBean.setPhone(AddBorderAgent.txtPhone.getText());
            borderAgentBean.setExt(AddBorderAgent.txtExt.getText());
            borderAgentBean.setFax(AddBorderAgent.txtFax.getText());
            borderAgentBean.setAfterHour(AddBorderAgent.txtAfterHour.getText());
            if (AddBorderAgent.ddlStatus.getSelectedIndex() == 0) {
                borderAgentBean.setStatus(1);
            } else {
                borderAgentBean.setStatus(0);
            }
            borderAgentBean.setEmail(AddBorderAgent.txtEmail.getText());
            borderAgentBean.setOpenFrom(AddBorderAgent.txtOpenFrom.getText());
            borderAgentBean.setOpenTo(AddBorderAgent.txtOpenTo.getText());
            if (AddBorderAgent.chkOpen24Hrs.isSelected()) {
                borderAgentBean.setIs24Hr(1);
            } else {
                borderAgentBean.setIs24Hr(0);
            }
            borderAgentBean.setComments(AddBorderAgent.taComments.getText());
            lstBorderAgents.add(lstBorderAgents.size(), borderAgentBean);
        } else {
            lstBorderAgents.remove(index);
            borderAgentBean.setCode(AddBorderAgent.txtCode.getText());
            borderAgentBean.setBorderAgent(AddBorderAgent.txtBorderAgent.getText());
            borderAgentBean.setBorderCrossing(AddBorderAgent.txtBorderCrossing.getText());
            borderAgentBean.setPhone(AddBorderAgent.txtPhone.getText());
            borderAgentBean.setExt(AddBorderAgent.txtExt.getText());
            borderAgentBean.setFax(AddBorderAgent.txtFax.getText());
            borderAgentBean.setAfterHour(AddBorderAgent.txtAfterHour.getText());
            if (AddBorderAgent.ddlStatus.getSelectedIndex() == 0) {
                borderAgentBean.setStatus(1);
            } else {
                borderAgentBean.setStatus(0);
            }
            borderAgentBean.setEmail(AddBorderAgent.txtEmail.getText());
            borderAgentBean.setOpenFrom(AddBorderAgent.txtOpenFrom.getText());
            borderAgentBean.setOpenTo(AddBorderAgent.txtOpenTo.getText());
            if (AddBorderAgent.chkOpen24Hrs.isSelected()) {
                borderAgentBean.setIs24Hr(1);
            } else {
                borderAgentBean.setIs24Hr(0);
            }
            borderAgentBean.setComments(AddBorderAgent.taComments.getText());
            lstBorderAgents.add(index, borderAgentBean);
        }
        generateTable();
    }

//    public String save(int customBrokerId) {
//        String msg = "";
//        for (BorderAgentBean borderAgentBean : lstBorderAgents) {
//            borderAgentBean.setCustomBrokerId(customBrokerId);
//            if (addUpdateFlag.equals("add")) {
//                msg = borderAgentDAO.addBorderAgent(borderAgentBean);
//            } else {
//                borderAgentBean.setBorderAgentId(borderAgentId);
//                msg = borderAgentDAO.updateBorderAgent(borderAgentBean);
//            }
//        }
//        return msg;
//    }

    public String delete(int index, int borderAgentId) {
        String msg = "";
        if (borderAgentId != 0) {
            BorderAgentUIHelper.lstBorderAgents.remove(index);
            borderAgentDAO.deleteBorderAgent(borderAgentId);
        } else {
            BorderAgentUIHelper.lstBorderAgents.remove(index);
            msg = "BorderAgent Deleted";
        }
        generateTable();
        return msg;
    }

    public void showData(BorderAgentBean borderAgentBean) {
        this.borderAgentBean = borderAgentBean;
        AddBorderAgent.txtCode.setText(borderAgentBean.getCode());
        AddBorderAgent.txtBorderAgent.setText(borderAgentBean.getBorderAgent());
        AddBorderAgent.txtBorderCrossing.setText(borderAgentBean.getBorderCrossing());
        AddBorderAgent.txtPhone.setText(borderAgentBean.getPhone());
        AddBorderAgent.txtExt.setText(borderAgentBean.getExt());
        AddBorderAgent.txtFax.setText(borderAgentBean.getFax());
        AddBorderAgent.txtAfterHour.setText(borderAgentBean.getAfterHour());
        if (borderAgentBean.getStatus() == 1) {
            AddBorderAgent.ddlStatus.setSelectedIndex(0);
        } else {
            AddBorderAgent.ddlStatus.setSelectedIndex(1);
        }
        AddBorderAgent.txtEmail.setText(borderAgentBean.getEmail());
        AddBorderAgent.txtOpenFrom.setText(borderAgentBean.getOpenFrom());
        AddBorderAgent.txtOpenTo.setText(borderAgentBean.getOpenTo());
        if (borderAgentBean.getIs24Hr() == 1) {
            AddBorderAgent.chkOpen24Hrs.setSelected(true);
        } else {
            AddBorderAgent.chkOpen24Hrs.setSelected(false);
        }
        AddBorderAgent.taComments.setText(borderAgentBean.getComments());
    }

    class BorderAgentTable extends DefaultTableCellRenderer {

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
