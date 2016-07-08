/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.common;

import dpu.beans.common.LoginBean;

/**
 *
 * @author student
 */
public interface CommonServicesDAO {

    LoginBean authUser(String username, String password);

    String changePass(int userId, String oldPass, String newPass);

    String changePassword(String username, String oldPass, String newPass);

    LoginBean checkUser(String username);

    String forgotPassword(String username);

    String forgotPasswordUsername(String username);
    
}
