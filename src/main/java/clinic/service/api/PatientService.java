package clinic.service.api;

import clinic.dto.PatientDTO;
import clinic.entities.Patient;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

/**
 * Patient's service
 *
 * CRUD for patient from AbstractService
 * Get list of patients by second name
 * create new patient or update existing
 */
public interface PatientService extends AbstractService<Patient, PatientDTO> {

    /**
     * Get list of patients by second name
     * @param name second name
     */
    List<PatientDTO> getPatientsByName(String name);

    /**
     * create new patient or update existing
     * @param patientDTO patient's data
     */
    @ApiOperation(value = "create new patient or update existing")
    PatientDTO createOrUpdatePatient(PatientDTO patientDTO);


}
