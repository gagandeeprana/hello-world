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
public class Datamaintenance extends javax.swing.JPanel {

    /**
     * Creates new form Datamaintenance
     */
    public Datamaintenance() {
        initComponents();
        setButtonContentArea();
    }

    private void setButtonContentArea() {
        btnCustomers.setContentAreaFilled(false);
        btnCustomBroker.setContentAreaFilled(false);
        btnStandardTemplates.setContentAreaFilled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        btnCustomers = new javax.swing.JButton();
        btnStandardTemplates = new javax.swing.JButton();
        btnCustomBroker = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(487, 37));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("<html>Payroll Schedules</html>");

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("<html>Misc Vendors</html>");

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("<html>Outside Carriers</html>");

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("<html>Border Crossing</html>");

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("<html> Shippers </html>");
        jLabel15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("<html>Standard Charges</html>");

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("<html>Sales Person</html>");

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("<html> Resources </html>");
        jLabel19.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("<html> Jurisdiction </html>");
        jLabel20.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("<html> Tracking </html>");
        jLabel21.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("<html> Roles </html>");
        jLabel22.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("<html> Company </html>");
        jLabel23.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("<html> List </html>");
        jLabel24.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("<html> Class </html>");
        jLabel25.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel25MouseEntered(evt);
            }
        });

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("<html>Timings</html>");
        jLabel26.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jSeparator19.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("<html> Prospects </html>");
        jLabel27.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel28.setFont(new java.awt.Font("Vijaya", 1, 17)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dpu/ui/common/Cross.png"))); // NOI18N
        jLabel28.setToolTipText("Close Menubar...");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(102, 102, 102));
        jLabel59.setText("<html>Master Orders</html>");

        btnCustomers.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomers.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCustomers.setForeground(new java.awt.Color(102, 102, 102));
        btnCustomers.setText("<html>Customers</html>");
        btnCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersActionPerformed(evt);
            }
        });

        btnStandardTemplates.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnStandardTemplates.setForeground(new java.awt.Color(102, 102, 102));
        btnStandardTemplates.setText("<html>Standard Templates</html>");

        btnCustomBroker.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCustomBroker.setForeground(new java.awt.Color(102, 102, 102));
        btnCustomBroker.setText("<html>Custom Broker</html>");
        btnCustomBroker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomBrokerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStandardTemplates, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCustomBroker, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jSeparator14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator10)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator5)
                            .addComponent(jSeparator6)
                            .addComponent(jSeparator7)
                            .addComponent(jSeparator8)
                            .addComponent(jSeparator9))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnStandardTemplates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCustomBroker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1316, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        ArrangedMainFrame3.jInternalFrame1.setVisible(true);
        //        jInternalFrame1.setTitle("DPU - " + jLabel25.getText().substring(jLabel25.getText().indexOf("<html>"), jLabel25.getText().indexOf("</html>")));
        ArrangedMainFrame3.jInternalFrame1.setTitle("DPU - Class");
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
        Container root = ArrangedMainFrame3.jInternalFrame1.getContentPane();
        root.setVisible(false);
        TestClassPanel testClassPanel = new TestClassPanel();
        testClassPanel.setBounds(5, 5, 500, 600);
        root.add(testClassPanel);
        root.setVisible(true);
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseEntered

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        jPanel3.setVisible(false);
    }//GEN-LAST:event_jLabel28MouseClicked

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        ArrangedMainFrame3.jInternalFrame1.setVisible(true);
        ArrangedMainFrame3.jInternalFrame1.setTitle("DPU - Customers");
        ArrangedMainFrame3.jInternalFrame1.putClientProperty("JInternalFrame.isPalette", Boolean.FALSE);
        ArrangedMainFrame3.jInternalFrame1.setMaximizable(false);
        ArrangedMainFrame3.jInternalFrame1.setIconifiable(false);
        ArrangedMainFrame3.jInternalFrame1.setClosable(false);
//        ArrangedMainFrame3.jInternalFrame1.getContentPane().setVisible(false);
        ArrangedMainFrame3.jInternalFrame1.getContentPane().removeAll();
        ArrangedMainFrame3.jInternalFrame1.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        BasicInternalFrameUI bi = (BasicInternalFrameUI) ArrangedMainFrame3.jInternalFrame1.getUI();
        bi.setNorthPane(null);
        bi.setEastPane(null);
        bi.setWestPane(null);
        bi.setSouthPane(null);
        ArrangedMainFrame3.jInternalFrame1.setBorder(null);
        Container root = ArrangedMainFrame3.jInternalFrame1.getContentPane();
        root.setVisible(false);
        TestCompanyPanel testCompanyPanel = new TestCompanyPanel();
        testCompanyPanel.setBounds(0, 0, getWidth() - 12, getHeight() - 10);
        root.add(testCompanyPanel);
        root.setVisible(true);
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        System.out.println("111111111111");
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
        System.out.println("2222222222");
        bi.setNorthPane(null);
        bi.setEastPane(null);
        bi.setWestPane(null);
        bi.setSouthPane(null);
        ArrangedMainFrame3.jInternalFrame1.setBorder(null);
        Container root = ArrangedMainFrame3.jInternalFrame1.getContentPane();
        root.setVisible(false);
        TestShipperPannel testShippersPanel = new TestShipperPannel();
        System.out.println("33333333");
        testShippersPanel.setBounds(0, 0, getWidth() - 12, getHeight() - 10);
        root.add(testShippersPanel);
        root.setVisible(true);
        System.out.println("44444444");
    }//GEN-LAST:event_jLabel15MousePressed

    private void btnCustomBrokerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomBrokerActionPerformed
        System.out.println("111111111111");
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
        System.out.println("2222222222");
        bi.setNorthPane(null);
        bi.setEastPane(null);
        bi.setWestPane(null);
        bi.setSouthPane(null);
        ArrangedMainFrame3.jInternalFrame1.setBorder(null);
        Container root = ArrangedMainFrame3.jInternalFrame1.getContentPane();
        root.setVisible(false);
        TestCustomBrokersPanel testCustomBrokersPanel = new TestCustomBrokersPanel();
        System.out.println("33333333");
        testCustomBrokersPanel.setBounds(0, 0, getWidth() - 12, getHeight() - 10);
        root.add(testCustomBrokersPanel);
        root.setVisible(true);
        System.out.println("44444444");
        
    }//GEN-LAST:event_btnCustomBrokerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomBroker;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnStandardTemplates;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
