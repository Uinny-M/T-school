package clinic.mappers;

import clinic.entities.enums.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {
    default String mapEnumToString(Role entity) {
        if (entity != null) {
            return entity.getDescription();
        } else {
            return null;
        }
    }

    default Role mapStringToEnum(String string) {
        Role entity;
        switch (string) {
            case "Администратор":
                entity = Role.ROLE_ADMIN;
                break;
            case "Доктор":
                entity = Role.ROLE_DOCTOR;
                break;
            case "Медсестра":
                entity = Role.ROLE_NURSE;
                break;
            default:
                entity = null;
                break;
        }
        return entity;
    }
}
