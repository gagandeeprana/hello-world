/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.dao.admin;

import dpu.beans.admin.TrailerBean;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface TrailerDAO {

    List<TrailerBean> getAllTrailers(String name);

    String addTrailer(TrailerBean obj);

    String updateTrailer(TrailerBean obj);

    String deleteTrailer(int trailerId);
}
