/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu;

import dpu.ui.common.LoginFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author gagandeep.rana
 */
public class DPU {

    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
//            ((ClassPathXmlApplicationContext) context).close();
        } catch (Exception e) {
            System.out.println("Main: " + e);
        }
    }
}
