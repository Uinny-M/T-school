package clinic.mappers;

import clinic.dto.EventDTO;
import clinic.dto.ManipulationDTO;
import clinic.dto.PatientDTO;
import clinic.entities.Event;
import clinic.entities.Manipulation;
import clinic.entities.Patient;
import clinic.entities.enums.Gender;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-30T11:31:33+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 13.0.2 (AdoptOpenJDK)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Autowired
    private EventStatusMapper eventStatusMapper;
    @Autowired
    private PrescriptionMapper prescriptionMapper;

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
        eventDTO.setPrescription( prescriptionMapper.mapEntityToDto( entity.getPrescription() ) );
        eventDTO.setStatus( eventStatusMapper.mapEnumToString( entity.getStatus() ) );
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
        event.setPrescription( prescriptionMapper.mapDtoToEntity( dto.getPrescription() ) );
        event.setStatus( eventStatusMapper.mapStringToEnum( dto.getStatus() ) );
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
        manipulationDTO.setType( manipulation.getType() );
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

    protected Manipulation manipulationDTOToManipulation(ManipulationDTO manipulationDTO) {
        if ( manipulationDTO == null ) {
            return null;
        }

        Manipulation manipulation = new Manipulation();

        manipulation.setId( manipulationDTO.getId() );
        manipulation.setTitle( manipulationDTO.getTitle() );
        manipulation.setType( manipulationDTO.getType() );
        manipulation.setDeleted( manipulationDTO.isDeleted() );

        return manipulation;
    }
}
