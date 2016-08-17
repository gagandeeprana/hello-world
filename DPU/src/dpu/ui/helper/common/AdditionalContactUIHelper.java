package dpu.ui.helper.common;

import dpu.beans.admin.AdditionalContactBean;
import dpu.dao.admin.AdditionalContactDAO;
import dpu.dao.admin.impl.AdditionalContactDAOImpl;
import dpu.ui.common.AddAdditionalContact;
import dpu.ui.common.AddCustomerFrame;
import java.awt.Color;
//import static dpu.ui.common.TestAdditionalContactPanel.mainTabbedPane;
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

public class AdditionalContactUIHelper {

    public static String addUpdateFlag = "add";
    static int additionalContactId = 0;
    AdditionalContactDAO additionalContactDAO = new AdditionalContactDAOImpl();
    List<AdditionalContactBean> lstAdditionalContacts = null;
    int additionalContactIdToBeDeleted = 0;
    String msg = "";
    AdditionalContactBean additionalContactBean = null;

    public void clear() {
//        TestAdditionalContactPanel.txtAdditionalContactSearch.setText("");
    }

    public void disable(boolean var) {
//        TestAdditionalContactPanel.tblAdditionalContact.setEnabled(var);
//        TestAdditionalContactPanel.lblAddManageAdditionalContact.setEnabled(var);
//        TestAdditionalContactPanel.lblPrintManageAdditionalContact.setEnabled(var);
//        TestAdditionalContactPanel.txtAdditionalContactSearch.setEnabled(var);
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
//            additionalContactIdToBeDeleted = lstCompanies.get(row).getAdditionalContactId();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                delete(0);
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
            additionalContactIdToBeDeleted = lstAdditionalContacts.get(row).getAdditionalContactId();
            additionalContactId = lstAdditionalContacts.get(row).getAdditionalContactId();
            additionalContactBean = additionalContactDAO.getAdditionalContactInfoById(additionalContactId);
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                addUpdateFlag = "update";
//                AddAdditionalContact addCustomerFrame = new AddAdditionalContact(additionalContactBean);
//                addCustomerFrame.setVisible(true);
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
        Object[] cols = {"Customer Name", "Phone", "Ext", "Cell Phone", "Email", "Fax", " ", "  "};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        AddCustomerFrame.tblAdditionalContacts.setModel(defaultTableModel);
        AddCustomerFrame.tblAdditionalContacts.setDefaultRenderer(Object.class, new AdditionalContactUIHelper.AdditionalContactTable());
        if (AddCustomerFrame.lstAdditionalContacts.size() > 0) {

            Object[][] data = new Object[AddCustomerFrame.lstAdditionalContacts.size()][8];
            for (int i = 0; i < AddCustomerFrame.lstAdditionalContacts.size(); i++) {
                AdditionalContactBean obj = AddCustomerFrame.lstAdditionalContacts.get(i);
                data[i][0] = obj.getCustomerName();
                data[i][1] = obj.getPhone();
                data[i][2] = obj.getExt();
                data[i][3] = obj.getPhone();
                data[i][4] = obj.getEmail();
                data[i][5] = obj.getFax();
                data[i][6] = "";
                data[i][7] = "";
                AddCustomerFrame.tblAdditionalContacts.setRowHeight(30);
            }
            defaultTableModel.setDataVector(data, cols);
            AddCustomerFrame.tblAdditionalContacts.getTableHeader().setBackground(Color.red);

            AddCustomerFrame.tblAdditionalContacts.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            AddCustomerFrame.tblAdditionalContacts.getTableHeader().setForeground(Color.DARK_GRAY);
            AddCustomerFrame.tblAdditionalContacts.getColumn(" ").setCellRenderer(new ButtonRenderer());
            AddCustomerFrame.tblAdditionalContacts.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
            AddCustomerFrame.tblAdditionalContacts.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
            AddCustomerFrame.tblAdditionalContacts.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
            AddCustomerFrame.tblAdditionalContacts.getColumn(" ").setMaxWidth(25);
            AddCustomerFrame.tblAdditionalContacts.getColumn("  ").setMaxWidth(25);
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
        AddCustomerFrame.tblAdditionalContacts.getTableHeader().setBackground(Color.red);

        AddCustomerFrame.tblAdditionalContacts.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        AddCustomerFrame.tblAdditionalContacts.getTableHeader().setForeground(Color.DARK_GRAY);
        AddCustomerFrame.tblAdditionalContacts.setIntercellSpacing(new Dimension(0, 0));
        AddCustomerFrame.tblAdditionalContacts.setShowGrid(false);
        AddCustomerFrame.ScrollPanetblAdditionalContacts.setViewportView(AddCustomerFrame.tblAdditionalContacts);
    }

    public String save() {
        AdditionalContactBean additionalContactBean = new AdditionalContactBean();
//        additionalContactBean.setContactId(AddAdditionalContact.txtCustomer.getText());
        additionalContactBean.setCustomerName(AddAdditionalContact.txtCustomer.getText());
        additionalContactBean.setAddress(AddAdditionalContact.txtAddress.getText());
        additionalContactBean.setPhone(AddAdditionalContact.txtPhone.getText());
        additionalContactBean.setExt(AddAdditionalContact.txtExt.getText());
        additionalContactBean.setFax(AddAdditionalContact.txtFax.getText());
        additionalContactBean.setPrefix(AddAdditionalContact.txtPrefix.getText());
        if (AddAdditionalContact.ddlProvinceState.getSelectedIndex() == 0) {
            additionalContactBean.setProvinceState(0);
        } else {
            additionalContactBean.setProvinceState(1);
        }
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
//        TestAdditionalContactPanel.mainTabbedPane.setEnabled(true);
//        TestAdditionalContactPanel.additionalContactPanel.setEnabled(true);
        return msg;
    }

    public void saveToList(int index) {
        AdditionalContactBean additionalContactBean = new AdditionalContactBean();
        additionalContactBean.setCustomerName(AddAdditionalContact.txtCustomer.getText());
        additionalContactBean.setAddress(AddAdditionalContact.txtAddress.getText());
        additionalContactBean.setPhone(AddAdditionalContact.txtPhone.getText());
        additionalContactBean.setExt(AddAdditionalContact.txtExt.getText());
        additionalContactBean.setFax(AddAdditionalContact.txtFax.getText());
        additionalContactBean.setPrefix(AddAdditionalContact.txtPrefix.getText());
        if (AddAdditionalContact.ddlProvinceState.getSelectedIndex() == 0) {
            additionalContactBean.setProvinceState(0);
        } else {
            additionalContactBean.setProvinceState(1);
        }
        if (AddAdditionalContact.ddlStatus.getSelectedIndex() == 0) {
            additionalContactBean.setStatus(0);
        } else {
            additionalContactBean.setStatus(1);
        }
        additionalContactBean.setEmail(AddAdditionalContact.txtEmail.getText());
        AddCustomerFrame.lstAdditionalContacts.add(index, additionalContactBean);
        generateTable();
    }

    public String delete(int additionalContactIdToBeDeleted) {
        AdditionalContactDAO additionalContactDAO = new AdditionalContactDAOImpl();
        String msg = additionalContactDAO.deleteAdditionalContact(additionalContactIdToBeDeleted);
        disable(true);
        generateTable();
//        TestAdditionalContactPanel.mainTabbedPane.setEnabled(true);
//        TestAdditionalContactPanel.additionalContactPanel.setEnabled(true);
        return msg;
    }

    public String update(AdditionalContactBean additionalContactBean) {
        AdditionalContactDAO additionalContactDAO = new AdditionalContactDAOImpl();
        String msg = additionalContactDAO.updateAdditionalContact(additionalContactBean);
        disable(true);
        generateTable();
//        TestAdditionalContactPanel.mainTabbedPane.setEnabled(true);
//        TestAdditionalContactPanel.additionalContactPanel.setEnabled(true);
        return msg;
    }

    class AdditionalContactTable implements TableCellRenderer {

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
