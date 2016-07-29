package dpu.ui.common;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MainFrame extends javax.swing.JFrame implements MouseMotionListener, MouseListener {

    String addUpdateFlag = "";
    static List<String> lstTabs = new ArrayList<>();
    static List<String> lstPreferences = new ArrayList<>();
    static Map<String, JPanel> map = new TreeMap<>();
    private boolean dragging = false;
    private Image tabImage = null;
    private Point currentMouseLocation = null;
    private int draggedTabIndex = 0;

    public MainFrame() {
        initComponents();
        setResizable(true);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        mainTabbedPane.removeAll();
        checkPreference();
        showHideTabs();
        readTabFile();
        mainTabbedPane.addMouseListener(MainFrame.this);
        mainTabbedPane.addMouseMotionListener(MainFrame.this);
//        instantiateUIHelper();
//        callGenerateTable();
        setSettingsIcon();
//        try {
//            Browser browser = new Browser();
//            BrowserView view = new BrowserView(browser);
//            browser.loadURL("D:\\JavaGit\\hello-world\\DPU\\src\\dpu\\ui\\common\\Demo.html");
//            JFrame frame = new JFrame();
//            frame.add(view, BorderLayout.CENTER);
//            frame.setSize(700, 500);
//            frame.setVisible(true);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

    private void readTabFile() {
        String msg = "";
        BufferedReader readFile = null;
        try {
            readFile = new BufferedReader(new InputStreamReader(new FileInputStream("src\\dpu\\ui\\common\\tabs.txt")));
            while ((msg = readFile.readLine()) != null) {
                lstTabs.add(msg);
            }
            readFile.close();
        } catch (Exception e) {
            System.out.println("MainFrame : readTabFile() : " + e);
        }
    }

    public static void checkPreference() {
        String msg = "";
        BufferedReader readFile = null;
        try {
            readFile = new BufferedReader(new InputStreamReader(new FileInputStream("src\\dpu\\ui\\common\\preferencetabs.txt")));
            while ((msg = readFile.readLine()) != null) {
                lstPreferences.add(msg);
                if (msg.contains("Class")) {
                    map.put(msg, new TestClassPanel());
                } else if (msg.contains("Company")) {
                    map.put(msg, new TestCompanyPanel());
                } else if (msg.contains("Role")) {
                    map.put(msg, new TestRolePanel());
                } else if (msg.contains("Tracking")) {
                    map.put(msg, new TestTrackingPanel());
                } else if (msg.contains("Jurisdiction")) {
                    map.put(msg, new TestJurisdictionPanel());
                } else if (msg.contains("List")) {
                    map.put(msg, new TestListPanel());
                } else if (msg.contains("Resources")) {
                    map.put(msg, new TestResourcesPanel());
                } else if (msg.contains("SalesPerson")) {
                    map.put(msg, new TestSalesPersonPanel());
                } else if (msg.contains("StandardCharges")) {
                    map.put(msg, new TestStandardCharges());
                } else if (msg.contains("Customers")) {
                    map.put(msg, new TestCustomerPanel());
                } else if (msg.contains("Prospects")) {
                    map.put(msg, new TestProspectPanel());
                } else if (msg.contains("Shippers")) {
                    map.put(msg, new TestShippersPanel());
                } else if (msg.contains("BorderCrossing")) {
                    map.put(msg, new TestBorderCrossingPanel());
                } else if (msg.contains("OutsideCarriers")) {
                    map.put(msg, new TestOutsideCarriersPanel());
                } else if (msg.contains("MiscVendors")) {
                    map.put(msg, new TestMiscVendorsPanel());
                } else if (msg.contains("CustomBrokers")) {
                    map.put(msg, new TestCustomBrokersPanel());
                } else if (msg.contains("PayrollSchedules")) {
                    map.put(msg, new TestPayrollSchedulesPanel());
                } else if (msg.contains("StandardTemplates")) {
                    map.put(msg, new TestStandardTemplatesPanel());
                } else if (msg.contains("MasterOrders")) {
                    map.put(msg, new TestMasterOrdersPanel());
                } else if (msg.contains("TravelTimes")) {
                    map.put(msg, new TestTravelTimesPanel());
                }
            }
            readFile.close();
        } catch (Exception e) {
            System.out.println("MainFrame : checkPreference() : " + e);
        }
    }

    public static void showHideTabs() {
        Set<String> set = map.keySet();
        Iterator<String> itr = set.iterator();
        int counter = 0;
        while (itr.hasNext()) {
            String key = itr.next();
            JPanel jPanel = map.get(key);
            mainTabbedPane.addTab(key + "    ", jPanel);
            if (key.equals("OutsideCarriers")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\OutsideCarrier.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("BorderCrossing")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\BorderCrossing.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("PayrollSchedules")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\PayrollSchedules.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("Prospects")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Prospects.jpg");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("Company")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Company.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("Resources")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Resources.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("Role")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Roles.jpg");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("Customers")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Customers.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("SalesPerson")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\SalesPerson.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("Shippers")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Shippers.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("Jurisdiction")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Jurisdiction.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("StandardCharges")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\StandardCharges.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("List")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\List.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("MasterOrders")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\MasterOrders.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("MiscVendors")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\MiscVendors.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("Tracking")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Tracking.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("TravelTimes")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\TravelTimes.gif");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("CustomBrokers")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\CustomBrokers.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("Class")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Class.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            } else if (key.equals("StandardTemplates")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\StandardTemplates.png");
                mainTabbedPane.setIconAt(counter, imageIcon);
            }
            counter++;
        }
    }

    public static void setSettingsIcon() {
        mainTabbedPane.add("Settings", new TestSettingsPanel());
        mainTabbedPane.setTitleAt(mainTabbedPane.getTabCount() - 1, "");
        ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Settings.png");
        mainTabbedPane.setIconAt(mainTabbedPane.getTabCount() - 1, imageIcon);
    }

