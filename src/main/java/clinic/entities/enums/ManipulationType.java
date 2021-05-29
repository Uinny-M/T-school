package clinic.entities.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ManipulationType {
    PROCEDURE("Procedure"),
    MEDICAMENT("Medicament");
    private final String description;

    public String getDescription() {
        return description;
    }
}
