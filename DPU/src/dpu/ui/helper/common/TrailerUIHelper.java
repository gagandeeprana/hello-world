package dpu.ui.helper.common;

import dpu.beans.admin.TrailerBean;
import dpu.dao.admin.TrailerDAO;
import dpu.dao.admin.impl.TrailerDAOImpl;
//import dpu.ui.common.AddTrailerFrame;
import dpu.ui.common.TestTrailerPanel;
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

public class TrailerUIHelper extends DefaultTableCellRenderer {

    public String addUpdateFlag = "";
    int trailerId = 0;
    String trailerName;
    TrailerDAO trailerDAO = new TrailerDAOImpl();
    List<TrailerBean> lstTrailers = null;
    int trailerIdToBeDeleted = 0;
    String msg = "";

    public void clear() {
        TestTrailerPanel.txtSearchManageTrailer.setText("");
    }

    public void disable(boolean var) {
//        mainTabbedPane.setEnabled(var);
//        TestTrailerPanel.trailerPanel.setEnabled(var);
        TestTrailerPanel.tblTrailer.setEnabled(var);
        TestTrailerPanel.btnAddManageTrailer.setEnabled(var);
        TestTrailerPanel.btnPrintManageTrailer.setEnabled(var);
        TestTrailerPanel.txtSearchManageTrailer.setEnabled(var);
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
            trailerIdToBeDeleted = lstTrailers.get(row).getTrailerId();
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
            trailerIdToBeDeleted = lstTrailers.get(row).getTrailerId();
            trailerId = lstTrailers.get(row).getTrailerId();
            trailerName = lstTrailers.get(row).getPlateNo();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                TrailerBean trailerBean = new TrailerBean();
                trailerBean.setTrailerId(trailerId);
//                trailerBean.setName(trailerName);
//                AddTrailerFrame addTrailerFrame = new AddTrailerFrame(trailerBean);
//                addTrailerFrame.setVisible(true);
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
        lstTrailers = trailerDAO.getAllTrailers(TestTrailerPanel.txtSearchManageTrailer.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestTrailerPanel.tblTrailer = new JTable(defaultTableModel);
        TestTrailerPanel.tblTrailer.setDefaultRenderer(Object.class, new TrailerTable());
        Object[][] data = new Object[lstTrailers.size()][18];
        for (int i = 0; i < lstTrailers.size(); i++) {
            TrailerBean obj = lstTrailers.get(i);
            data[i][0] = obj.getTrailerId();
            data[i][1] = obj.getClassId();
            data[i][2] = obj.getEquipmentId();
            data[i][3] = obj.getLength();
            data[i][4] = obj.getVIN();
            data[i][5] = obj.getMake();
            data[i][6] = obj.getModel();
            data[i][7] = obj.getYear();
            data[i][8] = obj.getPlateNo();
            data[i][9] = obj.getJurisdiction();
            data[i][10] = obj.getTareWeight();
            data[i][11] = obj.getRgw();
            data[i][12] = obj.getCurrentOdometer();
            data[i][13] = obj.getReadingTakenDate();
            data[i][14] = obj.getCreatedBy();
            data[i][15] = obj.getCreatedOn();
            data[i][16] = "";
            data[i][17] = "";
            TestTrailerPanel.tblTrailer.setRowHeight(30);
        }
        Object[] cols = {"Trailer Id", "Class Id", "Equipment Id", "Length", "VIN", "Make", "Model", "Year", "Plate No", "Jurisdiction", "Tare Weight", "RGW", "Current Odometer", "Reading Taken", "Created By", "Created On", " ", "  "};
        defaultTableModel.setDataVector(data, cols);
        TestTrailerPanel.tblTrailer.getColumn(" ").setCellRenderer(new ButtonRenderer());
        TestTrailerPanel.tblTrailer.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        TestTrailerPanel.tblTrailer.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        TestTrailerPanel.tblTrailer.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        TestTrailerPanel.tblTrailer.getColumn(" ").setMaxWidth(25);
        TestTrailerPanel.tblTrailer.getColumn("  ").setMaxWidth(25);
        TestTrailerPanel.tblTrailer.setIntercellSpacing(new Dimension(0, 0));
        TestTrailerPanel.tblTrailer.setShowGrid(false);
        TestTrailerPanel.jScrollPane9.setViewportView(TestTrailerPanel.tblTrailer);
    }

    public String save() {
        TrailerBean obj = new TrailerBean();
//        obj.setTrailerId(Integer.parseInt(AddTrailerFrame.txtTrailerIdAddTrailer.getText()));
//        obj.setName(AddTrailerFrame.txtTrailerNameAddTrailer.getText());
        TrailerDAO trailerDAO = new TrailerDAOImpl();
        String msg = trailerDAO.addTrailer(obj);
        disable(true);
        generateTable();
//        TestTrailerPanel.mainTabbedPane.setEnabled(true);
//        TestTrailerPanel.trailerPanel.setEnabled(true);
        return msg;
    }

    public String delete() {
        TrailerDAO trailerDAO = new TrailerDAOImpl();
        String msg = trailerDAO.deleteTrailer(trailerIdToBeDeleted);
        disable(true);
        generateTable();
//        TestTrailerPanel.mainTabbedPane.setEnabled(true);
//        TestTrailerPanel.trailerPanel.setEnabled(true);
        return msg;
    }

    public String update(TrailerBean trailerBean) {
        TrailerDAO divisionDAO = new TrailerDAOImpl();
        String msg = divisionDAO.updateTrailer(trailerBean);
        disable(true);
        generateTable();
//        TestTrailerPanel.mainTabbedPane.setEnabled(true);
//        TestTrailerPanel.trailerPanel.setEnabled(true);
        return msg;
    }

    class TrailerTable implements TableCellRenderer {

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
