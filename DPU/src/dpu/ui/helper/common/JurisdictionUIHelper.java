package dpu.ui.helper.common;

import dpu.beans.admin.JurisdictionBean;
import dpu.dao.admin.CountryDAO;
import dpu.dao.admin.JurisdictionDAO;
import dpu.dao.admin.impl.CountryDAOImpl;
import dpu.dao.admin.impl.JurisdictionDAOImpl;
import dpu.ui.common.AddJurisdictionFrame;
import dpu.ui.common.TestJurisdictionPanel;
//import static dpu.ui.common.TestJurisdictionPanel.mainTabbedPane;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class JurisdictionUIHelper {

    public String addUpdateFlag = "";
    int jurisdictionId = 0;
    JurisdictionDAO jurisdictionDAO = new JurisdictionDAOImpl();
    CountryDAO countryDAO = new CountryDAOImpl();
    List<JurisdictionBean> lstJurisdictions = null;
    int jurisdictionIdToBeDeleted = 0;
    String msg = "";

    public void clear() {
        TestJurisdictionPanel.txtJurisdictionSearch.setText("");
    }

    public void disable(boolean var) {
//        mainTabbedPane.setEnabled(var);
//        TestJurisdictionPanel.jurisdictionPanel.setEnabled(var);
        TestJurisdictionPanel.tblJurisdiction.setEnabled(var);
        TestJurisdictionPanel.btnAddManageJurisdiction.setEnabled(var);
        TestJurisdictionPanel.btnClearManageJurisdiction.setEnabled(var);
        TestJurisdictionPanel.txtJurisdictionSearch.setEnabled(var);
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
            jurisdictionIdToBeDeleted = lstJurisdictions.get(row).getJurisdictionId();
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
            jurisdictionIdToBeDeleted = lstJurisdictions.get(row).getJurisdictionId();
            jurisdictionId = lstJurisdictions.get(row).getJurisdictionId();
//            jurisdictionDate = lstJurisdictions.get(row).getJurisdictionDate();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                JurisdictionBean jurisdictionBean = new JurisdictionBean();
                jurisdictionBean.setJurisdictionId(jurisdictionId);
//                jurisdictionBean.setJurisdictionName(jurisdictionDate);
                AddJurisdictionFrame addJurisdictionFrame = new AddJurisdictionFrame(jurisdictionBean);
                addJurisdictionFrame.setVisible(true);
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
        lstJurisdictions = jurisdictionDAO.getAllJurisdictions(TestJurisdictionPanel.txtJurisdictionSearch.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestJurisdictionPanel.tblJurisdiction = new JTable(defaultTableModel);
        Object[][] data = new Object[lstJurisdictions.size()][7];
        for (int i = 0; i < lstJurisdictions.size(); i++) {
            JurisdictionBean obj = lstJurisdictions.get(i);
            data[i][0] = obj.getJurisdictionId();
            data[i][1] = obj.getJurisdictionName();
            data[i][2] = obj.getIFAJurisdiction();
            data[i][3] = countryDAO.getCountryInfo(obj.getCountryId()).getCountryName();
            data[i][4] = obj.getRoadTax();
            data[i][5] = "Remove";
            data[i][6] = "Update";
        }
        Object[] cols = {"Jurisdiction Id", "Jurisdiction Date", "IFA", "Country", "Road Tax", " ", "  "};
        defaultTableModel.setDataVector(data, cols);
        TestJurisdictionPanel.tblJurisdiction.getColumn(" ").setCellRenderer(new ButtonRenderer());
        TestJurisdictionPanel.tblJurisdiction.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        TestJurisdictionPanel.tblJurisdiction.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        TestJurisdictionPanel.tblJurisdiction.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        TestJurisdictionPanel.jScrollPane10.setViewportView(TestJurisdictionPanel.tblJurisdiction);
    }

    public String save() {
        JurisdictionBean obj = new JurisdictionBean();
        obj.setJurisdictionId(Integer.parseInt(AddJurisdictionFrame.txtJurisdictionIdAddJurisdiction.getText()));
        obj.setJurisdictionName(AddJurisdictionFrame.txtJurisdictionNameAddJurisdiction.getText());
        obj.setIFAJurisdiction(AddJurisdictionFrame.txtJurisdictionIFAAddJurisdiction.getText());
        obj.setCountryId(AddJurisdictionFrame.lstCountries.get(AddJurisdictionFrame.ddlCountryAddJurisdiction.getSelectedIndex() - 1).getCountryId());
        obj.setRoadTax(Double.parseDouble(AddJurisdictionFrame.txtRoadTaxAddJurisdiction.getText()));
        JurisdictionDAO jurisdictionDAO = new JurisdictionDAOImpl();
        String msg = jurisdictionDAO.addJurisdiction(obj);
        disable(true);
        generateTable();
//        TestJurisdictionPanel.mainTabbedPane.setEnabled(true);
//        TestJurisdictionPanel.jurisdictionPanel.setEnabled(true);
        return msg;
    }

    public String delete() {
        JurisdictionDAO jurisdictionDAO = new JurisdictionDAOImpl();
        String msg = jurisdictionDAO.deleteJurisdiction(jurisdictionIdToBeDeleted);
        disable(true);
        generateTable();
//        TestJurisdictionPanel.mainTabbedPane.setEnabled(true);
//        TestJurisdictionPanel.jurisdictionPanel.setEnabled(true);
        return msg;
    }

    public String update() {
        JurisdictionBean obj = new JurisdictionBean();
        obj.setJurisdictionId(Integer.parseInt(AddJurisdictionFrame.txtJurisdictionIdAddJurisdiction.getText()));
        obj.setJurisdictionName(AddJurisdictionFrame.txtJurisdictionNameAddJurisdiction.getText());
        obj.setIFAJurisdiction(AddJurisdictionFrame.txtJurisdictionIFAAddJurisdiction.getText());
        obj.setCountryId(AddJurisdictionFrame.lstCountries.get(AddJurisdictionFrame.ddlCountryAddJurisdiction.getSelectedIndex() + 1).getCountryId());
        obj.setRoadTax(Double.parseDouble(AddJurisdictionFrame.txtRoadTaxAddJurisdiction.getText()));
        JurisdictionDAO jurisdictionDAO = new JurisdictionDAOImpl();
        String msg = jurisdictionDAO.updateJurisdiction(obj);
        disable(true);
        generateTable();
//        TestJurisdictionPanel.mainTabbedPane.setEnabled(true);
//        TestJurisdictionPanel.jurisdictionPanel.setEnabled(true);
        return msg;
    }
}
