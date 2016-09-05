package dpu.dao.admin;

import dpu.beans.admin.CompanyBean;
import java.util.List;

public interface CompanyDAO {

    List<CompanyBean> getAllCompanies(String name);

    CompanyBean getCompanyInfoById(int companyId);

    int getMaxCompanyId();

    String addCompany(CompanyBean obj);

    String updateCompany(CompanyBean obj);

    String deleteCompany(int companyId);
}
