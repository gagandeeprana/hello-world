/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common;

import dpu.ui.helper.common.TrailerUIHelper;

/**
 *
 * @author gagandeep.rana
 */
public class TestTrailerPanel extends javax.swing.JPanel {

    /**
     * Creates new form TestTrailerPanel
     */
    
    TrailerUIHelper trailerUIHelper = null;

    public TestTrailerPanel() {
        initComponents();
        trailerUIHelper = new TrailerUIHelper();
        btnAddManageTrailer.setContentAreaFilled(false);
        btnPrintManageTrailer.setContentAreaFilled(false);
        trailerUIHelper.generateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddManageTrailer = new javax.swing.JButton();
        txtSearchManageTrailer = new javax.swing.JTextField();
        btnPrintManageTrailer = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblTrailer = new javax.swing.JTable();

        btnAddManageTrailer.setIcon(new javax.swing.ImageIcon("D:\\JavaGit\\hello-world\\DPU\\images\\Add.png")); // NOI18N
        btnAddManageTrailer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddManageTrailerMouseClicked(evt);
            }
        });
        btnAddManageTrailer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddManageTrailerActionPerformed(evt);
            }
        });

        btnPrintManageTrailer.setIcon(new javax.swing.ImageIcon("D:\\JavaGit\\hello-world\\DPU\\images\\Print.png")); // NOI18N

        tblTrailer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(tblTrailer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddManageTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchManageTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrintManageTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddManageTrailer)
                    .addComponent(txtSearchManageTrailer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrintManageTrailer, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddManageTrailer, btnPrintManageTrailer, txtSearchManageTrailer});

    }// </editor-fold>//GEN-END:initComponents

    private void btnAddManageTrailerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddManageTrailerMouseClicked
        // TODO add your handling code here:
        AddPowerUnitFrame addPowerUnitFrame = new AddPowerUnitFrame();
        addPowerUnitFrame.setVisible(true);
    }//GEN-LAST:event_btnAddManageTrailerMouseClicked

    private void btnAddManageTrailerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddManageTrailerActionPerformed

    }//GEN-LAST:event_btnAddManageTrailerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAddManageTrailer;
    public static javax.swing.JButton btnPrintManageTrailer;
    public static javax.swing.JScrollPane jScrollPane9;
    public static javax.swing.JTable tblTrailer;
    public static javax.swing.JTextField txtSearchManageTrailer;
    // End of variables declaration//GEN-END:variables
}
