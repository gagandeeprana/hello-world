package dpu.ui.helper.common;

import dpu.beans.admin.DivisionBean;
import dpu.dao.admin.DivisionDAO;
import dpu.dao.admin.impl.DivisionDAOImpl;
import dpu.ui.common.AddDivisionFrame;
import dpu.ui.common.MainFrame;
import static dpu.ui.common.MainFrame.divisionPanel;
import static dpu.ui.common.MainFrame.mainTabbedPane;
import static dpu.ui.common.MainFrame.tblDivision;
import static dpu.ui.common.MainFrame.txtDivisionSearch;
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

public class DivisionUIHelper {

    public String addUpdateFlag = "";
    int divisionId = 0;
    String divisionName;
    DivisionDAO divisionDAO = new DivisionDAOImpl();
    List<DivisionBean> lstDivisions = null;
    int divisionIdToBeDeleted = 0;
    String msg = "";

    public void clear() {
        MainFrame.txtDivisionSearch.setText("");
    }

    public void disable(boolean var) {
        mainTabbedPane.setEnabled(var);
        divisionPanel.setEnabled(var);
        tblDivision.setEnabled(var);
        MainFrame.btnAddManageDivision.setEnabled(var);
        MainFrame.btnClearManageDivision.setEnabled(var);
        txtDivisionSearch.setEnabled(var);
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
            divisionIdToBeDeleted = lstDivisions.get(row).getDivisionId();
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
            divisionIdToBeDeleted = lstDivisions.get(row).getDivisionId();
            divisionId = lstDivisions.get(row).getDivisionId();
            divisionName = lstDivisions.get(row).getDivision();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                DivisionBean divisionBean = new DivisionBean();
                divisionBean.setDivisionId(divisionId);
                divisionBean.setDivision(divisionName);
                AddDivisionFrame addDivisionFrame = new AddDivisionFrame(divisionBean);
                addDivisionFrame.setVisible(true);
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
        lstDivisions = divisionDAO.getAllDivisions(txtDivisionSearch.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        MainFrame.tblDivision = new JTable(defaultTableModel);
        Object[][] data = new Object[lstDivisions.size()][4];
        for (int i = 0; i < lstDivisions.size(); i++) {
            DivisionBean obj = lstDivisions.get(i);
            data[i][0] = obj.getDivisionId();
            data[i][1] = obj.getDivision();
            data[i][2] = "Remove";
            data[i][3] = "Update";
        }
        Object[] cols = {"Division Id", "Division Name", " ", "  "};
        defaultTableModel.setDataVector(data, cols);
        MainFrame.tblDivision.getColumn(" ").setCellRenderer(new ButtonRenderer());
        MainFrame.tblDivision.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        MainFrame.tblDivision.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        MainFrame.tblDivision.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        MainFrame.jScrollPane2.setViewportView(MainFrame.tblDivision);
    }

    public String save() {
        DivisionBean obj = new DivisionBean();
        obj.setDivisionId(Integer.parseInt(AddDivisionFrame.txtDivisionIdAddDivision.getText()));
        obj.setDivision(AddDivisionFrame.txtDivisionNameAddDivision.getText());
        DivisionDAO divisionDAO = new DivisionDAOImpl();
        String msg = divisionDAO.addDivision(obj);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.divisionPanel.setEnabled(true);
        return msg;
    }

    public String delete() {
        DivisionDAO divisionDAO = new DivisionDAOImpl();
        String msg = divisionDAO.deleteDivision(divisionIdToBeDeleted);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.divisionPanel.setEnabled(true);
        return msg;
    }

    public String update(DivisionBean divisionBean) {
        DivisionDAO divisionDAO = new DivisionDAOImpl();
        String msg = divisionDAO.updateDivision(divisionBean);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.divisionPanel.setEnabled(true);
        return msg;
    }
}
