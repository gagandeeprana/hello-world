/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.FeedbackBean;
import java.util.List;

/**
 *
 * @author student
 */
public interface FeedbackServicesDAO {

    String deleteFeedback(int feedbackId);

    List<FeedbackBean> getAllFeedbacks(String startDate, String endDate);
    
}
