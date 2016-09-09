package dpu.dao.admin;

import dpu.beans.admin.CustomBrokerBean;
import java.util.List;

public interface CustomBrokerDAO {

    List<CustomBrokerBean> getAllCustomBrokers(String name);

    CustomBrokerBean getCustomBrokerInfoById(int id);

    int addCustomBroker(CustomBrokerBean obj);

    String updateCustomBroker(CustomBrokerBean obj);

    String deleteCustomBroker(int customBrokerId);

}
