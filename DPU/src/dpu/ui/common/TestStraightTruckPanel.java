/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common;

import dpu.ui.helper.common.StraightTruckUIHelper;

/**
 *
 * @author gagandeep.rana
 */
public class TestStraightTruckPanel extends javax.swing.JPanel {

    /**
     * Creates new form TestStraightTruckPanel
     */
    
    StraightTruckUIHelper straightTruckUIHelper = null;
    
    public TestStraightTruckPanel() {
        initComponents();
        straightTruckUIHelper = new StraightTruckUIHelper();
        btnAddManageStraightTruck.setContentAreaFilled(false);
        btnPrintManageStraightTruck.setContentAreaFilled(false);
        straightTruckUIHelper.generateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddManageStraightTruck = new javax.swing.JButton();
        txtSearchManageStraightTruck = new javax.swing.JTextField();
        btnPrintManageStraightTruck = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblStraightTruck = new javax.swing.JTable();

        btnAddManageStraightTruck.setIcon(new javax.swing.ImageIcon("D:\\JavaGit\\hello-world\\DPU\\images\\Add.png")); // NOI18N
        btnAddManageStraightTruck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddManageStraightTruckMouseClicked(evt);
            }
        });
        btnAddManageStraightTruck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddManageStraightTruckActionPerformed(evt);
            }
        });

        txtSearchManageStraightTruck.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchManageStraightTruckKeyReleased(evt);
            }
        });

        btnPrintManageStraightTruck.setIcon(new javax.swing.ImageIcon("D:\\JavaGit\\hello-world\\DPU\\images\\Print.png")); // NOI18N

        tblStraightTruck.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Unit No", "Class", "Equipment Type", "Length", "VIN", "Make", "Model", "Year", "Plate No", "Jurisdiction", "Tare Wgt.", "R.G.W", "Current Odometer", "Reading Taken", "Created By", "Created On", "Division", "Terminal", "Category", "IFTA A/c"
            }
        ));
        jScrollPane9.setViewportView(tblStraightTruck);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddManageStraightTruck, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchManageStraightTruck, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrintManageStraightTruck)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1227, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnPrintManageStraightTruck, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAddManageStraightTruck))
                    .addComponent(txtSearchManageStraightTruck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddManageStraightTruck, btnPrintManageStraightTruck, txtSearchManageStraightTruck});

    }// </editor-fold>//GEN-END:initComponents

    private void btnAddManageStraightTruckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddManageStraightTruckActionPerformed

    }//GEN-LAST:event_btnAddManageStraightTruckActionPerformed

    private void btnAddManageStraightTruckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddManageStraightTruckMouseClicked
        // TODO add your handling code here:
        AddPowerUnitFrame addPowerUnitFrame = new AddPowerUnitFrame();
        addPowerUnitFrame.setVisible(true);
    }//GEN-LAST:event_btnAddManageStraightTruckMouseClicked

    private void txtSearchManageStraightTruckKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchManageStraightTruckKeyReleased
        straightTruckUIHelper.generateTable();
    }//GEN-LAST:event_txtSearchManageStraightTruckKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAddManageStraightTruck;
    public static javax.swing.JButton btnPrintManageStraightTruck;
    public static javax.swing.JScrollPane jScrollPane9;
    public static javax.swing.JTable tblStraightTruck;
    public static javax.swing.JTextField txtSearchManageStraightTruck;
    // End of variables declaration//GEN-END:variables
}
