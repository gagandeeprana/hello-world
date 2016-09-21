/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common;

import dpu.ui.shipper.TestShipperPannel;
import java.awt.Container;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author gagandeep.rana
 */
public class MainModules extends javax.swing.JPanel {

    /**
     * Creates new form DatamaintenanceOptions
     */
    Container root = null;

    public MainModules() {
        initComponents();
        jInternalFrame1.putClientProperty("JInternalFrame.isPalette", Boolean.FALSE);
        jInternalFrame1.setMaximizable(false);
        jInternalFrame1.setIconifiable(false);
        jInternalFrame1.setClosable(false);
        jInternalFrame1.setBorder(null);
        BasicInternalFrameUI bi = (BasicInternalFrameUI) jInternalFrame1.getUI();
        bi.setNorthPane(null);
        bi.setEastPane(null);
        bi.setWestPane(null);
        bi.setSouthPane(null);
    }

    private void internalFrameSettings() {
        ArrangedMainFrame3.jInternalFrame1.setVisible(true);
        ArrangedMainFrame3.jInternalFrame1.setTitle("DPU - Customers");
        ArrangedMainFrame3.jInternalFrame1.putClientProperty("JInternalFrame.isPalette", Boolean.FALSE);
        ArrangedMainFrame3.jInternalFrame1.setMaximizable(false);
        ArrangedMainFrame3.jInternalFrame1.setIconifiable(false);
        ArrangedMainFrame3.jInternalFrame1.setClosable(false);
        ArrangedMainFrame3.jInternalFrame1.getContentPane().setVisible(false);
        ArrangedMainFrame3.jInternalFrame1.getContentPane().removeAll();
        ArrangedMainFrame3.jInternalFrame1.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        BasicInternalFrameUI bi = (BasicInternalFrameUI) ArrangedMainFrame3.jInternalFrame1.getUI();
        bi.setNorthPane(null);
        bi.setEastPane(null);
        bi.setWestPane(null);
        bi.setSouthPane(null);
        ArrangedMainFrame3.jInternalFrame1.setBorder(null);
        root = ArrangedMainFrame3.jInternalFrame1.getContentPane();
        root.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jInternalFrame1.setBorder(null);
        jInternalFrame1.setVisible(true);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Datamaintenance.png"))); // NOI18N
        jMenu1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/New-Customer.png"))); // NOI18N
        jMenu2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        jMenuItem1.setText("Create an Order from scratch");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Create an Order using a master order");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Create a pick up request");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Create an Order from a spot quote");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jInternalFrame1.setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1297, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        internalFrameSettings();
        DatamaintenanceOptions datamaintenanceOptions = new DatamaintenanceOptions();
        datamaintenanceOptions.setBounds(0, 0, getWidth(), getHeight());
        ArrangedMainFrame3.jLayeredPane1.add(datamaintenanceOptions);
        ArrangedMainFrame3.jLayeredPane1.setVisible(true);
        datamaintenanceOptions.setVisible(true);
    }//GEN-LAST:event_jMenu1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
}
