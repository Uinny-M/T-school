package clinic.entities.enums;

import lombok.Getter;

@Getter
public enum Role {

    ROLE_ADMIN("ADMIN"),
    ROLE_DOCTOR("DOCTOR"),
    ROLE_NURSE("NURSE");
    private final String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
