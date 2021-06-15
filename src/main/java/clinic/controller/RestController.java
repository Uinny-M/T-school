package clinic.controller;


import clinic.dto.EventDTO;
import clinic.dto.EventOutDTO;
import clinic.service.api.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    private final EventService eventService;

    public RestController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<EventOutDTO> getEvents(){return eventService.getEventsToInfoBoard();}
}
