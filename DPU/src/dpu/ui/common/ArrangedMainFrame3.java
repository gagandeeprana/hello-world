/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;
import properties.ReadFromPropertiesFile;

/**
 *
 * @author gagandeep.rana
 */
public class ArrangedMainFrame3 extends javax.swing.JFrame {

    /**
     * Creates new form ArrangedMainFrame
     */
    float alpha = 1.0f;
    Timer timer;
    int animationDuration = 2000;
    long animationStartTime;
    BufferedImage buttonImage = null;
    boolean flag = true;
    Container root = null;

    public ArrangedMainFrame3() {
        initComponents();
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setButtonContentArea();
        jInternalFrame1.setPreferredSize(new Dimension(getWidth() - 10, getHeight() - 10));
        jInternalFrame1.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        jLayeredPane1.setVisible(false);
        jPanel4.setPreferredSize(new Dimension(getWidth() - 10, getHeight() - 10));
        root = getContentPane();
        jInternalFrame1.setVisible(false);
        jInternalFrame1.setBorder(null);
        setIconImage(new ImageIcon(ReadFromPropertiesFile.imagePath + "Application-Exe.png").getImage());
    }

    private void setButtonContentArea() {
        btnDatamaintenance.setContentAreaFilled(false);
    }

    class AddButton extends JButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!timer.isRunning()) {
                animationStartTime = System.nanoTime() / 1000000;
                this.setText("Stop Animation");
                timer.start();
            } else {
                timer.stop();
                this.setText("Start Animation");
                alpha = 1.0f;
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        btnDatamaintenance = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setBorder(null);
        jInternalFrame1.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Application-Exe.png"))); // NOI18N
        jInternalFrame1.setName(""); // NOI18N
        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jInternalFrame1)
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        try {
            jInternalFrame1.setMaximum(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnDatamaintenance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Datamaintenance.png"))); // NOI18N
        btnDatamaintenance.setToolTipText("Datamaintenance...");
        btnDatamaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatamaintenanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnDatamaintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnDatamaintenance)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLayeredPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setForeground(new java.awt.Color(51, 51, 51));
        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(51, 51, 51));
        jMenu2.setText("View");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(51, 51, 51));
        jMenu3.setText("Accounting");
        jMenu3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu3);

        jMenu4.setForeground(new java.awt.Color(51, 51, 51));
        jMenu4.setText("Payroll");
        jMenu4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu4);

        jMenu5.setForeground(new java.awt.Color(51, 51, 51));
        jMenu5.setText("Fuel Tax");
        jMenu5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu5);

        jMenu6.setForeground(new java.awt.Color(51, 51, 51));
        jMenu6.setText("Compliancy");
        jMenu6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu6);

        jMenu7.setForeground(new java.awt.Color(51, 51, 51));
        jMenu7.setText("Reports");
        jMenu7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu7);

        jMenu8.setForeground(new java.awt.Color(51, 51, 51));
        jMenu8.setText("Communication");
        jMenu8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatamaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatamaintenanceActionPerformed
//        Datamaintenance datamaintenance = new Datamaintenance();
//        datamaintenance.setBounds(0, 0, getWidth(), getHeight());
//        jLayeredPane1.add(datamaintenance);
//        jLayeredPane1.setVisible(true);
//        datamaintenance.setVisible(true);
        DatamaintenanceOptions datamaintenanceOptions = new DatamaintenanceOptions();
        datamaintenanceOptions.setBounds(0, 0, getWidth(), getHeight());
        jLayeredPane1.add(datamaintenanceOptions);
        jLayeredPane1.setVisible(true);
        datamaintenanceOptions.setVisible(true);
    }//GEN-LAST:event_btnDatamaintenanceActionPerformed

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
            java.util.logging.Logger.getLogger(ArrangedMainFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArrangedMainFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArrangedMainFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArrangedMainFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
//                new ArrangedMainFrame3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatamaintenance;
    public static javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
