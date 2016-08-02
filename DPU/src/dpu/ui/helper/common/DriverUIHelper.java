package dpu.ui.helper.common;

import dpu.beans.admin.DriverBean;
import dpu.dao.admin.DriverDAO;
import dpu.dao.admin.impl.DriverDAOImpl;
//import dpu.ui.common.AddDriverFrame;
import dpu.ui.common.TestDriverPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class DriverUIHelper extends DefaultTableCellRenderer {

    public String addUpdateFlag = "";
    int driverId = 0;
    String driverName;
    DriverDAO driverDAO = new DriverDAOImpl();
    List<DriverBean> lstDrivers = null;
    int driverIdToBeDeleted = 0;
    String msg = "";

    public void clear() {
        TestDriverPanel.txtSearchManageDriver.setText("");
    }

    public void disable(boolean var) {
//        mainTabbedPane.setEnabled(var);
//        TestDriverPanel.driverPanel.setEnabled(var);
        TestDriverPanel.tblDriver.setEnabled(var);
        TestDriverPanel.btnAddManageDriver.setEnabled(var);
        TestDriverPanel.btnPrintManageDriver.setEnabled(var);
        TestDriverPanel.txtSearchManageDriver.setEnabled(var);
    }

    public class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setIcon(new ImageIcon("src\\dpu\\ui\\common\\Delete.png"));
                setForeground(table.getSelectionForeground());
//                setBackground(table.getSelectionBackground());
                setBackground(Color.WHITE);
                setContentAreaFilled(false);
            } else {
                setForeground(table.getForeground());
                setIcon(new ImageIcon("src\\dpu\\ui\\common\\Delete.png"));
//                setBackground(UIManager.getColor("Button.background"));
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
                button.setBackground(table.getSelectionBackground());
                button.setIcon(new ImageIcon("src\\dpu\\ui\\common\\Delete.png"));
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
                button.setIcon(new ImageIcon("src\\dpu\\ui\\common\\Delete.png"));

            }
            driverIdToBeDeleted = lstDrivers.get(row).getDriverId();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                msg = delete();
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
                setIcon(new ImageIcon("src\\dpu\\ui\\common\\Update.png"));
                setForeground(table.getSelectionForeground());
                setBackground(Color.WHITE);
                setContentAreaFilled(false);
            } else {
                setForeground(table.getForeground());
                setIcon(new ImageIcon("src\\dpu\\ui\\common\\Update.png"));
//                setBackground(UIManager.getColor("Button.background"));
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
                button.setBackground(table.getSelectionBackground());
                button.setIcon(new ImageIcon("src\\dpu\\ui\\common\\Update.png"));
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
                button.setIcon(new ImageIcon("src\\dpu\\ui\\common\\Update.png"));
            }
            driverIdToBeDeleted = lstDrivers.get(row).getDriverId();
            driverId = lstDrivers.get(row).getDriverId();
            driverName = lstDrivers.get(row).getFirstName();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                DriverBean driverBean = new DriverBean();
                driverBean.setDriverId(driverId);
//                driverBean.setName(driverName);
//                AddDriverFrame addDriverFrame = new AddDriverFrame(driverBean);
//                addDriverFrame.setVisible(true);
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
        lstDrivers = driverDAO.getAllDrivers(TestDriverPanel.txtSearchManageDriver.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestDriverPanel.tblDriver = new JTable(defaultTableModel);
        TestDriverPanel.tblDriver.setDefaultRenderer(Object.class, new DriverTable());
        Object[][] data = new Object[lstDrivers.size()][24];
        for (int i = 0; i < lstDrivers.size(); i++) {
            DriverBean obj = lstDrivers.get(i);
            data[i][0] = obj.getDriverId();
            data[i][1] = obj.getFirstName();
            data[i][2] = obj.getLastName();
            data[i][3] = obj.getDefTruck();
            data[i][4] = obj.getAddress();
            data[i][5] = obj.getHomePhone();
            data[i][6] = obj.getCellular();
            data[i][7] = obj.getPager();
            data[i][8] = obj.getStatus();
            data[i][9] = obj.getLastTrip();
            data[i][10] = obj.getLastETA();
            data[i][11] = obj.getLastEvent();
            data[i][12] = obj.getLastLocation();
            data[i][13] = obj.getLastCity();
            data[i][14] = obj.getLastState();
            data[i][15] = obj.getFaxNo();
            data[i][16] = obj.getDivisionId();
            data[i][17] = obj.getTerminalId();
            data[i][18] = obj.getCategoryId();
            data[i][19] = obj.getClassId();
            data[i][20] = obj.getZip();
            data[i][21] = obj.getRoleId();
            data[i][22] = "";
            data[i][23] = "";
            TestDriverPanel.tblDriver.setRowHeight(30);
        }
        Object[] cols = {"Driver Id", "First Name","Last Name","Def Truck","Address","Home Phone","Cellular","Pager","Status","Last Trip","Last ETA","Last Event","Last Location","Last City","Last State","Fax","Division","Terminal","Category","Class","Zip","Role", " ", "  "};
        defaultTableModel.setDataVector(data, cols);
        TestDriverPanel.tblDriver.getColumn(" ").setCellRenderer(new ButtonRenderer());
        TestDriverPanel.tblDriver.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        TestDriverPanel.tblDriver.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        TestDriverPanel.tblDriver.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        TestDriverPanel.tblDriver.getColumn(" ").setMaxWidth(25);
        TestDriverPanel.tblDriver.getColumn("  ").setMaxWidth(25);
        TestDriverPanel.tblDriver.setIntercellSpacing(new Dimension(0, 0));
        TestDriverPanel.tblDriver.setShowGrid(false);
        TestDriverPanel.jScrollPane9.setViewportView(TestDriverPanel.tblDriver);
    }

    public String save() {
        DriverBean obj = new DriverBean();
//        obj.setDriverId(Integer.parseInt(AddDriverFrame.txtDriverIdAddDriver.getText()));
//        obj.setName(AddDriverFrame.txtDriverNameAddDriver.getText());
        DriverDAO driverDAO = new DriverDAOImpl();
        String msg = driverDAO.addDriver(obj);
        disable(true);
        generateTable();
//        TestDriverPanel.mainTabbedPane.setEnabled(true);
//        TestDriverPanel.driverPanel.setEnabled(true);
        return msg;
    }

    public String delete() {
        DriverDAO driverDAO = new DriverDAOImpl();
        String msg = driverDAO.deleteDriver(driverIdToBeDeleted);
        disable(true);
        generateTable();
//        TestDriverPanel.mainTabbedPane.setEnabled(true);
//        TestDriverPanel.driverPanel.setEnabled(true);
        return msg;
    }

    public String update(DriverBean driverBean) {
        DriverDAO divisionDAO = new DriverDAOImpl();
        String msg = divisionDAO.updateDriver(driverBean);
        disable(true);
        generateTable();
//        TestDriverPanel.mainTabbedPane.setEnabled(true);
//        TestDriverPanel.driverPanel.setEnabled(true);
        return msg;
    }

    class DriverTable implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JTextField editor = new JTextField();
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
