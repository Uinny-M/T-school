package clinic.mappers;

import clinic.dto.ManipulationDTO;
import clinic.entities.Manipulation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ManipulationMapper extends AbstractMapper<Manipulation, ManipulationDTO> {
    ManipulationDTO mapEntityToDto(Manipulation entity);
    Manipulation mapDtoToEntity(ManipulationDTO dto);
}
