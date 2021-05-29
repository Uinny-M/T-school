package clinic.mappers;

import clinic.entities.enums.EventStatus;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventStatusMapper {
    default String mapEnumToString(EventStatus entity) {
        if (entity != null) {
            return entity.getDescription();
        } else {
            return null;
        }
    }

    default EventStatus mapStringToEnum(String string) {
        EventStatus entity;
        switch (string) {
            case "Planned":
                entity = EventStatus.PLANNED;
                break;
            case "Completed":
                entity = EventStatus.COMPLETED;
                break;
            case "Canceled":
                entity = EventStatus.CANCELED;
                break;
            case "Failed":
                entity = EventStatus.FAILED;
                break;
            default:
                entity = null;
                break;
        }
        return entity;
    }
}
