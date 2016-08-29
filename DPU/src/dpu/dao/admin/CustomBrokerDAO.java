package dpu.dao.admin;

import dpu.beans.admin.CustomBrokerBean;
import java.util.List;

public interface CustomBrokerDAO {

    List<CustomBrokerBean> getAllCustomBrokers(String name);

//    CustomBrokerBean getCustomBrokerInfoById(int customBrokerId);
//    List<CustomBrokerBean> getAllCustomBrokersByCompanyId(int id);
    int getMaxCustomBrokerId();

    String addCustomBroker(CustomBrokerBean obj);

    String updateCustomBroker(CustomBrokerBean obj);

    String deleteCustomBroker(int customBrokerId);

//    int getMaxCustomBrokerId();
}
