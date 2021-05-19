package clinic.dao.core;

import clinic.dao.api.ManipulationDao;
import clinic.entities.Manipulation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManipulationDaoImpl extends AbstractHibernateDao<Manipulation> implements ManipulationDao {
    public ManipulationDaoImpl() {
        super(Manipulation.class);
    }

    @Override
    public List<Manipulation> findByTitle(String title) {
        return em.createQuery(
                "SELECT m FROM Manipulation m WHERE m.title = :title ")
                .setParameter("title", title)
                .getResultList();
    }
}
