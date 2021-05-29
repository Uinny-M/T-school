package clinic.entities.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventStatus {
    PLANNED ("Planned"),
    COMPLETED("Completed"),
    CANCELED("Canceled"),
    FAILED("Failed");
    private final String description;
    public String getDescription() {
        return description;
    }
}
