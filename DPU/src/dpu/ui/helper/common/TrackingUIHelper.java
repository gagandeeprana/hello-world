package dpu.ui.helper.common;

import dpu.beans.admin.TrackingBean;
import dpu.dao.admin.TrackingDAO;
import dpu.dao.admin.impl.TrackingDAOImpl;
import dpu.ui.common.AddTrackingFrame;
import dpu.ui.common.MainFrame;
import static dpu.ui.common.MainFrame.mainTabbedPane;
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

public class TrackingUIHelper {

    public String addUpdateFlag = "";
    int trackingId = 0;
    Date trackingDate;
    TrackingDAO trackingDAO = new TrackingDAOImpl();
    List<TrackingBean> lstTrackings = null;
    int trackingIdToBeDeleted = 0;
    String msg = "";

    public void clear() {
        MainFrame.txtTrackingSearch.setText("");
    }

    public void disable(boolean var) {
        mainTabbedPane.setEnabled(var);
        MainFrame.trackingPanel.setEnabled(var);
        MainFrame.tblTracking.setEnabled(var);
        MainFrame.btnAddManageTracking.setEnabled(var);
        MainFrame.btnClearManageTracking.setEnabled(var);
        MainFrame.txtTrackingSearch.setEnabled(var);
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
            trackingIdToBeDeleted = lstTrackings.get(row).getTrackingId();
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
            trackingIdToBeDeleted = lstTrackings.get(row).getTrackingId();
            trackingId = lstTrackings.get(row).getTrackingId();
            trackingDate = lstTrackings.get(row).getTrackingDate();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                TrackingBean trackingBean = new TrackingBean();
                trackingBean.setTrackingId(trackingId);
                trackingBean.setTrackingDate(trackingDate);
                AddTrackingFrame addTrackingFrame = new AddTrackingFrame(trackingBean);
                addTrackingFrame.setVisible(true);
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
        lstTrackings = trackingDAO.getAllTrackings(MainFrame.txtTrackingSearch.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        MainFrame.tblTracking = new JTable(defaultTableModel);
        Object[][] data = new Object[lstTrackings.size()][4];
        for (int i = 0; i < lstTrackings.size(); i++) {
            TrackingBean obj = lstTrackings.get(i);
            data[i][0] = obj.getTrackingId();
            data[i][1] = obj.getTrackingDate();
            data[i][2] = "Remove";
            data[i][3] = "Update";
        }
        Object[] cols = {"Tracking Id", "Tracking Date", " ", "  "};
        defaultTableModel.setDataVector(data, cols);
        MainFrame.tblTracking.getColumn(" ").setCellRenderer(new ButtonRenderer());
        MainFrame.tblTracking.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        MainFrame.tblTracking.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        MainFrame.tblTracking.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        MainFrame.jScrollPane8.setViewportView(MainFrame.tblTracking);
    }

    public String save() {
        TrackingBean obj = new TrackingBean();
        obj.setTrackingId(Integer.parseInt(AddTrackingFrame.txtTrackingIdAddTracking.getText()));
        String date[] = AddTrackingFrame.txtTrackingDateAddTracking.getText().split("-");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        Date trackingDate = new Date(year - 1900, month - 1, day);
        System.out.println(trackingDate);
        obj.setTrackingDate(trackingDate);
        TrackingDAO trackingDAO = new TrackingDAOImpl();
        String msg = trackingDAO.addTracking(obj);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.trackingPanel.setEnabled(true);
        return msg;
    }

    public String delete() {
        TrackingDAO trackingDAO = new TrackingDAOImpl();
        String msg = trackingDAO.deleteTracking(trackingIdToBeDeleted);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.trackingPanel.setEnabled(true);
        return msg;
    }

    public String update() {
        TrackingBean obj = new TrackingBean();
        obj.setTrackingId(Integer.parseInt(AddTrackingFrame.txtTrackingIdAddTracking.getText()));
        String date[] = AddTrackingFrame.txtTrackingDateAddTracking.getText().split("-");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        Date trackingDate = new Date(year, month, day);
        obj.setTrackingDate(trackingDate);
        TrackingDAO trackingDAO = new TrackingDAOImpl();
        String msg = trackingDAO.updateTracking(obj);
        disable(true);
        generateTable();
        MainFrame.mainTabbedPane.setEnabled(true);
        MainFrame.trackingPanel.setEnabled(true);
        return msg;
    }
}
