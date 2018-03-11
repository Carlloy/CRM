package crm.app.data.dao.implementations;

import crm.app.data.dao.abstraction.AbstractDAO;
import crm.app.data.dao.interfaces.CompanyDAO;
import crm.app.data.model.AppUser;
import crm.app.data.model.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class CompanyDAOImpl extends AbstractDAO<Company> implements CompanyDAO {

    public CompanyDAOImpl() {
        super(Company.class);
    }

    @Override
    public Company findByName(String name) {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Company> criteriaQuery = criteriaBuilder.createQuery(Company.class);
        Root<AppUser> appUser = criteriaQuery.from(AppUser.class);
        criteriaQuery.where(criteriaBuilder.equal(appUser.get("name"), name));
        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public Company findByIndustry(String industry) {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Company> criteriaQuery = criteriaBuilder.createQuery(Company.class);
        Root<AppUser> appUser = criteriaQuery.from(AppUser.class);
        criteriaQuery.where(criteriaBuilder.equal(appUser.get("industry"), industry));
        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
    }
}
