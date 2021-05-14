package clinic.mappers;

import clinic.entities.enums.ManipulationType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper (componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ManipulationTypeMapper {
    default String mapEnumToString(ManipulationType entity) {
        if (entity != null) {
            return entity.getDescription();
        } else {
            return null;
        }
    }

    default ManipulationType mapStringToEnum(String string) {
        ManipulationType entity;
        switch (string) {
            case "Лекарство":
                entity = ManipulationType.MEDICAMENT;
                break;
            case "Процедура":
                entity = ManipulationType.PROCEDURE;
                break;
            default:
                entity = null;
                break;
        }
        return entity;
    }
}
