package dpu.dao.admin;

import dpu.beans.admin.AdditionalContactBean;
import java.util.List;

public interface AdditionalContactDAO {

    List<AdditionalContactBean> getAllAdditionalContacts(String name);
    
    AdditionalContactBean getAdditionalContactInfoById(int additionalContactId);

    List<AdditionalContactBean> getAllAdditionalContactsByCompanyId(int id);
    
    String addAdditionalContact(AdditionalContactBean obj);

    String updateAdditionalContact(AdditionalContactBean obj);

    String deleteAdditionalContact(int additionalContactId);
    
    int getMaxAdditionalContactId();
}
