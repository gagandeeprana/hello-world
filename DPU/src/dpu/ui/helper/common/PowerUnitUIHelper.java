package dpu.ui.helper.common;

import dpu.beans.admin.PowerUnitBean;
import dpu.dao.admin.PowerUnitDAO;
import dpu.dao.admin.impl.PowerUnitDAOImpl;
//import dpu.ui.common.AddPowerUnitFrame;
import dpu.ui.common.TestPowerUnitPanel;
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
import properties.ReadFromPropertiesFile;

public class PowerUnitUIHelper extends DefaultTableCellRenderer {

    public String addUpdateFlag = "";
    int powerunitId = 0;
    String powerunitName;
    PowerUnitDAO powerunitDAO = new PowerUnitDAOImpl();
    List<PowerUnitBean> lstPowerUnits = null;
    int powerunitIdToBeDeleted = 0;
    String msg = "";

    public void clear() {
        TestPowerUnitPanel.txtSearchManagePowerUnit.setText("");
    }

    public void disable(boolean var) {
//        mainTabbedPane.setEnabled(var);
//        TestPowerUnitPanel.powerunitPanel.setEnabled(var);
        TestPowerUnitPanel.tblPowerUnit.setEnabled(var);
        TestPowerUnitPanel.btnAddManagePowerUnit.setEnabled(var);
        TestPowerUnitPanel.btnPrintManagePowerUnit.setEnabled(var);
        TestPowerUnitPanel.txtSearchManagePowerUnit.setEnabled(var);
    }

    public class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
                setForeground(table.getSelectionForeground());
//                setBackground(table.getSelectionBackground());
                setBackground(Color.WHITE);
                setContentAreaFilled(false);
            } else {
                setForeground(table.getForeground());
                setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
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
                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));

            }
            powerunitIdToBeDeleted = lstPowerUnits.get(row).getUnitNo();
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
                setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
                setForeground(table.getSelectionForeground());
                setBackground(Color.WHITE);
                setContentAreaFilled(false);
            } else {
                setForeground(table.getForeground());
                setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
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
                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
                button.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
            }
            powerunitIdToBeDeleted = lstPowerUnits.get(row).getUnitNo();
            powerunitId = lstPowerUnits.get(row).getUnitNo();
            powerunitName = lstPowerUnits.get(row).getPlateNo();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                PowerUnitBean powerunitBean = new PowerUnitBean();
                powerunitBean.setUnitNo(powerunitId);
//                powerunitBean.setName(powerunitName);
//                AddPowerUnitFrame addPowerUnitFrame = new AddPowerUnitFrame(powerunitBean);
//                addPowerUnitFrame.setVisible(true);
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
        lstPowerUnits = powerunitDAO.getAllPowerUnits(TestPowerUnitPanel.txtSearchManagePowerUnit.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestPowerUnitPanel.tblPowerUnit = new JTable(defaultTableModel);
        TestPowerUnitPanel.tblPowerUnit.setDefaultRenderer(Object.class, new PowerUnitTable());
        Object[][] data = new Object[lstPowerUnits.size()][18];
        for (int i = 0; i < lstPowerUnits.size(); i++) {
            PowerUnitBean obj = lstPowerUnits.get(i);
            data[i][0] = obj.getUnitNo();
            data[i][1] = obj.getStatus();
            data[i][2] = obj.getPowerUnitClass();
            data[i][3] = obj.getOwnerId();
            data[i][4] = obj.getVIN();
            data[i][5] = obj.getMake();
            data[i][6] = obj.getModel();
            data[i][7] = obj.getYear();
            data[i][8] = obj.getPlateNo();
            data[i][9] = obj.getJurisdiction();
            data[i][10] = obj.getTareWeight();
            data[i][11] = obj.getRgw();
            data[i][12] = obj.getTrackingId();
            data[i][13] = obj.getCurrentOdometer();
            data[i][14] = obj.getEquipmentType();
            data[i][15] = obj.getTerminalId();
            data[i][16] = "";
            data[i][17] = "";
            TestPowerUnitPanel.tblPowerUnit.setRowHeight(30);
        }
        Object[] cols = {"Unit No","Status", "Class","Owner Id", "VIN", "Make", "Model", "Truck Year", "Plate No", "Jurisdiction", "Tare Weight", "RGW", "Tracking Id", "Current Odometer", "Equipment Type", "Terminal Id"," ", "  "};
        defaultTableModel.setDataVector(data, cols);
        TestPowerUnitPanel.tblPowerUnit.getColumn(" ").setCellRenderer(new ButtonRenderer());
        TestPowerUnitPanel.tblPowerUnit.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        TestPowerUnitPanel.tblPowerUnit.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        TestPowerUnitPanel.tblPowerUnit.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        TestPowerUnitPanel.tblPowerUnit.getColumn(" ").setMaxWidth(25);
        TestPowerUnitPanel.tblPowerUnit.getColumn("  ").setMaxWidth(25);
        TestPowerUnitPanel.tblPowerUnit.setIntercellSpacing(new Dimension(0, 0));
        TestPowerUnitPanel.tblPowerUnit.setShowGrid(false);
        TestPowerUnitPanel.jScrollPane9.setViewportView(TestPowerUnitPanel.tblPowerUnit);
    }

    public String save() {
        PowerUnitBean obj = new PowerUnitBean();
//        obj.setPowerUnitId(Integer.parseInt(AddPowerUnitFrame.txtPowerUnitIdAddPowerUnit.getText()));
//        obj.setName(AddPowerUnitFrame.txtPowerUnitNameAddPowerUnit.getText());
        PowerUnitDAO powerunitDAO = new PowerUnitDAOImpl();
        String msg = powerunitDAO.addPowerUnit(obj);
        disable(true);
        generateTable();
//        TestPowerUnitPanel.mainTabbedPane.setEnabled(true);
//        TestPowerUnitPanel.powerunitPanel.setEnabled(true);
        return msg;
    }

    public String delete() {
        PowerUnitDAO powerunitDAO = new PowerUnitDAOImpl();
        String msg = powerunitDAO.deletePowerUnit(powerunitIdToBeDeleted);
        disable(true);
        generateTable();
//        TestPowerUnitPanel.mainTabbedPane.setEnabled(true);
//        TestPowerUnitPanel.powerunitPanel.setEnabled(true);
        return msg;
    }

    public String update(PowerUnitBean powerunitBean) {
        PowerUnitDAO divisionDAO = new PowerUnitDAOImpl();
        String msg = divisionDAO.updatePowerUnit(powerunitBean);
        disable(true);
        generateTable();
//        TestPowerUnitPanel.mainTabbedPane.setEnabled(true);
//        TestPowerUnitPanel.powerunitPanel.setEnabled(true);
        return msg;
    }

    class PowerUnitTable implements TableCellRenderer {

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
