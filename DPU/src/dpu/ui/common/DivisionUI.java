package dpu.ui.common;

import dpu.beans.admin.DivisionBean;
import dpu.dao.admin.DivisionDAO;
import dpu.dao.admin.impl.DivisionDAOImpl;
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

public class DivisionUI {

    public String addUpdateFlag = "";
    int divisionId = 0;
    DivisionDAO divisionDAO = new DivisionDAOImpl();
    List<DivisionBean> lstDivisions = null;

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
  private String    label;
  private boolean   isPushed;
  
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
    } else{
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value ==null) ? "" : value.toString();
    button.setText( label );
    isPushed = true;
    return button;
  }
  
  public Object getCellEditorValue() {
    if (isPushed)  {
      //
      //
      JOptionPane.showMessageDialog(button ,label + ": Ouch!");
      // System.out.println(label + ": Ouch!");
    }
    isPushed = false;
    return new String( label ) ;
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
        lstDivisions = divisionDAO.getAllDivisions("");
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        MainFrame.tblDivision = new JTable(defaultTableModel);
        Object[][] data = new Object[lstDivisions.size()][3];
        for (int i = 0; i < lstDivisions.size(); i++) {
            DivisionBean obj = lstDivisions.get(i);
            data[i][0] = obj.getDivisionId();
            data[i][1] = obj.getDivision();
            data[i][2] = "Button";
        }
        Object[] cols = {"Division Id", "Division Name", "Button"};
        defaultTableModel.setDataVector(data, cols);
        MainFrame.tblDivision.getColumn("Button").setCellRenderer(new ButtonRenderer());
         MainFrame.tblDivision.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));

//        MainFrame.tblDivision = new JTable(data, cols);
//        MainFrame.jScrollPane2.setViewportView(MainFrame.tblDivision);
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
}
