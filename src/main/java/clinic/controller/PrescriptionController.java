package clinic.controller;

import clinic.dto.PrescriptionDTO;
import clinic.exception.BusinessException;
import clinic.service.api.CaseService;
import clinic.service.api.ManipulationService;
import clinic.service.api.PrescriptionService;
import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/prescription")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;
    private final CaseService caseService;
    private final ManipulationService manipulationService;
    private final String ROLE_DOCTOR = "ROLE_DOCTOR";

    public PrescriptionController(PrescriptionService prescriptionService, CaseService caseService, ManipulationService manipulationService) {
        this.prescriptionService = prescriptionService;
        this.caseService = caseService;
        this.manipulationService = manipulationService;
    }

    private static Logger log = Logger.getLogger(PrescriptionController.class);

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
        modelAndView.addObject("caseId", caseId);
        modelAndView.addObject("prescriptions", prescriptionService.getAllByCaseId(caseId));
        modelAndView.addObject("patientId", caseService.getOneById(caseId).getPatient().getId());
        modelAndView.setViewName("prescriptions");
        return modelAndView;
    }

    //Return Prescription by ID
    @GetMapping(value = "/case/{caseId}/add/{prescriptionId}")
    public ModelAndView getPrescription(@PathVariable("caseId") Long caseId,
                                        @PathVariable("prescriptionId") Long prescriptionId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("prescription", prescriptionService.getOneById(prescriptionId));
        modelAndView.setViewName("prescription");
        return modelAndView;
    }

    //cancel thr prescription
    @Secured(ROLE_DOCTOR)
    @RequestMapping(value = "/cancel/{prescriptionId}", method = {RequestMethod.GET, RequestMethod.POST})
    public RedirectView prescriptionCancel(@PathVariable("prescriptionId") Long prescriptionId) {
        prescriptionService.prescriptionCancel(prescriptionId);
        PrescriptionDTO prescriptionDTO = prescriptionService.getOneById(prescriptionId);
        String url = "/T_school_war_exploded/cases/" + prescriptionDTO.getPatient().getId()
                + "/update/" + prescriptionDTO.getPatientCase().getId();
        return new RedirectView(url);
    }

    //Add new prescription
    @Secured(ROLE_DOCTOR)
    @RequestMapping(value = "/case/{caseId}/add", method = RequestMethod.POST)
    public String addPrescription(@ModelAttribute PrescriptionDTO prescriptionDTO,
                                  @PathVariable Long caseId, RedirectAttributes attributes) {
        try {
            prescriptionService.createPrescription(prescriptionDTO, caseId);
        } catch (BusinessException e) {
            attributes.addFlashAttribute("flashPrescription", prescriptionDTO);
            attributes.addFlashAttribute("error", e.getMessage());
        }
        String url1 = "redirect:/prescription/case/" + caseId + "/add";
        return url1;
    }

    @RequestMapping(value = "/case/{caseId}/add", method = RequestMethod.GET)
    public ModelAndView getPrescription(@PathVariable("caseId") Long caseId, Model model) {
        try {
            prescriptionService.validate(caseId);
        } catch (BusinessException e) {
            ModelAndView modelAndView1 = new ModelAndView();
            modelAndView1.setViewName("/error/exception");
            modelAndView1.addObject("error", e.getMessage());
            return modelAndView1;
        }
        ModelAndView modelAndView = new ModelAndView();
        List<DayOfWeek> days = new ArrayList<>();
        days.add(DayOfWeek.MONDAY);
        days.add(DayOfWeek.TUESDAY);
        days.add(DayOfWeek.WEDNESDAY);
        days.add(DayOfWeek.THURSDAY);
        days.add(DayOfWeek.FRIDAY);
        days.add(DayOfWeek.SATURDAY);
        days.add(DayOfWeek.SUNDAY);
        List<String> times = new ArrayList<>();
        times.add("11:00:00");
        times.add("12:00:00");
        times.add("14:00:00");
        times.add("15:00:00");
        times.add("16:00:00");
        times.add("17:00:00");
        times.add("18:00:00");
        times.add("19:00:00");
        times.add("20:00:00");
        times.add("23:00:00");
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        modelAndView.addObject("patientId", caseService.getOneById(caseId).getPatient().getId());
        modelAndView.addObject("prescription", model.asMap().get("flashPrescription") != null ? model.asMap().get("flashPrescription") : prescriptionDTO);
        modelAndView.addObject("days", days);
        modelAndView.addObject("times", times);
        modelAndView.addObject("manipulations", manipulationService.getAll());
        modelAndView.setViewName("prescription");
        return modelAndView;
    }
}
