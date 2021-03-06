package clinic.service.core;

import clinic.controller.PatientController;
import clinic.dao.api.PatientDao;
import clinic.dto.PatientDTO;
import clinic.entities.Patient;
import clinic.exception.BusinessException;
import clinic.mappers.PatientMapper;
import clinic.service.api.PatientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
        valid(patientDTO);
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

    private void valid(PatientDTO patientDTO){
        StringBuilder msg = new StringBuilder("");
        if(patientDTO.getSecondName().isEmpty()) {
            msg.append("SecondName; ");
        }
        if (patientDTO.getFirstName().isEmpty()){
            msg.append("FirstName; ");
        }
        if (patientDTO.getGender() == null) {
            msg.append("Gender; ");
        }
        if (patientDTO.getInsurance().isEmpty()){
            msg.append("Insurance; ");
        }
        if (patientDTO.getBirthdate()==null){
            msg.append("Birthdate; ");
        }
        if (!msg.isEmpty()){
            msg.append(" - the fields cannot be empty; ");
        }

        if (patientDTO.getBirthdate().isAfter(LocalDate.now())){
            msg.append("The birthdate cannot be in the future; ");
        }

        if (!msg.isEmpty()){
            throw new BusinessException(msg.toString());
        }
    }
}
