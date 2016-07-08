/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditSQBean;
import dpu.beans.admin.QuestionsBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sikka
 */
public class SecurityQuestionServicesImpl implements SecurityQuestionServicesDAO {

    @Override
    public List<QuestionsBean> getAllQuestions(int status) {
        StringBuilder query = new StringBuilder("select * from securitymaster");
        if (status != 2) {
            query.append(" where status = " + status);
        }
        List<QuestionsBean> lstQuestions = new ArrayList<>();
        try (Connection conn = ConnectDB.connect(); PreparedStatement pstmt = conn.prepareStatement(query.toString());
                ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                QuestionsBean obj = new QuestionsBean();
                obj.setqId(rs.getInt("security_question_id"));
                obj.setQuestion(rs.getString("question"));
                obj.setStatus(rs.getInt("status"));
                lstQuestions.add(obj);
            }
        } catch (Exception e) {
            System.out.println("getAllQuestions(): " + e);
        }
        return lstQuestions;
    }

    @Override
    public QuestionsBean getSQInfoById(int id) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        QuestionsBean obj = null;
        ResultSet rs = null;
        try {
            conn = ConnectDB.connect();
            pstmt = conn.prepareStatement("select * from securitymaster where security_question_id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = new QuestionsBean();
                obj.setqId(rs.getInt("security_question_id"));
                obj.setTaQuestion(rs.getString("question"));
                obj.setStatus(rs.getInt("status"));
            }
        } catch (Exception e) {
            System.out.println("getPCInfoById(): " + e);
        }
        return obj;
    }

    @Override
    public String addSQ(AddEditSQBean obj) {
        String res = "Failed to Add Security Question";
        try (Connection conn = ConnectDB.connect(); PreparedStatement pstmt = conn.prepareStatement("insert into securitymaster (question,status) values (?,?)");) {

            pstmt.setString(1, obj.getTaQuestion());
            pstmt.setInt(2, obj.getRbStatus());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                res = "Security Question Added Successfully";
            }

        } catch (Exception e) {
            System.out.println("addSQ(): " + e);
        }
        return res;
    }

    @Override
    public String updateSQ(AddEditSQBean obj) {
        String res = "Failed to Update Security Question";
        try (Connection conn = ConnectDB.connect(); PreparedStatement pstmt = conn.prepareStatement("update securitymaster set question=?,status=? where security_question_id=?");) {

            pstmt.setString(1, obj.getTaQuestion());
            pstmt.setInt(2, obj.getRbStatus());
            pstmt.setInt(3, obj.getTxtSecurityId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                res = "Security Question Updated Successfully";
            }

        } catch (Exception e) {
            System.out.println("updateSQ(): " + e);
        }
        return res;
    }

    @Override
    public String changeStatus(int status, int qId) {
        String result = "Failed To Update Status";
        if (status == 1) {
            status = 0;
        } else {
            status = 1;
        }
        try (Connection conn = ConnectDB.connect();) {
            PreparedStatement pstmt = conn.prepareStatement("update securitymaster set status=? where security_question_id=?");
            pstmt.setInt(1, status);
            pstmt.setInt(2, qId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "Status changed successfully";
            }
        } catch (Exception e) {
            System.out.println("changeStatus(): " + e);
        }
        return result;
    }
}
