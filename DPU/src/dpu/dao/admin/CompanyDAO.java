package dpu.dao.admin;

import dpu.beans.admin.CompanyBean;
import java.util.List;

public interface CompanyDAO {

    List<CompanyBean> getAllCompanies(String name);

    String addCompany(CompanyBean obj);

    String updateCompany(CompanyBean obj);

    String deleteCompany(int companyId);
}
