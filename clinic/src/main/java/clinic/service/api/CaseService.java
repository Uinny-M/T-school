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
 * create a new case
 * update the existing case
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

    /**
     * create a new case
     * @param diagnosis patient's diagnosis
     * @param patientId patient's id
     */
    void createCase(String diagnosis, Integer patientId);

    /**
     * update the existing case
     * @param diagnosis patient's diagnosis
     * @param caseId case's id
     */
    CaseDTO updateCase(String diagnosis, Long caseId);
}
