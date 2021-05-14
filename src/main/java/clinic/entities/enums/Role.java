package clinic.entities.enums;

import lombok.Getter;

@Getter
public enum Role {

    ROLE_ADMIN("Администратор"),
    ROLE_DOCTOR("Доктор"),
    ROLE_NURSE("Медсестра");
    private final String description;

    Role(String description) {
        this.description = description;
    }
}
