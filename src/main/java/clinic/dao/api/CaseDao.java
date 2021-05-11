package clinic.dao.api;

import clinic.entities.Case;

import java.util.List;

public interface CaseDao extends AbstractDao<Case>{
    List<Case> findCasesByPatientId(Integer patientId);
}
