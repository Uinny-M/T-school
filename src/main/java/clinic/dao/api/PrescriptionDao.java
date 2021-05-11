package clinic.dao.api;

import clinic.entities.Prescription;

import java.util.List;

public interface PrescriptionDao extends AbstractDao<Prescription> {
    List<Prescription> findAllByPatientId(Integer patientId);
    List<Prescription> findAllByCaseId(Long caseId);
}
