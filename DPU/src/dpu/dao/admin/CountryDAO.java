package dpu.dao.admin;

import dpu.beans.admin.CountryBean;
import java.util.List;

public interface CountryDAO {

    List<CountryBean> getAllCountries(String name);

    String addCountry(CountryBean obj);

    String updateCountry(CountryBean obj);

    String deleteCountry(int countryId);

    CountryBean getCountryInfo(int countryId);
}
