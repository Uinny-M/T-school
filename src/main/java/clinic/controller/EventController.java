package clinic.controller;

import clinic.service.api.EventService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Log
@Controller
@RequestMapping(value = "/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    //Return Events by PatientID
    @GetMapping(value = "/{patientId}")
    public ModelAndView getEventByPatientId(@PathVariable("patientId") Integer patientId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("events", eventService.getAllByPatientId(patientId));
        modelAndView.setViewName("events");
        return modelAndView;
    }

    //Return all Events for today
    @GetMapping(value = "/")
    public ModelAndView getEventsForToday() {
        ModelAndView modelAndView = new ModelAndView();
       // modelAndView.addObject("events", eventService.getAllEventsToday());
        modelAndView.addObject("events", eventService.getAllEventsToday());
        modelAndView.setViewName("events");
        return modelAndView;
    }

    //Return all Events for 1 our
    @GetMapping(value = "/now")
    public ModelAndView getEventsForOur() {
        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.addObject("events", eventService.getAllEventsNow());
        modelAndView.addObject("events", eventService.getAllEventsNow());
        modelAndView.setViewName("events");
        return modelAndView;
    }
}
