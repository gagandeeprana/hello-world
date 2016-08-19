/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common;

import dpu.beans.admin.AdditionalContactBean;
import dpu.beans.admin.BillingLocationBean;
import dpu.beans.admin.CompanyBean;
import dpu.dao.admin.AdditionalContactDAO;
import dpu.dao.admin.BillingLocationDAO;
import dpu.dao.admin.impl.AdditionalContactDAOImpl;
import dpu.dao.admin.impl.BillingLocationDAOImpl;
import dpu.ui.helper.common.AdditionalContactUIHelper;
import dpu.ui.helper.common.BillingLocationUIHelper;
import dpu.ui.helper.common.CompanyUIHelper;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import properties.ReadFromPropertiesFile;

/**
 *
 * @author gagandeep.rana
 */
public class AddCustomerFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddCustomerFrame
     */
    CompanyUIHelper companyUIHelper = null;
    CompanyBean companyBean = null;
    JMenuItem menuItem1 = null;
    JMenuItem menuItem3 = null;
    JMenuItem menuItem6 = null;
    BillingLocationUIHelper billingLocationUIHelper = null;
    BillingLocationDAO billingLocationDAO = new BillingLocationDAOImpl();
    AdditionalContactDAO additionalContactDAO = new AdditionalContactDAOImpl();
    AdditionalContactUIHelper additionalContactUIHelper = null;
    public static List<AdditionalContactBean> lstAdditionalContacts = new ArrayList<>();
    public static List<BillingLocationBean> lstBillingLocations = new ArrayList<>();
    public static List<BillingLocationBean> lstBillingLocationsFromDb = new ArrayList<>();
    public static List<AdditionalContactBean> lstAdditionalContactsFromDb = new ArrayList<>();
    
    public AddCustomerFrame() {
        initComponents();
        companyUIHelper = new CompanyUIHelper();
        billingLocationUIHelper = new BillingLocationUIHelper();
        additionalContactUIHelper = new AdditionalContactUIHelper();
        setIconImage(new ImageIcon(ReadFromPropertiesFile.imagePath + "Application-Exe.png").getImage());
        setLocationRelativeTo(null);
        setTitle("Add New Customer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setBackground(Color.WHITE);
        billingLocationUIHelper.generateEmptyTable();
        additionalContactUIHelper.generateEmptyTable();
        lblNotes.setVisible(false);
        
    }
    
    public AddCustomerFrame(CompanyBean companyBean) {
        initComponents();
        this.companyBean = companyBean;
        setTitle("Edit Customer");
        showDataOnScreen();
        companyUIHelper = new CompanyUIHelper();
        billingLocationUIHelper = new BillingLocationUIHelper();
        additionalContactUIHelper = new AdditionalContactUIHelper();
        setIconImage(new ImageIcon(ReadFromPropertiesFile.imagePath + "Application-Exe.png").getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setBackground(Color.WHITE);
        lstBillingLocations = billingLocationDAO.getBillingLocationsByCompanyId(companyBean.getCompanyId());
        lstBillingLocationsFromDb = billingLocationDAO.getBillingLocationsByCompanyId(companyBean.getCompanyId());
        lstAdditionalContacts = additionalContactDAO.getAllAdditionalContactsByCompanyId(companyBean.getCompanyId());
        lstAdditionalContactsFromDb = additionalContactDAO.getAllAdditionalContactsByCompanyId(companyBean.getCompanyId());
        billingLocationUIHelper.generateTable();
        additionalContactUIHelper.generateTable();
    }
    
    private void clickEventOnMenuItem() {
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAdditionalContact addAdditionalContact = new AddAdditionalContact();
                addAdditionalContact.setVisible(true);
            }
        });
    }
    
    private void clickEventOnMenuItemForBilling() {
        BillingLocationUIHelper.addUpdateFlag = "add";
        
        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBillingLocation addBillingLocation = new AddBillingLocation();
                addBillingLocation.setVisible(true);
            }
        });
    }
    
    private void showDataOnScreen() {
        txtCompanyName.setText(companyBean.getCompanyName());
        txtContact.setText(companyBean.getContact());
        txtAddress.setText(companyBean.getAddress());
        txtPosition.setText(companyBean.getPosition());
        txtUnitNo.setText(companyBean.getUnitNo());
        txtPhone.setText(companyBean.getPhone());
        txtExt.setText(companyBean.getExt());
        txtCity.setText(companyBean.getCity());
        txtFax.setText(companyBean.getFax());
        txtPrefix.setText(companyBean.getPrefix());
        txtProvinceState.setText(companyBean.getProvinceState());
        txtZip.setText(companyBean.getZip());
        txtTollFree.setText(companyBean.getTollfree());
        txtEmail.setText(companyBean.getEmail());
        txtCellular.setText(companyBean.getCellular());
        txtWebsite.setText(companyBean.getWebsite());
        txtPager.setText(companyBean.getPager());
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
        AddCustomerPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtZip = new javax.swing.JTextField();
        txtFax = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        txtProvinceState = new javax.swing.JTextField();
        txtPager = new javax.swing.JTextField();
        txtPosition = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        txtContact = new javax.swing.JTextField();
        txtPrefix = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        txtCellular = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        txtWebsite = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtExt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTollFree = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtUnitNo = new javax.swing.JTextField();
        customerTabbedPane = new javax.swing.JTabbedPane();
        ScrollPaneForBillingLocations = new javax.swing.JScrollPane();
        tblBillingLocations = new javax.swing.JTable();
        ScrollPanetblAdditionalContacts = new javax.swing.JScrollPane();
        tblAdditionalContacts = new javax.swing.JTable();
        lblNotes = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        AddCustomerPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtZip.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        txtFax.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Customer");

        txtCompanyName.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        txtCompanyName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCompanyNameKeyReleased(evt);
            }
        });

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox4.setText("Deliver ETA");
        jCheckBox4.setPreferredSize(new java.awt.Dimension(53, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Website.png"))); // NOI18N
        jLabel3.setToolTipText("Open this Url on Web Browser...");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Toll Free");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/New-Customer.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Zip");

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox5.setText("Deliver ETA");
        jCheckBox5.setPreferredSize(new java.awt.Dimension(53, 20));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Ext");

        txtProvinceState.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        txtPager.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        txtPosition.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Fax");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Email");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("City");

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox3.setText("PickUp");
        jCheckBox3.setPreferredSize(new java.awt.Dimension(53, 20));

        txtContact.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        txtPrefix.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Phone");

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Pager");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Address");

        txtCity.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        txtCellular.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox1.setText("Order");
        jCheckBox1.setPreferredSize(new java.awt.Dimension(53, 20));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Website");

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox2.setText("PickUp ETA");
        jCheckBox2.setPreferredSize(new java.awt.Dimension(53, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Position");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Unit No.");

        txtPhone.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        txtWebsite.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Email.png"))); // NOI18N
        jLabel2.setToolTipText("Send an Email to this contact using Outlook...");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Contact");

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Email Notifications");

        txtEmail.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        txtExt.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Cellular");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Province/State");

        txtTollFree.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Prefix");

        txtAddress.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        txtUnitNo.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel15)
                    .addComponent(jLabel8)
                    .addComponent(jLabel16))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(txtProvinceState, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtZip))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCity)
                                    .addComponent(txtUnitNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtWebsite)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPosition)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPager, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTollFree, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCellular, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtFax, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtExt)
                            .addComponent(txtPrefix)))
                    .addComponent(txtContact))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAddress, txtCity, txtUnitNo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(txtExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(txtPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(txtTollFree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtCellular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtPager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtUnitNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtProvinceState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(txtWebsite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );

        customerTabbedPane.setBackground(new java.awt.Color(255, 255, 255));

        tblBillingLocations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Company Name", "Address", "City, P/S", "Phone No", "Contact", "Zip", "Fax No"
            }
        ));
        tblBillingLocations.setToolTipText("Billing Location Listing...");
        tblBillingLocations.setDropMode(javax.swing.DropMode.ON_OR_INSERT_ROWS);
        tblBillingLocations.setGridColor(new java.awt.Color(255, 255, 255));
        tblBillingLocations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblBillingLocationsMouseReleased(evt);
            }
        });
        ScrollPaneForBillingLocations.setViewportView(tblBillingLocations);

        customerTabbedPane.addTab("Billing Locations", ScrollPaneForBillingLocations);

        tblAdditionalContacts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Contact Name", "Phone No", "Extension", "Cell Phone No", "Email Address", "Position", "Fax No", "Pager No"
            }
        ));
        tblAdditionalContacts.setToolTipText("Additional Contacts Listing...");
        tblAdditionalContacts.setGridColor(new java.awt.Color(255, 255, 255));
        tblAdditionalContacts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblAdditionalContactsMouseReleased(evt);
            }
        });
        ScrollPanetblAdditionalContacts.setViewportView(tblAdditionalContacts);

        customerTabbedPane.addTab("Additional Contacts", ScrollPanetblAdditionalContacts);

        lblNotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Notes.png"))); // NOI18N
        lblNotes.setToolTipText("Add Notes...");
        lblNotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblNotesMousePressed(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save.png"))); // NOI18N
        jLabel23.setToolTipText("Save Customer..");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel23MousePressed(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancel.png"))); // NOI18N
        jLabel24.setToolTipText("Close Window...");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel24MousePressed(evt);
            }
        });

        javax.swing.GroupLayout AddCustomerPanelLayout = new javax.swing.GroupLayout(AddCustomerPanel);
        AddCustomerPanel.setLayout(AddCustomerPanelLayout);
        AddCustomerPanelLayout.setHorizontalGroup(
            AddCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddCustomerPanelLayout.createSequentialGroup()
                .addGroup(AddCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AddCustomerPanelLayout.createSequentialGroup()
                        .addComponent(lblNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24))
                    .addGroup(AddCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(customerTabbedPane, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        AddCustomerPanelLayout.setVerticalGroup(
            AddCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddCustomerPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(AddCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(lblNotes)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        AddCustomerPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel23, jLabel24, lblNotes});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddCustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddCustomerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked

    }//GEN-LAST:event_jLabel23MouseClicked

    private void tblAdditionalContactsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdditionalContactsMouseReleased
        // TODO add your handling code here:
        final MouseEvent evt1 = evt;
        jPopupMenu1 = new JPopupMenu();
        menuItem1 = new JMenuItem("Add Contact");
        menuItem1.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "New-Customer.png"));
        menuItem1.setIconTextGap(5);
        JMenuItem menuItem2 = new JMenuItem("Edit Selected Contact");
        menuItem2.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
        menuItem2.setIconTextGap(5);
        JMenuItem menuItem3 = new JMenuItem("Email Selected Contact");
        menuItem3.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Email.png"));
        menuItem3.setIconTextGap(5);
        JMenuItem menuItem4 = new JMenuItem("Delete Selected Contact");
        menuItem4.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
        menuItem4.setIconTextGap(5);
        JMenuItem menuItem5 = new JMenuItem("Hide Inactive Contacts");
        jPopupMenu1.add(menuItem1);
        jPopupMenu1.add(menuItem2);
        jPopupMenu1.add(menuItem3);
        jPopupMenu1.add(menuItem4);
        jPopupMenu1.add(menuItem5);
        if (evt.getButton() == 3) {
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
            clickEventOnMenuItem();
        }
        if (lstAdditionalContacts.size() == 0) {
            menuItem2.setEnabled(false);
            menuItem3.setEnabled(false);
            menuItem4.setEnabled(false);
            menuItem5.setEnabled(false);
        }
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdditionalContactUIHelper.addUpdateFlag = "update";
                AdditionalContactBean additionalContactBean = new AdditionalContactBean();
                additionalContactBean = lstAdditionalContacts.get(tblAdditionalContacts.rowAtPoint(evt1.getPoint()));
                AddAdditionalContact addAdditionalContact = new AddAdditionalContact(tblAdditionalContacts.rowAtPoint(evt1.getPoint()), additionalContactBean);
                addAdditionalContact.setVisible(true);
            }
        });
        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdditionalContactBean additionalContactBean = lstAdditionalContacts.get(tblAdditionalContacts.rowAtPoint(evt1.getPoint()));
                if (additionalContactBean.getAdditionalContactId() != 0) {
                    lstAdditionalContacts.remove(tblAdditionalContacts.rowAtPoint(evt1.getPoint()));
                    additionalContactUIHelper.delete(additionalContactBean.getAdditionalContactId());
                } else {
                    lstAdditionalContacts.remove(tblAdditionalContacts.rowAtPoint(evt1.getPoint()));
                    additionalContactUIHelper.generateTable();
                }
            }
        });
    }//GEN-LAST:event_tblAdditionalContactsMouseReleased

    private void jLabel24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MousePressed
        // TODO add your handling code here:
        dispose();
        AddCustomerFrame.lstAdditionalContacts = new ArrayList<>();
        AddCustomerFrame.lstBillingLocations = new ArrayList<>();
        companyUIHelper.disable(true);
    }//GEN-LAST:event_jLabel24MousePressed

    private void jLabel23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MousePressed
        String msg = companyUIHelper.save();
        JOptionPane.showMessageDialog(null, msg);
        dispose();
    }//GEN-LAST:event_jLabel23MousePressed

    private void tblBillingLocationsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillingLocationsMouseReleased
        jPopupMenu1 = new JPopupMenu();
        final MouseEvent evt1 = evt;
        menuItem1 = new JMenuItem("Find Billing Location");
        menuItem1.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "New-Customer.png"));
        menuItem1.setIconTextGap(5);
        JMenuItem menuItem2 = new JMenuItem("Copy Customer to Billing Location");
        menuItem2.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Update.png"));
        menuItem2.setIconTextGap(5);
        menuItem3 = new JMenuItem("Add New Billing Location");
        menuItem3.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Email.png"));
        menuItem3.setIconTextGap(5);
        JMenuItem menuItem4 = new JMenuItem("Edit Billing Location");
        menuItem4.setIcon(new ImageIcon(ReadFromPropertiesFile.imagePath + "Delete.png"));
        menuItem4.setIconTextGap(5);
        JMenuItem menuItem5 = new JMenuItem("Email Selected Location");
        menuItem6 = new JMenuItem("Remove Billing Location");
        jPopupMenu1.add(menuItem1);
        jPopupMenu1.add(menuItem2);
        jPopupMenu1.add(menuItem3);
        jPopupMenu1.add(menuItem4);
        jPopupMenu1.add(menuItem5);
        jPopupMenu1.add(menuItem6);
        if (evt.getButton() == 3) {
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
            clickEventOnMenuItemForBilling();
        }
        if (lstBillingLocations.size() == 0) {
            menuItem1.setEnabled(false);
            menuItem2.setEnabled(false);
            menuItem4.setEnabled(false);
            menuItem5.setEnabled(false);
            menuItem6.setEnabled(false);
        }
        menuItem6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BillingLocationBean billingLocationBean = lstBillingLocations.get(tblBillingLocations.rowAtPoint(evt1.getPoint()));
                if (billingLocationBean.getBillingLocationId() != 0) {
                    lstBillingLocations.remove(tblBillingLocations.rowAtPoint(evt1.getPoint()));
                    billingLocationUIHelper.delete(billingLocationBean.getBillingLocationId());
                } else {
                    lstBillingLocations.remove(tblBillingLocations.rowAtPoint(evt1.getPoint()));
                    billingLocationUIHelper.generateTable();
                }
            }
        });
        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BillingLocationUIHelper.addUpdateFlag = "update";
                BillingLocationBean billingLocationBean = new BillingLocationBean();
                billingLocationBean = lstBillingLocations.get(tblBillingLocations.rowAtPoint(evt1.getPoint()));
                AddBillingLocation addBillingLocation = new AddBillingLocation(tblBillingLocations.rowAtPoint(evt1.getPoint()), billingLocationBean);
                addBillingLocation.setVisible(true);
            }
        });
    }//GEN-LAST:event_tblBillingLocationsMouseReleased

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseExited

    private void lblNotesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNotesMousePressed
        AddCustomerNotes addCustomerNotes = null;
        if (CompanyUIHelper.addUpdateFlag.equals("add")) {
            addCustomerNotes = new AddCustomerNotes();
        } else {
            addCustomerNotes = new AddCustomerNotes(companyBean);
        }
        addCustomerNotes.setVisible(true);
    }//GEN-LAST:event_lblNotesMousePressed

    private void txtCompanyNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanyNameKeyReleased
        // TODO add your handling code here:
        String companyName = txtCompanyName.getText();
        if (companyName.equals("")) {
            lblNotes.setVisible(false);
        } else {
            lblNotes.setVisible(true);
        }
    }//GEN-LAST:event_txtCompanyNameKeyReleased

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
            java.util.logging.Logger.getLogger(AddCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCustomerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel AddCustomerPanel;
    public static javax.swing.JScrollPane ScrollPaneForBillingLocations;
    public static javax.swing.JScrollPane ScrollPanetblAdditionalContacts;
    public static javax.swing.JTabbedPane customerTabbedPane;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNotes;
    public static javax.swing.JTable tblAdditionalContacts;
    public static javax.swing.JTable tblBillingLocations;
    public static javax.swing.JTextField txtAddress;
    public static javax.swing.JTextField txtCellular;
    public static javax.swing.JTextField txtCity;
    public static javax.swing.JTextField txtCompanyName;
    public static javax.swing.JTextField txtContact;
    public static javax.swing.JTextField txtEmail;
    public static javax.swing.JTextField txtExt;
    public static javax.swing.JTextField txtFax;
    public static javax.swing.JTextField txtPager;
    public static javax.swing.JTextField txtPhone;
    public static javax.swing.JTextField txtPosition;
    public static javax.swing.JTextField txtPrefix;
    public static javax.swing.JTextField txtProvinceState;
    public static javax.swing.JTextField txtTollFree;
    public static javax.swing.JTextField txtUnitNo;
    public static javax.swing.JTextField txtWebsite;
    public static javax.swing.JTextField txtZip;
    // End of variables declaration//GEN-END:variables
}
