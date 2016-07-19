package dpu.ui.helper.common;

import dpu.beans.admin.ClassBean;
import dpu.dao.admin.ClassDAO;
import dpu.dao.admin.impl.ClassDAOImpl;
import dpu.ui.common.AddClassFrame;
import static dpu.ui.common.MainFrame.mainTabbedPane;
import dpu.ui.common.TestClassPanel;
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

public class ClassUIHelper {

    public String addUpdateFlag = "";
    int classId = 0;
    String className;
    ClassDAO classDAO = new ClassDAOImpl();
    List<ClassBean> lstClasses = null;
    int classIdToBeDeleted = 0;
    String msg = "";

    public void clear() {
        TestClassPanel.txtClassSearch.setText("");
    }

    public void disable(boolean var) {
        mainTabbedPane.setEnabled(var);
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
        Object[][] data = new Object[lstClasses.size()][4];
        for (int i = 0; i < lstClasses.size(); i++) {
            ClassBean obj = lstClasses.get(i);
            data[i][0] = obj.getClassId();
            data[i][1] = obj.getName();
            data[i][2] = "Remove";
            data[i][3] = "Update";
        }
        Object[] cols = {"Class Id", "Class Name", " ", "  "};
        defaultTableModel.setDataVector(data, cols);
        TestClassPanel.tblClass.getColumn(" ").setCellRenderer(new ButtonRenderer());
        TestClassPanel.tblClass.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        TestClassPanel.tblClass.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        TestClassPanel.tblClass.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
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
}
