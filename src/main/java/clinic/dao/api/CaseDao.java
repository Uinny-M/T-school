package clinic.dao.api;

import clinic.entities.Case;

import java.util.List;

/**
 * Case's dao
 *
 * CRUD for case from AbstractDao
 * Get list of cases by patient
 */
public interface CaseDao extends AbstractDao<Case>{
    /**
     * Get list of cases by patient's id
     * @param patientId patient's id
     */
    List<Case> findCasesByPatientId(Integer patientId);
}
