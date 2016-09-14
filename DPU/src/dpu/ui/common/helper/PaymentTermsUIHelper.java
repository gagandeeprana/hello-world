/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common.helper;

import dpu.beans.admin.PaymentTermsBean;
import dpu.dao.admin.PaymentTermsDAO;
import dpu.dao.admin.impl.PaymentTermsDAOImpl;
import dpu.ui.common.AddPaymentTermsFrame;
import dpu.ui.common.PaymentTermsPanel;
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
public class PaymentTermsUIHelper {

    public static List<PaymentTermsBean> lstPaymentTerms = new ArrayList();
    PaymentTermsDAO paymentTermsDAO = new PaymentTermsDAOImpl();
    public static int paymentTermsId = 0;
    public static String addUpdateFlag = "add";

    public String delete(int paymentTermsIdToBeDeleted) {
        String msg = paymentTermsDAO.deletePaymentTerm(paymentTermsIdToBeDeleted);
        lstPaymentTerms = paymentTermsDAO.getAllPaymentTerms(PaymentTermsPanel.txtSearch.getText());
        generateTable();
        return msg;
    }

    public void showData(PaymentTermsBean paymentTermsBean) {
        AddPaymentTermsFrame.txt1.setText(paymentTermsBean.getTerm());
        AddPaymentTermsFrame.txt2.setText(String.valueOf(paymentTermsBean.getNetDueIn()));
        AddPaymentTermsFrame.txt3.setText(String.valueOf(paymentTermsBean.getDiscountPercent()));
        AddPaymentTermsFrame.txt4.setText(String.valueOf(paymentTermsBean.getDiscountWithinDays()));
        AddPaymentTermsFrame.ddl1.setSelectedIndex(paymentTermsBean.getStatus() == 1 ? 0 : 1);
    }

    public void generateTable() {
        Object[] cols = {"PaymentTerms Id", "PaymentTerms"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        PaymentTermsPanel.tblPaymentTerms.setModel(defaultTableModel);
        PaymentTermsPanel.tblPaymentTerms.setAutoCreateRowSorter(true);
        PaymentTermsPanel.tblPaymentTerms.setDefaultRenderer(Object.class, new PaymentTermsUIHelper.PaymentTermsTable());
        if (lstPaymentTerms.size() > 0) {
            Object[][] data = new Object[lstPaymentTerms.size()][1];
            for (int i = 0; i < lstPaymentTerms.size(); i++) {
                PaymentTermsBean obj = lstPaymentTerms.get(i);
                data[i][0] = obj.getTerm();
                PaymentTermsPanel.tblPaymentTerms.setRowHeight(30);
            }
            defaultTableModel.setDataVector(data, cols);
            PaymentTermsPanel.tblPaymentTerms.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            PaymentTermsPanel.tblPaymentTerms.getTableHeader().setForeground(Color.DARK_GRAY);
            PaymentTermsPanel.tblPaymentTerms.setIntercellSpacing(new Dimension(0, 0));
            PaymentTermsPanel.tblPaymentTerms.setShowGrid(false);
            PaymentTermsPanel.jScrollPane9.setViewportView(PaymentTermsPanel.tblPaymentTerms);
        } else {
            generateEmptyTable();
        }
    }

    public void generateEmptyTable() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        PaymentTermsPanel.tblPaymentTerms.setModel(defaultTableModel);
        PaymentTermsPanel.tblPaymentTerms.setDefaultRenderer(Object.class, new PaymentTermsUIHelper.PaymentTermsTable());
        Object[][] data = new Object[7][1];
        for (int i = 0; i < 7; i++) {
            data[i][0] = "";
            PaymentTermsPanel.tblPaymentTerms.setRowHeight(30);
        }
        Object[] cols = {"Terms"};

        defaultTableModel.setDataVector(data, cols);
        PaymentTermsPanel.tblPaymentTerms.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        PaymentTermsPanel.tblPaymentTerms.getTableHeader().setForeground(Color.DARK_GRAY);
        PaymentTermsPanel.tblPaymentTerms.setIntercellSpacing(new Dimension(0, 0));
        PaymentTermsPanel.tblPaymentTerms.setShowGrid(false);
        PaymentTermsPanel.jScrollPane9.setViewportView(PaymentTermsPanel.tblPaymentTerms);
    }

    public void save() {
        PaymentTermsBean paymentTermsBean = new PaymentTermsBean();
        paymentTermsBean.setTerm(AddPaymentTermsFrame.txt1.getText());
        paymentTermsBean.setNetDueIn(Integer.parseInt(AddPaymentTermsFrame.txt2.getText()));
        paymentTermsBean.setDiscountPercent(Double.parseDouble(AddPaymentTermsFrame.txt3.getText()));
        paymentTermsBean.setDiscountWithinDays(Integer.parseInt(AddPaymentTermsFrame.txt4.getText()));
        paymentTermsBean.setIsDiscountPaid(1);
        paymentTermsBean.setStatus(AddPaymentTermsFrame.ddl1.getSelectedIndex() == 0 ? 1 : 0);
        String msg = "";
        if (PaymentTermsUIHelper.addUpdateFlag.equals("add")) {
            int i = paymentTermsDAO.addPaymentTerm(paymentTermsBean);
            if (i > 0) {
                msg = "New PaymentTerm Added";
            }
        } else {
            paymentTermsBean.setTermId(paymentTermsId);
            msg = paymentTermsDAO.updatePaymentTerm(paymentTermsBean);
        }
        lstPaymentTerms = paymentTermsDAO.getAllPaymentTerms(PaymentTermsPanel.txtSearch.getText());
        generateTable();
        JOptionPane.showMessageDialog(null, msg);
    }

    class PaymentTermsTable extends DefaultTableCellRenderer {

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
