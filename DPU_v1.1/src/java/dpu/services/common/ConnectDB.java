/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.common;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import dbutils.DatabaseUtils;
import dbutils.exception.DatabaseCreationException;
import java.sql.Connection;
import java.sql.DriverManager;
import properties.ReadFromPropertyFile;

/**
 *
 * @author sikka
 */
public class ConnectDB {

    private static String SCRIPT_FILENAME = "DPU_DM_DATA.sql", IP = "10.10.3.15", USERNAME = "root", PASSWORD = "root";
    private static String DATABASE_NAME = "dpu6m";
    private static final Integer PORT_NO = 3306;

    public static Connection connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + PORT_NO + "/" + DATABASE_NAME, USERNAME, PASSWORD);
        } catch (MySQLSyntaxErrorException e) {
            try {
                DatabaseUtils.connectDB(ConnectDB.class, SCRIPT_FILENAME, USERNAME, PASSWORD, IP, PORT_NO);
                con = DriverManager.getConnection("jdbc:mysql:///" + DATABASE_NAME, USERNAME, PASSWORD);
            } catch (DatabaseCreationException ex) {
                System.out.println("in creating database ()" + e);
            } catch (Exception ex) {
                System.out.println("Exception in inner connect of DBConnection : " + e);
            }
        } catch (Exception e) {
            System.out.println("Exception in connect of DBConnection : " + e);
        }
        return con;
    }
}
