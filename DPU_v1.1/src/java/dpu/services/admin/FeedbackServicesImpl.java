/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.FeedbackBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sikka
 */
public class FeedbackServicesImpl implements FeedbackServicesDAO {

    @Override
    public List<FeedbackBean> getAllFeedbacks(String startDate, String endDate) {
        List<FeedbackBean> lstFeedback = new ArrayList<>();
        StringBuilder query = new StringBuilder("select * from feedbackmaster fm, usermaster um where um.user_id=fm.user_id");
        if (!startDate.equals("")) {
            query.append(" and feedback_time >= '" + startDate + "'");
        }
        if (!endDate.equals("")) {
            query.append(" and feedback_time <= '" + endDate + "'");
        }
        try (Connection conn = ConnectDB.connect();
                PreparedStatement pstmt = conn.prepareStatement(query.toString());
                ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                FeedbackBean obj = new FeedbackBean();
                obj.setFeedbackId(rs.getInt("feedback_id"));
                obj.setFeedback(rs.getString("feedback"));
                obj.setPosted_by(rs.getString("username"));
                obj.setDt(rs.getString("feedback_time"));
                lstFeedback.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllFeedbacks(): " + e);
        }
        return lstFeedback;
    }
    @Override
    public String deleteFeedback(int feedbackId)
    {
        String result="Failed to delete Feedback";
        try(Connection conn=ConnectDB.connect();PreparedStatement pstmt=conn.prepareStatement("delete from feedbackmaster where feedback_id=?");)
        {
            pstmt.setInt(1, feedbackId);
           int i= pstmt.executeUpdate();
           if(i>0)
           {
               result="Feedback deleted successfully";
           }
        }
        catch(Exception e)
        {
            System.out.println("deleteFeedback() "+e);
        }
        return result;
    }
}
