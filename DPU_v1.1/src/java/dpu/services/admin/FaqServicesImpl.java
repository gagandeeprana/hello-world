/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditFaqBean;
import dpu.beans.admin.FaqBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sikka
 */
public class FaqServicesImpl implements FaqServicesDAO {

    @Override
    public List<FaqBean> getAllFaq() {
        List<FaqBean> lstFaq = new ArrayList<>();
        try (Connection conn = ConnectDB.connect(); PreparedStatement pstmt = conn.prepareStatement("select * from faqmaster");
                ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                FaqBean obj = new FaqBean();
                obj.setFaqId(rs.getInt("faq_id"));
                obj.setQuestion(rs.getString("question"));
                obj.setAnswer(rs.getString("answer"));
                obj.setStatus(rs.getInt("status"));
                lstFaq.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllFaq(): " + e);
        }
        return lstFaq;
    }

    @Override
    public List<FaqBean> getAllFaqByStatus(String status) {
        List<FaqBean> lstFaq = new ArrayList<>();
        try (Connection conn = ConnectDB.connect();) {
            String query = "";
            if (!status.equalsIgnoreCase("2")) {
                query = " where status="+status;
            }
            PreparedStatement pstmt = conn.prepareStatement("select * from faqmaster"+query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                FaqBean obj = new FaqBean();
                obj.setFaqId(rs.getInt("faq_id"));
                obj.setQuestion(rs.getString("question"));
                obj.setAnswer(rs.getString("answer"));
                obj.setStatus(rs.getInt("status"));
                lstFaq.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllFaq(): " + e);
        }
        return lstFaq;
    }

    @Override
    public String addFaq(AddEditFaqBean obj) {
        String res = "Failed to Add FAQ";
        try (Connection conn = ConnectDB.connect(); PreparedStatement pstmt = conn.prepareStatement("insert into faqmaster (question,answer) values (?,?)");) {

            pstmt.setString(1, obj.getTxtFAQ());
            pstmt.setString(2, obj.getTxtAnswer());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                res = "FAQ Added Successfully";
            }

        } catch (Exception e) {
            System.out.println("addFaq(): " + e);
        }
        return res;
    }

    @Override
    public String updateFaq(AddEditFaqBean obj) {
        String result = "Failed to update FAQ";
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("update  faqmaster set question=?,answer=? where faq_id=?");
            pstmt.setString(1, obj.getTaFAQ());
            pstmt.setString(2, obj.getTaAnswer());
            pstmt.setInt(3, obj.getFaqId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "FAQ Updated Successfully";
            }
        } catch (Exception e) {
            System.out.println("updateFaq(): " + e);
        }
        return result;
    }

    @Override
    public String changeStatus(int status, int faqId) {
        String result = "Failed To Update Status";
        if (status == 1) {
            status = 0;
        } else {
            status = 1;
        }
        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("update faqmaster set status=? where faq_id=?");
            pstmt.setInt(1, status);
            pstmt.setInt(2, faqId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "Status changed successfully";
            }
        } catch (Exception e) {
            System.out.println("changeStatus(): " + e);
        }
        return result;
    }

    @Override
    public FaqBean getFAQInfo(int id) {
        PreparedStatement ps = null;
        Connection conn = null;
        FaqBean obj = null;
        ResultSet rs = null;
        try {
            conn = ConnectDB.connect();
            ps = conn.prepareStatement("select * from faqmaster where faq_id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new FaqBean();
                obj.setFaqId(rs.getInt("faq_id"));
                obj.setQuestion(rs.getString("question"));
                obj.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            System.out.println("getFAQInfo():" + e);
        }
        return obj;
    }
}
