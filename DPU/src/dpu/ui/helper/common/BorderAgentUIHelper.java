/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.helper.common;

import dpu.beans.admin.BorderAgentBean;
import dpu.dao.admin.BorderAgentDAO;
import dpu.dao.admin.impl.BorderAgentDAOImpl;
import dpu.ui.common.AddCustomBroker;
import static dpu.ui.helper.common.BorderAgentUIHelper.lstBorderAgents;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gagandeep
 */
public class BorderAgentUIHelper {

    public static List<BorderAgentBean> lstBorderAgents = null;
    static public String addUpdateFlag = "add";
    static public int borderAgentId = 0;
    BorderAgentDAO borderAgentDAO = new BorderAgentDAOImpl();
    public static BorderAgentBean borderAgentBean = new BorderAgentBean();

    public void generateTable() {
        Object[] cols = {"Office/Agent", "Border Crossing"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        AddCustomBroker.tblBorderAgents.setModel(defaultTableModel);
        AddCustomBroker.tblBorderAgents.setAutoCreateRowSorter(true);
        AddCustomBroker.tblBorderAgents.setDefaultRenderer(Object.class, new BorderAgentUIHelper.BorderAgentTable());
        if (lstBorderAgents != null && lstBorderAgents.size() > 0) {
            Object[][] data = new Object[lstBorderAgents.size()][2];
            for (int i = 0; i < lstBorderAgents.size(); i++) {
                BorderAgentBean obj = lstBorderAgents.get(i);
                data[i][0] = obj.getBorderAgent();
                data[i][1] = obj.getBorderCrossing();
                AddCustomBroker.tblBorderAgents.setRowHeight(30);
            }
            AddCustomBroker.tblBorderAgents.setColumnSelectionAllowed(false);

            defaultTableModel.setDataVector(data, cols);
            AddCustomBroker.tblBorderAgents.getTableHeader().setBackground(Color.red);

            AddCustomBroker.tblBorderAgents.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            AddCustomBroker.tblBorderAgents.getTableHeader().setForeground(Color.DARK_GRAY);
            AddCustomBroker.tblBorderAgents.setIntercellSpacing(new Dimension(0, 0));
            AddCustomBroker.tblBorderAgents.setShowGrid(false);
            AddCustomBroker.jScrollPane1.setViewportView(AddCustomBroker.tblBorderAgents);
        } else {
            generateEmptyTable();
        }
    }

    private void generateEmptyTable() {
        Object[] cols = {"Office/Agent", "Border Crossing"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        AddCustomBroker.tblBorderAgents.setModel(defaultTableModel);
        AddCustomBroker.tblBorderAgents.setAutoCreateRowSorter(true);
        AddCustomBroker.tblBorderAgents.setDefaultRenderer(Object.class, new BorderAgentUIHelper.BorderAgentTable());
        Object[][] data = new Object[7][2];
        for (int i = 0; i < 7; i++) {
            data[i][0] = "";
            data[i][1] = "";

            AddCustomBroker.tblBorderAgents.setRowHeight(30);
        }
        AddCustomBroker.tblBorderAgents.setColumnSelectionAllowed(false);

        defaultTableModel.setDataVector(data, cols);

        AddCustomBroker.tblBorderAgents.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        AddCustomBroker.tblBorderAgents.getTableHeader().setForeground(Color.DARK_GRAY);
        AddCustomBroker.tblBorderAgents.setIntercellSpacing(new Dimension(0, 0));
        AddCustomBroker.tblBorderAgents.setShowGrid(false);
        AddCustomBroker.jScrollPane1.setViewportView(AddCustomBroker.tblBorderAgents);
    }

    class BorderAgentTable extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JTextField editor = new JTextField();
            editor.setFont(new Font(Font.SANS_SERIF, 0, 15));
            editor.setEditable(false);
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
