/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common.helper;

import dpu.beans.admin.ShippermasterBean;
import dpu.dao.admin.ShipperDAO;
import dpu.dao.admin.impl.ShipperDAOImpl;
import dpu.ui.shipper.Directions;
import dpu.ui.shipper.NewShipperFrame;
import dpu.ui.shipper.NotePad;
import dpu.ui.shipper.TestShipperPannel;
import dpu.ui.terminal.AddTerminal;
import dpu.ui.terminal.LocationFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author jagvir
 */
public class ShipperUIHelper {

    public static String addUpdateFlag = "";
    public static ArrayList<ShippermasterBean> shipperList = null;
    ShipperDAO shipperDAO = null;
    public static int shipperId = 0;

    public ShipperUIHelper() {
        shipperDAO = new ShipperDAOImpl();
    }

    class ShipperTable implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JTextField editor = new JTextField();
            editor.setFont(new Font(Font.SANS_SERIF, 0, 15));
            editor.setBorder(null);
            if (value != null) {
                //here space is given to provide some left margin while showing data on textfield..
                editor.setText("   " + value.toString());
            }
//            if (row % 2 == 0) {
//                Border border = BorderFactory.createLineBorder(Color.WHITE, 4);
//                editor.setBorder(border);
//
//            } else {
//                Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4);
//                editor.setBorder(border);
//
//            }
//            editor.setBackground((row % 2 == 0) ? Color.white : Color.LIGHT_GRAY);
            Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
            editor.setBorder(border);
            editor.setBackground(Color.white);
            if (isSelected) {
                border = BorderFactory.createLineBorder(Color.CYAN, 4);
                editor.setBorder(border);
                editor.setBackground(Color.CYAN);
            }
            return editor;
        }
    }

    public void generateTable() {
//        shipperList = new ArrayList<>();
        shipperList = shipperDAO.getAllShipper(TestShipperPannel.txtShipperSearch.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestShipperPannel.tblShipper = new JTable(defaultTableModel);
        TestShipperPannel.tblShipper.getTableHeader().setBackground(Color.red);
        TestShipperPannel.tblShipper.setDefaultRenderer(Object.class, new ShipperUIHelper.ShipperTable());
        Object[][] data = new Object[shipperList.size()][22];
        for (int i = 0; i < shipperList.size(); i++) {
            ShippermasterBean obj = shipperList.get(i);
            data[i][0] = obj.getCity();
            data[i][1] = obj.getAddress();
            data[i][2] = obj.getUnit();
            data[i][3] = obj.getCity();
            data[i][4] = obj.getProvinceState();
            data[i][5] = obj.getPostalZip();
            data[i][6] = obj.getZone();
            data[i][7] = obj.getContact();
            data[i][8] = obj.getPosition();
            data[i][9] = obj.getPhone();
            data[i][10] = obj.getExt();
            data[i][11] = obj.getFax();
            data[i][12] = "---";
            data[i][13] = "createdBY";
            data[i][14] = obj.getEmail();
            TestShipperPannel.tblShipper.setRowHeight(30);
        }
        Object[] cols = {"Location Name", "Address", "Unit No", "City", "P/S", "Postal/Zip", "Zone", "Main Contact", "Position", "Phone", "Extension", "Fax", "Watts", "Created By", "Email"};
        defaultTableModel.setDataVector(data, cols);
        TestShipperPannel.tblShipper.getTableHeader().setBackground(Color.red);
        TestShipperPannel.tblShipper.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        TestShipperPannel.tblShipper.getTableHeader().setForeground(Color.DARK_GRAY);
        TestShipperPannel.tblShipper.setIntercellSpacing(new Dimension(0, 0));
        TestShipperPannel.tblShipper.setShowGrid(false);
        TestShipperPannel.jScrollPane4.setViewportView(TestShipperPannel.tblShipper);
    }

    public String save() {
        ShippermasterBean shippermasterBean = new ShippermasterBean();
        shippermasterBean.setAddress(NewShipperFrame.txtAddress.getText());
        shippermasterBean.setCity(NewShipperFrame.txtCity.getText());
        shippermasterBean.setCompany(NewShipperFrame.txtCompany.getText());
        shippermasterBean.setContact(NewShipperFrame.txtContact.getText());
        shippermasterBean.setEmail(NewShipperFrame.txtEmail.getText());
        shippermasterBean.setExt(NewShipperFrame.txtExt.getText());
        shippermasterBean.setFax(NewShipperFrame.txtFax.getText());
        shippermasterBean.setCellNumber(NewShipperFrame.txtCellNumber.getText());
        shippermasterBean.setImporter(NewShipperFrame.txtImporter.getText());
        shippermasterBean.setInternalNotes(NewShipperFrame.txtInternalNotes.getText());
        shippermasterBean.setLeadTime(NewShipperFrame.txtLeadTime.getText());
        shippermasterBean.setPhone(NewShipperFrame.txtPhone.getText());
        shippermasterBean.setPlant(NewShipperFrame.txtPlant.getText());
        shippermasterBean.setPosition(NewShipperFrame.txtPosition.getText());
        shippermasterBean.setPostalZip(NewShipperFrame.txtPostalZip.getText());
        shippermasterBean.setPrefix(NewShipperFrame.txtPrefix.getText());
        shippermasterBean.setProvinceState(NewShipperFrame.txtProvinceState.getText());
        shippermasterBean.setStandardNotes(NewShipperFrame.txtStandardNotes.getText());
        if (NewShipperFrame.ddlStatus.equals("Active")) {
            shippermasterBean.setStatus(1);
        } else {
            shippermasterBean.setStatus(0);
        }
//        shippermasterBean.setReport(LocationReports.ddlReport.getSelectedItem().toString());
//        shippermasterBean.setReportName(LocationReports.ddlReportName.getSelectedItem().toString());

//        shippermasterBean.setStatus(NewShipperFrame.ddlStatus.getSelectedItem().toString());
        shippermasterBean.setTimeZone(NewShipperFrame.ddlTimeZone.getSelectedItem().toString());
        shippermasterBean.setTollFree(NewShipperFrame.txtTollFree.getText());
        shippermasterBean.setUnit(NewShipperFrame.txtUnitNo.getText());
        shippermasterBean.setZone(NewShipperFrame.txtZone.getText());
        shippermasterBean.setDirections(Directions.taDirections.getText());
        shippermasterBean.setDateStamp(NotePad.taDateStamp.getText());
        shippermasterBean.setShipperId(ShipperUIHelper.shipperId);
        System.out.println("id:::::::" + ShipperUIHelper.shipperId);
        ShipperDAO shipperDAO = new ShipperDAOImpl();
        String msg = "";
        if (ShipperUIHelper.addUpdateFlag.equalsIgnoreCase("add")) {
            msg = shipperDAO.addShipper(shippermasterBean);
        }
        if (ShipperUIHelper.addUpdateFlag.equalsIgnoreCase("update")) {
            msg = shipperDAO.updateShipper(shippermasterBean);
        }

        return msg;
    }

    public String saveShippingReceiving() {
        String msg = null;
        shipperDAO.addShippingHours(ShippingReceivingHoursUIHelper.listOfReceivingHours, ShippingReceivingHoursUIHelper.listOfShippingHours);
        if (ShipperUIHelper.addUpdateFlag.equalsIgnoreCase("update")) {

        }
        if (ShipperUIHelper.addUpdateFlag.equalsIgnoreCase("add")) {
            msg = shipperDAO.addShippingHours(ShippingReceivingHoursUIHelper.listOfReceivingHours, ShippingReceivingHoursUIHelper.listOfShippingHours);

        }
        return msg;
    }

    public String deleteShipper(int shipperId) {
        String msg = shipperDAO.deleteShipper(shipperId);
        generateTable();
        return msg;
    }

    public String updateShipper(ShippermasterBean shippermasterBean) {
        String msg = shipperDAO.updateShipper(shippermasterBean);
        generateTable();
        return msg;
    }

    public void generateLocationTable() {
        shipperList = shipperDAO.getAllShipper(AddTerminal.txtLocation.getText());
        System.out.println("dasd " + AddTerminal.txtLocation.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        LocationFrame.tblLocation = new JTable(defaultTableModel);
        LocationFrame.tblLocation.setAutoCreateRowSorter(true);
        //LocationFrame.tblLocation.getTableHeader().setBackground(Color.red);
        LocationFrame.tblLocation.setDefaultRenderer(Object.class, new ShipperUIHelper.ShipperTable());
        System.out.println("sizeshipper" + shipperList.size());
        Object[][] data = new Object[shipperList.size()][22];
        for (int i = 0; i < shipperList.size(); i++) {
            ShippermasterBean obj = shipperList.get(i);
            data[i][0] = obj.getCompany();
            data[i][1] = obj.getAddress();
            data[i][2] = obj.getUnit();
            data[i][3] = obj.getCity();
            data[i][4] = obj.getProvinceState();
            data[i][5] = obj.getPostalZip();
            LocationFrame.tblLocation.setRowHeight(20);
        }
        Object[] cols = {"Location Name", "Address", "Unit No", "City", "P/S", "Postal/Zip"};
        defaultTableModel.setDataVector(data, cols);
        //  LocationFrame.tblLocation.getTableHeader().setBackground(Color.DARK_GRAY);
        LocationFrame.tblLocation.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        LocationFrame.tblLocation.getTableHeader().setForeground(Color.DARK_GRAY);
        TableCellRenderer renderer = LocationFrame.tblLocation.getTableHeader().getDefaultRenderer();
        JLabel label = (JLabel) renderer;
        label.setHorizontalAlignment(JLabel.LEFT);
        LocationFrame.tblLocation.setIntercellSpacing(new Dimension(0, 0));
        LocationFrame.tblLocation.setShowGrid(false);
        LocationFrame.tblLocation.setShowVerticalLines(true);
        LocationFrame.jScrollPane1.setViewportView(LocationFrame.tblLocation);
    }
}
