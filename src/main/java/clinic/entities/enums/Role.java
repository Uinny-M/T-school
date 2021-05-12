package clinic.entities.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ROLE_ADMIN,
    ROLE_DOCTOR,
    ROLE_NURSE


//    ROLE_ADMIN ("Администратор"),
//    ROLE_DOCTOR("Доктор"),
//    ROLE_NURSE("Медсестра");
//    private final String description;
}
