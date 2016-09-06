package dpu.ui.common.helper;

import dpu.beans.admin.CompanyBean;
import dpu.dao.admin.CompanyDAO;
import dpu.ui.common.TestCompanyPanel;
import org.springframework.beans.factory.annotation.Autowired;

public class CompanyUIHelper {

    @Autowired
    CompanyDAO companyDAO;
//    CompanyDAO companyDAO = new CompanyDAOImpl();

    @Autowired
    CompanyBean companyBean;

//    static public String addUpdateFlag = "";
//    public static int companyId = 0;
//    public static List<CompanyBean> lstCompanies = null;
//    public String addUpdateFlag = "";
//    public int companyId = 0;
//    public List<CompanyBean> lstCompanies = null;
//    int companyIdToBeDeleted = 0;
//    String msg = "";
//    static Logger logger = Logger.getLogger(CompanyUIHelper.class);
    public void clear() {
        TestCompanyPanel.txtCompanySearch.setText("");
    }

    public void disable(boolean var) {
    }

    public void generateTable() {
        Object[] cols = {"Company Id", "Company Name", "Address", "Unit No", "City", "Province/State", "Zip", "Email", "Website", "Contact", "Position", "Phone", "Ext", "Fax", "Pager"};
        companyDAO.getAllCompanies(TestCompanyPanel.txtCompanySearch.getText());
//        System.out.println("size: " + lstCompanies.size());
//        DefaultTableModel defaultTableModel = new DefaultTableModel();
//        TestCompanyPanel.tblCompany.setModel(defaultTableModel);
//        TestCompanyPanel.tblCompany.setAutoCreateRowSorter(true);
//        TestCompanyPanel.tblCompany.setDefaultRenderer(Object.class, new CompanyUIHelper.CompanyTable());
//        if (lstCompanies.size() > 0) {
//            Object[][] data = new Object[lstCompanies.size()][15];
//            for (int i = 0; i < lstCompanies.size(); i++) {
//                CompanyBean obj = lstCompanies.get(i);
//                data[i][0] = obj.getCompanyId();
//                data[i][1] = obj.getCompanyName();
//                data[i][2] = obj.getAddress();
//                data[i][3] = obj.getUnitNo();
//                data[i][4] = obj.getCity();
//                data[i][5] = obj.getProvinceState();
//                data[i][6] = obj.getZip();
//                data[i][7] = obj.getEmail();
//                data[i][8] = obj.getWebsite();
//                data[i][9] = obj.getContact();
//                data[i][10] = obj.getPosition();
//                data[i][11] = obj.getPhone();
//                data[i][12] = obj.getExt();
//                data[i][13] = obj.getFax();
//                data[i][14] = obj.getPager();
//                TestCompanyPanel.tblCompany.setRowHeight(30);
//            }
//            TestCompanyPanel.tblCompany.setColumnSelectionAllowed(false);
//            defaultTableModel.setDataVector(data, cols);
//            TestCompanyPanel.tblCompany.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
//            TestCompanyPanel.tblCompany.getTableHeader().setForeground(Color.DARK_GRAY);
//            TestCompanyPanel.tblCompany.setIntercellSpacing(new Dimension(0, 0));
//            TestCompanyPanel.tblCompany.setShowGrid(false);
//            TestCompanyPanel.jScrollPane4.setViewportView(TestCompanyPanel.tblCompany);
//        } else {
//            generateEmptyTable();
//        }
    }
//
//    private void generateEmptyTable() {
//        Object[] cols = {"Company Id", "Company Name", "Address", "Unit No", "City", "Province/State", "Zip", "Email", "Website", "Contact", "Position", "Phone", "Ext", "Fax", "Pager"};
//        DefaultTableModel defaultTableModel = new DefaultTableModel();
//        TestCompanyPanel.tblCompany.setModel(defaultTableModel);
//        TestCompanyPanel.tblCompany.setDefaultRenderer(Object.class, new CompanyUIHelper.CompanyTable());
//        Object[][] data = new Object[7][17];
//        for (int i = 0; i < 7; i++) {
//            data[i][0] = "";
//            data[i][1] = "";
//            data[i][2] = "";
//            data[i][3] = "";
//            data[i][4] = "";
//            data[i][5] = "";
//            data[i][6] = "";
//            data[i][7] = "";
//            data[i][8] = "";
//            data[i][9] = "";
//            data[i][10] = "";
//            data[i][11] = "";
//            data[i][12] = "";
//            data[i][13] = "";
//            data[i][14] = "";
//            data[i][15] = "";
//            data[i][16] = "";
//            TestCompanyPanel.tblCompany.setRowHeight(30);
//        }
//        TestCompanyPanel.tblCompany.setColumnSelectionAllowed(false);
//
//        defaultTableModel.setDataVector(data, cols);
//
//        TestCompanyPanel.tblCompany.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
//        TestCompanyPanel.tblCompany.getTableHeader().setForeground(Color.DARK_GRAY);
//        TestCompanyPanel.tblCompany.setIntercellSpacing(new Dimension(0, 0));
//        TestCompanyPanel.tblCompany.setShowGrid(false);
//        TestCompanyPanel.jScrollPane4.setViewportView(TestCompanyPanel.tblCompany);
//    }
////
////    
////
//    public String delete(int companyIdToBeDeleted) {
//        CompanyDAO companyDAO = new CompanyDAOImpl();
//        String msg = companyDAO.deleteCompany(companyIdToBeDeleted);
//        generateTable();
//        return msg;
//    }
////
////    public String update(CompanyBean companyBean) {
////        CompanyDAO companyDAO = new CompanyDAOImpl();
////        String msg = companyDAO.updateCompany(companyBean);
////        disable(true);
////        generateTable();
////        return msg;
////    }
////
//    class CompanyTable extends DefaultTableCellRenderer {
//
//        @Override
//        public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            JTextField editor = new JTextField();
//            editor.setFont(new Font(Font.SANS_SERIF, 0, 15));
//            editor.setEditable(false);
//            editor.setBorder(null);
//            if (value != null) {
//                editor.setText("   " + value.toString());
//            }
//            if (row % 2 == 0) {
//                Border border = BorderFactory.createLineBorder(Color.WHITE, 4);
//                editor.setBorder(border);
//
//            } else {
//                Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4);
//                editor.setBorder(border);
//            }
//            editor.setBackground((row % 2 == 0) ? Color.white : Color.LIGHT_GRAY);
//            if (isSelected) {
//                Border border = BorderFactory.createLineBorder(Color.CYAN, 4);
//                editor.setBorder(border);
//                editor.setBackground(Color.CYAN);
//            }
//            return editor;
//        }
//    }
}
