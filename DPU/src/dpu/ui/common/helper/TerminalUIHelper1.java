/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common.helper;

import dpu.beans.admin.TerminalBean;
import dpu.dao.admin.TerminalDAO;
import dpu.dao.admin.impl.TerminalDAOImpl;
import dpu.ui.common.AddTerminalFrame;
import dpu.ui.common.TerminalPanel1;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gagandeep.rana
 */
public class TerminalUIHelper1 {

    public static List<TerminalBean> lstTerminals = new ArrayList();
    TerminalDAO terminalDAO = new TerminalDAOImpl();
    public static int terminalId = 0;
    public static String addUpdateFlag = "add";

    public String delete(int terminalIdToBeDeleted) {
        String msg = terminalDAO.deleteTerminal(terminalIdToBeDeleted);
        lstTerminals = terminalDAO.getAllTerminals(TerminalPanel1.txtSearch.getText());
        generateTable();
        return msg;
    }

    public void showData(TerminalBean terminalBean) {
        AddTerminalFrame.txt1.setText(terminalBean.getTerminalName());
        AddTerminalFrame.txt2.setText(terminalBean.getLocation());
    }

    public void generateTable() {
        Object[] cols = {"Terminal", "Location"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TerminalPanel1.tblTerminal.setModel(defaultTableModel);
        TerminalPanel1.tblTerminal.setAutoCreateRowSorter(true);
        TerminalPanel1.tblTerminal.setDefaultRenderer(Object.class, new TerminalUIHelper1.TerminalTable());
        if (lstTerminals.size() > 0) {
            Object[][] data = new Object[lstTerminals.size()][2];
            for (int i = 0; i < lstTerminals.size(); i++) {
                TerminalBean obj = lstTerminals.get(i);
                data[i][0] = obj.getTerminalName();
                data[i][1] = obj.getLocation();
                TerminalPanel1.tblTerminal.setRowHeight(30);
            }
            defaultTableModel.setDataVector(data, cols);
            TerminalPanel1.tblTerminal.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            TerminalPanel1.tblTerminal.getTableHeader().setForeground(Color.DARK_GRAY);
            TerminalPanel1.tblTerminal.setIntercellSpacing(new Dimension(0, 0));
            TerminalPanel1.tblTerminal.setShowGrid(false);
            TerminalPanel1.jScrollPane9.setViewportView(TerminalPanel1.tblTerminal);
        } else {
            generateEmptyTable();
        }
    }

    public void generateEmptyTable() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TerminalPanel1.tblTerminal.setModel(defaultTableModel);
        TerminalPanel1.tblTerminal.setDefaultRenderer(Object.class, new TerminalUIHelper1.TerminalTable());
        Object[][] data = new Object[7][2];
        for (int i = 0; i < 7; i++) {
            data[i][0] = "";
            data[i][1] = "";
            TerminalPanel1.tblTerminal.setRowHeight(30);
        }
        Object[] cols = {"Terminal", "Location"};

        defaultTableModel.setDataVector(data, cols);
        TerminalPanel1.tblTerminal.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        TerminalPanel1.tblTerminal.getTableHeader().setForeground(Color.DARK_GRAY);
        TerminalPanel1.tblTerminal.setIntercellSpacing(new Dimension(0, 0));
        TerminalPanel1.tblTerminal.setShowGrid(false);
        TerminalPanel1.jScrollPane9.setViewportView(TerminalPanel1.tblTerminal);
    }

    public void save() {
        TerminalBean terminalBean = new TerminalBean();
        terminalBean.setTerminalName(AddTerminalFrame.txt1.getText());
        terminalBean.setLocation(AddTerminalFrame.txt2.getText());
        String msg = "";
        if (TerminalUIHelper1.addUpdateFlag.equals("add")) {
            int i = terminalDAO.addTerminal(terminalBean);
            if (i > 0) {
                msg = "New Terminal Added";
            }
        } else {
            terminalBean.setTerminalId(terminalId);
            msg = terminalDAO.updateTerminal(terminalBean);
        }
        lstTerminals = terminalDAO.getAllTerminals(TerminalPanel1.txtSearch.getText());
        generateTable();
        JOptionPane.showMessageDialog(null, msg);
    }

    class TerminalTable extends DefaultTableCellRenderer {

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
