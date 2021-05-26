package clinic.entities.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum Gender {

    MALE("Мужской"),
    FEMALE("Женский");
    public final String description;

    Gender(String description) {
        this.description = description;
    }
}
