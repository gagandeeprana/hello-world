package dpu.ui.helper.common;

import dpu.beans.admin.EquipmentBean;
import dpu.dao.admin.EquipmentDAO;
import dpu.dao.admin.impl.EquipmentDAOImpl;
import dpu.ui.common.AddEquipmentFrame;
import dpu.ui.common.TestEquipmentPanel;
//import static dpu.ui.common.TestEquipmentPanel.mainTabbedPane;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class EquipmentUIHelper {

    public String addUpdateFlag = "";
    int equipmentId = 0;
    String equipmentName;
    EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
    List<EquipmentBean> lstEquipments = null;
    int equipmentIdToBeDeleted = 0;
    String msg = "";

    public void clear() {
        TestEquipmentPanel.txtEquipmentSearch.setText("");
    }

    public void disable(boolean var) {
//        mainTabbedPane.setEnabled(var);
//        TestEquipmentPanel.equipmentPanel.setEnabled(var);
        TestEquipmentPanel.tblEquipment.setEnabled(var);
        TestEquipmentPanel.btnAddManageEquipment.setEnabled(var);
        TestEquipmentPanel.btnClearManageEquipment.setEnabled(var);
        TestEquipmentPanel.txtEquipmentSearch.setEnabled(var);
    }

    public class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
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
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            equipmentIdToBeDeleted = lstEquipments.get(row).getEquipmentId();
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
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
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
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            equipmentIdToBeDeleted = lstEquipments.get(row).getEquipmentId();
            equipmentId = lstEquipments.get(row).getEquipmentId();
            equipmentName = lstEquipments.get(row).getEquipmentName();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                EquipmentBean equipmentBean = new EquipmentBean();
                equipmentBean.setEquipmentId(equipmentId);
                equipmentBean.setEquipmentName(equipmentName);
                AddEquipmentFrame addEquipmentFrame = new AddEquipmentFrame(equipmentBean);
                addEquipmentFrame.setVisible(true);
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
        lstEquipments = equipmentDAO.getAllEquipments(TestEquipmentPanel.txtEquipmentSearch.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestEquipmentPanel.tblEquipment = new JTable(defaultTableModel);
        Object[][] data = new Object[lstEquipments.size()][4];
        for (int i = 0; i < lstEquipments.size(); i++) {
            EquipmentBean obj = lstEquipments.get(i);
            data[i][0] = obj.getEquipmentId();
            data[i][1] = obj.getEquipmentName();
            data[i][2] = "Remove";
            data[i][3] = "Update";
        }
        Object[] cols = {"Equipment Id", "Equipment Name", " ", "  "};
        defaultTableModel.setDataVector(data, cols);
        TestEquipmentPanel.tblEquipment.getColumn(" ").setCellRenderer(new ButtonRenderer());
        TestEquipmentPanel.tblEquipment.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        TestEquipmentPanel.tblEquipment.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        TestEquipmentPanel.tblEquipment.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        TestEquipmentPanel.jScrollPane5.setViewportView(TestEquipmentPanel.tblEquipment);
    }

    public String save() {
        EquipmentBean obj = new EquipmentBean();
        obj.setEquipmentId(Integer.parseInt(AddEquipmentFrame.txtEquipmentIdAddEquipment.getText()));
        obj.setEquipmentName(AddEquipmentFrame.txtEquipmentNameAddEquipment.getText());
        EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
        String msg = equipmentDAO.addEquipment(obj);
        disable(true);
        generateTable();
//        TestEquipmentPanel.mainTabbedPane.setEnabled(true);
//        TestEquipmentPanel.equipmentPanel.setEnabled(true);
        return msg;
    }

    public String delete() {
        EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
        String msg = equipmentDAO.deleteEquipment(equipmentIdToBeDeleted);
        disable(true);
        generateTable();
//        TestEquipmentPanel.mainTabbedPane.setEnabled(true);
//        TestEquipmentPanel.equipmentPanel.setEnabled(true);
        return msg;
    }

    public String update(EquipmentBean equipmentBean) {
        EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
        String msg = equipmentDAO.updateEquipment(equipmentBean);
        disable(true);
        generateTable();
//        TestEquipmentPanel.mainTabbedPane.setEnabled(true);
//        TestEquipmentPanel.equipmentPanel.setEnabled(true);
        return msg;
    }
}
