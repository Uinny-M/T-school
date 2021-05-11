package clinic.dao.api;

import clinic.entities.Patient;


import java.util.List;


public interface PatientDao extends AbstractDao<Patient> {

    List<Patient> findAllByName(String name);
    Patient findPatientByInsurance(String insurance);
}
