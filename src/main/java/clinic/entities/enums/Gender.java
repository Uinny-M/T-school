package clinic.entities.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum Gender {

    MALE("Male"),
    FEMALE("Female");
    public final String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
