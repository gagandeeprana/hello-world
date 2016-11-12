/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dpu.ui.common.helper;

import dpu.beans.admin.DriverBean;
import dpu.dao.admin.DriverDAO;
import dpu.dao.admin.StateDAO;
import dpu.dao.admin.impl.DriverDAOImpl;
import dpu.dao.admin.impl.StateDaoImpl;
import dpu.entity.admin.Driver;
import dpu.entity.admin.State;
import dpu.ui.common.AddDriverFrame;
import dpu.ui.common.DriverPanel;
import dpu.ui.common.ProvincialFrame;
//import dpu.ui.common.AddDriverFrame;
import dpu.ui.common.TestDriverPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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

public class StateHelper extends DefaultTableCellRenderer {

   public String addUpdateFlag = "";
    int driverId = 0;
    String driverName;
    StateDAO stateDao = new StateDaoImpl();
    List<Driver> lstDrivers = null;
    int driverIdToBeDeleted = 0;
    String msg = "";
    
    public void getAllStates(){
        List<State> stateList = stateDao.getAllStates();
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        ProvincialFrame.stateTable = new JTable(defaultTableModel);
      //  DriverPanel.stateTable.setDefaultRenderer(Object.class, new DriverUIHelper.DriverTable());
        Object[][] data = new Object[stateList.size()][2];//yaha 22 kyu likha hai..??? sory 2  2 baar print ho gya hai..ok
        for (int i = 0; i < stateList.size(); i++) {
            State obj = stateList.get(i);
            data[i][0] = obj.getStateCode();
            data[i][1] = obj.getStateName();
           
             
            ProvincialFrame.stateTable.setRowHeight(30);
        }
        Object[] cols = {"Code", "Name"};
        defaultTableModel.setDataVector(data, cols);
        ProvincialFrame.stateTable.setIntercellSpacing(new Dimension(0, 0));
        //ProvincialFrame.stateTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //ProvincialFrame.stateTable.getColumn(0).setWidth(100);
        //ProvincialFrame.stateTable.getColumn(1).setWidth(300);
        ProvincialFrame.stateTable.setShowGrid(false);
        ProvincialFrame.jScrollPane1.setViewportView(ProvincialFrame.stateTable);
        
         
    }
    public List<State> getAllStateData(){
        List<State> stateList = stateDao.getAllStates();
        return stateList;
    }
    class ProvincialTable extends DefaultTableCellRenderer {

        @Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            table.setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());

//            table.set
            JTextField editor = new JTextField();
            editor.setFont(new Font(Font.SANS_SERIF, 0, 12));
            editor.setBorder(null);
            if (value != null) {
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
            if (isSelected) {
                Border border = BorderFactory.createLineBorder(Color.CYAN, 4);
                editor.setBorder(border);
                editor.setBackground(Color.CYAN);
            }
            return editor;
        }
    }
}

