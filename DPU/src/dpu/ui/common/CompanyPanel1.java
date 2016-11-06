/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common;

import dpu.beans.admin.CompanyBean;
import dpu.reports.common.JasperReportGenerator;
import static dpu.ui.common.CompanyPanel.tblCompany;
import dpu.ui.common.helper.CompanyUIHelper;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.apache.log4j.Logger;
import properties.ReadFromPropertiesFile;

/**
 *
 * @author Gagandeep
 */
public class CompanyPanel1 extends javax.swing.JPanel {

    /**
     * Creates new form CompanyPanel1
     */
     Logger logger = Logger.getLogger(CompanyPanel.class);

//    @Autowired
    CompanyUIHelper companyUIHelper;
//    String printImage = ReadFromPropertiesFile.imagePath + ImageConstants.PRINT;
    String printImage = "";
    
    public CompanyPanel1() {
        initComponents();
        doWork();
    }
    
    
    private void doWork() {
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        companyUIHelper = new CompanyUIHelper();
        companyUIHelper.generateTable();
//        btnPrint.setToolTipText("Print Company Report...");
//        btnPrint.setIcon(new ImageIcon(printImage));
//        btnPrint.setContentAreaFilled(false);
//        btnDelete.setContentAreaFilled(false);
//        btnUpdate.setContentAreaFilled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        btnAdd = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCompany = new javax.swing.JTable();

        btnAdd.setText("+");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel10.setText("Search");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnUpdate.setText("Edit");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jScrollPane4.setToolTipText("Company Listing...");
        jScrollPane4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        tblCompany.setAutoCreateRowSorter(true);
        tblCompany.setFont(new java.awt.Font("BatangChe", 0, 14)); // NOI18N
        tblCompany.setForeground(new java.awt.Color(255, 102, 102));
        tblCompany.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Title", "address", "Unit No", "City", "Province/State", "Zip", "Email", "Website", "Contact", "Position", "Phone", "Ext", "Fax", "Pager"
            }
        ));
        tblCompany.setToolTipText("Company Listing...");
        tblCompany.setGridColor(new java.awt.Color(255, 255, 255));
        tblCompany.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblCompanyMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tblCompany);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1229, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked

    }//GEN-LAST:event_btnAddMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
//        TypeUIHelper.addUpdateFlag = "add";
//        AddTypeFrame addTypeFrame = new AddTypeFrame();
//        addTypeFrame.setVisible(true);
        companyUIHelper.addUpdateFlag = "add";
        AddCustomerFrame addCustomerFrame = new AddCustomerFrame();
        addCustomerFrame.setVisible(true);
        companyUIHelper.disable(false);
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
//        TypeUIHelper.lstTypes = typeDAO.getAllTypes(TypePanel.txtSearch.getText());
//        typeUIHelper.generateTable();
        companyUIHelper.generateTable();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
//        JasperReportGenerator.generateReport("TypeReport.jrxml");
        JasperReportGenerator.generateReport("CompanyReport.jrxml");

    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
//        TypeBean typeBean = TypeUIHelper.lstTypes.get(tblType.getSelectedRow());
//        TypeUIHelper.typeId = typeBean.getTypeId();
//        TypeUIHelper.addUpdateFlag = "update";
//        AddTypeFrame addTypeFrame = new AddTypeFrame(typeBean);
//        addTypeFrame.setVisible(true);
        CompanyBean companyBean = CompanyUIHelper.lstCompanies.get(tblCompany.getSelectedRow());
        CompanyUIHelper.companyId = companyBean.getCompanyId();
        CompanyUIHelper.addUpdateFlag = "update";
        AddCustomerFrame addCustomerFrame = new AddCustomerFrame(companyBean);
        addCustomerFrame.setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
//        int typeIdToBeDeleted = TypeUIHelper.lstTypes.get(tblType.getSelectedRow()).getTypeId();
//        String msg = typeUIHelper.delete(typeIdToBeDeleted);
//        JOptionPane.showMessageDialog(null, msg);
        int companyIdToBeDeleted = CompanyUIHelper.lstCompanies.get(tblCompany.getSelectedRow()).getCompanyId();
        companyUIHelper.delete(companyIdToBeDeleted);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblCompanyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCompanyMouseReleased
        if (evt.getButton() == 3) {
            final MouseEvent evt1 = evt;
            jPopupMenu1 = new JPopupMenu();
            JMenuItem menuItem1 = new JMenuItem("Add New Customer");
            menuItem1.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "New-Customer.png"));
            menuItem1.setIconTextGap(5);
            JMenuItem menuItem2 = new JMenuItem("Print Company Report");
            menuItem2.setIcon(new ImageIcon(printImage));
            menuItem2.setIconTextGap(5);
            JMenuItem menuItem3 = new JMenuItem("Edit Customer");
            menuItem3.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "New-Customer.png"));
            menuItem3.setIconTextGap(5);
            JMenuItem menuItem4 = new JMenuItem("Delete Customer");
            menuItem4.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
            menuItem4.setIconTextGap(5);
            jPopupMenu1.add(menuItem1);
            jPopupMenu1.add(menuItem2);
            jPopupMenu1.add(menuItem3);
            jPopupMenu1.add(menuItem4);
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());

            menuItem1.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    CompanyUIHelper.addUpdateFlag = "add";
                    AddCustomerFrame addCustomerFrame = new AddCustomerFrame();
                    addCustomerFrame.setVisible(true);
                }
            });

            menuItem2.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JasperReportGenerator.generateReport("CustomerReport.jrxml");
                }
            });

            menuItem3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CompanyUIHelper.addUpdateFlag = "update";
                    CompanyBean companyBean = new CompanyBean();
                    companyBean = CompanyUIHelper.lstCompanies.get(tblCompany.rowAtPoint(evt1.getPoint()));
                    CompanyUIHelper.companyId = companyBean.getCompanyId();
                    AddCustomerFrame addCustomerFrame = new AddCustomerFrame(companyBean);
                    addCustomerFrame.setVisible(true);
                }
            });

            menuItem4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CompanyBean companyBean = CompanyUIHelper.lstCompanies.get(tblCompany.rowAtPoint(evt1.getPoint()));
                    companyUIHelper.delete(companyBean.getCompanyId());
                }
            });
        } else if (evt.getButton() == 1) {
            tblCompany.setSelectionBackground(Color.GREEN);
        }
    }//GEN-LAST:event_tblCompanyMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAdd;
    public static javax.swing.JButton btnDelete;
    public static javax.swing.JButton btnPrint;
    public static javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPopupMenu jPopupMenu1;
    public static javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable tblCompany;
    public static javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
