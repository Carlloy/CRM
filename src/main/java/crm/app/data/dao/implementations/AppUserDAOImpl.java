package crm.app.data.dao.implementations;

import crm.app.data.dao.abstraction.AbstractDAO;
import crm.app.data.dao.interfaces.AppUserDAO;
import crm.app.data.model.AppUser;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class AppUserDAOImpl extends AbstractDAO<AppUser> implements AppUserDAO {

    public AppUserDAOImpl() {
        super(AppUser.class);
    }

    public Boolean isEmailExists(String email) {
        Long result;
        CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<AppUser> appUser = criteriaQuery.from(AppUser.class);
        criteriaQuery.select(criteriaBuilder.count(appUser))
                .where(criteriaBuilder.equal(appUser.get("email"), email));
        result = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
        return (result == 1) ? Boolean.TRUE : Boolean.FALSE;
    }

    public AppUser findByEmail(String email) {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<AppUser> criteriaQuery = criteriaBuilder.createQuery(AppUser.class);
        Root<AppUser> appUser = criteriaQuery.from(AppUser.class);
        criteriaQuery.where(criteriaBuilder.equal(appUser.get("email"), email));
        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
    }

}
