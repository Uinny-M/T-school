package clinic.controller;

import clinic.dto.CaseDTO;
import clinic.service.api.CaseService;
import clinic.service.api.PrescriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/cases")
public class CaseController {
    private final CaseService caseService;
    public final PrescriptionService prescriptionService;

    public CaseController(CaseService caseService, PrescriptionService prescriptionService) {
        this.caseService = caseService;
        this.prescriptionService = prescriptionService;
    }

    //Return all cases by PatientId
    @GetMapping(value = "/{patientId}")
    public ModelAndView getAllCases(@PathVariable Integer patientId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cases", caseService.getCasesByPatientId(patientId));
        modelAndView.setViewName("cases");
        return modelAndView;
    }
    //Return Patient by ID
    @GetMapping(value = "/update/{caseId}")
    public ModelAndView getCaseById(@PathVariable("caseId") Long caseId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("case", caseService.getOneById(caseId));
        modelAndView.addObject("prescription", prescriptionService.getAllByCaseId(caseId));
        modelAndView.setViewName("patientCase");
        return modelAndView;
    }

    //Return Case by ID
    @GetMapping(value = "/update")
    public ModelAndView getCaseById() {
        ModelAndView modelAndView = new ModelAndView();
        CaseDTO caseDTO = new CaseDTO();
        caseDTO.setStartDate(LocalDate.now());
        modelAndView.addObject("case", caseDTO);
        modelAndView.setViewName("patientCase");
        return modelAndView;
    }

        //Add new case
    @PostMapping(value = "/update")
    public RedirectView addPatientCase(@ModelAttribute CaseDTO caseDTO) {
        caseService.createOrUpdate(caseDTO); //todo сделать отдельный метод
//        ModelAndView modelAndView = new ModelAndView(new RedirectView());
        return new RedirectView("/T_school_war_exploded/cases/");
    }

   // Add new case
    @PostMapping(value = "/close/{caseId}")
    public ModelAndView closeCase(@PathVariable Long caseId) {
        caseService.closeCase(caseId);
        ModelAndView modelAndView = new ModelAndView(new RedirectView());
        return modelAndView;
    }



}