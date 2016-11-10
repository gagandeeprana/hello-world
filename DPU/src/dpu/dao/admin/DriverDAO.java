package dpu.dao.admin;

 
import dpu.entity.admin.Driver;
import java.util.List;

public interface DriverDAO {

    public List<Driver> getAllDrivers(String name);

    public String addDriver(Driver obj);

    public String updateDriver(Driver obj);

    public String deleteDriver(int driverId);
    
    public List<Driver> showAllDrivers( );
    
    public List<Driver> QuickFilterDrivers();
    
    

}
