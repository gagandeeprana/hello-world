package dpu.dao.admin;

import dpu.beans.admin.SalesPersonBean;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface SalesPersonDAO {

    List<SalesPersonBean> getAllSalesPersons(String salesPersonName);

    SalesPersonBean getSalesPersonInfoById(int id);

    int addSalesPerson(SalesPersonBean obj);

    String updateSalesPerson(SalesPersonBean obj);

    String deleteSalesPerson(int salesPersonId);
}
