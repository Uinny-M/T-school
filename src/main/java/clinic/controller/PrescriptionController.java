package clinic.controller;

import clinic.dto.PrescriptionDTO;
import clinic.service.api.ManipulationService;
import clinic.service.api.PrescriptionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Log4j2
@Controller
@RequestMapping(value = "/prescription")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;
    private final PrescriptionService caseService;
    private final ManipulationService manipulationService;

    public PrescriptionController(PrescriptionService prescriptionService, PrescriptionService caseService, ManipulationService manipulationService) {
        this.prescriptionService = prescriptionService;
        this.caseService = caseService;
        this.manipulationService = manipulationService;
    }

    //Return all prescriptions by PatientId
    @GetMapping(value = "/{patientId}")
    public ModelAndView getAllPrescriptionsByPatientId(@PathVariable Integer patientId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("prescriptions", prescriptionService.getAllByPatientId(patientId));
        modelAndView.setViewName("prescriptions");
        return modelAndView;
    }

    //Return all prescriptions by CaseId
    @GetMapping(value = "/case/{caseId}")
    public ModelAndView getAllPrescriptionsByCaseId(@PathVariable Long caseId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("prescriptions", prescriptionService.getAllByCaseId(caseId));
        modelAndView.setViewName("prescriptions");
        return modelAndView;
    }

    //Add new prescription
    @PostMapping(value = "/case/{caseId}/add")
    public RedirectView addPrescription(@ModelAttribute PrescriptionDTO prescriptionDTO,
                                        @PathVariable Long caseId) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("prescription", new PrescriptionDTO());
//        modelAndView.addObject("caseId", caseId);
//        modelAndView.setViewName("prescription");
        prescriptionService.createPrescription(prescriptionDTO, caseId);
        return new RedirectView("/T_school_war_exploded/patient/");
    }

    //Return Patient by ID
    @GetMapping(value = "/case/{caseId}/add/{prescriptionId}")
    public ModelAndView getPrescription(@PathVariable("caseId") Long caseId,
                                        @PathVariable("prescriptionId") Long prescriptionId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("prescription", prescriptionService.getOneById(prescriptionId));
        // modelAndView.addObject("cases", caseService.getAll());
        modelAndView.setViewName("prescription");
        return modelAndView;
    }

    @RequestMapping(value = "/case/{caseId}/add", method = RequestMethod.GET)
    public ModelAndView getPrescription(@PathVariable("caseId") Long caseId) {
        ModelAndView modelAndView = new ModelAndView();
        String[] week = new String[]{"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};
        String[] times = new String[]{"09:00", "10:00", "11:00", "12:00"};
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        modelAndView.addObject("prescription", prescriptionDTO);
        modelAndView.addObject("week", week);
        modelAndView.addObject("times", times);
        modelAndView.addObject("manipulations", manipulationService.getAll());
        modelAndView.setViewName("prescription");
        return modelAndView; //todo
    }
}
