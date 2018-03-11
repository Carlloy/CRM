package crm.app.data.dao.interfaces;

import crm.app.data.dao.abstraction.IDAO;
import crm.app.data.model.Company;

public interface CompanyDAO extends IDAO<Company> {
    Company findByName(String name);

    Company findByIndustry(String industry);

}
