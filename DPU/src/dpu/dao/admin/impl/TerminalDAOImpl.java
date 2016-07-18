/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin.impl;

import dpu.beans.admin.TerminalBean;
import dpu.dao.admin.TerminalDAO;
import dpu.dao.common.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class TerminalDAOImpl implements TerminalDAO {

    ConnectDB connectDB = ConnectDB.getInstance();
    Logger logger = Logger.getLogger(TerminalDAOImpl.class);

    @Override
    public List<TerminalBean> getAllTerminals(String name) {
        List<TerminalBean> lstTerminals = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("select * from terminalmaster where name like ? order by name");
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                TerminalBean obj = new TerminalBean();
                obj.setTerminalId(rs.getInt("terminal_id"));
                obj.setTerminalName(rs.getString("name"));
                lstTerminals.add(obj);
            }
        } catch (Exception e) {
            logger.error("TerminalDAOImpl : getAllTerminals : " + e);
        }
        return lstTerminals;
    }

    @Override
    public String addTerminal(TerminalBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("insert into terminalmaster values(?,?)");
            pstmt.setInt(1, obj.getTerminalId());
            pstmt.setString(2, obj.getTerminalName());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Terminal Added";
            }
        } catch (Exception e) {
            logger.error("TerminalDAOImpl : addTerminal : " + e);
        }
        return "Failed to Add Terminal";
    }

    @Override
    public String updateTerminal(TerminalBean obj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("update terminalmaster set name = ? where terminal_id = ?");
            pstmt.setString(1, obj.getTerminalName());
            pstmt.setInt(2, obj.getTerminalId());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Terminal Updated";
            }
        } catch (Exception e) {
            logger.error("TerminalDAOImpl : updateTerminal : " + e);
        }
        return "Failed to Update Terminal";
    }

    @Override
    public String deleteTerminal(int divisionId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = connectDB.connect();
            pstmt = conn.prepareStatement("delete from terminalmaster where terminal_id = ?");
            pstmt.setInt(1, divisionId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return "Terminal Deleted";
            }
        } catch (Exception e) {
            logger.error("TerminalDAOImpl : deleteTerminal : " + e);
        }
        return "Failed to Delete Terminal";
    }
}
