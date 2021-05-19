package clinic.mappers;

import clinic.dto.ManipulationDTO;
import clinic.entities.Manipulation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {ManipulationTypeMapper.class})
public interface ManipulationMapper extends AbstractMapper<Manipulation, ManipulationDTO> {

    ManipulationDTO mapEntityToDto(Manipulation entity);
    Manipulation mapDtoToEntity(ManipulationDTO dto);
}
