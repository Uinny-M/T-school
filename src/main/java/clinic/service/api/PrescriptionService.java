package clinic.service.api;

import clinic.dto.PrescriptionDTO;
import clinic.entities.Prescription;

import java.util.List;
/**
 * Prescription's service
 *
 * CRUD for prescription from AbstractService
 * Get list of prescriptions by patient
 * Get list of prescriptions by case
 */
public interface PrescriptionService extends AbstractService<Prescription, PrescriptionDTO>{
    /**
     * Get list of prescriptions by patient
     * @param patientId patient's id
     */
    List<PrescriptionDTO> getAllByPatientId(Integer patientId);

    /**
     * Get list of prescriptions by case
     * @param caseId case's id
     */
    List<PrescriptionDTO> getAllByCaseId(Long caseId);
}
