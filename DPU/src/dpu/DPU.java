/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu;

import dpu.ui.common.LoginFrame;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author gagandeep.rana
 */
public class DPU {

    static Logger logger = Logger.getLogger(DPU.class);

    public static void main(String[] args) {

        logger.info("Inside DPU: main(): STARTS");
        try {
            //**********************************Spring Configuration*********************************
//            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//            LoginFrame loginFrame = (LoginFrame) context.getBean(LoginFrame.class);
            //****************************************************************************************
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        } catch (Exception e) {
            System.out.println("Main: " + e);
        }

        logger.info("Inside DPU: main(): ENDS");
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return sessionFactory;
    }
}
