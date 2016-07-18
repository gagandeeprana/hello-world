package dpu.ui.helper.common;

import dpu.beans.admin.RoleBean;
import dpu.dao.admin.RoleDAO;
import dpu.dao.admin.impl.RoleDAOImpl;
import dpu.ui.common.AddRoleFrame;
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

public class RoleUIHelper {

    public String addUpdateFlag = "";
    int roleId = 0;
    String roleName;
    RoleDAO roleDAO = new RoleDAOImpl();
    List<RoleBean> lstRoles = null;
    int roleIdToBeDeleted = 0;
    String msg = "";

    public void clear() {
        MainFrame.txtRoleSearch.setText("");
    }

    public void disable(boolean var) {
        mainTabbedPane.setEnabled(var);
        MainFrame.rolePanel.setEnabled(var);
        MainFrame.tblRole.setEnabled(var);
        MainFrame.btnAddManageRole.setEnabled(var);
        MainFrame.btnClearManageRole.setEnabled(var);
        MainFrame.txtRoleSearch.setEnabled(var);
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
            roleIdToBeDeleted = lstRoles.get(row).getRoleId();
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
            roleIdToBeDeleted = lstRoles.get(row).getRoleId();
            roleId = lstRoles.get(row).getRoleId();
            roleName = lstRoles.get(row).getRoleName();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                RoleBean roleBean = new RoleBean();
                roleBean.setRoleId(roleId);
                roleBean.setRoleName(roleName);
                AddRoleFrame addRoleFrame = new AddRoleFrame(roleBean);
                addRoleFrame.setVisible(true);
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
        lstRoles = roleDAO.getAllRoles(MainFrame.txtRoleSearch.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        MainFrame.tblRole = new JTable(defaultTableModel);
        Object[][] data = new Object[lstRoles.size()][4];
        for (int i = 0; i < lstRoles.size(); i++) {
            RoleBean obj = lstRoles.get(i);
            data[i][0] = obj.getRoleId();
            data[i][1] = obj.getRoleName();
            data[i][2] = "Remove";
            data[i][3] = "Update";
        }
        Object[] cols = {"Role Id", "Role Name", " ", "  "};
        defaultTableModel.setDataVector(data, cols);
        MainFrame.tblRole.getColumn(" ").setCellRenderer(new ButtonRenderer());
        MainFrame.tblRole.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        MainFrame.tblRole.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        MainFrame.tblRole.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        MainFrame.jScrollPane6.setViewportView(MainFrame.tblRole);
    }

    public String save() {
        RoleBean obj = new RoleBean();
        obj.setRoleId(Integer.parseInt(AddRoleFrame.txtRoleIdAddRole.getText()));
        obj.setRoleName(AddRoleFrame.txtRoleNameAddRole.getText());
        RoleDAO roleDAO = new RoleDAOImpl();
        String msg = roleDAO.addRole(obj);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.rolePanel.setEnabled(true);
        return msg;
    }

    public String delete() {
        RoleDAO roleDAO = new RoleDAOImpl();
        String msg = roleDAO.deleteRole(roleIdToBeDeleted);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.rolePanel.setEnabled(true);
        return msg;
    }

    public String update(RoleBean roleBean) {
        RoleDAO roleDAO = new RoleDAOImpl();
        String msg = roleDAO.updateRole(roleBean);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.rolePanel.setEnabled(true);
        return msg;
    }
}
