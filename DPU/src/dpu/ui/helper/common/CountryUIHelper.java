package dpu.ui.helper.common;

import dpu.beans.admin.CountryBean;
import dpu.dao.admin.CountryDAO;
import dpu.dao.admin.impl.CountryDAOImpl;
import dpu.ui.common.AddCountryFrame;
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

public class CountryUIHelper {

    public String addUpdateFlag = "";
    int countryId = 0;
    String countryName;
    CountryDAO countryDAO = new CountryDAOImpl();
    List<CountryBean> lstCompanies = null;
    int countryIdToBeDeleted = 0;
    String msg = "";

    public void clear() {
        MainFrame.txtCountrySearch.setText("");
    }

    public void disable(boolean var) {
        mainTabbedPane.setEnabled(var);
        MainFrame.countryPanel.setEnabled(var);
        MainFrame.tblCountry.setEnabled(var);
        MainFrame.btnAddManageCountry.setEnabled(var);
        MainFrame.btnClearManageCountry.setEnabled(var);
        MainFrame.txtCountrySearch.setEnabled(var);
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
            countryIdToBeDeleted = lstCompanies.get(row).getCountryId();
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
            countryIdToBeDeleted = lstCompanies.get(row).getCountryId();
            countryId = lstCompanies.get(row).getCountryId();
            countryName = lstCompanies.get(row).getCountryName();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                CountryBean countryBean = new CountryBean();
                countryBean.setCountryId(countryId);
                countryBean.setCountryName(countryName);
                AddCountryFrame addCountryFrame = new AddCountryFrame(countryBean);
                addCountryFrame.setVisible(true);
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
        lstCompanies = countryDAO.getAllCountries(MainFrame.txtCountrySearch.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        MainFrame.tblCountry = new JTable(defaultTableModel);
        Object[][] data = new Object[lstCompanies.size()][4];
        for (int i = 0; i < lstCompanies.size(); i++) {
            CountryBean obj = lstCompanies.get(i);
            data[i][0] = obj.getCountryId();
            data[i][1] = obj.getCountryName();
            data[i][2] = "Remove";
            data[i][3] = "Update";
        }
        Object[] cols = {"Country Id", "Country Name", " ", "  "};
        defaultTableModel.setDataVector(data, cols);
        MainFrame.tblCountry.getColumn(" ").setCellRenderer(new ButtonRenderer());
        MainFrame.tblCountry.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        MainFrame.tblCountry.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        MainFrame.tblCountry.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        MainFrame.jScrollPane11.setViewportView(MainFrame.tblCountry);
    }

    public String save() {
        CountryBean obj = new CountryBean();
        obj.setCountryId(Integer.parseInt(AddCountryFrame.txtCountryIdAddCountry.getText()));
        obj.setCountryName(AddCountryFrame.txtCountryNameAddCountry.getText());
        CountryDAO countryDAO = new CountryDAOImpl();
        String msg = countryDAO.addCountry(obj);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.countryPanel.setEnabled(true);
        return msg;
    }

    public String delete() {
        CountryDAO countryDAO = new CountryDAOImpl();
        String msg = countryDAO.deleteCountry(countryIdToBeDeleted);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.countryPanel.setEnabled(true);
        return msg;
    }

    public String update(CountryBean countryBean) {
        CountryDAO countryDAO = new CountryDAOImpl();
        String msg = countryDAO.updateCountry(countryBean);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.countryPanel.setEnabled(true);
        return msg;
    }
}
