package clinic.dao.api;

import clinic.entities.Prescription;

import java.util.List;
/**
 * Prescription's dao
 *
 * CRUD for prescription from AbstractDao
 * Get list of prescriptions by patient
 * Get list of prescriptions by case
 */
public interface PrescriptionDao extends AbstractDao<Prescription> {

    /**
     * Get list of prescriptions by patient
     * @param patientId patient's id
     */
    List<Prescription> findAllByPatientId(Integer patientId);

    /**
     * Get list of prescriptions by case
     * @param caseId case's id
     */
    List<Prescription> findAllByCaseId(Long caseId);
}
