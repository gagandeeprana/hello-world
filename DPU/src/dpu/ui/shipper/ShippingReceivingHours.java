/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.shipper;

import dpu.beans.admin.WorkingHoursAdditionalShipperBean;
import dpu.dao.admin.ShipperDAO;
import dpu.dao.admin.WorkingHoursAdditionalContactDAO;
import dpu.dao.admin.impl.ShipperDAOImpl;
import dpu.dao.admin.impl.WorkingHoursAdditionalContactDAOImpl;
import dpu.ui.common.helper.ShipperUIHelper;
import dpu.ui.common.helper.ShippingReceivingHoursUIHelper;
import java.util.List;
import properties.TimeConstants;

/**
 *
 * @author jagvir
 */
public class ShippingReceivingHours extends javax.swing.JFrame {

    ShippingReceivingHoursUIHelper shippingReceivingHoursUIHelper = null;
    ShipperDAO shipperDAO = null;
    boolean flag = true;

    public ShippingReceivingHours() {
        initComponents();
        shippingReceivingHoursUIHelper = new ShippingReceivingHoursUIHelper();
        shipperDAO = new ShipperDAOImpl();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
//        enableDisableFieled(false);
        sameTextFieledDisable(false);
        if (ShippingReceivingHoursUIHelper.listOfReceivingHours != null && ShippingReceivingHoursUIHelper.listOfReceivingHours.size() != 0) {
            System.out.println("aaaaaaaaaaaa");
            shippingReceivingHoursUIHelper.showReceivingData(ShippingReceivingHoursUIHelper.listOfReceivingHours);
        }
        if (ShippingReceivingHoursUIHelper.listOfShippingHours != null && ShippingReceivingHoursUIHelper.listOfShippingHours.size() != 0) {
            System.out.println("bbbbbbbbb");
            shippingReceivingHoursUIHelper.showShippingData(ShippingReceivingHoursUIHelper.listOfShippingHours);
        }
        if (ShipperUIHelper.addUpdateFlag.equals("update")) {
            List<WorkingHoursAdditionalShipperBean> lstReceiving = shipperDAO.getRecevingHoursByShipperId(NewShipperFrame.shippermasterBean.getShipperId());
            List<WorkingHoursAdditionalShipperBean> lstShipping = shipperDAO.getShippingHoursByShipperId(NewShipperFrame.shippermasterBean.getShipperId());
            System.out.println("lstShipping::::::::" + lstShipping.size());
            System.out.println("lstReceiving::::::::" + lstReceiving.size());
            shippingReceivingHoursUIHelper.showReceivingData(lstReceiving);
            shippingReceivingHoursUIHelper.showShippingData(lstReceiving);
        }
    }