//    private void instantiateUIHelper() {
//        classUI = new ClassUIHelper();
//        divisionUI = new DivisionUIHelper();
//        companyUI = new CompanyUIHelper();
//        equipmentUI = new EquipmentUIHelper();
//        roleUI = new RoleUIHelper();
//        terminalUIHelper = new TerminalUIHelper();
//        trackingUIHelper = new TrackingUIHelper();
//        countryUIHelper = new CountryUIHelper();
//        jurisdictionUIHelper = new JurisdictionUIHelper();
//    }
//    private void callGenerateTable() {
//        classUI.generateTable();
//        divisionUI.generateTable();
//        companyUI.generateTable();
//        equipmentUI.generateTable();
//        roleUI.generateTable();
//        terminalUIHelper.generateTable();
//        trackingUIHelper.generateTable();
//        countryUIHelper.generateTable();
//        jurisdictionUIHelper.generateTable();
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTabbedPane = new javax.swing.JTabbedPane();
        divisionPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDivision = new javax.swing.JTable();
        btnClearManageDivision = new javax.swing.JButton();
        txtDivisionSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnAddManageDivision = new javax.swing.JButton();
        classPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblClass = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAddManageClass = new javax.swing.JButton();
        btnClearManageClass = new javax.swing.JButton();
        txtClassSearch = new javax.swing.JTextField();
        companyPanel = new javax.swing.JPanel();
        btnAddManageCompany = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCompanySearch = new javax.swing.JTextField();
        btnClearManageCompany = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCompany = new javax.swing.JTable();
        equipmentPanel = new javax.swing.JPanel();
        btnAddManageEquipment = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtEquipmentSearch = new javax.swing.JTextField();
        btnClearManageEquipment = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblEquipment = new javax.swing.JTable();
        rolePanel = new javax.swing.JPanel();
        btnAddManageRole = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtRoleSearch = new javax.swing.JTextField();
        btnClearManageRole = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblRole = new javax.swing.JTable();
        terminalPanel = new javax.swing.JPanel();
        btnAddManageTerminal = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTerminalSearch = new javax.swing.JTextField();
        btnClearManageTerminal = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblTerminal = new javax.swing.JTable();
        trackingPanel = new javax.swing.JPanel();
        txtTrackingSearch = new javax.swing.JTextField();
        btnAddManageTracking = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnClearManageTracking = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblTracking = new javax.swing.JTable();
        powerUnitPanel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblPowerUnit = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtPowerUnitSearch = new javax.swing.JTextField();
        btnAddManagePowerUnit = new javax.swing.JButton();
        btnClearManagePowerUnit = new javax.swing.JButton();
        mapPanel = new javax.swing.JPanel();
        jurisdictionPanel = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblJurisdiction = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtJurisdictionSearch = new javax.swing.JTextField();
        btnAddManageJurisdiction = new javax.swing.JButton();
        btnClearManageJurisdiction = new javax.swing.JButton();
        countryPanel = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblCountry = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtCountrySearch = new javax.swing.JTextField();
        btnAddManageCountry = new javax.swing.JButton();
        btnClearManageCountry = new javax.swing.JButton();
        settingsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblDivision.setAutoCreateRowSorter(true);
        tblDivision.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Division Id", "Title"
            }
        ));
        tblDivision.setRowHeight(18);
        jScrollPane2.setViewportView(tblDivision);

        btnClearManageDivision.setText("Clear");
        btnClearManageDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearManageDivisionActionPerformed(evt);
            }
        });

        txtDivisionSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDivisionSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDivisionSearchKeyTyped(evt);
            }
        });

        jLabel8.setText("Search");

        btnAddManageDivision.setText("+");
        btnAddManageDivision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddManageDivisionMouseClicked(evt);
            }
        });
        btnAddManageDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddManageDivisionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout divisionPanelLayout = new javax.swing.GroupLayout(divisionPanel);
        divisionPanel.setLayout(divisionPanelLayout);
        divisionPanelLayout.setHorizontalGroup(
            divisionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(divisionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(divisionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(divisionPanelLayout.createSequentialGroup()
                        .addComponent(btnAddManageDivision)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDivisionSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearManageDivision)))
                .addContainerGap(780, Short.MAX_VALUE))
        );
        divisionPanelLayout.setVerticalGroup(
            divisionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, divisionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(divisionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDivisionSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnClearManageDivision)
                    .addComponent(btnAddManageDivision))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Division", divisionPanel);

        tblClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Title"
            }
        ));
        jScrollPane3.setViewportView(tblClass);

        jLabel2.setText("Search");

        btnAddManageClass.setText("+");
        btnAddManageClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddManageClassActionPerformed(evt);
            }
        });

        btnClearManageClass.setText("Clear");
        btnClearManageClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearManageClassActionPerformed(evt);
            }
        });

        txtClassSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClassSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClassSearchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout classPanelLayout = new javax.swing.GroupLayout(classPanel);
        classPanel.setLayout(classPanelLayout);
        classPanelLayout.setHorizontalGroup(
            classPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(classPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(classPanelLayout.createSequentialGroup()
                        .addComponent(btnAddManageClass)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClassSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearManageClass))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(766, Short.MAX_VALUE))
        );
        classPanelLayout.setVerticalGroup(
            classPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, classPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(classPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddManageClass)
                    .addComponent(jLabel2)
                    .addComponent(btnClearManageClass)
                    .addComponent(txtClassSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Class", classPanel);

        btnAddManageCompany.setText("+");
        btnAddManageCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddManageCompanyActionPerformed(evt);
            }
        });

        jLabel3.setText("Search");

        txtCompanySearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCompanySearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCompanySearchKeyTyped(evt);
            }
        });

        btnClearManageCompany.setText("Clear");
        btnClearManageCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearManageCompanyActionPerformed(evt);
            }
        });

        tblCompany.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Title"
            }
        ));
        jScrollPane4.setViewportView(tblCompany);

        javax.swing.GroupLayout companyPanelLayout = new javax.swing.GroupLayout(companyPanel);
        companyPanel.setLayout(companyPanelLayout);
        companyPanelLayout.setHorizontalGroup(
            companyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(companyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(companyPanelLayout.createSequentialGroup()
                        .addComponent(btnAddManageCompany)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCompanySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearManageCompany))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(766, Short.MAX_VALUE))
        );
        companyPanelLayout.setVerticalGroup(
            companyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(companyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddManageCompany)
                    .addComponent(jLabel3)
                    .addComponent(btnClearManageCompany)
                    .addComponent(txtCompanySearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Company", companyPanel);

        btnAddManageEquipment.setText("+");
        btnAddManageEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddManageEquipmentActionPerformed(evt);
            }
        });

        jLabel4.setText("Search");

        txtEquipmentSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEquipmentSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEquipmentSearchKeyTyped(evt);
            }
        });

        btnClearManageEquipment.setText("Clear");
        btnClearManageEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearManageEquipmentActionPerformed(evt);
            }
        });

        tblEquipment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Title"
            }
        ));
        jScrollPane5.setViewportView(tblEquipment);

        javax.swing.GroupLayout equipmentPanelLayout = new javax.swing.GroupLayout(equipmentPanel);
        equipmentPanel.setLayout(equipmentPanelLayout);
        equipmentPanelLayout.setHorizontalGroup(
            equipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(equipmentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(equipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(equipmentPanelLayout.createSequentialGroup()
                        .addComponent(btnAddManageEquipment)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEquipmentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearManageEquipment))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(766, Short.MAX_VALUE))
        );
        equipmentPanelLayout.setVerticalGroup(
            equipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, equipmentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(equipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddManageEquipment)
                    .addComponent(jLabel4)
                    .addComponent(btnClearManageEquipment)
                    .addComponent(txtEquipmentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Equipment", equipmentPanel);

        btnAddManageRole.setText("+");
        btnAddManageRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddManageRoleActionPerformed(evt);
            }
        });

        jLabel5.setText("Search");

        txtRoleSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRoleSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRoleSearchKeyTyped(evt);
            }
        });

        btnClearManageRole.setText("Clear");
        btnClearManageRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearManageRoleActionPerformed(evt);
            }
        });

        tblRole.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Title"
            }
        ));
        jScrollPane6.setViewportView(tblRole);

        javax.swing.GroupLayout rolePanelLayout = new javax.swing.GroupLayout(rolePanel);
        rolePanel.setLayout(rolePanelLayout);
        rolePanelLayout.setHorizontalGroup(
            rolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rolePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rolePanelLayout.createSequentialGroup()
                        .addComponent(btnAddManageRole)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRoleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearManageRole))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(766, Short.MAX_VALUE))
        );
        rolePanelLayout.setVerticalGroup(
            rolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rolePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddManageRole)
                    .addComponent(jLabel5)
                    .addComponent(btnClearManageRole)
                    .addComponent(txtRoleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Role", rolePanel);

        btnAddManageTerminal.setText("+");
        btnAddManageTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddManageTerminalActionPerformed(evt);
            }
        });

        jLabel6.setText("Search");

        txtTerminalSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTerminalSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTerminalSearchKeyTyped(evt);
            }
        });

        btnClearManageTerminal.setText("Clear");
        btnClearManageTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearManageTerminalActionPerformed(evt);
            }
        });

        tblTerminal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Title"
            }
        ));
        jScrollPane7.setViewportView(tblTerminal);

        javax.swing.GroupLayout terminalPanelLayout = new javax.swing.GroupLayout(terminalPanel);
        terminalPanel.setLayout(terminalPanelLayout);
        terminalPanelLayout.setHorizontalGroup(
            terminalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(terminalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(terminalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(terminalPanelLayout.createSequentialGroup()
                        .addComponent(btnAddManageTerminal)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTerminalSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearManageTerminal))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(766, Short.MAX_VALUE))
        );
        terminalPanelLayout.setVerticalGroup(
            terminalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, terminalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(terminalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddManageTerminal)
                    .addComponent(jLabel6)
                    .addComponent(btnClearManageTerminal)
                    .addComponent(txtTerminalSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Terminal", terminalPanel);

        txtTrackingSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTrackingSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTrackingSearchKeyTyped(evt);
            }
        });

        btnAddManageTracking.setText("+");
        btnAddManageTracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddManageTrackingActionPerformed(evt);
            }
        });

        jLabel7.setText("Search");

        btnClearManageTracking.setText("Clear");
        btnClearManageTracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearManageTrackingActionPerformed(evt);
            }
        });

        tblTracking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Title"
            }
        ));
        jScrollPane8.setViewportView(tblTracking);

        javax.swing.GroupLayout trackingPanelLayout = new javax.swing.GroupLayout(trackingPanel);
        trackingPanel.setLayout(trackingPanelLayout);
        trackingPanelLayout.setHorizontalGroup(
            trackingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trackingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(trackingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(trackingPanelLayout.createSequentialGroup()
                        .addComponent(btnAddManageTracking)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTrackingSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearManageTracking))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(766, Short.MAX_VALUE))
        );
        trackingPanelLayout.setVerticalGroup(
            trackingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trackingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(trackingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddManageTracking)
                    .addComponent(jLabel7)
                    .addComponent(btnClearManageTracking)
                    .addComponent(txtTrackingSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Tracking", trackingPanel);

        tblPowerUnit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Title"
            }
        ));
        jScrollPane9.setViewportView(tblPowerUnit);

        jLabel10.setText("Search");

        btnAddManagePowerUnit.setText("+");
        btnAddManagePowerUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddManagePowerUnitActionPerformed(evt);
            }
        });

        btnClearManagePowerUnit.setText("Clear");

        javax.swing.GroupLayout powerUnitPanelLayout = new javax.swing.GroupLayout(powerUnitPanel);
        powerUnitPanel.setLayout(powerUnitPanelLayout);
        powerUnitPanelLayout.setHorizontalGroup(
            powerUnitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(powerUnitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(powerUnitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(powerUnitPanelLayout.createSequentialGroup()
                        .addComponent(btnAddManagePowerUnit)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPowerUnitSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearManagePowerUnit)))
                .addGap(0, 796, Short.MAX_VALUE))
        );
        powerUnitPanelLayout.setVerticalGroup(
            powerUnitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, powerUnitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(powerUnitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPowerUnitSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearManagePowerUnit)
                    .addComponent(btnAddManagePowerUnit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("PowerUnit", powerUnitPanel);

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1258, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        mainTabbedPane.addTab("Map", mapPanel);

        tblJurisdiction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Title"
            }
        ));
        jScrollPane10.setViewportView(tblJurisdiction);

        jLabel11.setText("Search");

        txtJurisdictionSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJurisdictionSearchKeyReleased(evt);
            }
        });

        btnAddManageJurisdiction.setText("+");
        btnAddManageJurisdiction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddManageJurisdictionActionPerformed(evt);
            }
        });

        btnClearManageJurisdiction.setText("Clear");
        btnClearManageJurisdiction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearManageJurisdictionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jurisdictionPanelLayout = new javax.swing.GroupLayout(jurisdictionPanel);
        jurisdictionPanel.setLayout(jurisdictionPanelLayout);
        jurisdictionPanelLayout.setHorizontalGroup(
            jurisdictionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jurisdictionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jurisdictionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jurisdictionPanelLayout.createSequentialGroup()
                        .addComponent(btnAddManageJurisdiction)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtJurisdictionSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearManageJurisdiction)))
                .addGap(0, 796, Short.MAX_VALUE))
        );
        jurisdictionPanelLayout.setVerticalGroup(
            jurisdictionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jurisdictionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jurisdictionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtJurisdictionSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearManageJurisdiction)
                    .addComponent(btnAddManageJurisdiction))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Jurisdiction", jurisdictionPanel);

        tblCountry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Title"
            }
        ));
        jScrollPane11.setViewportView(tblCountry);

        jLabel12.setText("Search");

        txtCountrySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCountrySearchActionPerformed(evt);
            }
        });
        txtCountrySearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCountrySearchKeyReleased(evt);
            }
        });

        btnAddManageCountry.setText("+");
        btnAddManageCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddManageCountryActionPerformed(evt);
            }
        });

        btnClearManageCountry.setText("Clear");
        btnClearManageCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearManageCountryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout countryPanelLayout = new javax.swing.GroupLayout(countryPanel);
        countryPanel.setLayout(countryPanelLayout);
        countryPanelLayout.setHorizontalGroup(
            countryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(countryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(countryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(countryPanelLayout.createSequentialGroup()
                        .addComponent(btnAddManageCountry)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCountrySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearManageCountry)))
                .addGap(0, 796, Short.MAX_VALUE))
        );
        countryPanelLayout.setVerticalGroup(
            countryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, countryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(countryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCountrySearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearManageCountry)
                    .addComponent(btnAddManageCountry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Country", countryPanel);

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1258, Short.MAX_VALUE)
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        mainTabbedPane.addTab("Settings", settingsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearManageCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearManageCountryActionPerformed
//        txtCountrySearch.setText("");
//        countryUIHelper.generateTable();
    }//GEN-LAST:event_btnClearManageCountryActionPerformed

    private void btnAddManageCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddManageCountryActionPerformed
        // TODO add your handling code here:
//        countryUIHelper.disable(false);
//        AddCountryFrame addCountryFrame = new AddCountryFrame();
//        addCountryFrame.setVisible(true);
    }//GEN-LAST:event_btnAddManageCountryActionPerformed

    private void txtCountrySearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCountrySearchKeyReleased
