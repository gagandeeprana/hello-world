package dpu.ui.common;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainTabbedPane extends JTabbedPane {

    static List<String> lstPreferences = new ArrayList<>();
    static Map<String, JPanel> map = new TreeMap<>();
    private boolean dragging = false;
    private Image tabImage = null;
    private Point currentMouseLocation = null;
    private int draggedTabIndex = 0;
    static MainTabbedPane m1 = new MainTabbedPane();
    static List<String> lstTabs = new ArrayList<>();

    public MainTabbedPane() {
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {

                if (!dragging) {
                    // Gets the tab index based on the mouse position
                    int tabNumber = getUI().tabForCoordinate(MainTabbedPane.this, e.getX(), e.getY());
                    if (tabNumber >= 0) {
                        draggedTabIndex = tabNumber;
                        Rectangle bounds = getUI().getTabBounds(MainTabbedPane.this, tabNumber);

                        // Paint the tabbed pane to a buffer
                        Image totalImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                        Graphics totalGraphics = totalImage.getGraphics();
                        totalGraphics.setClip(bounds);
                        // Don't be double buffered when painting to a static image.
                        setDoubleBuffered(false);
                        paintComponent(totalGraphics);

                        // Paint just the dragged tab to the buffer
                        tabImage = new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_ARGB);
                        Graphics graphics = tabImage.getGraphics();
                        graphics.drawImage(totalImage, 0, 0, bounds.width, bounds.height, bounds.x, bounds.y, bounds.x + bounds.width, bounds.y + bounds.height, MainTabbedPane.this);

                        dragging = true;
                        repaint();
                    }
                } else {
                    currentMouseLocation = e.getPoint();

                    // Need to repaint
                    repaint();
                }

                super.mouseDragged(e);
            }
        });

        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {

                if (dragging) {
                    int tabNumber = getUI().tabForCoordinate(MainTabbedPane.this, e.getX(), e.getY());

                    if (tabNumber >= 0) {
                        Component comp = getComponentAt(draggedTabIndex);
                        String title = getTitleAt(draggedTabIndex);
                        removeTabAt(draggedTabIndex);
                        insertTab(title, null, comp, null, tabNumber);
                        setImageIcon(getTitleAt(tabNumber), tabNumber);
                        setSelectedIndex(tabNumber);
                    }
                }

                dragging = false;
                tabImage = null;
            }
        });
        checkPreference();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Are we dragging?
        if (dragging && currentMouseLocation != null && tabImage != null) {
            // Draw the dragged tab

            g.drawImage(tabImage, currentMouseLocation.x, currentMouseLocation.y, this);
        }
    }

    public void checkPreference() {

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
            showHideTabs();
            setSettingsIcon();
        } catch (Exception e) {
            System.out.println("MainFrame : checkPreference() : " + e);
        }
    }

    public void showHideTabs() {
        try {
            removeAll();
            Set<String> set = map.keySet();
            Iterator<String> itr = set.iterator();
            int counter = 0;
            while (itr.hasNext()) {
                String key = itr.next();
                JPanel jPanel = map.get(key);
                addTab(key + "    ", jPanel);
                setImageIcon(key, counter);
                counter++;
            }
        } catch (Exception e) {
            System.out.println("MainFrame : showHideTabs() : " + e);
        }
    }

    public void setSettingsIcon() {
        try {
            addTab("Settings", new TestSettingsPanel());
            System.out.println("1111111111");
            setTitleAt(getTabCount() - 1, "");
            System.out.println("2222222");
            ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Settings.png");
            System.out.println("33333333333");
            setIconAt(getTabCount() - 1, imageIcon);
            System.out.println("444444444444");
        } catch (Exception e) {
            System.out.println("MainFrame : setSettingsIcon() : " + e);
        }
    }

    public void setImageIcon(String key, int counter) {
        try {
            if (key.contains("OutsideCarriers")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\OutsideCarrier.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("BorderCrossing")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\BorderCrossing.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("PayrollSchedules")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\PayrollSchedules.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("Prospects")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Prospects.jpg");
                setIconAt(counter, imageIcon);
            } else if (key.contains("Company")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Company.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("Resources")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Resources.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("Role")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Roles.jpg");
                setIconAt(counter, imageIcon);
            } else if (key.contains("Customers")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Customers.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("SalesPerson")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\SalesPerson.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("Shippers")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Shippers.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("Jurisdiction")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Jurisdiction.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("StandardCharges")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\StandardCharges.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("List")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\List.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("MasterOrders")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\MasterOrders.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("MiscVendors")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\MiscVendors.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("Tracking")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Tracking.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("TravelTimes")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\TravelTimes.gif");
                setIconAt(counter, imageIcon);
            } else if (key.contains("CustomBrokers")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\CustomBrokers.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("Class")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Class.png");
                setIconAt(counter, imageIcon);
            } else if (key.contains("StandardTemplates")) {
                ImageIcon imageIcon = new ImageIcon("src\\dpu\\ui\\common\\StandardTemplates.png");
                setIconAt(counter, imageIcon);
            }
        } catch (Exception e) {
            System.out.println("MainTabbedPane : setImageIcon(): " + e);
        }
    }

    public static void main(String[] args) {
        JFrame test = new JFrame("Dispatch Processing Unit");
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        readTabFile();
        m1 = new MainTabbedPane();
        test.add(m1);
        test.setVisible(true);
    }

    private static void readTabFile() {
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
}
