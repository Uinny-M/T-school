package clinic.service.api;

import clinic.dto.PrescriptionDTO;
import clinic.entities.Prescription;

import java.util.List;

public interface PrescriptionService extends AbstractService<Prescription, PrescriptionDTO>{
    List<PrescriptionDTO> getAllByPatientId(Integer PatientId);
 //   List<PrescriptionDTO> getAllByCaseId(Long caseId);
    List<PrescriptionDTO> getAllByCaseId(Long caseId);
}
