package clinic.dao.api;

import clinic.entities.Patient;


import java.util.List;

/**
 * Patient's dao
 *
 * CRUD for patient from AbstractDao
 * Get list of patients by second name
 * Get patient by insurance
 */
public interface PatientDao extends AbstractDao<Patient> {

    /**
     * Get list of patients by second name
     * @param name second name
     */
    List<Patient> findAllByName(String name);

    /**
     * Get patient by insurance
     * @param insurance patient's insurance
     */
    Patient findPatientByInsurance(String insurance);
}
