/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common.helper;

import dpu.Validations;
import dpu.beans.admin.TerminalBean;
import dpu.dao.admin.TerminalDAO;
import dpu.dao.admin.impl.TerminalDAOImpl;
import dpu.ui.terminal.AddTerminal;
import dpu.ui.terminal.LocationFrame;
import dpu.ui.terminal.TerminalPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author sunny
 */
public class TerminalUIHelper {

    public static List<TerminalBean> lstTerminals = new ArrayList();
    public static List<TerminalBean> lstTerminals1 = new ArrayList();
    public static List<TerminalBean> lstLocation = new ArrayList();
    TerminalDAO terminalDAO = new TerminalDAOImpl();
    public static int terminalId = 0;
    public static String addUpdateFlag = "add";
    public static TerminalBean terminalBean=new TerminalBean();

    public String delete(int terminalIdToBeDeleted) {
        String msg = terminalDAO.deleteTerminal(terminalIdToBeDeleted);
        lstTerminals = terminalDAO.getAllTerminals(TerminalPanel.txtSearch.getText());
        generateTable();
        return msg;
    }

    public void showData(TerminalBean terminalBean) {
        AddTerminal.txtTerminal.setText(terminalBean.getTerminalName());
        AddTerminal.txtLocation.setText(terminalBean.getLocation());
    }

    public void generateTable() {
        Object[] cols = {"Terminal", "Facilty", "Location"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        JFrame frame = new JFrame();
// set up frame

// Set up table, add data
// Frame has a content pane with BorderLayout by default
        frame.getContentPane().add(new JScrollPane(TerminalPanel.tblTerminal), BorderLayout.CENTER);
        TerminalPanel.tblTerminal.setModel(defaultTableModel);
        TerminalPanel.tblTerminal.setAutoCreateRowSorter(true);
        TerminalPanel.tblTerminal.setDefaultRenderer(Object.class, new TerminalUIHelper.TerminalTable());
        if (lstTerminals.size() > 0) {
            System.out.println("list>0");
            Object[][] data = new Object[lstTerminals.size()][3];
            for (int i = 0; i < lstTerminals.size(); i++) {
                TerminalBean obj = lstTerminals.get(i);
                data[i][0] = obj.getTerminalName();
                data[i][1] = obj.getFacility();
                data[i][2] = obj.getLocation();
                TerminalPanel.tblTerminal.setRowHeight(20);
            }
            defaultTableModel.setDataVector(data, cols);
            TerminalPanel.tblTerminal.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            TerminalPanel.tblTerminal.getTableHeader().setForeground(Color.DARK_GRAY);
            TableCellRenderer renderer = TerminalPanel.tblTerminal.getTableHeader().getDefaultRenderer();
            JLabel label = (JLabel) renderer;
            label.setHorizontalAlignment(JLabel.LEFT);
            TerminalPanel.tblTerminal.setIntercellSpacing(new Dimension(0, 0));
            TerminalPanel.tblTerminal.setShowGrid(false);
            TerminalPanel.tblTerminal.setShowVerticalLines(true);
            TerminalPanel.tblTerminal.setShowGrid(false);
            TerminalPanel.tblTerminal.setShowHorizontalLines(false);
            TerminalPanel.jScrollPane9.setViewportView(TerminalPanel.tblTerminal);

        } else {
            generateEmptyTable();
        }
    }

    public void generateEmptyTable() {
        System.out.println("empty");
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TerminalPanel.tblTerminal.setModel(defaultTableModel);
        TerminalPanel.tblTerminal.setDefaultRenderer(Object.class, new TerminalUIHelper.TerminalTable());
        TableCellRenderer renderer = TerminalPanel.tblTerminal.getTableHeader().getDefaultRenderer();
        JLabel label = (JLabel) renderer;
        label.setHorizontalAlignment(JLabel.LEFT);
        Object[][] data = new Object[7][3];
        for (int i = 0; i < 7; i++) {
            data[i][0] = "";
            data[i][1] = "";
            data[i][2] = "";
            TerminalPanel.tblTerminal.setRowHeight(20);
        }
        Object[] cols = {"Terminal", "Facilty", "Location"};

        defaultTableModel.setDataVector(data, cols);
        TerminalPanel.tblTerminal.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        TerminalPanel.tblTerminal.getTableHeader().setForeground(Color.DARK_GRAY);
        TerminalPanel.tblTerminal.setIntercellSpacing(new Dimension(0, 0));
        TerminalPanel.tblTerminal.setShowGrid(false);
        TerminalPanel.tblTerminal.setShowVerticalLines(true);
        TerminalPanel.tblTerminal.setShowGrid(false);
        TerminalPanel.tblTerminal.setShowHorizontalLines(false);
        TerminalPanel.jScrollPane9.setViewportView(TerminalPanel.tblTerminal);

    }

    public void save() {
       
        terminalBean.setTerminalName(AddTerminal.txtTerminal.getText());
//        terminalBean.setLocation(AddTerminal.txtLocation.getText());
//        terminalBean.
        String msg = "";
        String tn = (AddTerminal.txtTerminal.getText());
        String loc = (AddTerminal.txtLocation.getText());
        String facilty = terminalBean.getFacility().toString();
        System.out.println("tn :" + tn + "facilty " + facilty + "loc " + loc);
        String result = validations(tn, loc);
        System.out.println("result " + result);
        if (result == "true") {
            lstTerminals1 = terminalDAO.getAllTerminals(TerminalPanel.txtSearch.getText());
            int count = 0;
            for (int i = 0; i < lstTerminals1.size(); i++) {
                System.out.println("lstTerminals1.name" + lstTerminals1.get(i).getTerminalName() + "   terminalBean.getTerminalName()" + terminalBean.getTerminalName());
                if (lstTerminals1.get(i).getTerminalName().equals(terminalBean.getTerminalName())) {
                    count++;
                }
            }
            if (count > 0) {
                msg = "Terminal already exists";
            } else {
                if (TerminalUIHelper.addUpdateFlag.equals("add")) {
                    int i = terminalDAO.addTerminal(terminalBean);
                    if (i > 0) {
                        msg = "New Terminal Added";
                    }
                } else {
                    terminalBean.setTerminalId(terminalId);
                    msg = terminalDAO.updateTerminal(terminalBean);
                }
            }

        } else {
            msg = result;
        }
        lstTerminals = terminalDAO.getAllTerminals(TerminalPanel.txtSearch.getText());
        generateTable();
        JOptionPane.showMessageDialog(null, msg);
    }

    private String validations(String tn1, String loc1) {
        if (Validations.isEmpty(tn1) || Validations.isEmpty(loc1)) {
            return "!!Terminal Or Locatiion Name can't be empty";
        }
        return "true";

    }

    class TerminalTable extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JTextField editor = new JTextField();
            editor.setFont(new Font(Font.SANS_SERIF, 0, 12));
            editor.setEditable(false);
            editor.setBorder(null);
            if (value != null) {
                editor.setText("   " + value.toString());
            }
            Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
            editor.setBorder(border);
            editor.setBackground(Color.white);
            if (isSelected) {
                border = BorderFactory.createLineBorder(Color.CYAN, 4);
                editor.setBorder(border);
                editor.setBackground(Color.CYAN);
            }
            return editor;
        }
    }
}
