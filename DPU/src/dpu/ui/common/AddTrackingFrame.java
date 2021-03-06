/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common;

import dpu.ui.common.helper.TrackingUIHelper;
import dpu.Validations;
import dpu.beans.admin.TrackingBean;
import dpu.dao.admin.TrackingDAO;
import dpu.dao.admin.impl.TrackingDAOImpl;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class AddTrackingFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddTracking
     */
    String msg = "";
    TrackingUIHelper trackingUI = null;
    String addUpdateFlag = "";
    TrackingBean trackingBean;

    public AddTrackingFrame() {
        initComponents();
        setLocationRelativeTo(null);
        trackingUI = new TrackingUIHelper();
        btnSaveAddTracking.setEnabled(false);
        fillLabel();
    }

    public AddTrackingFrame(TrackingBean trackingBean) {
        initComponents();
        trackingUI = new TrackingUIHelper();
        this.trackingBean = trackingBean;
        setLocationRelativeTo(null);
        addUpdateFlag = "update";
        showRecord(trackingBean);
        btnSaveAddTracking.setText("Update");
        btnSaveAddTracking.setEnabled(true);
    }

    private void fillLabel() {
        lblTrackingIdAddTrackingFrameValidation.setText(" ");
        lblTrackingDateAddTrackingFrameValidation.setText(" ");
    }

    public boolean validateTrackingId(String str) {
        if (Validations.isEmpty(str)) {
            msg = "Left Empty..!";
            return false;
        }
        if (Validations.hasNumerals(str)) {
            msg = "Only Numerics Allowed..!";
            return false;
        }
        if (Validations.hasSpace(str)) {
            msg = "Space Not Allowed..!";
            return false;
        }
        return true;
    }

    public boolean validateTrackingDate(String str) {
        if (Validations.isEmpty(str)) {
            msg = "Left Empty..!";
            return false;
        }
        return true;
    }

    public void showRecord(TrackingBean trackingBean) {
        txtTrackingIdAddTracking.setText(String.valueOf(trackingBean.getTrackingId()));
        txtTrackingDateAddTracking.setText(String.valueOf(trackingBean.getTrackingDate()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTrackingIdAddTracking = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTrackingDateAddTracking = new javax.swing.JTextField();
        btnSaveAddTracking = new javax.swing.JButton();
        btnCancelAddTracking = new javax.swing.JButton();
        lblTrackingIdAddTrackingFrameValidation = new javax.swing.JLabel();
        lblTrackingDateAddTrackingFrameValidation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tracking Id");

        txtTrackingIdAddTracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrackingIdAddTrackingActionPerformed(evt);
            }
        });
        txtTrackingIdAddTracking.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTrackingIdAddTrackingKeyReleased(evt);
            }
        });

        jLabel8.setText("Tracking Date");

        txtTrackingDateAddTracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrackingDateAddTrackingActionPerformed(evt);
            }
        });
        txtTrackingDateAddTracking.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTrackingDateAddTrackingKeyReleased(evt);
            }
        });

        btnSaveAddTracking.setText("Save");
        btnSaveAddTracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAddTrackingActionPerformed(evt);
            }
        });

        btnCancelAddTracking.setText("Cancel");
        btnCancelAddTracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelAddTrackingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSaveAddTracking, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelAddTracking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTrackingDateAddTracking)
                            .addComponent(txtTrackingIdAddTracking, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTrackingIdAddTrackingFrameValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTrackingDateAddTrackingFrameValidation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelAddTracking, btnSaveAddTracking});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTrackingIdAddTrackingFrameValidation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtTrackingIdAddTracking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtTrackingDateAddTracking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTrackingDateAddTrackingFrameValidation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveAddTracking)
                    .addComponent(btnCancelAddTracking))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTrackingIdAddTrackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrackingIdAddTrackingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrackingIdAddTrackingActionPerformed

    private void btnCancelAddTrackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelAddTrackingActionPerformed
        dispose();
        trackingUI.disable(true);
    }//GEN-LAST:event_btnCancelAddTrackingActionPerformed

    private void btnSaveAddTrackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAddTrackingActionPerformed
        String msg = "";
        if (addUpdateFlag.equals("update")) {
            msg = trackingUI.update();
        } else {
            msg = trackingUI.save();
        }
        JOptionPane.showMessageDialog(null, msg);
        dispose();
    }//GEN-LAST:event_btnSaveAddTrackingActionPerformed

    private void txtTrackingIdAddTrackingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTrackingIdAddTrackingKeyReleased
        TrackingDAO trackingDAO = new TrackingDAOImpl();
        List<TrackingBean> lstTrackings = trackingDAO.getAllTrackings("");
        try {
            if (validateTrackingId(txtTrackingIdAddTracking.getText())) {
                lblTrackingIdAddTrackingFrameValidation.setText("");
                for (TrackingBean trackingBean : lstTrackings) {
                    if (trackingBean.getTrackingId() == Integer.parseInt(txtTrackingIdAddTracking.getText().trim())) {
                        lblTrackingIdAddTrackingFrameValidation.setText("Already Taken");
                        btnSaveAddTracking.setEnabled(false);
                    }
                }
            } else {
                lblTrackingIdAddTrackingFrameValidation.setText(msg);
                btnSaveAddTracking.setEnabled(false);
            }
            if (lblTrackingIdAddTrackingFrameValidation.getText().equals("") && lblTrackingDateAddTrackingFrameValidation.getText().equals("")) {
                btnSaveAddTracking.setEnabled(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_txtTrackingIdAddTrackingKeyReleased

    private void txtTrackingDateAddTrackingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTrackingDateAddTrackingKeyReleased
        try {
            lblTrackingDateAddTrackingFrameValidation.setText("");
            if (!validateTrackingDate(txtTrackingDateAddTracking.getText())) {
                lblTrackingDateAddTrackingFrameValidation.setText(msg);
                btnSaveAddTracking.setEnabled(false);
            }
            if (lblTrackingIdAddTrackingFrameValidation.getText().equals("") && lblTrackingDateAddTrackingFrameValidation.getText().equals("")) {
                btnSaveAddTracking.setEnabled(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_txtTrackingDateAddTrackingKeyReleased

    private void txtTrackingDateAddTrackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrackingDateAddTrackingActionPerformed
    }//GEN-LAST:event_txtTrackingDateAddTrackingActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddTrackingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTrackingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTrackingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTrackingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTrackingFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCancelAddTracking;
    public static javax.swing.JButton btnSaveAddTracking;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblTrackingDateAddTrackingFrameValidation;
    private javax.swing.JLabel lblTrackingIdAddTrackingFrameValidation;
    public static javax.swing.JTextField txtTrackingDateAddTracking;
    public static javax.swing.JTextField txtTrackingIdAddTracking;
    // End of variables declaration//GEN-END:variables
}
