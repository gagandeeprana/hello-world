/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.helper.common;

import dpu.beans.admin.ShippermasterBean;
import dpu.dao.admin.ShipperDAO;
import dpu.dao.admin.impl.ShipperDAOImpl;
import dpu.ui.shipper.NewShipperFrame;
import dpu.ui.shipper.TestShipperPannel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
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

    public String addUpdateFlag = "";
    ArrayList<ShippermasterBean> arrayList = null;
    ShipperDAO shipperDAO = new ShipperDAOImpl();

    class ShipperTable implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
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

    public void generateTable() {
        arrayList = new ArrayList<>();
        arrayList = shipperDAO.getAllShipper(TestShipperPannel.txtShipperSearch.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestShipperPannel.tblShipper = new JTable(defaultTableModel);
        TestShipperPannel.tblShipper.setDefaultRenderer(Object.class, new ShipperUIHelper.ShipperTable());
        Object[][] data = new Object[arrayList.size()][22];
        for (int i = 0; i < arrayList.size(); i++) {
            ShippermasterBean obj = arrayList.get(i);
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
        shippermasterBean.setTimeZone(NewShipperFrame.ddlTimeZone.getSelectedItem().toString());
        shippermasterBean.setTollFree(NewShipperFrame.txtTollFree.getText());
        shippermasterBean.setUnit(NewShipperFrame.txtUnitNo.getText());
        shippermasterBean.setZone(NewShipperFrame.txtZone.getText());
        ShipperDAO shipperDAO = new ShipperDAOImpl();
        String msg = "";
        msg = shipperDAO.addShipper(shippermasterBean);
        return msg;
    }
}
