package service;

import dao.PatientDaoImpl;
import entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
 private PatientDaoImpl patientDao;

    public Patient createOrUpdatePatient(Patient patient) {
        return null;
    }
    public ResponseEntity removePatient(Patient patient) {
        return null;
    }
    public Patient getPatient(Integer patientId){
        return patientDao.findById(patientId);
    }
    public Patient getPatient(String patientName){
        return null;
    }
}
