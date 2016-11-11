package dpu.dao.admin;

 
import dpu.entity.admin.Driver;
import java.util.List;

public interface DriverDAO {

    public List<Driver> getAllDrivers(String name);

    public String addDriver(Driver obj);
    
    public void updateDriver(Driver driver);

    public List<Driver> updateDriver(String driverCode);

    public String deleteDriver(String driverCode);
    
    public List<Driver> showAllDrivers( );
    
    public List<Driver> QuickFilterDrivers();
    
    

}
