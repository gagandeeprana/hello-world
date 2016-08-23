package dpu.dao.admin.impl;

import dpu.beans.admin.WorkingHoursAdditionalContactBean;
import dpu.dao.admin.WorkingHoursAdditionalContactDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