//        countryUIHelper.generateTable();
    }//GEN-LAST:event_txtCountrySearchKeyReleased

    private void txtCountrySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCountrySearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCountrySearchActionPerformed

    private void btnClearManageJurisdictionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearManageJurisdictionActionPerformed
//        txtJurisdictionSearch.setText("");
//        jurisdictionUIHelper.generateTable();
    }//GEN-LAST:event_btnClearManageJurisdictionActionPerformed

    private void btnAddManageJurisdictionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddManageJurisdictionActionPerformed
//        jurisdictionUIHelper.disable(false);
//        AddJurisdictionFrame addJurisdictionFrame = new AddJurisdictionFrame();
//        addJurisdictionFrame.setVisible(true);
    }//GEN-LAST:event_btnAddManageJurisdictionActionPerformed

    private void txtJurisdictionSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJurisdictionSearchKeyReleased
//        jurisdictionUIHelper.generateTable();
    }//GEN-LAST:event_txtJurisdictionSearchKeyReleased

    private void btnAddManagePowerUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddManagePowerUnitActionPerformed
//        AddPowerUnitFrame addPowerUnitFrame = new AddPowerUnitFrame();
//        addPowerUnitFrame.setVisible(true);
    }//GEN-LAST:event_btnAddManagePowerUnitActionPerformed

    private void btnClearManageTrackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearManageTrackingActionPerformed
