package clinic.mappers;

import clinic.dto.PatientDTO;
import clinic.entities.Patient;
import clinic.entities.enums.Gender;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-12T14:13:02+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 13.0.2 (AdoptOpenJDK)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public List<Patient> mapDtoToEntity(List<PatientDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Patient> list = new ArrayList<Patient>( dto.size() );
        for ( PatientDTO patientDTO : dto ) {
            list.add( mapDtoToEntity( patientDTO ) );
        }

        return list;
    }

    @Override
    public List<PatientDTO> mapEntityToDto(List<Patient> entity) {
        if ( entity == null ) {
            return null;
        }

        List<PatientDTO> list = new ArrayList<PatientDTO>( entity.size() );
        for ( Patient patient : entity ) {
            list.add( mapEntityToDto( patient ) );
        }

        return list;
    }

    @Override
    public PatientDTO mapEntityToDto(Patient entity) {
        if ( entity == null ) {
            return null;
        }

        PatientDTO patientDTO = new PatientDTO();

        patientDTO.setBirthdate( entity.getBirthdate() );
        patientDTO.setId( entity.getId() );
        patientDTO.setSecondName( entity.getSecondName() );
        patientDTO.setFirstName( entity.getFirstName() );
        patientDTO.setMiddleName( entity.getMiddleName() );
        if ( entity.getGender() != null ) {
            patientDTO.setGender( entity.getGender().name() );
        }
        patientDTO.setInsurance( entity.getInsurance() );

        return patientDTO;
    }

    @Override
    public Patient mapDtoToEntity(PatientDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( dto.getId() );
        patient.setSecondName( dto.getSecondName() );
        patient.setFirstName( dto.getFirstName() );
        patient.setMiddleName( dto.getMiddleName() );
        patient.setBirthdate( dto.getBirthdate() );
        if ( dto.getGender() != null ) {
            patient.setGender( Enum.valueOf( Gender.class, dto.getGender() ) );
        }
        patient.setInsurance( dto.getInsurance() );

        return patient;
    }
}
