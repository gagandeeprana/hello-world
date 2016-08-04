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
import properties.ReadFromPropertiesFile;

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
            chkArray = new JCheckBox[lstTabs.size()];
            JLabel lblSelectAll = new JLabel("Select All");
            lblSelectAll.setBounds(360, 10, 120, 40);
            add(lblSelectAll);
            headCheckBox = new JCheckBox();
            headCheckBox.setBounds(420, 10, 120, 40);
            add(headCheckBox);
            headCheckBox.addItemListener(this);
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
            btn = new JButton("Save");
            btn.setBounds(800, 360, 120, 40);
            add(btn);
            btn.addActionListener(this);
            setVisible(true);
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
            MainTabbedPane.lstPreferences = new ArrayList<>();
            MainTabbedPane.map = new TreeMap<>();
            LoginFrame.mainTabbedPane.checkPreference();
            LoginFrame.mainTabbedPane.showHideTabs();
            LoginFrame.mainTabbedPane.setSettingsIcon();
            setSettingsPanelBody();
        }
    }

    private void writeIntoTabFile(List<String> lstTabs) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(ReadFromPropertiesFile.filesPath + "preferencetabs.txt", false);
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
            String imageName = "";
            if (key.contains("OutsideCarriers")) {
                imageName = "OutsideCarrier.png";
            } else if (key.contains("BorderCrossing")) {
                imageName = "BorderCrossing.png";
            } else if (key.contains("PayrollSchedules")) {
                imageName = "PayrollSchedules.png";
            } else if (key.contains("Prospects")) {
                imageName = "Prospects.jpg";
            } else if (key.contains("Company")) {
                imageName = "Company.png";
            } else if (key.contains("Resources")) {
                imageName = "Resources.png";
            } else if (key.contains("Role")) {
                imageName = "Roles.jpg";
            } else if (key.contains("Customers")) {
                imageName = "Customers.png";
            } else if (key.contains("SalesPerson")) {
                imageName = "SalesPerson.png";
            } else if (key.contains("Shippers")) {
                imageName = "Shippers.png";
            } else if (key.contains("Jurisdiction")) {
                imageName = "Jurisdiction.png";
            } else if (key.contains("StandardCharges")) {
                imageName = "StandardCharges.png";
            } else if (key.contains("List")) {
                imageName = "List.png";
            } else if (key.contains("MasterOrders")) {
                imageName = "MasterOrders.png";
            } else if (key.contains("MiscVendors")) {
                imageName = "MiscVendors.png";
            } else if (key.contains("Tracking")) {
                imageName = "Tracking.png";
            } else if (key.contains("TravelTimes")) {
                imageName = "TravelTimes.gif";
            } else if (key.contains("CustomBrokers")) {
                imageName = "CustomBrokers.png";
            } else if (key.contains("Class")) {
                imageName = "Class.png";
            } else if (key.contains("StandardTemplates")) {
                imageName = "StandardTemplates.png";
            }
            imageIcon = new ImageIcon(ReadFromPropertiesFile.imagePath + imageName);
        } catch (Exception e) {
            System.out.println("TestSettingsPanel : setImageIcon(): " + e);
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