//        txtTrackingSearch.setText("");
//        trackingUIHelper.generateTable();
    }//GEN-LAST:event_btnClearManageTrackingActionPerformed

    private void btnAddManageTrackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddManageTrackingActionPerformed
//        trackingUIHelper.disable(false);
//        AddTrackingFrame addTrackingFrame = new AddTrackingFrame();
//        addTrackingFrame.setVisible(true);
    }//GEN-LAST:event_btnAddManageTrackingActionPerformed

    private void txtTrackingSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTrackingSearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrackingSearchKeyTyped

    private void txtTrackingSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTrackingSearchKeyReleased
//        trackingUIHelper.generateTable();
    }//GEN-LAST:event_txtTrackingSearchKeyReleased

    private void btnClearManageTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearManageTerminalActionPerformed
//        txtTerminalSearch.setText("");
//        terminalUIHelper.generateTable();
    }//GEN-LAST:event_btnClearManageTerminalActionPerformed

    private void txtTerminalSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTerminalSearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTerminalSearchKeyTyped

    private void txtTerminalSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTerminalSearchKeyReleased
//        terminalUIHelper.generateTable();
    }//GEN-LAST:event_txtTerminalSearchKeyReleased

    private void btnAddManageTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddManageTerminalActionPerformed
//        terminalUIHelper.disable(false);
//        AddTerminalFrame addTerminalFrame = new AddTerminalFrame();
//        addTerminalFrame.setVisible(true);
    }//GEN-LAST:event_btnAddManageTerminalActionPerformed

    private void btnClearManageRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearManageRoleActionPerformed
