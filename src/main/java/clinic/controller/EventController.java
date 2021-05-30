package clinic.controller;

import clinic.service.api.EventService;
import lombok.extern.java.Log;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Log
@Controller
@RequestMapping(value = "/event")
public class EventController {
    private final EventService eventService;
    private final String ROLE_NURSE = "ROLE_NURSE";

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
    public ModelAndView getEvents() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("events", eventService.getAllEvents());
        modelAndView.setViewName("events");
        return modelAndView;
    }

    //Return all Events for 1 our
    @GetMapping(value = "/now")
    public ModelAndView getEventsForOur() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("events", eventService.getAllEventsNow());
        modelAndView.setViewName("events");
        return modelAndView;
    }
    //Return all Events for today
    @GetMapping(value = "/today")
    public ModelAndView getEventsForToday() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("events", eventService.getAllEventsToday());
        modelAndView.addObject("comment", new String());
        modelAndView.setViewName("events");
        return modelAndView;
    }

    //change eventStatus to Done
    @Secured(ROLE_NURSE)
    @RequestMapping(value = "/{eventId}/done", method = {RequestMethod.GET, RequestMethod.POST})
    public RedirectView eventDone(@PathVariable("eventId") Long eventId) {
        eventService.eventDone(eventId);
        return new RedirectView("/T_school_war_exploded/event/now");
    }

    //change eventStatus to Cancel
    @Secured(ROLE_NURSE)
    @RequestMapping(value = "/{eventId}/cancel", method = {RequestMethod.GET, RequestMethod.POST})
    public RedirectView eventCancel(@PathVariable("eventId") Long eventId,
                                    @RequestParam(required = false, value = "comment") String comment) {
        eventService.eventCancel(eventId, comment);
        return new RedirectView("/T_school_war_exploded/event/now");
    }
}
