package dpu.dao.admin;

import dpu.beans.admin.WorkingHoursAdditionalContactBean;
import java.util.List;

/**
 *
 * @author Gagandeep
 */
public interface WorkingHoursAdditionalContactDAO {

    String addWorkingHours(WorkingHoursAdditionalContactBean obj);

    List<WorkingHoursAdditionalContactBean> getWorkingHoursByAdditionalContactId(int id);
}