//        txtRoleSearch.setText("");
//        roleUI.generateTable();
    }//GEN-LAST:event_btnClearManageRoleActionPerformed

    private void txtRoleSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRoleSearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoleSearchKeyTyped

    private void txtRoleSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRoleSearchKeyReleased
//        roleUI.generateTable();
    }//GEN-LAST:event_txtRoleSearchKeyReleased

    private void btnAddManageRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddManageRoleActionPerformed
//        roleUI.disable(false);
//        AddRoleFrame addRoleFrame = new AddRoleFrame();
//        addRoleFrame.setVisible(true);
    }//GEN-LAST:event_btnAddManageRoleActionPerformed

    private void btnClearManageEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearManageEquipmentActionPerformed
//        txtEquipmentSearch.setText("");
//        equipmentUI.generateTable();
    }//GEN-LAST:event_btnClearManageEquipmentActionPerformed

    private void txtEquipmentSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEquipmentSearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEquipmentSearchKeyTyped

    private void txtEquipmentSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEquipmentSearchKeyReleased
//        equipmentUI.generateTable();
    }//GEN-LAST:event_txtEquipmentSearchKeyReleased

    private void btnAddManageEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddManageEquipmentActionPerformed
//        equipmentUI.disable(false);
//        AddEquipmentFrame addEquipmentFrame = new AddEquipmentFrame();
//        addEquipmentFrame.setVisible(true);
    }//GEN-LAST:event_btnAddManageEquipmentActionPerformed

    private void btnClearManageCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearManageCompanyActionPerformed
        // TODO add your handling code here:
