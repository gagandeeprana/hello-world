/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.ProfileBean;

/**
 *
 * @author student
 */
public interface ProfileServicesDAO {

    ProfileBean getUserInfoById(int id);

    String updateProfile(ProfileBean obj);

    String updateProfileImage(String fileName, String userid);
    
}
