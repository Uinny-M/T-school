package clinic.entities.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ManipulationType {
    PROCEDURE("Процедура"),
    MEDICAMENT("Лекарство");
    private final String description;

    public String getDescription() {
        return description;
    }
}
