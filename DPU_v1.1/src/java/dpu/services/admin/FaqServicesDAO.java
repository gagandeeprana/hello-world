/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditFaqBean;
import dpu.beans.admin.FaqBean;
import java.util.List;

/**
 *
 * @author student
 */
public interface FaqServicesDAO {

    String addFaq(AddEditFaqBean obj);

    String changeStatus(int status, int faqId);

    List<FaqBean> getAllFaq();

    List<FaqBean> getAllFaqByStatus(String status);

    FaqBean getFAQInfo(int id);

    String updateFaq(AddEditFaqBean obj);
    
}
