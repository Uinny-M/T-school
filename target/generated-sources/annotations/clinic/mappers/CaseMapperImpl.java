package clinic.mappers;

import clinic.dto.CaseDTO;
import clinic.dto.PatientDTO;
import clinic.entities.Case;
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
public class CaseMapperImpl implements CaseMapper {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Case> mapDtoToEntity(List<CaseDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Case> list = new ArrayList<Case>( dto.size() );
        for ( CaseDTO caseDTO : dto ) {
            list.add( mapDtoToEntity( caseDTO ) );
        }

        return list;
    }

    @Override
    public List<CaseDTO> mapEntityToDto(List<Case> entity) {
        if ( entity == null ) {
            return null;
        }

        List<CaseDTO> list = new ArrayList<CaseDTO>( entity.size() );
        for ( Case case1 : entity ) {
            list.add( mapEntityToDto( case1 ) );
        }

        return list;
    }

    @Override
    public CaseDTO mapEntityToDto(Case entity) {
        if ( entity == null ) {
            return null;
        }

        CaseDTO caseDTO = new CaseDTO();

        caseDTO.setStartDate( entity.getStartDate() );
        caseDTO.setEndDate( entity.getEndDate() );
        caseDTO.setId( entity.getId() );
        caseDTO.setPatient( patientToPatientDTO( entity.getPatient() ) );
        caseDTO.setDiagnosis( entity.getDiagnosis() );
        caseDTO.setDoctor( employeeMapper.mapEntityToDto( entity.getDoctor() ) );
        caseDTO.setOpenCase( entity.isOpenCase() );

        return caseDTO;
    }

    @Override
    public Case mapDtoToEntity(CaseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Case case1 = new Case();

        case1.setId( dto.getId() );
        case1.setPatient( patientDTOToPatient( dto.getPatient() ) );
        case1.setDiagnosis( dto.getDiagnosis() );
        case1.setDoctor( employeeMapper.mapDtoToEntity( dto.getDoctor() ) );
        case1.setStartDate( dto.getStartDate() );
        case1.setEndDate( dto.getEndDate() );
        case1.setOpenCase( dto.isOpenCase() );

        return case1;
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
}
