/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common;

import static dpu.ui.common.MainTabbedPane.lstPreferences;
import static dpu.ui.common.MainTabbedPane.lstTabs;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author gagandeep.rana
 */
public class TestSettingsPanel extends javax.swing.JPanel implements ActionListener, ItemListener {

    /**
     * Creates new form TestSettingsPanel
     */
    JCheckBox[] chkArray = null;
    JCheckBox chk = null;
    JButton btn = null;
    JCheckBox headCheckBox = null;

    public TestSettingsPanel() {
        initComponents();
        setSettingsPanelBody();
    }

    private int columns() {
        int cols = 0;
        if (lstTabs.size() % 10 == 0) {
            cols = lstTabs.size() / 10;
        } else {
            cols = (lstTabs.size() / 10) + 1;
        }
        return cols;
    }

    private void setSettingsPanelBody() {
        try {

            int yForLabel = 0;
            int count = 0;
            int start = 0;
            int end = start + 10;
            if (end > lstTabs.size()) {
                end = lstTabs.size();
            }
            System.out.println("000000000000000000000000");
            chkArray = new JCheckBox[lstTabs.size()];
            JLabel lblSelectAll = new JLabel("Select All");
            lblSelectAll.setBounds(360, 10, 120, 40);
            add(lblSelectAll);
            headCheckBox = new JCheckBox();
            headCheckBox.setBounds(420, 10, 120, 40);
            add(headCheckBox);
            headCheckBox.addItemListener(this);
            System.out.println("0000000011111111111111111111111110000000000000000");
            while (count < columns()) {
                yForLabel = 0;
                for (int i = start; i < end; i++) {
                    yForLabel++;
                    JLabel lbl = new JLabel(lstTabs.get(i));
                    JLabel lblImage = new JLabel();
                    chk = new JCheckBox();
                    chk.setName("chk" + i);
                    lblImage.setIcon(setImageIcon(lstTabs.get(i), yForLabel));
                    lbl.setFont(new Font("Dialog", Font.BOLD, 12));
                    lblImage.setBounds(80 + (count * 300), ((yForLabel + 1) * 33) + 10, 16, 16);
                    lbl.setBounds(100 + (count * 300), ((yForLabel + 1) * 32) + 10, 120, 16);
                    chk.setBounds(260 + (count * 300), ((yForLabel + 1) * 32) + 10, 120, 16);
                    add(lbl);
                    add(lblImage);
                    add(chk);
                    chkArray[i] = chk;
                    for (String tab : lstPreferences) {
                        if (lbl.getText().equals(tab)) {
                            chk.setSelected(true);
                        }
                    }
                }
                count++;
                start = end;
                end = start + 10;
                if (end > lstTabs.size()) {
                    end = lstTabs.size();
                }
            }
            System.out.println("00000000222222222222222222220000000000000000");
            btn = new JButton("Save");
            btn.setBounds(800, 360, 120, 40);
            add(btn);
            System.out.println("00000000666666666666666666666660000000000000000");
            btn.addActionListener(this);
            System.out.println("00000000666666666666666666666660000000000000000");
            setVisible(true);
            System.out.println("00000000666666666666666666666660000000000000000");
        } catch (Exception e) {
            System.out.println("setSettingsPanelBody(): " + e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == btn) {
            List<String> lstTabsToBeWritten = new ArrayList<>();
            for (int i = 0; i < lstTabs.size(); i++) {
                if (chkArray[i].isSelected()) {
                    lstTabsToBeWritten.add(lstTabs.get(i));
                }
            }
            writeIntoTabFile(lstTabsToBeWritten);
            JOptionPane.showMessageDialog(null, "Changes Done");
//            mainTabbedPane.removeAll();
            MainTabbedPane.lstPreferences = new ArrayList<>();
            MainTabbedPane.map = new TreeMap<>();
            System.out.println("Map Size+++++++++++++++1: " + MainTabbedPane.map.size());
            MainTabbedPane.m1.checkPreference();
            MainTabbedPane.m1.showHideTabs();
            System.out.println("Map Size+++++++++++++++2: " + MainTabbedPane.map.size());
            MainTabbedPane.m1.setSettingsIcon();
            setSettingsPanelBody();
        }
    }

    private void writeIntoTabFile(List<String> lstTabs) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src\\dpu\\ui\\common\\preferencetabs.txt", false);
            for (int i = 0; i < lstTabs.size(); i++) {
                String tab = lstTabs.get(i);
                if (i != lstTabs.size() - 1) {
                    fileWriter.write(tab + "\r");
                } else {
                    fileWriter.write(tab);
                }
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("MainFrame : writeIntoTabFile() : " + e);
        }
    }

    public static ImageIcon setImageIcon(String key, int counter) {
        ImageIcon imageIcon = null;
        try {
            if (key.contains("OutsideCarriers")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\OutsideCarrier.png");
            } else if (key.contains("BorderCrossing")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\BorderCrossing.png");
            } else if (key.contains("PayrollSchedules")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\PayrollSchedules.png");
            } else if (key.contains("Prospects")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Prospects.jpg");
            } else if (key.contains("Company")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Company.png");
            } else if (key.contains("Resources")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Resources.png");
            } else if (key.contains("Role")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Roles.jpg");
            } else if (key.contains("Customers")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Customers.png");
            } else if (key.contains("SalesPerson")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\SalesPerson.png");
            } else if (key.contains("Shippers")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Shippers.png");
            } else if (key.contains("Jurisdiction")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Jurisdiction.png");
            } else if (key.contains("StandardCharges")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\StandardCharges.png");
            } else if (key.contains("List")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\List.png");
            } else if (key.contains("MasterOrders")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\MasterOrders.png");
            } else if (key.contains("MiscVendors")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\MiscVendors.png");
            } else if (key.contains("Tracking")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Tracking.png");
            } else if (key.contains("TravelTimes")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\TravelTimes.gif");
            } else if (key.contains("CustomBrokers")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\CustomBrokers.png");
            } else if (key.contains("Class")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\Class.png");
            } else if (key.contains("StandardTemplates")) {
                imageIcon = new ImageIcon("src\\dpu\\ui\\common\\StandardTemplates.png");
            }
        } catch (Exception e) {
            System.out.println("MainTabbedPane : setImageIcon(): " + e);
        }
        return imageIcon;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == 1) {
            for (int i = 0; i < chkArray.length; i++) {
                chkArray[i].setSelected(true);
            }
        } else {
            for (int i = 0; i < chkArray.length; i++) {
                chkArray[i].setSelected(false);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
