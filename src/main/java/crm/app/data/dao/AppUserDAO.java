package crm.app.data.dao;

import crm.app.data.dao.abstraction.AbstractDAO;
import crm.app.data.model.AppUser;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class AppUserDAO extends AbstractDAO<AppUser> {

    public AppUserDAO() {
        super(AppUser.class);
    }

    public Boolean isEmailExists(String email) {
        Long result;
        try {
            beginTransaction();
            CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
            CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
            Root<AppUser> appUser = criteriaQuery.from(AppUser.class);
            criteriaQuery.select(criteriaBuilder.count(appUser))
                    .where(criteriaBuilder.equal(appUser.get("email"), email));
            result = getSession().createQuery(criteriaQuery).getSingleResult();
        } finally {
            sessionClose();
        }
        return (result == 1) ? Boolean.TRUE : Boolean.FALSE;
    }

}
