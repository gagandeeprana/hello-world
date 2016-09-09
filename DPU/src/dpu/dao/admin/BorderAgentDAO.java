/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin;

import dpu.beans.admin.BorderAgentBean;
import java.util.List;

/**
 *
 * @author Gagandeep
 */
public interface BorderAgentDAO {

    List<BorderAgentBean> getAllBorderAgents();

    BorderAgentBean getBorderAgentInfoById(int id);

    List<BorderAgentBean> getAllBorderAgentsByCustomBrokerId(int customBrokerId);

    int addBorderAgent(BorderAgentBean obj);

    String updateBorderAgent(BorderAgentBean obj);

    String deleteBorderAgent(int borderAgentId);
}
