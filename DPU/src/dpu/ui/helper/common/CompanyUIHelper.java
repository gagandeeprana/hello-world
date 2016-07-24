package dpu.ui.helper.common;

import dpu.beans.admin.CompanyBean;
import dpu.dao.admin.CompanyDAO;
import dpu.dao.admin.impl.CompanyDAOImpl;
import dpu.ui.common.AddCompanyFrame;
import dpu.ui.common.TestCompanyPanel;
//import static dpu.ui.common.TestCompanyPanel.mainTabbedPane;
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

public class CompanyUIHelper {

    public String addUpdateFlag = "";
    int companyId = 0;
    String companyName;
    CompanyDAO companyDAO = new CompanyDAOImpl();
    List<CompanyBean> lstCompanies = null;
    int companyIdToBeDeleted = 0;
    String msg = "";

    public void clear() {
        TestCompanyPanel.txtCompanySearch.setText("");
    }

    public void disable(boolean var) {
//        mainTabbedPane.setEnabled(var);
//        TestCompanyPanel.companyPanel.setEnabled(var);
        TestCompanyPanel.tblCompany.setEnabled(var);
        TestCompanyPanel.btnAddManageCompany.setEnabled(var);
        TestCompanyPanel.btnClearManageCompany.setEnabled(var);
        TestCompanyPanel.txtCompanySearch.setEnabled(var);
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
            companyIdToBeDeleted = lstCompanies.get(row).getCompanyId();
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
            companyIdToBeDeleted = lstCompanies.get(row).getCompanyId();
            companyId = lstCompanies.get(row).getCompanyId();
            companyName = lstCompanies.get(row).getCompanyName();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                CompanyBean companyBean = new CompanyBean();
                companyBean.setCompanyId(companyId);
                companyBean.setCompanyName(companyName);
                AddCompanyFrame addCompanyFrame = new AddCompanyFrame(companyBean);
                addCompanyFrame.setVisible(true);
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
        lstCompanies = companyDAO.getAllCompanies(TestCompanyPanel.txtCompanySearch.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestCompanyPanel.tblCompany = new JTable(defaultTableModel);
        Object[][] data = new Object[lstCompanies.size()][4];
        for (int i = 0; i < lstCompanies.size(); i++) {
            CompanyBean obj = lstCompanies.get(i);
            data[i][0] = obj.getCompanyId();
            data[i][1] = obj.getCompanyName();
            data[i][2] = "Remove";
            data[i][3] = "Update";
        }
        Object[] cols = {"Company Id", "Company Name", " ", "  "};
        defaultTableModel.setDataVector(data, cols);
        TestCompanyPanel.tblCompany.getColumn(" ").setCellRenderer(new ButtonRenderer());
        TestCompanyPanel.tblCompany.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        TestCompanyPanel.tblCompany.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        TestCompanyPanel.tblCompany.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        TestCompanyPanel.jScrollPane4.setViewportView(TestCompanyPanel.tblCompany);
    }

    public String save() {
        CompanyBean obj = new CompanyBean();
        obj.setCompanyId(Integer.parseInt(AddCompanyFrame.txtCompanyIdAddCompany.getText()));
        obj.setCompanyName(AddCompanyFrame.txtCompanyNameAddCompany.getText());
        CompanyDAO companyDAO = new CompanyDAOImpl();
        String msg = companyDAO.addCompany(obj);
        disable(true);
        generateTable();
//        TestCompanyPanel.mainTabbedPane.setEnabled(true);
//        TestCompanyPanel.companyPanel.setEnabled(true);
        return msg;
    }

    public String delete() {
        CompanyDAO companyDAO = new CompanyDAOImpl();
        String msg = companyDAO.deleteCompany(companyIdToBeDeleted);
        disable(true);
        generateTable();
//        TestCompanyPanel.mainTabbedPane.setEnabled(true);
//        TestCompanyPanel.companyPanel.setEnabled(true);
        return msg;
    }

    public String update(CompanyBean companyBean) {
        CompanyDAO companyDAO = new CompanyDAOImpl();
        String msg = companyDAO.updateCompany(companyBean);
        disable(true);
        generateTable();
//        TestCompanyPanel.mainTabbedPane.setEnabled(true);
//        TestCompanyPanel.companyPanel.setEnabled(true);
        return msg;
    }
}
