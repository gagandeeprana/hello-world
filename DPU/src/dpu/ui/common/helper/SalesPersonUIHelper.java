/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common.helper;

import dpu.beans.admin.SalesPersonBean;
import dpu.dao.admin.SalesPersonDAO;
import dpu.dao.admin.impl.SalesPersonDAOImpl;
import dpu.ui.common.AddSalesPersonFrame;
import dpu.ui.common.SalesPersonPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gagandeep.rana
 */
public class SalesPersonUIHelper {

    public static List<SalesPersonBean> lstSalesPersons = new ArrayList();
    SalesPersonDAO salesPersonDAO = new SalesPersonDAOImpl();
    public static int salesPersonId = 0;
    public static String addUpdateFlag = "add";

    public String delete(int salesPersonIdToBeDeleted) {
        String msg = salesPersonDAO.deleteSalesPerson(salesPersonIdToBeDeleted);
        lstSalesPersons = salesPersonDAO.getAllSalesPersons(SalesPersonPanel.txtSearch.getText());
        generateTable();
        return msg;
    }

    public void showData(SalesPersonBean salesPersonBean) {
        AddSalesPersonFrame.txt1.setText(salesPersonBean.getCode());
        AddSalesPersonFrame.ddl1.setSelectedIndex(salesPersonBean.getStatus() == 1 ? 0 : 1);
        AddSalesPersonFrame.txt2.setText(salesPersonBean.getName());
        AddSalesPersonFrame.txt3.setText(salesPersonBean.getAddress());
        AddSalesPersonFrame.txt4.setText(salesPersonBean.getUnitNo());
        AddSalesPersonFrame.txt5.setText(salesPersonBean.getCity());
        AddSalesPersonFrame.txt6.setText(salesPersonBean.getPresentState());
        AddSalesPersonFrame.txt7.setText(salesPersonBean.getPostalCode());
        AddSalesPersonFrame.txt8.setText(salesPersonBean.getPhoneNo());
        AddSalesPersonFrame.txt9.setText(salesPersonBean.getExt());
        AddSalesPersonFrame.txt10.setText(salesPersonBean.getFaxNo());
        AddSalesPersonFrame.txt11.setText(salesPersonBean.getSalesPersonPrefix());
        AddSalesPersonFrame.txt12.setText(salesPersonBean.getPagerNo());
        AddSalesPersonFrame.txt13.setText(salesPersonBean.getCellularNo());
        AddSalesPersonFrame.txt14.setText(salesPersonBean.getEmail());
        AddSalesPersonFrame.txt15.setText(salesPersonBean.getArCdn());
        AddSalesPersonFrame.txt16.setText(salesPersonBean.getArUs());
        AddSalesPersonFrame.txt17.setText(String.valueOf(salesPersonBean.getBaseSalary()));
        AddSalesPersonFrame.ddl3.setSelectedIndex(salesPersonBean.getPaid());
        AddSalesPersonFrame.txt18.setText(salesPersonBean.getPercentOnApplicableRevenue());
        AddSalesPersonFrame.txt19.setText(salesPersonBean.getPercentOnGrossProfit());
        AddSalesPersonFrame.txt20.setText(salesPersonBean.getMaxCommissionPaid());
    }

    public void generateTable() {
        Object[] cols = {"Code", "Name", "Address", "UnitNo", "City", "Province/State", "Postal Code", "Phone No", "Fax", "Cellular", "Pager"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        SalesPersonPanel.tblSalesPerson.setModel(defaultTableModel);
        SalesPersonPanel.tblSalesPerson.setAutoCreateRowSorter(true);
        SalesPersonPanel.tblSalesPerson.setDefaultRenderer(Object.class, new SalesPersonUIHelper.SalesPersonTable());
        if (lstSalesPersons.size() > 0) {
            Object[][] data = new Object[lstSalesPersons.size()][11];
            for (int i = 0; i < lstSalesPersons.size(); i++) {
                SalesPersonBean obj = lstSalesPersons.get(i);
                data[i][0] = obj.getCode();
                data[i][1] = obj.getName();
                data[i][2] = obj.getAddress();
                data[i][3] = obj.getUnitNo();
                data[i][4] = obj.getCity();
                data[i][5] = obj.getPresentState();
                data[i][6] = obj.getPostalCode();
                data[i][7] = obj.getPhoneNo();
                data[i][8] = obj.getFaxNo();
                data[i][9] = obj.getCellularNo();
                data[i][10] = obj.getPagerNo();
                SalesPersonPanel.tblSalesPerson.setRowHeight(30);
            }
            defaultTableModel.setDataVector(data, cols);
            SalesPersonPanel.tblSalesPerson.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            SalesPersonPanel.tblSalesPerson.getTableHeader().setForeground(Color.DARK_GRAY);
            SalesPersonPanel.tblSalesPerson.setIntercellSpacing(new Dimension(0, 0));
            SalesPersonPanel.tblSalesPerson.setShowGrid(false);
            SalesPersonPanel.jScrollPane9.setViewportView(SalesPersonPanel.tblSalesPerson);
        } else {
            generateEmptyTable();
        }
    }

    public void generateEmptyTable() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        SalesPersonPanel.tblSalesPerson.setModel(defaultTableModel);
        SalesPersonPanel.tblSalesPerson.setDefaultRenderer(Object.class, new SalesPersonUIHelper.SalesPersonTable());
        Object[][] data = new Object[7][11];
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
            SalesPersonPanel.tblSalesPerson.setRowHeight(30);
        }
        Object[] cols = {"Code", "Name", "Address", "UnitNo", "City", "Province/State", "Postal Code", "Phone No", "Fax", "Cellular", "Pager"};

