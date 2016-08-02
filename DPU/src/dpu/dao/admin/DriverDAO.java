package dpu.dao.admin;

import dpu.beans.admin.DriverBean;
import java.util.List;

public interface DriverDAO {

    List<DriverBean> getAllDrivers(String name);

    String addDriver(DriverBean obj);

    String updateDriver(DriverBean obj);

    String deleteDriver(int driverId);

}
