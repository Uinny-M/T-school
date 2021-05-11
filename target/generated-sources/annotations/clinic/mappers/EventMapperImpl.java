package clinic.mappers;

import clinic.dto.CaseDTO;
import clinic.dto.EmployeeDTO;
import clinic.dto.EventDTO;
import clinic.dto.ManipulationDTO;
import clinic.dto.PatientDTO;
import clinic.dto.PrescriptionDTO;
import clinic.entities.Case;
import clinic.entities.Employee;
import clinic.entities.Event;
import clinic.entities.Manipulation;
import clinic.entities.Patient;
import clinic.entities.Prescription;
import clinic.entities.enums.EventStatus;
import clinic.entities.enums.Gender;
import clinic.entities.enums.ManipulationType;
import clinic.entities.enums.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-11T01:27:59+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 13.0.2 (AdoptOpenJDK)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public List<Event> mapDtoToEntity(List<EventDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Event> list = new ArrayList<Event>( dto.size() );
        for ( EventDTO eventDTO : dto ) {
            list.add( mapDtoToEntity( eventDTO ) );
        }

        return list;
    }

    @Override
    public List<EventDTO> mapEntityToDto(List<Event> entity) {
        if ( entity == null ) {
            return null;
        }

        List<EventDTO> list = new ArrayList<EventDTO>( entity.size() );
        for ( Event event : entity ) {
            list.add( mapEntityToDto( event ) );
        }

        return list;
    }

    @Override
    public EventDTO mapEntityToDto(Event entity) {
        if ( entity == null ) {
            return null;
        }

        EventDTO eventDTO = new EventDTO();

        eventDTO.setId( entity.getId() );
        eventDTO.setPatient( patientToPatientDTO( entity.getPatient() ) );
        eventDTO.setDate( entity.getDate() );
        eventDTO.setTime( entity.getTime() );
        eventDTO.setManipulation( manipulationToManipulationDTO( entity.getManipulation() ) );
        eventDTO.setPrescription( prescriptionToPrescriptionDTO( entity.getPrescription() ) );
        if ( entity.getStatus() != null ) {
            eventDTO.setStatus( entity.getStatus().name() );
        }
        eventDTO.setComment( entity.getComment() );

        return eventDTO;
    }

    @Override
    public Event mapDtoToEntity(EventDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Event event = new Event();

        event.setId( dto.getId() );
        event.setPatient( patientDTOToPatient( dto.getPatient() ) );
        event.setDate( dto.getDate() );
        event.setTime( dto.getTime() );
        event.setManipulation( manipulationDTOToManipulation( dto.getManipulation() ) );
        event.setPrescription( prescriptionDTOToPrescription( dto.getPrescription() ) );
        if ( dto.getStatus() != null ) {
            event.setStatus( Enum.valueOf( EventStatus.class, dto.getStatus() ) );
        }
        event.setComment( dto.getComment() );

        return event;
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
        employeeDTO.setDeleted( employee.isDeleted() );
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

    protected PrescriptionDTO prescriptionToPrescriptionDTO(Prescription prescription) {
        if ( prescription == null ) {
            return null;
        }

        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();

        prescriptionDTO.setId( prescription.getId() );
        prescriptionDTO.setPatient( patientToPatientDTO( prescription.getPatient() ) );
        prescriptionDTO.setPatientCase( caseToCaseDTO( prescription.getPatientCase() ) );
        prescriptionDTO.setManipulation( manipulationToManipulationDTO( prescription.getManipulation() ) );
        prescriptionDTO.setStartDate( prescription.getStartDate() );
        prescriptionDTO.setDuration( prescription.getDuration() );
        prescriptionDTO.setDailyChart( prescription.getDailyChart() );
        prescriptionDTO.setDrug( prescription.getDrug() );
        prescriptionDTO.setDosage( prescription.getDosage() );
        prescriptionDTO.setDeleted( prescription.isDeleted() );

        return prescriptionDTO;
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
        employee.setDeleted( employeeDTO.isDeleted() );
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

    protected Prescription prescriptionDTOToPrescription(PrescriptionDTO prescriptionDTO) {
        if ( prescriptionDTO == null ) {
            return null;
        }

        Prescription prescription = new Prescription();

        prescription.setId( prescriptionDTO.getId() );
        prescription.setPatient( patientDTOToPatient( prescriptionDTO.getPatient() ) );
        prescription.setPatientCase( caseDTOToCase( prescriptionDTO.getPatientCase() ) );
        prescription.setManipulation( manipulationDTOToManipulation( prescriptionDTO.getManipulation() ) );
        prescription.setStartDate( prescriptionDTO.getStartDate() );
        prescription.setDuration( prescriptionDTO.getDuration() );
        prescription.setDailyChart( prescriptionDTO.getDailyChart() );
        prescription.setDrug( prescriptionDTO.getDrug() );
        prescription.setDosage( prescriptionDTO.getDosage() );
        prescription.setDeleted( prescriptionDTO.isDeleted() );

        return prescription;
    }
}
