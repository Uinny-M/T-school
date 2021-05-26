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

    /**
     * Create new prescription
     * @param prescriptionDTO prescription's data
     * @param caseId case's id
     */
    PrescriptionDTO createPrescription(PrescriptionDTO prescriptionDTO, Long caseId);

    /**
     * Cancel the prescription by prescriptionId
     * @param prescriptionId prescription's idd
     */
    void prescriptionCancel(Long prescriptionId);
}
