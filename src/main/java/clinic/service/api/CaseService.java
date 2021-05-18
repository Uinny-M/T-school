package clinic.service.api;

import clinic.dto.CaseDTO;
import clinic.entities.Case;

import java.util.List;

/**
 * Case's service
 *
 * CRUD for case from AbstractService
 * Get list of cases by patient
 * Close the case
 */
public interface CaseService extends AbstractService<Case, CaseDTO>{
    /**
     * Get list of cases by patient's id
     * @param patientId patient's id
     */
    List<CaseDTO> getCasesByPatientId(Integer patientId);

    /**
     * Close the case by case's id
     * @param caseId case's id
     */
    void closeCase(Long caseId);

//    /**
//     * create new case or update existing
//     * @param caseDTO case's data
//     */
//    CaseDTO createOrUpdate(CaseDTO caseDTO);

    CaseDTO createCase(String diagnosis, Integer patientId);

    CaseDTO updateCase(String diagnosis, Long caseId);
}
