package clinic.mappers;

import clinic.dto.CaseDTO;
import clinic.entities.Case;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CaseMapper extends AbstractMapper<Case, CaseDTO> {
    @Mappings({
            @Mapping(target = "startDate", source = "entity.startDate", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "endDate", source = "entity.endDate", dateFormat = "yyyy-MM-dd")
    })
    CaseDTO mapEntityToDto(Case entity);

    Case mapDtoToEntity(CaseDTO dto);
}
