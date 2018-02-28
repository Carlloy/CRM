package crm.app.data.dao.abstraction;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
public interface IDAO<T extends Serializable> {
    T findById(Long id);

    List<T> findAll();

    void create(T object);

    void update(T object);

    void delete(T object);

    void deleteById(Long id);

    void createOrUpdate(T object);
}
