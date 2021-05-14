package clinic.mappers;

import clinic.entities.enums.EventStatus;
import clinic.entities.enums.Gender;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenderMapper {
    default String mapEnumToString(EventStatus entity) {
        if (entity != null) {
            return entity.getDescription();
        } else {
            return null;
        }
    }
    default Gender mapStringToEnum(String string) {
        Gender entity;
        switch (string) {
            case "Мужской":
                entity = Gender.MALE;
                break;
            case "Женский":
                entity = Gender.FEMALE;
                break;
            default:
                entity = null;
                break;
        }
        return entity;
    }
}
