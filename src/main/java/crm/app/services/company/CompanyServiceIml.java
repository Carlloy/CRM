package crm.app.services.company;

import crm.app.data.dao.interfaces.AppUserDAO;
import crm.app.data.dao.interfaces.CompanyDAO;
import crm.app.data.model.Company;
import org.springframework.beans.factory.annotation.Autowired;

public class CompanyServiceIml implements CompanyService {

    private final CompanyDAO companyDAO;
    private final AppUserDAO appUserDAO;

    @Autowired
    public CompanyServiceIml(CompanyDAO companyDAO, AppUserDAO appUserDAO) {
        this.companyDAO = companyDAO;
        this.appUserDAO = appUserDAO;
    }

    @Override
    public void createCompany(CompanyDTO companyDTO) throws Exception {
        Company company = new Company();
        if (isCompanyExist(companyDTO.getName())) {
            throw new Exception("Company already exists");
        }
        company.setName(companyDTO.getName());
        company.setCreatedby(appUserDAO.findByEmail(companyDTO.getCreatedby()));
        companyDAO.create(company);
    }

    private boolean isCompanyExist(String companyName) {
        return companyDAO.findByName(companyName) != null; //if true than exists
    }
}
