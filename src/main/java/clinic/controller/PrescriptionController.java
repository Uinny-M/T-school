package clinic.controller;

import clinic.dto.PrescriptionDTO;
import clinic.service.api.CaseService;
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
    private final CaseService caseService;
    private final ManipulationService manipulationService;

    public PrescriptionController(PrescriptionService prescriptionService, CaseService caseService, ManipulationService manipulationService) {
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
        // modelAndView.addObject("cases", caseService.getAll());
        modelAndView.setViewName("prescription");
        return modelAndView;
    }

    //Add new prescription
    @RequestMapping(value = "/case/{caseId}/add", method = RequestMethod.POST)
    public RedirectView addPrescription(@RequestParam PrescriptionDTO prescriptionDTO,
                                        @PathVariable Long caseId
//            ,
//                                        @ModelAttribute byte manipulationid

//            , @RequestParam("weekdays")
    ) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("prescription", new PrescriptionDTO());
//        modelAndView.addObject("caseId", caseId);
//        modelAndView.setViewName("prescription");
//        System.out.println(manipulationid);
        prescriptionService.createPrescription(prescriptionDTO, caseId);
        return new RedirectView("/T_school_war_exploded/prescription/case/{caseId}/add");
    }

    @RequestMapping(value = "/case/{caseId}/add", method = RequestMethod.GET)
    public ModelAndView getPrescription(@PathVariable("caseId") Long caseId) {
        ModelAndView modelAndView = new ModelAndView();
        String[] days = new String[]{"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};
        String[] times = new String[]{"09:00", "10:00", "11:00", "12:00"};
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        modelAndView.addObject("patientId", caseService.getOneById(caseId).getPatient().getId());
        modelAndView.addObject("manipName", new String());
        modelAndView.addObject("prescription", prescriptionDTO);
        modelAndView.addObject("days", days);
        modelAndView.addObject("times", times);
//        List<String> manipulations = manipulationService.getAll().stream().map(manipulationDTO ->
//                manipulationDTO.getTitle()).collect(Collectors.toList());
//        modelAndView.addObject("manipulations", manipulations);
        //modelAndView.addObject("manipulations", manipulationService.getAll().stream().map(ManipulationDTO::getTitle).collect(Collectors.toList()));
        modelAndView.addObject("manipulations", manipulationService.getAll());
        modelAndView.setViewName("prescription");
        return modelAndView; //todo
    }
}