    private void sameTextFieledDisable(Boolean v) {
        txtSunOpen1.setEnabled(v);
        txtSunOpen2.setEnabled(v);
        txtSunClose1.setEnabled(v);
        txtSunClose2.setEnabled(v);

        txtMonOpen1.setEnabled(v);
        txtMonOpen2.setEnabled(v);
        txtMonClose1.setEnabled(v);
        txtMonClose2.setEnabled(v);

        txtTueOpen1.setEnabled(v);
        txtTueOpen2.setEnabled(v);
        txtTueClose1.setEnabled(v);
        txtTueClose2.setEnabled(v);

        txtWedOpen1.setEnabled(v);
        txtWedOpen2.setEnabled(v);
        txtWedClose1.setEnabled(v);
        txtWedClose2.setEnabled(v);

        txtThuOpen1.setEnabled(v);
        txtThuOpen2.setEnabled(v);
        txtThuClose1.setEnabled(v);
        txtThuClose2.setEnabled(v);

        txtFriOpen1.setEnabled(v);
        txtFriOpen2.setEnabled(v);
        txtFriClose1.setEnabled(v);
        txtFriClose2.setEnabled(v);

        txtSatOpen1.setEnabled(v);
        txtSatOpen2.setEnabled(v);
        txtSatClose1.setEnabled(v);
        txtSatClose2.setEnabled(v);

        txtSameClose1.setEnabled(v);
        txtSameClose2.setEnabled(v);
        txtSameOpen1.setEnabled(v);
        txtSameOpen2.setEnabled(v);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        customerTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        chkReceivingHours = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        chkSun = new javax.swing.JCheckBox();
        txtSunOpen1 = new javax.swing.JTextField();
        txtSunClose1 = new javax.swing.JTextField();
        txtSunOpen2 = new javax.swing.JTextField();
        txtSunClose2 = new javax.swing.JTextField();
        btn24HrRSun = new javax.swing.JButton();
        btn24HrRMon = new javax.swing.JButton();
        txtMonClose2 = new javax.swing.JTextField();
        txtMonOpen2 = new javax.swing.JTextField();
        txtMonClose1 = new javax.swing.JTextField();
        txtMonOpen1 = new javax.swing.JTextField();
        chkMon = new javax.swing.JCheckBox();
        btn24HrRTue = new javax.swing.JButton();
        txtTueClose2 = new javax.swing.JTextField();
        txtTueOpen2 = new javax.swing.JTextField();
        txtTueClose1 = new javax.swing.JTextField();
        txtTueOpen1 = new javax.swing.JTextField();
        chkTue = new javax.swing.JCheckBox();
        btn24HrRWed = new javax.swing.JButton();
        txtWedClose2 = new javax.swing.JTextField();
        txtWedOpen2 = new javax.swing.JTextField();
        txtWedClose1 = new javax.swing.JTextField();
        txtWedOpen1 = new javax.swing.JTextField();
        chkWed = new javax.swing.JCheckBox();
        btn24HrRThu = new javax.swing.JButton();
        txtThuClose2 = new javax.swing.JTextField();
        txtThuOpen2 = new javax.swing.JTextField();
        txtThuClose1 = new javax.swing.JTextField();
        txtThuOpen1 = new javax.swing.JTextField();
        chkThu = new javax.swing.JCheckBox();
        btn24HrRFri = new javax.swing.JButton();
        txtFriClose2 = new javax.swing.JTextField();
        txtFriOpen2 = new javax.swing.JTextField();
        txtFriClose1 = new javax.swing.JTextField();
        txtFriOpen1 = new javax.swing.JTextField();
        chkFri = new javax.swing.JCheckBox();
        btn24HrRSat = new javax.swing.JButton();
        txtSatClose2 = new javax.swing.JTextField();
        txtSatOpen2 = new javax.swing.JTextField();
        txtSatClose1 = new javax.swing.JTextField();
        txtSatOpen1 = new javax.swing.JTextField();
        chkSat = new javax.swing.JCheckBox();
        btn24HrRSame = new javax.swing.JButton();
        txtSameClose2 = new javax.swing.JTextField();
        txtSameOpen2 = new javax.swing.JTextField();
        txtSameClose1 = new javax.swing.JTextField();
        txtSameOpen1 = new javax.swing.JTextField();
        chkSame = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        chkSSun = new javax.swing.JCheckBox();
        txtSSunOpen1 = new javax.swing.JTextField();
        txtSSunClose1 = new javax.swing.JTextField();
        txtSSunOpen2 = new javax.swing.JTextField();
        txtSSunClose2 = new javax.swing.JTextField();
        btn24HrSSun = new javax.swing.JButton();
        btnSMon24Hr = new javax.swing.JButton();
        txtSMonClose2 = new javax.swing.JTextField();
        txtSMonOpen2 = new javax.swing.JTextField();
        txtSMonClose1 = new javax.swing.JTextField();
        txtSMonOpen1 = new javax.swing.JTextField();
        chkSMon = new javax.swing.JCheckBox();
        btn24HrSTue = new javax.swing.JButton();
        txtSTueClose2 = new javax.swing.JTextField();
        txtSTueOpen2 = new javax.swing.JTextField();
        txtSTueClose1 = new javax.swing.JTextField();
        txtSTueOpen1 = new javax.swing.JTextField();
        chkSTue = new javax.swing.JCheckBox();
        btn24HrSWed = new javax.swing.JButton();
        txtSWedClose2 = new javax.swing.JTextField();
        txtSWedOpen2 = new javax.swing.JTextField();
        txtSWedClose1 = new javax.swing.JTextField();
        txtSWedOpen1 = new javax.swing.JTextField();
        chkSWed = new javax.swing.JCheckBox();
        btn24HrSThu = new javax.swing.JButton();
        txtSThuClose2 = new javax.swing.JTextField();
        txtSThuOpen2 = new javax.swing.JTextField();
        txtSThuClose1 = new javax.swing.JTextField();
        txtSThuOpen1 = new javax.swing.JTextField();
        chkSThu = new javax.swing.JCheckBox();
        btn24HrSFri = new javax.swing.JButton();
        txtSFrClose2 = new javax.swing.JTextField();
        txtSFriOpen2 = new javax.swing.JTextField();
        txtSFrClose1 = new javax.swing.JTextField();
        txtSFriOpen1 = new javax.swing.JTextField();
        chkSFri = new javax.swing.JCheckBox();
        btn24HrSSat = new javax.swing.JButton();
        txtSSatClose2 = new javax.swing.JTextField();
        txtSSatOpen2 = new javax.swing.JTextField();
        txtSSatClose1 = new javax.swing.JTextField();
        txtSSatOpen1 = new javax.swing.JTextField();
        chkSSat = new javax.swing.JCheckBox();
        btn24HrSSame = new javax.swing.JButton();
        txtSSameClose2 = new javax.swing.JTextField();
        txtSSameOpen2 = new javax.swing.JTextField();
        txtSSameClose1 = new javax.swing.JTextField();
        txtSSameOpen1 = new javax.swing.JTextField();
        chkSSame1 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customerTabbedPane.setBackground(new java.awt.Color(255, 255, 255));

        chkReceivingHours.setBackground(new java.awt.Color(255, 255, 255));
        chkReceivingHours.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chkReceivingHours.setForeground(new java.awt.Color(51, 51, 51));
        chkReceivingHours.setText("This Locations Shipping And Receiving hours are the same");
        chkReceivingHours.setPreferredSize(new java.awt.Dimension(53, 20));
        chkReceivingHours.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkReceivingHoursStateChanged(evt);
            }
        });
        chkReceivingHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkReceivingHoursActionPerformed(evt);
            }
        });

        chkSun.setText("Sun");
        chkSun.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkSunStateChanged(evt);
            }
        });
        chkSun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSunActionPerformed(evt);
            }
        });

        btn24HrRSun.setText("<");
        btn24HrRSun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn24HrRSunActionPerformed(evt);
            }
        });

        btn24HrRMon.setText("<");
        btn24HrRMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn24HrRMonActionPerformed(evt);
            }
        });

        txtMonClose2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonClose2ActionPerformed(evt);
            }
        });

        chkMon.setText("Mon");
        chkMon.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkMonStateChanged(evt);
            }
        });

        btn24HrRTue.setText("<");
        btn24HrRTue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn24HrRTueActionPerformed(evt);
            }
        });

        chkTue.setText("Tue");
        chkTue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkTueStateChanged(evt);
            }
        });

        btn24HrRWed.setText("<");
        btn24HrRWed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn24HrRWedActionPerformed(evt);
            }
        });

        chkWed.setText("Wed");
        chkWed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkWedStateChanged(evt);
            }
        });

        btn24HrRThu.setText("<");
        btn24HrRThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn24HrRThuActionPerformed(evt);
            }
        });

        chkThu.setText("Thu");
        chkThu.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkThuStateChanged(evt);
            }
        });

        btn24HrRFri.setText("<");
        btn24HrRFri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn24HrRFriActionPerformed(evt);
            }
        });

        txtFriClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFriClose1ActionPerformed(evt);
            }
        });

        chkFri.setText("Fri");
        chkFri.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkFriStateChanged(evt);
            }
        });

        btn24HrRSat.setText("<");
        btn24HrRSat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn24HrRSatActionPerformed(evt);
            }
        });

        chkSat.setText("Sat");
        chkSat.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkSatStateChanged(evt);
            }
        });

        btn24HrRSame.setText("<");
        btn24HrRSame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn24HrRSameActionPerformed(evt);
            }
        });

        chkSame.setText("Same");
        chkSame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSameActionPerformed(evt);
            }
        });

        jLabel1.setText("Open");

        jLabel2.setText("Close");

        jLabel3.setText("Open");

        jLabel4.setText("Close");

        jLabel5.setText("24 Hr");

        jLabel6.setText("Which of the following options best represents how thw dates should be");

        jLabel7.setText("collected when assigning this location to a customer order ?");

        jLabel8.setText("Default Date Criteria");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ready For Pickup On", "Call for Appointment", "Scheduled Appointment", "Scheduled Window", " " }));

        jLabel9.setText("When Printing Carrier Confirmation and/or Driver Itineraries would you");

        jLabel10.setText("like the shipping/receiving hours to appear on the report ?");

        jLabel11.setText("Print On Report");

        jRadioButton1.setText("Yes");

        jRadioButton2.setText("No");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(125, 125, 125)
                            .addComponent(jLabel1)
                            .addGap(37, 37, 37)
                            .addComponent(jLabel2)
                            .addGap(51, 51, 51)
                            .addComponent(jLabel3)
                            .addGap(40, 40, 40)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkReceivingHours, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(chkSame)
                                        .addGap(14, 14, 14)
                                        .addComponent(txtSameOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSameClose1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSameOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSameClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn24HrRSame))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(38, 38, 38)
                                                .addComponent(jRadioButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jRadioButton2))
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(chkSun)
                                                        .addGap(22, 22, 22)
                                                        .addComponent(txtSunOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(chkMon)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtMonOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtMonClose1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                                    .addComponent(txtSunClose1)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(chkWed)
                                                    .addComponent(chkTue))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(txtTueOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtTueClose1))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(txtWedOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtWedClose1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(chkThu)
                                                        .addGap(22, 22, 22))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(chkFri)
                                                        .addGap(28, 28, 28)))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(chkSat)
                                                    .addGap(24, 24, 24)))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtSatOpen1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                                .addComponent(txtFriOpen1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtThuOpen1, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addGap(6, 6, 6)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtFriClose1)
                                                .addComponent(txtSatClose1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtThuClose1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtSatOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtSatClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn24HrRSat))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtFriOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtFriClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn24HrRFri))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtThuOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtThuClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn24HrRThu))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtWedOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtWedClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn24HrRWed))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtSunOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtSunClose2))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtTueOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtMonOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtTueClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtMonClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGap(21, 21, 21)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btn24HrRMon, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btn24HrRTue, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btn24HrRSun, javax.swing.GroupLayout.Alignment.TRAILING)))))))))
                .addGap(40, 40, 40))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtMonClose2, txtMonOpen2, txtThuClose2, txtThuOpen2, txtTueClose2, txtTueOpen2, txtWedClose2, txtWedOpen2});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtFriClose2, txtFriOpen2, txtSameClose2, txtSameOpen2, txtSatClose2, txtSatOpen2});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtFriClose1, txtFriOpen1, txtMonClose1, txtSameClose1, txtSameOpen1, txtSatClose1, txtSatOpen1, txtSunClose1, txtSunOpen1, txtThuClose1, txtThuOpen1, txtTueClose1, txtWedClose1, txtWedOpen1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(chkReceivingHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkSun)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSunClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSunOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSunOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSunClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn24HrRSun))))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkMon)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMonClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMonOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMonOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMonClose2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn24HrRMon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTueClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTueOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkTue)
                            .addComponent(txtTueOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTueClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn24HrRTue))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkWed)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtWedClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtWedOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtWedOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtWedClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn24HrRWed)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(chkThu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtThuClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThuOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtThuOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtThuClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn24HrRThu, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkFri)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFriClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFriOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFriOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFriClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn24HrRFri)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkSat)
                    .addComponent(btn24HrRSat)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSatOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSatClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSatOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSatClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkSame)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSameClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSameOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSameOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSameClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn24HrRSame))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtFriClose1, txtFriOpen1, txtMonClose1, txtMonOpen1, txtSameClose1, txtSameOpen1, txtSatClose1, txtSatOpen1, txtSunClose1, txtSunOpen1, txtThuClose1, txtThuOpen1, txtTueClose1, txtTueOpen1, txtWedClose1, txtWedOpen1});

        customerTabbedPane.addTab("Receiving", jPanel1);

        chkSSun.setText("Sun");

        btn24HrSSun.setText("<");

        btnSMon24Hr.setText("<");

        txtSMonClose2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSMonClose2ActionPerformed(evt);
            }
        });

        chkSMon.setText("Mon");

        btn24HrSTue.setText("<");

        chkSTue.setText("Tue");

        btn24HrSWed.setText("<");

        chkSWed.setText("Wed");

        btn24HrSThu.setText("<");

        chkSThu.setText("Thu");

        btn24HrSFri.setText("<");

        txtSFrClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSFrClose1ActionPerformed(evt);
            }
        });

        chkSFri.setText("Fri");

        btn24HrSSat.setText("<");

        chkSSat.setText("Sat");
        chkSSat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSSatActionPerformed(evt);
            }
        });

        btn24HrSSame.setText("<");

        txtSSameClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSSameClose1ActionPerformed(evt);
            }
        });

        chkSSame1.setText("Same");

        jLabel23.setText("Open");

        jLabel24.setText("Close");

        jLabel25.setText("Open");

        jLabel26.setText("Close");

        jLabel27.setText("24 Hr");

        jLabel28.setText("Which of the following options best represents how thw dates should be");

        jLabel29.setText("collected when assigning this location to a customer order ?");

        jLabel30.setText("Default Date Criteria");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deliver No Later Than", "Call for Appointment", "Scheduled Appointment", "Scheduled Window" }));

        jLabel31.setText("When Printing Carrier Confirmation and/or Driver Itineraries would you");

        jLabel32.setText("like the shipping/receiving hours to appear on the report ?");

        jLabel33.setText("Print On Report");

        jRadioButton5.setText("Yes");

        jRadioButton6.setText("No");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel23)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel24)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel25)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel26))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(38, 38, 38)
                                .addComponent(jRadioButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton6))
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel30)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(chkSSame1)
                                .addGap(14, 14, 14)
                                .addComponent(txtSSameOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSSameClose1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSSameOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtSSameClose2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn24HrSSame))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(chkSSun)
                                                    .addGap(22, 22, 22)
                                                    .addComponent(txtSSunOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(chkSTue)
                                                        .addComponent(chkSMon))
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtSMonOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtSMonClose1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                                .addComponent(txtSSunClose1)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(chkSWed)
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(txtSTueOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtSTueClose1))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(txtSWedOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtSWedClose1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                    .addComponent(chkSThu)
                                                    .addGap(22, 22, 22))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(chkSFri)
                                                    .addGap(28, 28, 28)))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(chkSSat)
                                                .addGap(24, 24, 24)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSSatOpen1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                            .addComponent(txtSFriOpen1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtSThuOpen1, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSFrClose1)
                                            .addComponent(txtSSatClose1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtSThuClose1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtSSatOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSSatClose2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn24HrSSat))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtSFriOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(txtSFrClose2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(txtSThuOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtSThuClose2))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(txtSSunOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtSSunClose2))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txtSMonOpen2, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                                            .addComponent(txtSTueOpen2))
                                                        .addComponent(txtSWedOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtSWedClose2)
                                                        .addComponent(txtSTueClose2)
                                                        .addComponent(txtSMonClose2)))))
                                        .addGap(6, 6, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnSMon24Hr, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btn24HrSTue, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btn24HrSSun)
                                            .addComponent(btn24HrSWed, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btn24HrSThu, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btn24HrSFri, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkSSun)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSSunClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSSunOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSSunOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSSunClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn24HrSSun))))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkSMon)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSMonClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSMonOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSMon24Hr)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSMonOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSMonClose2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSTueClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSTueOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkSTue)
                            .addComponent(txtSTueOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSTueClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn24HrSTue))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkSWed)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSWedClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSWedOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSWedOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSWedClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn24HrSWed)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(chkSThu))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSThuClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSThuOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSThuOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSThuClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn24HrSThu, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkSFri)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSFrClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSFriOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSFriOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSFrClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn24HrSFri)))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkSSat)
                    .addComponent(btn24HrSSat)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSSatOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSSatClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSSatOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSSatClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkSSame1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSSameClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSSameOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSSameOpen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSSameClose2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn24HrSSame))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addContainerGap())
        );

        customerTabbedPane.addTab("Shipping", jPanel3);

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerTabbedPane)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(btnOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(customerTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOk)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFriClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFriClose1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFriClose1ActionPerformed

    private void txtMonClose2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonClose2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMonClose2ActionPerformed

    private void txtSMonClose2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSMonClose2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSMonClose2ActionPerformed

    private void txtSFrClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSFrClose1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSFrClose1ActionPerformed

    private void chkSSatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSSatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkSSatActionPerformed

    private void btn24HrRSunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn24HrRSunActionPerformed
        chkSun.setSelected(true);
        txtSunOpen1.setText(TimeConstants.open1);
        txtSunOpen2.setText(TimeConstants.open2);
        txtSunClose1.setText(TimeConstants.close1);
        txtSunClose2.setText(TimeConstants.close2);
    }//GEN-LAST:event_btn24HrRSunActionPerformed

    private void btn24HrRMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn24HrRMonActionPerformed
        chkMon.setSelected(true);
        txtMonOpen1.setText(TimeConstants.open1);
        txtMonOpen2.setText(TimeConstants.open2);
        txtMonClose1.setText(TimeConstants.close1);
        txtMonClose2.setText(TimeConstants.close2);
    }//GEN-LAST:event_btn24HrRMonActionPerformed

    private void btn24HrRTueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn24HrRTueActionPerformed
        chkTue.setSelected(true);
        txtTueOpen1.setText(TimeConstants.open1);
        txtTueOpen2.setText(TimeConstants.open2);
        txtTueClose1.setText(TimeConstants.close1);
        txtTueClose2.setText(TimeConstants.close2);
    }//GEN-LAST:event_btn24HrRTueActionPerformed

    private void btn24HrRWedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn24HrRWedActionPerformed
        chkWed.setSelected(true);
        txtWedOpen1.setText(TimeConstants.open1);
        txtWedOpen2.setText(TimeConstants.open2);
        txtWedClose1.setText(TimeConstants.close1);
        txtWedClose2.setText(TimeConstants.close2);
    }//GEN-LAST:event_btn24HrRWedActionPerformed

    private void btn24HrRThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn24HrRThuActionPerformed
        chkThu.setSelected(true);
        txtThuOpen1.setText(TimeConstants.open1);
        txtThuOpen2.setText(TimeConstants.open2);
        txtThuClose1.setText(TimeConstants.close1);
        txtThuClose2.setText(TimeConstants.close2);
    }//GEN-LAST:event_btn24HrRThuActionPerformed

    private void btn24HrRFriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn24HrRFriActionPerformed
        chkFri.setSelected(true);
        txtFriOpen1.setText(TimeConstants.open1);
        txtFriOpen2.setText(TimeConstants.open2);
        txtFriClose1.setText(TimeConstants.close1);
        txtFriClose2.setText(TimeConstants.close2);
    }//GEN-LAST:event_btn24HrRFriActionPerformed

    private void btn24HrRSatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn24HrRSatActionPerformed
        chkSat.setSelected(true);
        txtSatOpen1.setText(TimeConstants.open1);
        txtSatOpen2.setText(TimeConstants.open2);
        txtSatClose1.setText(TimeConstants.close1);
        txtSatClose2.setText(TimeConstants.close2);
    }//GEN-LAST:event_btn24HrRSatActionPerformed

    private void btn24HrRSameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn24HrRSameActionPerformed
        chkSame.setSelected(true);
        txtSameOpen1.setText(TimeConstants.open1);
        txtSameOpen2.setText(TimeConstants.open2);
        txtSameClose1.setText(TimeConstants.close1);
        txtSameClose2.setText(TimeConstants.close2);
        shippingReceivingHoursUIHelper.setText();
    }//GEN-LAST:event_btn24HrRSameActionPerformed

    private void chkSunStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkSunStateChanged
        if (chkSun.isSelected()) {
            txtSunOpen1.setEditable(true);
            txtSunOpen2.setEditable(true);
            txtSunClose1.setEditable(true);
            txtSunClose2.setEditable(true);
        } else {
            txtSunOpen1.setEditable(false);
            txtSunOpen2.setEditable(false);
            txtSunClose1.setEditable(false);
            txtSunClose2.setEditable(false);
        }
    }//GEN-LAST:event_chkSunStateChanged

    private void chkMonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkMonStateChanged
        if (chkMon.isSelected()) {
            txtMonOpen1.setEditable(true);
            txtMonOpen2.setEditable(true);
            txtMonClose1.setEditable(true);
            txtMonClose2.setEditable(true);
        } else {
            txtMonOpen1.setEditable(false);
            txtMonOpen2.setEditable(false);
            txtMonClose1.setEditable(false);
            txtMonClose2.setEditable(false);
        }
    }//GEN-LAST:event_chkMonStateChanged

    private void chkTueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkTueStateChanged
        if (chkTue.isSelected()) {
            txtTueOpen1.setEditable(true);
            txtTueOpen2.setEditable(true);
            txtTueClose1.setEditable(true);
            txtTueClose2.setEditable(true);
        } else {
            txtTueOpen1.setEditable(false);
            txtTueOpen2.setEditable(false);
            txtTueClose1.setEditable(false);
            txtTueClose2.setEditable(false);
        }
    }//GEN-LAST:event_chkTueStateChanged

    private void chkWedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkWedStateChanged
        if (chkWed.isSelected()) {
            txtWedOpen1.setEditable(true);
            txtWedOpen2.setEditable(true);
            txtWedClose1.setEditable(true);
            txtWedClose2.setEditable(true);
        } else {
            txtWedOpen1.setEditable(false);
            txtWedOpen2.setEditable(false);
            txtWedClose1.setEditable(false);
            txtWedClose2.setEditable(false);
        }
    }//GEN-LAST:event_chkWedStateChanged

    private void chkThuStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkThuStateChanged
        if (chkSun.isSelected()) {
            txtThuOpen1.setEditable(true);
            txtThuOpen2.setEditable(true);
            txtThuClose1.setEditable(true);
            txtThuClose2.setEditable(true);
        } else {
            txtThuOpen1.setEditable(false);
            txtThuOpen2.setEditable(false);
            txtThuClose1.setEditable(false);
            txtThuClose2.setEditable(false);
        }
    }//GEN-LAST:event_chkThuStateChanged

    private void chkFriStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkFriStateChanged
        if (chkFri.isSelected()) {
            txtFriOpen1.setEditable(true);
            txtFriOpen2.setEditable(true);
            txtFriClose1.setEditable(true);
            txtFriClose2.setEditable(true);
        } else {
            txtFriOpen1.setEditable(false);
            txtFriOpen2.setEditable(false);
            txtFriClose1.setEditable(false);
            txtFriClose2.setEditable(false);
        }
    }//GEN-LAST:event_chkFriStateChanged

    private void chkSatStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkSatStateChanged
        if (chkSat.isSelected()) {
            txtSatOpen1.setEditable(true);
            txtSatOpen2.setEditable(true);
            txtSatClose1.setEditable(true);
            txtSatClose2.setEditable(true);
        } else {
            txtSatOpen1.setEditable(false);
            txtSatOpen2.setEditable(false);
            txtSatClose1.setEditable(false);
            txtSatClose2.setEditable(false);
        }
    }//GEN-LAST:event_chkSatStateChanged

    private void chkSameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSameActionPerformed
        if (chkSame.isSelected()) {
            shippingReceivingHoursUIHelper.setChecked(true);
            String open1 = txtSameOpen1.getText();
            String open2 = txtSameOpen2.getText();
            String close1 = txtSameClose1.getText();
            String close2 = txtSameClose2.getText();
            if (!open1.equals("") && !open2.equals("") && !close1.equals("") && !close2.equals("")) {
                shippingReceivingHoursUIHelper.setOpen1Text(open1);
                shippingReceivingHoursUIHelper.setOpen2Text(open2);
                shippingReceivingHoursUIHelper.setClose1Text(close1);
                shippingReceivingHoursUIHelper.setClose2Text(close2);
            }
        } else {
            String open1 = txtSameOpen1.getText();
            String open2 = txtSameOpen2.getText();
            String close1 = txtSameClose1.getText();
            String close2 = txtSameClose2.getText();
            shippingReceivingHoursUIHelper.setChecked(false);
            if (!open1.equals("") && !open2.equals("") && !close1.equals("") && !close2.equals("")) {
                shippingReceivingHoursUIHelper.setOpen1Text("");
                shippingReceivingHoursUIHelper.setOpen2Text("");
                shippingReceivingHoursUIHelper.setClose1Text("");
                shippingReceivingHoursUIHelper.setClose2Text("");
            }
        }
    }//GEN-LAST:event_chkSameActionPerformed

    private void chkSunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkSunActionPerformed

    private void chkReceivingHoursStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkReceivingHoursStateChanged
        if (flag == true && chkReceivingHours.isSelected()) {
            shippingReceivingHoursUIHelper.copyReceivinngToShipping();
            shippingReceivingHoursUIHelper.copyCheckBox();
        } else if (flag == false && chkReceivingHours.isSelected() == false) {
            chkReceivingHours.setSelected(false);
            shippingReceivingHoursUIHelper.unCheck();
            shippingReceivingHoursUIHelper.clearShippingFieleds();
        }
    }//GEN-LAST:event_chkReceivingHoursStateChanged

    private void txtSSameClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSSameClose1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSSameClose1ActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        shippingReceivingHoursUIHelper.saveShipperReceivingHours();
        shippingReceivingHoursUIHelper.saveShipperShippingHours();
        dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void chkReceivingHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkReceivingHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkReceivingHoursActionPerformed

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
            java.util.logging.Logger.getLogger(ShippingReceivingHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShippingReceivingHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShippingReceivingHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShippingReceivingHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShippingReceivingHours().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn24HrRFri;
    public static javax.swing.JButton btn24HrRMon;
    public static javax.swing.JButton btn24HrRSame;
    public static javax.swing.JButton btn24HrRSat;
    public static javax.swing.JButton btn24HrRSun;
    public static javax.swing.JButton btn24HrRThu;
    public static javax.swing.JButton btn24HrRTue;
    public static javax.swing.JButton btn24HrRWed;
    private javax.swing.JButton btn24HrSFri;
    private javax.swing.JButton btn24HrSSame;
    private javax.swing.JButton btn24HrSSat;
    private javax.swing.JButton btn24HrSSun;
    private javax.swing.JButton btn24HrSThu;
    private javax.swing.JButton btn24HrSTue;
    private javax.swing.JButton btn24HrSWed;
    public static javax.swing.JButton btnOk;
    private javax.swing.JButton btnSMon24Hr;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JCheckBox chkFri;
    public static javax.swing.JCheckBox chkMon;
    private javax.swing.JCheckBox chkReceivingHours;
    public static javax.swing.JCheckBox chkSFri;
    public static javax.swing.JCheckBox chkSMon;
    public static javax.swing.JCheckBox chkSSame1;
    public static javax.swing.JCheckBox chkSSat;
    public static javax.swing.JCheckBox chkSSun;
    public static javax.swing.JCheckBox chkSThu;
    public static javax.swing.JCheckBox chkSTue;
    public static javax.swing.JCheckBox chkSWed;
    public static javax.swing.JCheckBox chkSame;
    public static javax.swing.JCheckBox chkSat;
    public static javax.swing.JCheckBox chkSun;
    public static javax.swing.JCheckBox chkThu;
    public static javax.swing.JCheckBox chkTue;
    public static javax.swing.JCheckBox chkWed;
    public static javax.swing.JTabbedPane customerTabbedPane;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator6;
    public static javax.swing.JTextField txtFriClose1;
    public static javax.swing.JTextField txtFriClose2;
    public static javax.swing.JTextField txtFriOpen1;
    public static javax.swing.JTextField txtFriOpen2;
    public static javax.swing.JTextField txtMonClose1;
    public static javax.swing.JTextField txtMonClose2;
    public static javax.swing.JTextField txtMonOpen1;
    public static javax.swing.JTextField txtMonOpen2;
    public static javax.swing.JTextField txtSFrClose1;
    public static javax.swing.JTextField txtSFrClose2;
    public static javax.swing.JTextField txtSFriOpen1;
    public static javax.swing.JTextField txtSFriOpen2;
    public static javax.swing.JTextField txtSMonClose1;
    public static javax.swing.JTextField txtSMonClose2;
    public static javax.swing.JTextField txtSMonOpen1;
    public static javax.swing.JTextField txtSMonOpen2;
    public static javax.swing.JTextField txtSSameClose1;
    public static javax.swing.JTextField txtSSameClose2;
    public static javax.swing.JTextField txtSSameOpen1;
    public static javax.swing.JTextField txtSSameOpen2;
    public static javax.swing.JTextField txtSSatClose1;
    public static javax.swing.JTextField txtSSatClose2;
    public static javax.swing.JTextField txtSSatOpen1;
    public static javax.swing.JTextField txtSSatOpen2;
    public static javax.swing.JTextField txtSSunClose1;
    public static javax.swing.JTextField txtSSunClose2;
    public static javax.swing.JTextField txtSSunOpen1;
    public static javax.swing.JTextField txtSSunOpen2;
    public static javax.swing.JTextField txtSThuClose1;
    public static javax.swing.JTextField txtSThuClose2;
    public static javax.swing.JTextField txtSThuOpen1;
    public static javax.swing.JTextField txtSThuOpen2;
    public static javax.swing.JTextField txtSTueClose1;
    public static javax.swing.JTextField txtSTueClose2;
    public static javax.swing.JTextField txtSTueOpen1;
    public static javax.swing.JTextField txtSTueOpen2;
    public static javax.swing.JTextField txtSWedClose1;
    public static javax.swing.JTextField txtSWedClose2;
    public static javax.swing.JTextField txtSWedOpen1;
    public static javax.swing.JTextField txtSWedOpen2;
    public static javax.swing.JTextField txtSameClose1;
    public static javax.swing.JTextField txtSameClose2;
    public static javax.swing.JTextField txtSameOpen1;
    public static javax.swing.JTextField txtSameOpen2;
    public static javax.swing.JTextField txtSatClose1;
    public static javax.swing.JTextField txtSatClose2;
    public static javax.swing.JTextField txtSatOpen1;
    public static javax.swing.JTextField txtSatOpen2;
    public static javax.swing.JTextField txtSunClose1;
    public static javax.swing.JTextField txtSunClose2;
    public static javax.swing.JTextField txtSunOpen1;
    public static javax.swing.JTextField txtSunOpen2;
    public static javax.swing.JTextField txtThuClose1;
    public static javax.swing.JTextField txtThuClose2;
    public static javax.swing.JTextField txtThuOpen1;
    public static javax.swing.JTextField txtThuOpen2;
    public static javax.swing.JTextField txtTueClose1;
    public static javax.swing.JTextField txtTueClose2;
    public static javax.swing.JTextField txtTueOpen1;
    public static javax.swing.JTextField txtTueOpen2;
    public static javax.swing.JTextField txtWedClose1;
    public static javax.swing.JTextField txtWedClose2;
    public static javax.swing.JTextField txtWedOpen1;
    public static javax.swing.JTextField txtWedOpen2;
    // End of variables declaration//GEN-END:variables
}