//        txtCompanySearch.setText("");
//        companyUI.generateTable();
    }//GEN-LAST:event_btnClearManageCompanyActionPerformed

    private void txtCompanySearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanySearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompanySearchKeyTyped

    private void txtCompanySearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanySearchKeyReleased
        // TODO add your handling code here:
//        companyUI.generateTable();
    }//GEN-LAST:event_txtCompanySearchKeyReleased

    private void btnAddManageCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddManageCompanyActionPerformed
        // TODO add your handling code here:
//        companyUI.disable(false);
//        AddCompanyFrame addCompanyFrame = new AddCompanyFrame();
//        addCompanyFrame.setVisible(true);
    }//GEN-LAST:event_btnAddManageCompanyActionPerformed

    private void txtClassSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClassSearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClassSearchKeyTyped

    private void txtClassSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClassSearchKeyReleased
//        classUI.generateTable();
    }//GEN-LAST:event_txtClassSearchKeyReleased

    private void btnClearManageClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearManageClassActionPerformed
//        txtClassSearch.setText("");
//        classUI.generateTable();
    }//GEN-LAST:event_btnClearManageClassActionPerformed

    private void btnAddManageClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddManageClassActionPerformed
//        classUI.disable(false);
//        AddClassFrame addClassFrame = new AddClassFrame();
//        addClassFrame.setVisible(true);
    }//GEN-LAST:event_btnAddManageClassActionPerformed

    private void btnAddManageDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddManageDivisionActionPerformed
