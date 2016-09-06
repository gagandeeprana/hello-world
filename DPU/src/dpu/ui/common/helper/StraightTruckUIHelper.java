package dpu.ui.common.helper;

import dpu.beans.admin.StraightTruckBean;
import dpu.dao.admin.StraightTruckDAO;
import dpu.dao.admin.impl.StraightTruckDAOImpl;
//import dpu.ui.common.AddStraightTruckFrame;
import dpu.ui.common.TestStraightTruckPanel;
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

public class StraightTruckUIHelper extends DefaultTableCellRenderer {

    public String addUpdateFlag = "";
    int straighttruckmasterId = 0;
    String straighttruckmasterName;
    StraightTruckDAO straighttruckmasterDAO = new StraightTruckDAOImpl();
    List<StraightTruckBean> lstStraightTrucks = null;
    int straighttruckmasterIdToBeDeleted = 0;
    String msg = "";

    public void clear() {
        TestStraightTruckPanel.txtSearchManageStraightTruck.setText("");
    }

    public void disable(boolean var) {
//        mainTabbedPane.setEnabled(var);
//        TestStraightTruckPanel.straighttruckmasterPanel.setEnabled(var);
        TestStraightTruckPanel.tblStraightTruck.setEnabled(var);
        TestStraightTruckPanel.btnAddManageStraightTruck.setEnabled(var);
        TestStraightTruckPanel.btnPrintManageStraightTruck.setEnabled(var);
        TestStraightTruckPanel.txtSearchManageStraightTruck.setEnabled(var);
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
            straighttruckmasterIdToBeDeleted = lstStraightTrucks.get(row).getUnitNo();
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
            straighttruckmasterIdToBeDeleted = lstStraightTrucks.get(row).getUnitNo();
            straighttruckmasterId = lstStraightTrucks.get(row).getUnitNo();
            straighttruckmasterName = lstStraightTrucks.get(row).getPlateNo();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                StraightTruckBean straighttruckmasterBean = new StraightTruckBean();
                straighttruckmasterBean.setUnitNo(straighttruckmasterId);
//                straighttruckmasterBean.setName(straighttruckmasterName);
//                AddStraightTruckFrame addStraightTruckFrame = new AddStraightTruckFrame(straighttruckmasterBean);
//                addStraightTruckFrame.setVisible(true);
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
        lstStraightTrucks = straighttruckmasterDAO.getAllStraightTrucks(TestStraightTruckPanel.txtSearchManageStraightTruck.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestStraightTruckPanel.tblStraightTruck = new JTable(defaultTableModel);
        TestStraightTruckPanel.tblStraightTruck.setDefaultRenderer(Object.class, new StraightTruckTable());
        Object[][] data = new Object[lstStraightTrucks.size()][21];
        for (int i = 0; i < lstStraightTrucks.size(); i++) {
            StraightTruckBean obj = lstStraightTrucks.get(i);
            data[i][0] = obj.getUnitNo();
            data[i][1] = obj.getStraightTruckClass();
            data[i][2] = obj.getVIN();
            data[i][3] = obj.getMake();
            data[i][4] = obj.getModel();
            data[i][5] = obj.getYear();
            data[i][6] = obj.getPlateNo();
            data[i][7] = obj.getJurisdiction();
            data[i][8] = obj.getTareWeight();
            data[i][9] = obj.getRgw();
            data[i][10] = obj.getTrackingId();
            data[i][11] = obj.getCurrentOdometer();
            data[i][12] = obj.getReadingTaken();
            data[i][13] = obj.getCreatedBy();
            data[i][14] = obj.getCreatedOn();
            data[i][15] = obj.getDivision();
            data[i][16] = obj.getTerminalId();
            data[i][17] = obj.getCategoryId();
            data[i][18] = obj.getIFTAAccount();
            data[i][19] = "";
            data[i][20] = "";
            TestStraightTruckPanel.tblStraightTruck.setRowHeight(30);
        }
        Object[] cols = {"Unit No", "Class", "VIN", "Make", "Model", "Year", "Plate No", "Jurisdiction", "Tare Weight", "RGW", "Tracking Id", "Current Odometer", "Reading Taken", "Created By", "Created On", "Division", "Terminal Id", "Category Id", "IFTA Account", "Class", " ", "  "};
        defaultTableModel.setDataVector(data, cols);
        TestStraightTruckPanel.tblStraightTruck.getColumn(" ").setCellRenderer(new ButtonRenderer());
        TestStraightTruckPanel.tblStraightTruck.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        TestStraightTruckPanel.tblStraightTruck.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        TestStraightTruckPanel.tblStraightTruck.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        TestStraightTruckPanel.tblStraightTruck.getColumn(" ").setMaxWidth(25);
        TestStraightTruckPanel.tblStraightTruck.getColumn("  ").setMaxWidth(25);
        TestStraightTruckPanel.tblStraightTruck.setIntercellSpacing(new Dimension(0, 0));
        TestStraightTruckPanel.tblStraightTruck.setShowGrid(false);
        TestStraightTruckPanel.jScrollPane9.setViewportView(TestStraightTruckPanel.tblStraightTruck);
    }

    public String save() {
        StraightTruckBean obj = new StraightTruckBean();
//        obj.setStraightTruckId(Integer.parseInt(AddStraightTruckFrame.txtStraightTruckIdAddStraightTruck.getText()));
//        obj.setName(AddStraightTruckFrame.txtStraightTruckNameAddStraightTruck.getText());
        StraightTruckDAO straighttruckmasterDAO = new StraightTruckDAOImpl();
        String msg = straighttruckmasterDAO.addStraightTruck(obj);
        disable(true);
        generateTable();
//        TestStraightTruckPanel.mainTabbedPane.setEnabled(true);
//        TestStraightTruckPanel.straighttruckmasterPanel.setEnabled(true);
        return msg;
    }

    public String delete() {
        StraightTruckDAO straighttruckmasterDAO = new StraightTruckDAOImpl();
        String msg = straighttruckmasterDAO.deleteStraightTruck(straighttruckmasterIdToBeDeleted);
        disable(true);
        generateTable();
//        TestStraightTruckPanel.mainTabbedPane.setEnabled(true);
//        TestStraightTruckPanel.straighttruckmasterPanel.setEnabled(true);
        return msg;
    }

    public String update(StraightTruckBean straighttruckmasterBean) {
        StraightTruckDAO divisionDAO = new StraightTruckDAOImpl();
        String msg = divisionDAO.updateStraightTruck(straighttruckmasterBean);
        disable(true);
        generateTable();
//        TestStraightTruckPanel.mainTabbedPane.setEnabled(true);
//        TestStraightTruckPanel.straighttruckmasterPanel.setEnabled(true);
        return msg;
    }

    class StraightTruckTable implements TableCellRenderer {

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
