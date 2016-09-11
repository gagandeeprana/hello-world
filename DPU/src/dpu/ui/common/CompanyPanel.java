/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common;

import dpu.beans.admin.CompanyBean;
import dpu.reports.common.JasperReportGenerator;
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
 * @author gagandeep.rana
 */
public class CompanyPanel extends javax.swing.JPanel {

    /**
     * Creates new form CompanyPanel
     */
    Logger logger = Logger.getLogger(CompanyPanel.class);

//    @Autowired
    CompanyUIHelper companyUIHelper;
//    String printImage = ReadFromPropertiesFile.imagePath + ImageConstants.PRINT;
    String printImage = "";

    public CompanyPanel() {
        initComponents();
//        DPU.autowire(this);
        doWork();
    }

    private void doWork() {
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        companyUIHelper = new CompanyUIHelper();
        companyUIHelper.generateTable();
        btnPrint.setToolTipText("Print Company Report...");
//        btnPrint.setIcon(new ImageIcon(printImage));
        btnPrint.setContentAreaFilled(false);
        btnDelete.setContentAreaFilled(false);
        btnUpdate.setContentAreaFilled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtCompanySearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblAddManageCompany = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCompany = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1265, 539));

        jPanel2.setBackground(new java.awt.Color(135, 192, 248));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("Type CustomBroker to Search...");

        txtCompanySearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCompanySearch.setToolTipText("Type CustomBroker to Search...");
        txtCompanySearch.setBorder(null);
        txtCompanySearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCompanySearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCompanySearchKeyTyped(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SearchIcon24.png"))); // NOI18N
        jLabel2.setToolTipText("Type CustomBroker to Search...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtCompanySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCompanySearch))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblAddManageCompany.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add.png"))); // NOI18N
        lblAddManageCompany.setToolTipText("Add New Company...");
        lblAddManageCompany.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddManageCompanyMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAddManageCompanyMousePressed(evt);
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

        btnPrint.setBackground(new java.awt.Color(135, 192, 248));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print.png"))); // NOI18N
        btnPrint.setToolTipText("Print Company Report...");
        btnPrint.setBorder(null);
        btnPrint.setBorderPainted(false);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(135, 192, 248));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        btnDelete.setToolTipText("Delete Company...");
        btnDelete.setBorder(null);
        btnDelete.setBorderPainted(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(135, 192, 248));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Update.png"))); // NOI18N
        btnUpdate.setToolTipText("Edit Company...");
        btnUpdate.setBorder(null);
        btnUpdate.setBorderPainted(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddManageCompany)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(861, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblAddManageCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnPrint, jPanel1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCompanySearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanySearchKeyReleased
        companyUIHelper.generateTable();
    }//GEN-LAST:event_txtCompanySearchKeyReleased

    private void txtCompanySearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanySearchKeyTyped
    }//GEN-LAST:event_txtCompanySearchKeyTyped

    private void lblAddManageCompanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddManageCompanyMouseClicked

    }//GEN-LAST:event_lblAddManageCompanyMouseClicked

    private void lblAddManageCompanyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddManageCompanyMousePressed
        // TODO add your handling code here:
        companyUIHelper.addUpdateFlag = "add";
        AddCustomerFrame addCustomerFrame = new AddCustomerFrame();
        addCustomerFrame.setVisible(true);
        companyUIHelper.disable(false);
    }//GEN-LAST:event_lblAddManageCompanyMousePressed

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

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int companyIdToBeDeleted = CompanyUIHelper.lstCompanies.get(tblCompany.getSelectedRow()).getCompanyId();
        companyUIHelper.delete(companyIdToBeDeleted);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        CompanyBean companyBean = CompanyUIHelper.lstCompanies.get(tblCompany.getSelectedRow());
        CompanyUIHelper.companyId = companyBean.getCompanyId();
        CompanyUIHelper.addUpdateFlag = "update";
        AddCustomerFrame addCustomerFrame = new AddCustomerFrame(companyBean);
        addCustomerFrame.setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnDelete;
    public static javax.swing.JButton btnPrint;
    public static javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    public static javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JLabel lblAddManageCompany;
    public static javax.swing.JTable tblCompany;
    public static javax.swing.JTextField txtCompanySearch;
    // End of variables declaration//GEN-END:variables
}
