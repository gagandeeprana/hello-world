package dpu.ui.helper.common;

import dpu.beans.admin.TerminalBean;
import dpu.dao.admin.TerminalDAO;
import dpu.dao.admin.impl.TerminalDAOImpl;
import dpu.ui.common.AddTerminalFrame;
import dpu.ui.common.MainFrame;
import static dpu.ui.common.MainFrame.mainTabbedPane;
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

public class TerminalUIHelper {

    public String addUpdateFlag = "";
    int terminalId = 0;
    String terminalName;
    TerminalDAO terminalDAO = new TerminalDAOImpl();
    List<TerminalBean> lstTerminals = null;
    int terminalIdToBeDeleted = 0;
    String msg = "";

    public void clear() {
        MainFrame.txtTerminalSearch.setText("");
    }

    public void disable(boolean var) {
        mainTabbedPane.setEnabled(var);
        MainFrame.terminalPanel.setEnabled(var);
        MainFrame.tblTerminal.setEnabled(var);
        MainFrame.btnAddManageTerminal.setEnabled(var);
        MainFrame.btnClearManageTerminal.setEnabled(var);
        MainFrame.txtTerminalSearch.setEnabled(var);
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
            terminalIdToBeDeleted = lstTerminals.get(row).getTerminalId();
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
            terminalIdToBeDeleted = lstTerminals.get(row).getTerminalId();
            terminalId = lstTerminals.get(row).getTerminalId();
            terminalName = lstTerminals.get(row).getTerminalName();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                TerminalBean terminalBean = new TerminalBean();
                terminalBean.setTerminalId(terminalId);
                terminalBean.setTerminalName(terminalName);
                AddTerminalFrame addTerminalFrame = new AddTerminalFrame(terminalBean);
                addTerminalFrame.setVisible(true);
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
        lstTerminals = terminalDAO.getAllTerminals(MainFrame.txtTerminalSearch.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        MainFrame.tblTerminal = new JTable(defaultTableModel);
        Object[][] data = new Object[lstTerminals.size()][4];
        for (int i = 0; i < lstTerminals.size(); i++) {
            TerminalBean obj = lstTerminals.get(i);
            data[i][0] = obj.getTerminalId();
            data[i][1] = obj.getTerminalName();
            data[i][2] = "Remove";
            data[i][3] = "Update";
        }
        Object[] cols = {"Terminal Id", "Terminal Name", " ", "  "};
        defaultTableModel.setDataVector(data, cols);
        MainFrame.tblTerminal.getColumn(" ").setCellRenderer(new ButtonRenderer());
        MainFrame.tblTerminal.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        MainFrame.tblTerminal.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        MainFrame.tblTerminal.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        MainFrame.jScrollPane7.setViewportView(MainFrame.tblTerminal);
    }

    public String save() {
        TerminalBean obj = new TerminalBean();
        obj.setTerminalId(Integer.parseInt(AddTerminalFrame.txtTerminalIdAddTerminal.getText()));
        obj.setTerminalName(AddTerminalFrame.txtTerminalNameAddTerminal.getText());
        TerminalDAO terminalDAO = new TerminalDAOImpl();
        String msg = terminalDAO.addTerminal(obj);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.terminalPanel.setEnabled(true);
        return msg;
    }

    public String delete() {
        TerminalDAO terminalDAO = new TerminalDAOImpl();
        String msg = terminalDAO.deleteTerminal(terminalIdToBeDeleted);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.terminalPanel.setEnabled(true);
        return msg;
    }

    public String update(TerminalBean terminalBean) {
        TerminalDAO terminalDAO = new TerminalDAOImpl();
        String msg = terminalDAO.updateTerminal(terminalBean);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.terminalPanel.setEnabled(true);
        return msg;
    }
}
