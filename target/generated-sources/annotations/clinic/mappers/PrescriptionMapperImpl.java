package clinic.mappers;

import clinic.dto.CaseDTO;
import clinic.dto.EmployeeDTO;
import clinic.dto.ManipulationDTO;
import clinic.dto.PatientDTO;
import clinic.dto.PrescriptionDTO;
import clinic.entities.Case;
import clinic.entities.Employee;
import clinic.entities.Manipulation;
import clinic.entities.Patient;
import clinic.entities.Prescription;
import clinic.entities.enums.Gender;
import clinic.entities.enums.ManipulationType;
import clinic.entities.enums.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-13T10:34:31+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 13.0.2 (AdoptOpenJDK)"
)
@Component
public class PrescriptionMapperImpl implements PrescriptionMapper {

    @Override
    public List<Prescription> mapDtoToEntity(List<PrescriptionDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Prescription> list = new ArrayList<Prescription>( dto.size() );
        for ( PrescriptionDTO prescriptionDTO : dto ) {
            list.add( mapDtoToEntity( prescriptionDTO ) );
        }

        return list;
    }

    @Override
    public List<PrescriptionDTO> mapEntityToDto(List<Prescription> entity) {
        if ( entity == null ) {
            return null;
        }

        List<PrescriptionDTO> list = new ArrayList<PrescriptionDTO>( entity.size() );
        for ( Prescription prescription : entity ) {
            list.add( mapEntityToDto( prescription ) );
        }

        return list;
    }

    @Override
    public PrescriptionDTO mapEntityToDto(Prescription entity) {
        if ( entity == null ) {
            return null;
        }

        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();

        prescriptionDTO.setId( entity.getId() );
        prescriptionDTO.setPatient( patientToPatientDTO( entity.getPatient() ) );
        prescriptionDTO.setPatientCase( caseToCaseDTO( entity.getPatientCase() ) );
        prescriptionDTO.setManipulation( manipulationToManipulationDTO( entity.getManipulation() ) );
        prescriptionDTO.setStartDate( entity.getStartDate() );
        prescriptionDTO.setDuration( entity.getDuration() );
        prescriptionDTO.setDailyChart( entity.getDailyChart() );
        prescriptionDTO.setDrug( entity.getDrug() );
        prescriptionDTO.setDosage( entity.getDosage() );
        prescriptionDTO.setDeleted( entity.isDeleted() );

        return prescriptionDTO;
    }

    @Override
    public Prescription mapDtoToEntity(PrescriptionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Prescription prescription = new Prescription();

        prescription.setId( dto.getId() );
        prescription.setPatient( patientDTOToPatient( dto.getPatient() ) );
        prescription.setPatientCase( caseDTOToCase( dto.getPatientCase() ) );
        prescription.setManipulation( manipulationDTOToManipulation( dto.getManipulation() ) );
        prescription.setStartDate( dto.getStartDate() );
        prescription.setDuration( dto.getDuration() );
        prescription.setDailyChart( dto.getDailyChart() );
        prescription.setDrug( dto.getDrug() );
        prescription.setDosage( dto.getDosage() );
        prescription.setDeleted( dto.isDeleted() );

        return prescription;
    }

    protected PatientDTO patientToPatientDTO(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDTO patientDTO = new PatientDTO();

        patientDTO.setId( patient.getId() );
        patientDTO.setSecondName( patient.getSecondName() );
        patientDTO.setFirstName( patient.getFirstName() );
        patientDTO.setMiddleName( patient.getMiddleName() );
        patientDTO.setBirthdate( patient.getBirthdate() );
        if ( patient.getGender() != null ) {
            patientDTO.setGender( patient.getGender().name() );
        }
        patientDTO.setInsurance( patient.getInsurance() );

        return patientDTO;
    }

