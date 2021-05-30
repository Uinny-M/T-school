package clinic.mappers;

import clinic.dto.ManipulationDTO;
import clinic.dto.PatientDTO;
import clinic.dto.PrescriptionDTO;
import clinic.entities.Manipulation;
import clinic.entities.Patient;
import clinic.entities.Prescription;
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
public class PrescriptionMapperImpl implements PrescriptionMapper {

    @Autowired
    private CaseMapper caseMapper;

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
        prescriptionDTO.setPatientCase( caseMapper.mapEntityToDto( entity.getPatientCase() ) );
        prescriptionDTO.setManipulation( manipulationToManipulationDTO( entity.getManipulation() ) );
        prescriptionDTO.setDuration( entity.getDuration() );
        prescriptionDTO.setDailyChart( entity.getDailyChart() );
        prescriptionDTO.setDrug( entity.getDrug() );
        prescriptionDTO.setDosage( entity.getDosage() );
        prescriptionDTO.setClosed( entity.isClosed() );

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
        prescription.setPatientCase( caseMapper.mapDtoToEntity( dto.getPatientCase() ) );
        prescription.setManipulation( manipulationDTOToManipulation( dto.getManipulation() ) );
        prescription.setDuration( dto.getDuration() );
        prescription.setDailyChart( dto.getDailyChart() );
        prescription.setDrug( dto.getDrug() );
        prescription.setDosage( dto.getDosage() );
        prescription.setClosed( dto.isClosed() );

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
