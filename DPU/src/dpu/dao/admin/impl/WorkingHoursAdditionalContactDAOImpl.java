package dpu.dao.admin.impl;

import dpu.beans.admin.WorkingHoursAdditionalContactBean;
import dpu.dao.admin.WorkingHoursAdditionalContactDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gagandeep
 */
public class WorkingHoursAdditionalContactDAOImpl implements WorkingHoursAdditionalContactDAO {

    ConnectDB connectDB = ConnectDB.getInstance();

    @Override
    public String addWorkingHours(WorkingHoursAdditionalContactBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into working_hours_additionalcontact (working_day,open1,close1,open2,close2,is24Hr,additional_contact_id) values(?,?,?,?,?,?,?)");
            pstmt.setString(1, obj.getWorkingDay());
            pstmt.setString(2, obj.getOpen1());
            pstmt.setString(3, obj.getClose1());
            pstmt.setString(4, obj.getOpen2());
            pstmt.setString(5, obj.getClose2());
            pstmt.setInt(6, obj.getIs24Hrs());
            pstmt.setInt(7, obj.getAdditionalContactId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Working Hours Added";
            }
        } catch (Exception e) {
            System.out.println("WorkingHoursAdditionalContactDAOImpl : addWorkingHours : " + e);
        }
        return "Failed to Add Working Hours";
    }

    @Override
    public List<WorkingHoursAdditionalContactBean> getWorkingHoursByAdditionalContactId(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<WorkingHoursAdditionalContactBean> lstWorkingHours = new ArrayList<>();
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from working_hours_additionalcontact where additional_contact_id = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                WorkingHoursAdditionalContactBean work = new WorkingHoursAdditionalContactBean(rs.getInt("working_id"), rs.getString("working_day"), rs.getString("open1"), rs.getString("close1"), rs.getString("open2"), rs.getString("close2"), rs.getInt("is24Hr"), rs.getInt("additional_contact_id"));
                lstWorkingHours.add(work);
            }
        } catch (Exception e) {
            System.out.println("WorkingHoursAdditionalContactDAOImpl : getWorkingHoursByAdditionalContactId : " + e);
        }
        return lstWorkingHours;
    }
}
