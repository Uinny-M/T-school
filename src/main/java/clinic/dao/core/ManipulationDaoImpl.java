package clinic.dao.core;

import clinic.dao.api.ManipulationDao;
import clinic.entities.Manipulation;
import org.springframework.stereotype.Repository;

@Repository
public class ManipulationDaoImpl extends AbstractHibernateDao<Manipulation> implements ManipulationDao {
    public ManipulationDaoImpl() {
        super(Manipulation.class);
    }
}
