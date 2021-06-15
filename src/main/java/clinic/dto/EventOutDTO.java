package clinic.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventOutDTO {
    private Long id;

    //patient's name
    private String patient;

    //time of the event
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;

//    //type of the manipulation
//    private String manipulationType;
}
