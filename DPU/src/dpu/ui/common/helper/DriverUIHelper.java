package dpu.ui.common.helper;

import dpu.beans.admin.DriverBean;
import dpu.beans.admin.TerminalBean;
import dpu.dao.admin.DriverDAO;
import dpu.dao.admin.impl.CategoryDAOImpl;
import dpu.dao.admin.impl.ClasssDAOImpl;
import dpu.dao.admin.impl.DriverDAOImpl;
import dpu.dao.admin.impl.RoleDAOImpl;
import dpu.dao.admin.impl.StatusDAOImpl;
import dpu.dao.admin.impl.TerminalDAOImpl;
import dpu.entity.admin.Category;
import dpu.entity.admin.Classs;
import dpu.entity.admin.Driver;
import dpu.entity.admin.Role;
import dpu.entity.admin.Status;
import dpu.ui.common.AddDriverFrame;
import static dpu.ui.common.AddDriverFrame.ddlCategory;
import static dpu.ui.common.AddDriverFrame.ddlClassId;
import static dpu.ui.common.AddDriverFrame.ddlRole;
import static dpu.ui.common.AddDriverFrame.ddlStatus;
import static dpu.ui.common.AddDriverFrame.ddlTerminal;
import dpu.ui.common.DriverPanel;
import static dpu.ui.common.DriverPanel.driverTable;
//import dpu.ui.common.AddDriverFrame;
import dpu.ui.common.TestDriverPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class DriverUIHelper extends DefaultTableCellRenderer {
    
    Driver driver = new Driver();
    public DriverUIHelper(){
        
    }

    public  static String addUpdateFlag = "";
    public static String driverId = "";
    String driverName;
    DriverDAO driverDAO = new DriverDAOImpl();
    public static List<Driver> lstDrivers = null;
    String driverIdToBeDeleted = "";
    String msg = "";

    public void clear() {
        TestDriverPanel.txtSearchManageDriver.setText("");
    }

    public void disable(boolean var) {
 
    }

    public class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setIcon(new ImageIcon("src\\dpu\\ui\\common\\Delete.png"));
                setForeground(table.getSelectionForeground());
//                setBackground(table.getSelectionBackground());
                setBackground(Color.WHITE);
                setContentAreaFilled(false);
            } else {
                setForeground(table.getForeground());
                setIcon(new ImageIcon("src\\dpu\\ui\\common\\Delete.png"));
//                setBackground(UIManager.getColor("Button.background"));
                setContentAreaFilled(false);
            }
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    public class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
                button.setIcon(new ImageIcon("src\\dpu\\ui\\common\\Delete.png"));
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
                button.setIcon(new ImageIcon("src\\dpu\\ui\\common\\Delete.png"));

            }
            driverIdToBeDeleted = lstDrivers.get(row).getDriverCode();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

       // public Object getCellEditorValue() {
         //   if (isPushed) {
           //     msg = delete();
             //   JOptionPane.showMessageDialog(null, msg);
            //}
            //isPushed = false;
            //return new String(label);
        //}

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    public class ButtonRendererUpdate extends JButton implements TableCellRenderer {

        public ButtonRendererUpdate() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setIcon(new ImageIcon("src\\dpu\\ui\\common\\Update.png"));
                setForeground(table.getSelectionForeground());
                setBackground(Color.WHITE);
                setContentAreaFilled(false);
            } else {
                setForeground(table.getForeground());
                setIcon(new ImageIcon("src\\dpu\\ui\\common\\Update.png"));
//                setBackground(UIManager.getColor("Button.background"));
                setBackground(Color.WHITE);
                setContentAreaFilled(false);
            }
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    public class ButtonEditorUpdate extends DefaultCellEditor {

        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditorUpdate(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
                button.setIcon(new ImageIcon("src\\dpu\\ui\\common\\Update.png"));
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
                button.setIcon(new ImageIcon("src\\dpu\\ui\\common\\Update.png"));
            }
            driverIdToBeDeleted = lstDrivers.get(row).getDriverCode();
            driverId = lstDrivers.get(row).getDriverCode();
            driverName = lstDrivers.get(row).getFirstName();
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                Driver driver = new Driver();
                driver.setDriverCode(driverId);
//                driverBean.setName(driverName);
//                AddDriverFrame addDriverFrame = new AddDriverFrame(driverBean);
//                addDriverFrame.setVisible(true);
            }
            isPushed = false;
            return new String(label);
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    public void generateTable() {
        lstDrivers = driverDAO.getAllDrivers(TestDriverPanel.txtSearchManageDriver.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TestDriverPanel.tblDriver = new JTable(defaultTableModel);
        TestDriverPanel.tblDriver.setDefaultRenderer(Object.class, new DriverTable());
        Object[][] data = new Object[lstDrivers.size()][24];
        for (int i = 0; i < lstDrivers.size(); i++) {
            Driver obj = lstDrivers.get(i);
            data[i][0] = obj.getDriverId();
            data[i][1] = obj.getFirstName();
            data[i][2] = obj.getLastName();
            //data[i][3] = obj.getDefTruck();
            //data[i][4] = obj.getAddress();
            //data[i][5] = obj.getHomePhone();
            //data[i][6] = obj.getCellular();
            //data[i][7] = obj.getPager();
            //data[i][8] = obj.getStatus();
            //data[i][9] = obj.getLastTrip();
            //data[i][10] = obj.getLastETA();
            //data[i][11] = obj.getLastEvent();
            //data[i][12] = obj.getLastLocation();
            //data[i][13] = obj.getLastCity();
            //data[i][14] = obj.getLastState();
            //data[i][15] = obj.getFaxNo();
            //data[i][16] = obj.getDivisionId();
            //data[i][17] = obj.getTerminalId();
            //data[i][18] = obj.getCategoryId();
            //data[i][19] = obj.getClassId();
            //data[i][20] = obj.getZip();
            data[i][21] = obj.getRoleId();
            data[i][22] = "";
            data[i][23] = "";
            TestDriverPanel.tblDriver.setRowHeight(30);
        }
        Object[] cols = {"Driver Id", "First Name","Last Name","Def Truck","Address","Home Phone","Cellular","Pager","Status","Last Trip","Last ETA","Last Event","Last Location","Last City","Last State","Fax","Division","Terminal","Category","Class","Zip","Role", " ", "  "};
        defaultTableModel.setDataVector(data, cols);
        TestDriverPanel.tblDriver.getColumn(" ").setCellRenderer(new ButtonRenderer());
        TestDriverPanel.tblDriver.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        TestDriverPanel.tblDriver.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        TestDriverPanel.tblDriver.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        TestDriverPanel.tblDriver.getColumn(" ").setMaxWidth(25);
        TestDriverPanel.tblDriver.getColumn("  ").setMaxWidth(25);
        TestDriverPanel.tblDriver.setIntercellSpacing(new Dimension(0, 0));
        TestDriverPanel.tblDriver.setShowGrid(false);
        TestDriverPanel.jScrollPane9.setViewportView(TestDriverPanel.tblDriver);
    }

    public String save() {
        Driver driver = new Driver();
         
        String driverCode = AddDriverFrame.txtDriverCode.getText();
        String firstName = AddDriverFrame.txtFirstName.getText();
        String lastName = AddDriverFrame.txtLastName.getText();
        String address = AddDriverFrame.txtAddress.getText();
        String unit = AddDriverFrame.txtUnit.getText();
        String city = AddDriverFrame.txtCity.getText();
        String pvs = AddDriverFrame.txtPvs.getText();
        String postal = AddDriverFrame.txtPostal.getText();
        String email = AddDriverFrame.txtEmail.getText();
        String home = AddDriverFrame.jFormattedHome.getText();
        String faxNo = AddDriverFrame.jFormattedFaxNo.getText();
        String cellular = AddDriverFrame.jFormattedCellular.getText();
        String pager = AddDriverFrame.jFormattedPager.getText();
        String division = AddDriverFrame.txtDivision.getText();
        String terminal = AddDriverFrame.ddlTerminal.getSelectedItem().toString();
        String category = AddDriverFrame.ddlCategory.getSelectedItem().toString();
        String role = AddDriverFrame.ddlRole.getSelectedItem().toString();
        String status = AddDriverFrame.ddlStatus.getSelectedItem().toString();
        String classId = AddDriverFrame.ddlClassId.getSelectedItem().toString();
        System.out.println("=-=-=-=-=classs :"+classId);
        driver.setDriverCode(driverCode);
        driver.setFirstName(firstName);
        driver.setLastName(lastName);
        driver.setAddress(address);
        driver.setUnit(unit);
        driver.setCity(city);
        driver.setPvs(pvs);
        driver.setPostalCode(postal);
        driver.setEmail(email);
         
        driver.setHome(home.replaceAll("[^A-Za-z0-9]",""));
        driver.setFaxNo(faxNo.replaceAll("[^A-Za-z0-9]",""));
        driver.setCellular(cellular.replaceAll("[^A-Za-z0-9]",""));
        driver.setPager(pager.replaceAll("[^A-Za-z0-9]",""));
        driver.setDivision(division);
        driver.setTerminalId( terminal);
        driver.setCatogoryId( category);
        driver.setRoleId( role);
        driver.setStatusId( status);
        driver.setClassId( classId);
         
//        obj.setDriverId(Integer.parseInt(AddDriverFrame.txtDriverIdAddDriver.getText()));
//        obj.setName(AddDriverFrame.txtDriverNameAddDriver.getText());
        DriverDAO driverDAO = new DriverDAOImpl();
        String msg = driverDAO.addDriver(driver);
        //disable(true);
        //generateTable();
//        TestDriverPanel.mainTabbedPane.setEnabled(true);
//        TestDriverPanel.driverPanel.setEnabled(true);
        return msg;
    }

    public void showAll(){
        DriverDAO driverDAO = new DriverDAOImpl();
        List<Driver> listOfDrivers = driverDAO.showAll();
       // lstDrivers = driverDAO.getAllDrivers(TestDriverPanel.txtSearchManageDriver.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        DriverPanel.driverTable = new JTable(defaultTableModel);
        DriverPanel.driverTable.setDefaultRenderer(Object.class, new DriverTable());
        Object[][] data = new Object[listOfDrivers.size()][24];
        for (int i = 0; i < listOfDrivers.size(); i++) {
            Driver obj = listOfDrivers.get(i);
            data[i][0] = obj.getDriverCode();
            data[i][1] = obj.getFirstName();
            data[i][2] = obj.getLastName();
            data[i][3] = obj.getAddress();
            data[i][4] = obj.getUnit();
            data[i][5] = obj.getCity();
            data[i][6] = obj.getPvs();
            data[i][7] = obj.getPostalCode();
            data[i][8] = obj.getEmail();
            data[i][9] = obj.getHome();
            data[i][10] = obj.getFaxNo();
            data[i][11] = obj.getCellular();
            data[i][12] = obj.getPager();
            data[i][13] = obj.getDivision();
            data[i][14] = obj.getTerminalId();
            data[i][15] = obj.getCatogoryId();
            data[i][16] = obj.getRoleId();
            data[i][17] = obj.getStatusId();
            data[i][18] = obj.getClassId();
            
            DriverPanel.driverTable.setRowHeight(30);
        }
        Object[] cols = {"Driver Code", "First Name", "Last Name", "Address", "Unit#", "City", "PVS", "Postal Zip", "E-Mail", "Home", "Fax No.", "Cellullar", "Pager", "Division", "Terminal", "Category", "Role", "Status", "ClassId"};
        defaultTableModel.setDataVector(data, cols);
         
        DriverPanel.driverTable.setIntercellSpacing(new Dimension(0, 0));
        DriverPanel.driverTable.setShowGrid(false);
        DriverPanel.jScrollPane1.setViewportView(DriverPanel.driverTable);
        
         
         
        
    }
    public void  showAllDrivers() {
        DriverDAO driverDAO = new DriverDAOImpl();
        List<Driver> listOfDrivers = driverDAO.showAllDrivers();
       // lstDrivers = driverDAO.getAllDrivers(TestDriverPanel.txtSearchManageDriver.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        DriverPanel.driverTable = new JTable(defaultTableModel);
        DriverPanel.driverTable.setDefaultRenderer(Object.class, new DriverTable());
        Object[][] data = new Object[listOfDrivers.size()][24];
        for (int i = 0; i < listOfDrivers.size(); i++) {
            Driver obj = listOfDrivers.get(i);
            data[i][0] = obj.getDriverCode();
            data[i][1] = obj.getFirstName();
            data[i][2] = obj.getLastName();
            data[i][3] = obj.getAddress();
            data[i][4] = obj.getUnit();
            data[i][5] = obj.getCity();
            data[i][6] = obj.getPvs();
            data[i][7] = obj.getPostalCode();
            data[i][8] = obj.getEmail();
            data[i][9] = obj.getHome();
            data[i][10] = obj.getFaxNo();
            data[i][11] = obj.getCellular();
            data[i][12] = obj.getPager();
            data[i][13] = obj.getDivision();
            data[i][14] = obj.getTerminalId();
            data[i][15] = obj.getCatogoryId();
            data[i][16] = obj.getRoleId();
            data[i][17] = obj.getStatusId();
            data[i][18] = obj.getClassId();
            
            DriverPanel.driverTable.setRowHeight(30);
        }
        Object[] cols = {"Driver Code", "First Name", "Last Name", "Address", "Unit#", "City", "PVS", "Postal Zip", "E-Mail", "Home", "Fax No.", "Cellullar", "Pager", "Division", "Terminal", "Category", "Role", "Status", "ClassId"};
        defaultTableModel.setDataVector(data, cols);
        //DriverPanel.driverTable.getColumn(" ").setCellRenderer(new ButtonRenderer());
        //DriverPanel.driverTable.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        //DriverPanel.driverTable.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        //DriverPanel.driverTable.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        //DriverPanel.driverTable.getColumn(" ").setMaxWidth(25);
        // DriverPanel.driverTable.getColumn("  ").setMaxWidth(25);
        DriverPanel.driverTable.setIntercellSpacing(new Dimension(0, 0));
        DriverPanel.driverTable.setShowGrid(false);
        DriverPanel.jScrollPane1.setViewportView(DriverPanel.driverTable);
        
         
         
    }
    
    public void QuickFilterDrivers() {
        DriverDAO driverDAO = new DriverDAOImpl();
        List<Driver> listOfDrivers = driverDAO.QuickFilterDrivers();
       // lstDrivers = driverDAO.getAllDrivers(TestDriverPanel.txtSearchManageDriver.getText());
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        DriverPanel.driverTable = new JTable(defaultTableModel);
        DriverPanel.driverTable.setDefaultRenderer(Object.class, new DriverTable());
        Object[][] data = new Object[listOfDrivers.size()][24];
        for (int i = 0; i < listOfDrivers.size(); i++) {
            Driver obj = listOfDrivers.get(i);
            data[i][0] = obj.getDriverCode();
            data[i][1] = obj.getFirstName();
            data[i][2] = obj.getLastName();
            data[i][3] = obj.getAddress();
            data[i][4] = obj.getUnit();
            data[i][5] = obj.getCity();
            data[i][6] = obj.getPvs();
            data[i][7] = obj.getPostalCode();
            data[i][8] = obj.getEmail();
            data[i][9] = obj.getHome();
            data[i][10] = obj.getFaxNo();
            data[i][11] = obj.getCellular();
            data[i][12] = obj.getPager();
            data[i][13] = obj.getDivision();
            data[i][14] = obj.getTerminalId();
            data[i][15] = obj.getCatogoryId();
            data[i][16] = obj.getRoleId();
            data[i][17] = obj.getStatusId();
            data[i][18] = obj.getClassId();
             
            DriverPanel.driverTable.setRowHeight(30);
        }
        Object[] cols = {"Driver Code", "First Name", "Last Name", "Address", "Unit#", "City", "PVS", "Postal Zip", "E-Mail", "Home", "Fax No.", "Cellullar", "Pager", "Division", "Terminal", "Category", "Role", "Status", "ClassId"};
        defaultTableModel.setDataVector(data, cols);
        //DriverPanel.driverTable.getColumn(" ").setCellRenderer(new ButtonRenderer());
        //DriverPanel.driverTable.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
        //DriverPanel.driverTable.getColumn("  ").setCellRenderer(new ButtonRendererUpdate());
        //DriverPanel.driverTable.getColumn("  ").setCellEditor(new ButtonEditorUpdate(new JCheckBox()));
        //DriverPanel.driverTable.getColumn(" ").setMaxWidth(25);
        // DriverPanel.driverTable.getColumn("  ").setMaxWidth(25);
        DriverPanel.driverTable.setIntercellSpacing(new Dimension(0, 0));
        DriverPanel.driverTable.setShowGrid(false);
        DriverPanel.jScrollPane1.setViewportView(DriverPanel.driverTable);
        
         
         
    }
    
    
    public String deleteDriver(String driverCode){
        DriverDAO driverDAO = new DriverDAOImpl();
        String msg = driverDAO.deleteDriver(driverCode);
        disable(true);
        generateTable();
//        TestDriverPanel.mainTabbedPane.setEnabled(true);
//        TestDriverPanel.driverPanel.setEnabled(true);
        return msg;
    }

      
      private void fillTerminalDropDown() {
        List<TerminalBean> lst = new TerminalDAOImpl().getAllTerminals("");
        for(TerminalBean terminalBean : lst) {
            ddlTerminal.addItem(terminalBean.getTerminalName());
        } 
    }
    
       private void fillCtegoryDropDown() {
        List<Category> lst = new CategoryDAOImpl().getAllCategory();
        for(Category category : lst) {
            ddlCategory.addItem(category.getCatgoryValue());
        } 
    }
    
    private void fillRoleDropDown() {
        List<Role> lst = new RoleDAOImpl().getAllRole();
        for(Role role : lst) {
            ddlRole.addItem(role.getRoleName());
        } 
    }
    
    private void fillStatusDropDown() {
        List<Status> lst = new StatusDAOImpl().getAllStatus();
        for(Status status : lst) {
            ddlStatus.addItem(status.getStatusValue());
        } 
    }
    
    private void fillClasssDropDown() {
        List<Classs> lst = new ClasssDAOImpl().getAllClass();
        for(Classs classs : lst) {
            ddlClassId.addItem(classs.getClassValue());
        } 
    }
    
    public Driver update() {
        fillTerminalDropDown();
        fillCtegoryDropDown();
        fillRoleDropDown();
        fillStatusDropDown();
        fillClasssDropDown();
        
        DefaultTableModel model = (DefaultTableModel)driverTable.getModel();
        // get Selected Row Index
        
            int selectedRowIndex = driverTable.getSelectedRow();
            String driverCode = model.getValueAt(selectedRowIndex, 0).toString();
            System.out.println("------------------Driver Code : "+driverCode);
            Driver driver = new Driver();
            DriverDAO driverDAO = new DriverDAOImpl();
            
            List<Driver> drivers = driverDAO.updateDriver(driverCode);
            Driver driverOb = drivers.get(0);
             
            AddDriverFrame.updateDriverId = driverOb.getDriverId();;
            //Long classId = Long.parseLong(model.getValueAt(selectedRowIndex, 18).toString());
            
             
            if(!drivers.isEmpty())
            {
                for(Driver driverObj : drivers) {
                    AddDriverFrame.txtDriverCode.setText(driverCode);
                    AddDriverFrame.txtFirstName.setText(driverObj.getFirstName());
                    AddDriverFrame.txtLastName.setText(driverObj.getLastName());
                    AddDriverFrame.txtAddress.setText(driverObj.getAddress());
                    AddDriverFrame.txtUnit.setText(driverObj.getUnit());
                    AddDriverFrame.txtCity.setText(driverObj.getCity());
                    AddDriverFrame.txtPvs.setText(driverObj.getPvs());
                    AddDriverFrame.txtPostal.setText(driverObj.getPostalCode());
                    AddDriverFrame.txtEmail.setText(driverObj.getEmail());
                    AddDriverFrame.jFormattedHome.setText(driverObj.getHome());
                    AddDriverFrame.jFormattedFaxNo.setText(driverObj.getFaxNo());
                    AddDriverFrame.jFormattedCellular.setText(driverObj.getCellular());
                    AddDriverFrame.jFormattedPager.setText(driverObj.getPager());
                    AddDriverFrame.txtDivision.setText(driverObj.getDivision());
                    
                    
                    //AddDriverFrame.ddlTerminal.setSelectedItem(driverObj.getTerminalId());
                    //AddDriverFrame.ddlCategory.setSelectedItem(1);
                    //AddDriverFrame.ddlRole.setSelectedItem(1);
                    //AddDriverFrame.ddlStatus.setSelectedItem(1);
                }
            }
                   
     
                      
        
         //driverDAO.updateDriver(driver);
        disable(true);
        //generateTable();
//        TestDriverPanel.mainTabbedPane.setEnabled(true);
//        TestDriverPanel.driverPanel.setEnabled(true);
        return driver;
    }
    
    
   
    class DriverTable implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JTextField editor = new JTextField();
            editor.setBorder(null);
            if (value != null) {
                //here space is given to provide some left margin while showing data on textfield..
                editor.setText("   " + value.toString());
            }
            if (row % 2 == 0) {
                Border border = BorderFactory.createLineBorder(Color.WHITE, 4);
                editor.setBorder(border);

            } else {
                Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4);
                editor.setBorder(border);

            }
            editor.setBackground((row % 2 == 0) ? Color.white : Color.LIGHT_GRAY);
            if (isSelected) {
                Border border = BorderFactory.createLineBorder(Color.decode("#DCDCDC"), 1);
                editor.setBorder(border);
                editor.setBackground(Color.decode("#DCDCDC"));
            }
            return editor;
        }

    }
}
