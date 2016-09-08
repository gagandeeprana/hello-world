/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common.helper;

import dpu.beans.admin.AdditionalShippperContactBean;
import dpu.dao.admin.ShipperDAO;
import dpu.dao.admin.impl.ShipperDAOImpl;
import dpu.ui.shipper.AddContactForShipper;
import dpu.ui.shipper.AdditionaShipperlContacts;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
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
public class AdditionalShipperContactsHelper {
    
    public static String addUpdateFlag = "";
    public static List<AdditionalShippperContactBean> lstAdditionalContacts = null;
    ShipperDAO shipperDAO = null;
    
    public AdditionalShipperContactsHelper() {
        shipperDAO = new ShipperDAOImpl();
    }
    
    class ContactsTable implements TableCellRenderer {
        
        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
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
    
    public void generateTable() {
        lstAdditionalContacts = shipperDAO.getAllShipperContactsByShipperId(1);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        AdditionaShipperlContacts.tblShipperContacts = new JTable(defaultTableModel);
        AdditionaShipperlContacts.tblShipperContacts.getTableHeader().setBackground(Color.red);
        AdditionaShipperlContacts.tblShipperContacts.setDefaultRenderer(Object.class, new AdditionalShipperContactsHelper.ContactsTable());
        Object[][] data = new Object[lstAdditionalContacts.size()][6];
        for (int i = 0; i < lstAdditionalContacts.size(); i++) {
            AdditionalShippperContactBean obj = lstAdditionalContacts.get(i);
            data[i][0] = obj.getContactName();
            data[i][1] = obj.getPhone();
            data[i][2] = obj.getEmail();
            data[i][3] = obj.getCellular();
            data[i][4] = obj.getExt();
            data[i][5] = obj.getFax();
        }
        String col[] = new String[]{"ContactName", "Phone", "Email", "Cellular", "Ext", "Fax"};
        defaultTableModel.setDataVector(data, col);
        AdditionaShipperlContacts.tblShipperContacts.getTableHeader().setBackground(Color.red);
        AdditionaShipperlContacts.tblShipperContacts.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        AdditionaShipperlContacts.tblShipperContacts.getTableHeader().setForeground(Color.DARK_GRAY);
        AdditionaShipperlContacts.tblShipperContacts.setIntercellSpacing(new Dimension(0, 0));
        AdditionaShipperlContacts.tblShipperContacts.setShowGrid(false);
        AdditionaShipperlContacts.jScrollPane4.setViewportView(AdditionaShipperlContacts.tblShipperContacts);
    }
    
    public String addContact() {
        AdditionalShippperContactBean additionalShippperContactBean = new AdditionalShippperContactBean();
        additionalShippperContactBean.setCellular(AddContactForShipper.txtCellular.getText());
        additionalShippperContactBean.setContactName(AddContactForShipper.txtContactName.getText());
        additionalShippperContactBean.setEmail(AddContactForShipper.txtEmail.getText());
        additionalShippperContactBean.setExt(AddContactForShipper.txtExt.getText());
        additionalShippperContactBean.setFax(AddContactForShipper.txtFax.getText());
        additionalShippperContactBean.setPhone(AddContactForShipper.txtPhone.getText());
        additionalShippperContactBean.setPosition(AddContactForShipper.txtPosition.getText());
        additionalShippperContactBean.setPrefix(AddContactForShipper.txtPrefix.getText());
        if (AddContactForShipper.ddlStatus.getSelectedItem().equals("Active")) {
            additionalShippperContactBean.setStatus(1);
        } else {
            additionalShippperContactBean.setStatus(0);
            
        }
        String msg = shipperDAO.addAdditionalContact(additionalShippperContactBean);
        return msg;
    }
}