        defaultTableModel.setDataVector(data, cols);
        SalesPersonPanel.tblSalesPerson.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        SalesPersonPanel.tblSalesPerson.getTableHeader().setForeground(Color.DARK_GRAY);
        SalesPersonPanel.tblSalesPerson.setIntercellSpacing(new Dimension(0, 0));
        SalesPersonPanel.tblSalesPerson.setShowGrid(false);
        SalesPersonPanel.jScrollPane9.setViewportView(SalesPersonPanel.tblSalesPerson);
    }

    public void save() {
        SalesPersonBean salesPersonBean = new SalesPersonBean();
        salesPersonBean.setCode(AddSalesPersonFrame.txt1.getText());
        salesPersonBean.setStatus(AddSalesPersonFrame.ddl1.getSelectedIndex() == 0 ? 1 : 0);
        salesPersonBean.setName(AddSalesPersonFrame.txt2.getText());
        salesPersonBean.setAddress(AddSalesPersonFrame.txt3.getText());
        salesPersonBean.setUnitNo(AddSalesPersonFrame.txt4.getText());
        salesPersonBean.setCity(AddSalesPersonFrame.txt5.getText());
        salesPersonBean.setPresentState(AddSalesPersonFrame.txt6.getText());
        salesPersonBean.setPostalCode(AddSalesPersonFrame.txt7.getText());
        salesPersonBean.setPhoneNo(AddSalesPersonFrame.txt8.getText());
        salesPersonBean.setExt(AddSalesPersonFrame.txt9.getText());
        salesPersonBean.setFaxNo(AddSalesPersonFrame.txt10.getText());
        salesPersonBean.setSalesPersonPrefix(AddSalesPersonFrame.txt11.getText());
        salesPersonBean.setPagerNo(AddSalesPersonFrame.txt12.getText());
        salesPersonBean.setCellularNo(AddSalesPersonFrame.txt13.getText());
        salesPersonBean.setEmail(AddSalesPersonFrame.txt14.getText());
        salesPersonBean.setArCdn(AddSalesPersonFrame.txt15.getText());
        salesPersonBean.setArUs(AddSalesPersonFrame.txt16.getText());
        salesPersonBean.setBaseSalary(Double.parseDouble(AddSalesPersonFrame.txt17.getText()));
        salesPersonBean.setPaid(AddSalesPersonFrame.ddl3.getSelectedIndex());
        salesPersonBean.setPercentOnApplicableRevenue(AddSalesPersonFrame.txt18.getText());
        salesPersonBean.setPercentOnGrossProfit(AddSalesPersonFrame.txt19.getText());
        salesPersonBean.setMaxCommissionPaid(AddSalesPersonFrame.txt20.getText());
        String msg = "";
        if (SalesPersonUIHelper.addUpdateFlag.equals("add")) {
            int i = salesPersonDAO.addSalesPerson(salesPersonBean);
            if (i > 0) {
                msg = "New SalesPerson Added";
            }
        } else {
            salesPersonBean.setPersonId(salesPersonId);
            msg = salesPersonDAO.updateSalesPerson(salesPersonBean);
        }
        lstSalesPersons = salesPersonDAO.getAllSalesPersons(SalesPersonPanel.txtSearch.getText());
        generateTable();
        JOptionPane.showMessageDialog(null, msg);
    }

    class SalesPersonTable extends DefaultTableCellRenderer {

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