    protected EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( employee.getId() );
        employeeDTO.setSecondName( employee.getSecondName() );
        employeeDTO.setFirstName( employee.getFirstName() );
        employeeDTO.setMiddleName( employee.getMiddleName() );
        employeeDTO.setPosition( employee.getPosition() );
        employeeDTO.setLogin( employee.getLogin() );
        employeeDTO.setPassword( employee.getPassword() );
        if ( employee.getRole() != null ) {
            employeeDTO.setRole( employee.getRole().name() );
        }

        return employeeDTO;
    }

    protected CaseDTO caseToCaseDTO(Case case1) {
        if ( case1 == null ) {
            return null;
        }

        CaseDTO caseDTO = new CaseDTO();

        caseDTO.setId( case1.getId() );
        caseDTO.setPatient( patientToPatientDTO( case1.getPatient() ) );
        caseDTO.setDiagnosis( case1.getDiagnosis() );
        caseDTO.setDoctor( employeeToEmployeeDTO( case1.getDoctor() ) );
        caseDTO.setStartDate( case1.getStartDate() );
        caseDTO.setEndDate( case1.getEndDate() );
        caseDTO.setOpenCase( case1.isOpenCase() );

        return caseDTO;
    }

    protected ManipulationDTO manipulationToManipulationDTO(Manipulation manipulation) {
        if ( manipulation == null ) {
            return null;
        }

        ManipulationDTO manipulationDTO = new ManipulationDTO();

        manipulationDTO.setId( manipulation.getId() );
        manipulationDTO.setTitle( manipulation.getTitle() );
        if ( manipulation.getType() != null ) {
            manipulationDTO.setType( manipulation.getType().name() );
        }
        manipulationDTO.setDeleted( manipulation.isDeleted() );

        return manipulationDTO;
    }

    protected Patient patientDTOToPatient(PatientDTO patientDTO) {
        if ( patientDTO == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( patientDTO.getId() );
        patient.setSecondName( patientDTO.getSecondName() );
        patient.setFirstName( patientDTO.getFirstName() );
        patient.setMiddleName( patientDTO.getMiddleName() );
        patient.setBirthdate( patientDTO.getBirthdate() );
        if ( patientDTO.getGender() != null ) {
            patient.setGender( Enum.valueOf( Gender.class, patientDTO.getGender() ) );
        }
        patient.setInsurance( patientDTO.getInsurance() );

        return patient;
    }

    protected Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDTO.getId() );
        employee.setSecondName( employeeDTO.getSecondName() );
        employee.setFirstName( employeeDTO.getFirstName() );
        employee.setMiddleName( employeeDTO.getMiddleName() );
        employee.setPosition( employeeDTO.getPosition() );
        employee.setLogin( employeeDTO.getLogin() );
        employee.setPassword( employeeDTO.getPassword() );
        if ( employeeDTO.getRole() != null ) {
            employee.setRole( Enum.valueOf( Role.class, employeeDTO.getRole() ) );
        }

        return employee;
    }

    protected Case caseDTOToCase(CaseDTO caseDTO) {
        if ( caseDTO == null ) {
            return null;
        }

        Case case1 = new Case();

        case1.setId( caseDTO.getId() );
        case1.setPatient( patientDTOToPatient( caseDTO.getPatient() ) );
        case1.setDiagnosis( caseDTO.getDiagnosis() );
        case1.setDoctor( employeeDTOToEmployee( caseDTO.getDoctor() ) );
        case1.setStartDate( caseDTO.getStartDate() );
        case1.setEndDate( caseDTO.getEndDate() );
        case1.setOpenCase( caseDTO.isOpenCase() );

        return case1;
    }

    protected Manipulation manipulationDTOToManipulation(ManipulationDTO manipulationDTO) {
        if ( manipulationDTO == null ) {
            return null;
        }

        Manipulation manipulation = new Manipulation();

        manipulation.setId( manipulationDTO.getId() );
        manipulation.setTitle( manipulationDTO.getTitle() );
        if ( manipulationDTO.getType() != null ) {
            manipulation.setType( Enum.valueOf( ManipulationType.class, manipulationDTO.getType() ) );
        }
        manipulation.setDeleted( manipulationDTO.isDeleted() );

        return manipulation;
    }
}
