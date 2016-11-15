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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author gagandeep.rana
 */
public class DPU {

    static Logger logger = Logger.getLogger(DPU.class);

    private static ApplicationContext applicationContext;

//    public static void autowire(Object object) {
//        try {
//            System.out.println("Object : " + object.getClass());
//            applicationContext.getAutowireCapableBeanFactory().autowireBean(object);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

//    @Autowired
//    private void setApplicationContext(ApplicationContext applicationContext) {
//        DPU.applicationContext = applicationContext;
//    }

    public static void main(String[] args) {

        try {
            //**********************************Spring Configuration*********************************
//            applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//            LoginFrame loginFrame = (LoginFrame) applicationContext.getBean(LoginFrame.class);
            //****************************************************************************************
            LoginFrame loginFrame = new LoginFrame();
//            loginFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(DPU.class.getClassLoader().getResource(ReadFromPropertiesFile.imagePath + "Application-Exe.png")));
//            loginFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(DPU.class.getClassLoader().getResource("Application-Exe.png")));
            //WW --loginFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(DPU.class.getClassLoader().getResource("images\\Application-Exe.png")));
//            loginFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(ReadFromPropertiesFile.imagePath + "Application-Exe.png")));
//            loginFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Application-Exe.png")));
//            loginFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images\\Application-Exe.png")));
           loginFrame.setVisible(true);
         
        } catch (Exception e) {
            System.out.println("Main: " + e);
        }
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            System.out.println("session created");
        }
        return sessionFactory;
    }
}