//        divisionUI.disable(false);
//        AddDivisionFrame addDivisionFrame = new AddDivisionFrame();
//        addDivisionFrame.setVisible(true);
    }//GEN-LAST:event_btnAddManageDivisionActionPerformed

    private void txtDivisionSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDivisionSearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDivisionSearchKeyTyped

    private void txtDivisionSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDivisionSearchKeyReleased
//        divisionUI.generateTable();
    }//GEN-LAST:event_txtDivisionSearchKeyReleased

    private void btnClearManageDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearManageDivisionActionPerformed
//        txtDivisionSearch.setText("");
//        divisionUI.generateTable();
    }//GEN-LAST:event_btnClearManageDivisionActionPerformed

    private void btnAddManageDivisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddManageDivisionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddManageDivisionMouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAddManageClass;
    public static javax.swing.JButton btnAddManageCompany;
    public static javax.swing.JButton btnAddManageCountry;
    public static javax.swing.JButton btnAddManageDivision;
    public static javax.swing.JButton btnAddManageEquipment;
    public static javax.swing.JButton btnAddManageJurisdiction;
    public static javax.swing.JButton btnAddManagePowerUnit;
    public static javax.swing.JButton btnAddManageRole;
    public static javax.swing.JButton btnAddManageTerminal;
    public static javax.swing.JButton btnAddManageTracking;
    public static javax.swing.JButton btnClearManageClass;
    public static javax.swing.JButton btnClearManageCompany;
    public static javax.swing.JButton btnClearManageCountry;
    public static javax.swing.JButton btnClearManageDivision;
    public static javax.swing.JButton btnClearManageEquipment;
    public static javax.swing.JButton btnClearManageJurisdiction;
    public static javax.swing.JButton btnClearManagePowerUnit;
    public static javax.swing.JButton btnClearManageRole;
    public static javax.swing.JButton btnClearManageTerminal;
    public static javax.swing.JButton btnClearManageTracking;
    public static javax.swing.JPanel classPanel;
    public static javax.swing.JPanel companyPanel;
    public static javax.swing.JPanel countryPanel;
    public static javax.swing.JPanel divisionPanel;
    public static javax.swing.JPanel equipmentPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JScrollPane jScrollPane10;
    public static javax.swing.JScrollPane jScrollPane11;
    public static javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JScrollPane jScrollPane6;
    public static javax.swing.JScrollPane jScrollPane7;
    public static javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public static javax.swing.JPanel jurisdictionPanel;
    public static javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JPanel mapPanel;
    public static javax.swing.JPanel powerUnitPanel;
    public static javax.swing.JPanel rolePanel;
    public static javax.swing.JPanel settingsPanel;
    public static javax.swing.JTable tblClass;
    public static javax.swing.JTable tblCompany;
    public static javax.swing.JTable tblCountry;
    public static javax.swing.JTable tblDivision;
    public static javax.swing.JTable tblEquipment;
    public static javax.swing.JTable tblJurisdiction;
    public static javax.swing.JTable tblPowerUnit;
    public static javax.swing.JTable tblRole;
    public static javax.swing.JTable tblTerminal;
    public static javax.swing.JTable tblTracking;
    public static javax.swing.JPanel terminalPanel;
    public static javax.swing.JPanel trackingPanel;
    public static javax.swing.JTextField txtClassSearch;
    public static javax.swing.JTextField txtCompanySearch;
    public static javax.swing.JTextField txtCountrySearch;
    public static javax.swing.JTextField txtDivisionSearch;
    public static javax.swing.JTextField txtEquipmentSearch;
    public static javax.swing.JTextField txtJurisdictionSearch;
    public static javax.swing.JTextField txtPowerUnitSearch;
    public static javax.swing.JTextField txtRoleSearch;
    public static javax.swing.JTextField txtTerminalSearch;
    public static javax.swing.JTextField txtTrackingSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!dragging) {
            // Gets the tab index based on the mouse position
            int tabNumber = mainTabbedPane.getUI().tabForCoordinate(mainTabbedPane, e.getX(), e.getY());

            if (tabNumber >= 0) {
                draggedTabIndex = tabNumber;
                Rectangle bounds = mainTabbedPane.getUI().getTabBounds(mainTabbedPane, tabNumber);
//                System.out.println("BOUNDS: " + bounds);
                // Paint the tabbed pane to a buffer
                Image totalImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
//                System.out.println("2nd:aa " + getWidth());
//                System.out.println("2nd:bb " + getHeight());
                Graphics totalGraphics = totalImage.getGraphics();
                totalGraphics.setClip(bounds);
                mainTabbedPane.setDoubleBuffered(false);
                // Don't be double buffered when painting to a static image.
                // Paint just the dragged tab to the buffer
                tabImage = new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_ARGB);
                Graphics graphics = tabImage.getGraphics();
                graphics.drawImage(totalImage, 0, 0, bounds.width, bounds.height, bounds.x, bounds.y, bounds.x + bounds.width, bounds.y + bounds.height, MainFrame.this);

                dragging = true;
            currentMouseLocation = e.getPoint();
                paintComponent(totalGraphics);
                repaint();
            }
        } else {
            // Need to repaint
            repaint();
        }

    }

    protected void paintComponent(Graphics g) {
        // Are we dragging?
//        mainTabbedPane.paintComponents(g);
            System.out.println(dragging);
            System.out.println(currentMouseLocation);
            System.out.println(tabImage);
        if (dragging && currentMouseLocation != null && tabImage != null) {
            // Draw the dragged tab
//                g.drawImage(tabImage, 0, 0, bounds.width, bounds.height, bounds.x, bounds.y, bounds.x + bounds.width, bounds.y + bounds.height, mainTabbedPane);
            g.drawImage(tabImage, currentMouseLocation.x, currentMouseLocation.y, mainTabbedPane.getTabComponentAt(draggedTabIndex));
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (dragging) {
            int tabNumber = mainTabbedPane.getUI().tabForCoordinate(mainTabbedPane, e.getX(), e.getY());
            if (tabNumber >= 0) {
                Component comp = mainTabbedPane.getComponentAt(draggedTabIndex);
                String title = mainTabbedPane.getTitleAt(draggedTabIndex);
                System.out.println("Title At: " + title);
                mainTabbedPane.removeTabAt(draggedTabIndex);
                mainTabbedPane.insertTab(title, null, comp, null, tabNumber);
            }
        }

        dragging = false;
        tabImage = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
