package clinic.entities.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventStatus {
    PLANNED,
    COMPLETED,
    CANCELED,
    FAILED
//    PLANNED ("Запланировано"),
//    COMPLETED("Выполнено"),
//    CANCELED("Отменено"),
//    FAILED("Пропущено");
//    private final String description;
}
