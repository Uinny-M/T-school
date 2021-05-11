package clinic.mappers;

import clinic.dto.PatientDTO;
import clinic.entities.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatientMapper extends AbstractMapper<Patient, PatientDTO> {

    @Mappings({
            @Mapping(target = "birthdate", source = "entity.birthdate", dateFormat = "yyyy-MM-dd")
    })
    PatientDTO mapEntityToDto(Patient entity);
    Patient mapDtoToEntity(PatientDTO dto);
}
