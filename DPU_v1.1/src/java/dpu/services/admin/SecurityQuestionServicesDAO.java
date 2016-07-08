/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.services.admin;

import dpu.beans.admin.AddEditSQBean;
import dpu.beans.admin.QuestionsBean;
import java.util.List;

/**
 *
 * @author student
 */
public interface SecurityQuestionServicesDAO {

    String addSQ(AddEditSQBean obj);

    String changeStatus(int status, int qId);

    List<QuestionsBean> getAllQuestions(int status);

    QuestionsBean getSQInfoById(int id);

    String updateSQ(AddEditSQBean obj);
    
}
