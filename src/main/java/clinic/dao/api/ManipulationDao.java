package clinic.dao.api;

import clinic.entities.Manipulation;
import clinic.entities.Patient;

import java.util.List;

/**
 * Manipulation's dao
 *
 * CRUD for manipulation from AbstractDao
 */
public interface ManipulationDao extends AbstractDao<Manipulation>{
    /**
     * Get Manipulation  by title
     * @param title title
     */
    List<Manipulation> findByTitle(String title);
}
