package clinic.mappers;

import clinic.dto.EventDTO;
import clinic.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {EventStatusMapper.class})
public interface EventMapper extends AbstractMapper<Event, EventDTO> {
    EventDTO mapEntityToDto(Event entity);

    Event mapDtoToEntity(EventDTO dto);
}
