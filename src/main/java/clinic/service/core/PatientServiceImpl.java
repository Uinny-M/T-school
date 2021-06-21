package clinic.service.core;

import clinic.controller.PatientController;
import clinic.dao.api.PatientDao;
import clinic.dto.PatientDTO;
import clinic.entities.Patient;
import clinic.mappers.PatientMapper;
import clinic.service.api.PatientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientServiceImpl extends AbstractServiceImpl<Patient, PatientDTO, PatientDao, PatientMapper>
        implements PatientService {

    @Autowired
    public PatientServiceImpl(PatientDao dao, PatientMapper mapper) {
        super(dao, mapper);
    }

    @Transactional
    public List<PatientDTO> getPatientsByName(String name) {
        if (name == null||name.isEmpty()) return mapToDTO(dao.findAll());
        else return mapToDTO(dao.findAllByName(name));
    }
    private static Logger log = Logger.getLogger(PatientServiceImpl.class);

    @Transactional
    public PatientDTO createOrUpdatePatient(PatientDTO patientDTO) {
        if (getAll().stream().anyMatch(p -> p.getInsurance().equals(patientDTO.getInsurance()))) {
            Patient p = dao.findPatientByInsurance(patientDTO.getInsurance());
            patientDTO.setId(p.getId());
            log.info("new patient " + patientDTO.getSecondName() + " updated");
            dao.update(mapToEntity(patientDTO));
        } else {
            log.info("new patient " + patientDTO.getSecondName() + " created");
            dao.save(mapToEntity(patientDTO));
        }
        return patientDTO;
    }
}
