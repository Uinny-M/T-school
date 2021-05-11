package clinic.service.api;

import clinic.dto.PatientDTO;
import clinic.entities.Patient;

import java.util.List;

public interface PatientService extends AbstractService<Patient, PatientDTO> {

    //get patient by part of name
    List<PatientDTO> getPatientsByName(String name);

    PatientDTO createOrUpdatePatient(PatientDTO patientDTO);


}
