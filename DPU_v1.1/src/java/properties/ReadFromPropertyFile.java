/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package properties;

/**
 *
 * @author sikka
 */
public class ReadFromPropertyFile {
     public static final String ipAddress = "122.176.41.88";
//    public static final String ipAddress = "10.10.3.4";
    private static final String rootPath = "/home/deployment-server/web-deployment/tomcat7/webapps/DQEData";
    public static final String rootURL = "http://" + ipAddress + ":8080/dpudata/profilepics";
    public static final String mysqlUsername = "team";
    public static final String mysqlPassowrd = "teamdb";
    public static String filePath="/home/deployment-server/web-deployment/tomcat7/webapps/dpudata/profilepics";
}
