/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.reports.common;

import dpu.dao.common.ConnectDB;
import java.io.InputStream;
import java.sql.Connection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Gagandeep
 */
public class JasperReportGenerator {

    public static void generateReport(String fileName) {
        try {
            InputStream is = JasperReportGenerator.class.getResourceAsStream(fileName);

            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            Connection con = ConnectDB.connect();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            System.out.println("Exception in generationg report, generateReport() of JasperReportGenerator: " + e);
        }
    }
}
