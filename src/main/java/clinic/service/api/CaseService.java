package clinic.service.api;

import clinic.dto.CaseDTO;
import clinic.entities.Case;

import java.util.List;

public interface CaseService extends AbstractService<Case, CaseDTO>{
    //get cases by patient's Id
    List<CaseDTO> getCasesByPatientId(Integer patientId);
    List<Case> getCases(Integer i);
    List<CaseDTO>getAllOpenCases();
    void closeCase(Long caseId);
}
