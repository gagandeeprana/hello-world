package dpu.ui.common.helper;

import dpu.beans.admin.ClassBean;
import dpu.dao.admin.ClassDAO;
import dpu.dao.admin.impl.ClassDAOImpl;
import dpu.ui.common.AddClassFrame;
import dpu.ui.common.TestClassPanel;
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

public class ClassUIHelper extends DefaultTableCellRenderer {

    public String addUpdateFlag = "";
    int classId = 0;
    String className;
    ClassDAO classDAO = new ClassDAOImpl();
    List<ClassBean> lstClasses = null;
    int classIdToBeDeleted = 0;
    String msg = "";

//    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
////        Component returnComp = super.prepareRenderer(renderer, row, column);
//        Color alternateColor = new Color(252, 242, 206);
//        Color whiteColor = Color.WHITE;
//        if (!returnComp.getBackground().equals(getSelectionBackground())) {
//            Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
//            returnComp.setBackground(bg);
//            bg = null;
//        }
//        return returnComp;
//    }
    public void clear() {
        TestClassPanel.txtClassSearch.setText("");
    }

    public void disable(boolean var) {
//        mainTabbedPane.setEnabled(var);
//        TestClassPanel.classPanel.setEnabled(var);
        TestClassPanel.tblClass.setEnabled(var);
        TestClassPanel.btnAddManageClass.setEnabled(var);
        TestClassPanel.btnClearManageClass.setEnabled(var);
        TestClassPanel.txtClassSearch.setEnabled(var);
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
            classIdToBeDeleted = lstClasses.get(row).getClassId();
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
            classIdToBeDeleted = lstClasses.get(row).getClassId();
            classId = lstClasses.get(row).getClassId();
            className = lstClasses.get(row).getName();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                ClassBean classBean = new ClassBean();
                classBean.setClassId(classId);
                classBean.setName(className);
                AddClassFrame addClassFrame = new AddClassFrame(classBean);
                addClassFrame.setVisible(true);
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
        lstClasses = classDAO.getAllClasses(TestClassPanel.txtClassSearch.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestClassPanel.tblClass = new JTable(defaultTableModel);
        TestClassPanel.tblClass.setDefaultRenderer(Object.class, new ClassTable());
        Object[][] data = new Object[lstClasses.size()][4];
        for (int i = 0; i < lstClasses.size(); i++) {
            ClassBean obj = lstClasses.get(i);
            data[i][0] = obj.getClassId();
            data[i][1] = obj.getName();
            data[i][2] = "";
            data[i][3] = "";
            TestClassPanel.tblClass.setRowHeight(30);
        }
        Object[] cols = {"Class Id", "Class Name", " ", "  "};
        defaultTableModel.setDataVector(data, cols);
        TestClassPanel.tblClass.getColumn(" ").setCellRenderer(new ButtonRenderer());
        TestClassPanel.tblClass.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        TestClassPanel.tblClass.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        TestClassPanel.tblClass.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        TestClassPanel.tblClass.getColumn(" ").setMaxWidth(25);
        TestClassPanel.tblClass.getColumn("  ").setMaxWidth(25);
        TestClassPanel.tblClass.setIntercellSpacing(new Dimension(0, 0));
        TestClassPanel.tblClass.setShowGrid(false);
        TestClassPanel.jScrollPane3.setViewportView(TestClassPanel.tblClass);
        
    }

    public String save() {
        ClassBean obj = new ClassBean();
        obj.setClassId(Integer.parseInt(AddClassFrame.txtClassIdAddClass.getText()));
        obj.setName(AddClassFrame.txtClassNameAddClass.getText());
        ClassDAO classDAO = new ClassDAOImpl();
        String msg = classDAO.addClass(obj);
        disable(true);
        generateTable();
//        TestClassPanel.mainTabbedPane.setEnabled(true);
//        TestClassPanel.classPanel.setEnabled(true);
        return msg;
    }

    public String delete() {
        ClassDAO classDAO = new ClassDAOImpl();
        String msg = classDAO.deleteClass(classIdToBeDeleted);
        disable(true);
        generateTable();
//        TestClassPanel.mainTabbedPane.setEnabled(true);
//        TestClassPanel.classPanel.setEnabled(true);
        return msg;
    }

    public String update(ClassBean classBean) {
        ClassDAO divisionDAO = new ClassDAOImpl();
        String msg = divisionDAO.updateClass(classBean);
        disable(true);
        generateTable();
//        TestClassPanel.mainTabbedPane.setEnabled(true);
//        TestClassPanel.classPanel.setEnabled(true);
        return msg;
    }

    class ClassTable implements TableCellRenderer {

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
