package clinic.controller;

import clinic.dto.CaseDTO;
import clinic.exception.BusinessException;
import clinic.service.api.CaseService;
import clinic.service.api.PatientService;
import clinic.service.api.PrescriptionService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value = "/cases")
public class CaseController {
    private final CaseService caseService;
    private final PrescriptionService prescriptionService;
    private final PatientService patientService;
    private final String ROLE_DOCTOR = "ROLE_DOCTOR";

    public CaseController(CaseService caseService, PrescriptionService prescriptionService, PatientService patientService) {
        this.caseService = caseService;
        this.prescriptionService = prescriptionService;
        this.patientService = patientService;
    }

    //Return all cases by PatientId
    @RequestMapping(value = "/{patientId}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getAllCases(@PathVariable Integer patientId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patientId", patientId);
        CaseDTO caseDTO = new CaseDTO();
        try {
            modelAndView.addObject("newCase", caseDTO);
            modelAndView.addObject("cases", caseService.getCasesByPatientId(patientId));
            modelAndView.addObject("patient", patientService.getOneById(patientId));
        } catch (BusinessException e) {
            ModelAndView modelAndView1 = new ModelAndView();
            modelAndView1.setViewName("/error/exception");
            modelAndView1.addObject("error", e.getMessage());
            return modelAndView1;
        }
        modelAndView.setViewName("cases");
        return modelAndView;
    }

    //Return all prescriptions by CaseID
    @RequestMapping(value = "/{patientId}/update/{caseId}", method = RequestMethod.GET)
    public ModelAndView getCaseById(@PathVariable("caseId") Long caseId,
                                    @PathVariable("patientId") Integer patientId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patientId", patientId);
        try {
            modelAndView.addObject("patient", patientService.getOneById(patientId));
            modelAndView.addObject("case", caseService.getOneById(caseId));
            modelAndView.addObject("openCase", caseService.getOneById(caseId).isOpenCase());
            modelAndView.addObject("prescription", prescriptionService.getAllByCaseId(caseId));
        } catch (BusinessException e){
            ModelAndView modelAndView1 = new ModelAndView();
            modelAndView.setViewName("/error/exception");
            modelAndView1.addObject("error", e.getMessage());
            return modelAndView1;//todo check
        }
        modelAndView.setViewName("patientCase");
        return modelAndView;
    }

    //Add a new case
    @Secured(value = ROLE_DOCTOR)
    @PostMapping(value = "/{patientId}/add")
    public RedirectView addCase(@ModelAttribute CaseDTO caseDTO,
                                @PathVariable("patientId") Integer patientId) {
        try {
            caseService.createCase(caseDTO.getDiagnosis(), patientId);
        }
        catch (BusinessException e){
            RedirectView redirectView = new RedirectView("/T_school_war_exploded/error/exception");
            redirectView.addStaticAttribute("error", e.getMessage());
            return redirectView;
        }
        return new RedirectView("/T_school_war_exploded/cases/" + patientId);
    }

    // Close the case by Case's id
    @Secured(value = ROLE_DOCTOR)
    @RequestMapping(value = "/close/{caseId}", method = {RequestMethod.GET, RequestMethod.POST})
    public RedirectView closeCase(@PathVariable Long caseId) {
        try {
            caseService.closeCase(caseId);
        } catch (BusinessException e) {
            RedirectView redirectView = new RedirectView("/T_school_war_exploded/error/exception");
            redirectView.addStaticAttribute("error", e.getMessage());
            return redirectView;//todo
        }
//        caseService.closeCase(caseId);
        String url = "/T_school_war_exploded/cases/"
                + caseService.getOneById(caseId).getPatient().getId();
        return new RedirectView(url);
    }

    //update the existing case
    @Secured(value = ROLE_DOCTOR)
    @PostMapping(value = "/{patientId}/update/{caseId}")
    public RedirectView updateCase(@ModelAttribute CaseDTO caseDTO,
                                   @PathVariable("patientId") Integer patientId,
                                   @PathVariable("caseId") Long caseId) {
        caseService.updateCase(caseDTO.getDiagnosis(), caseId);
        return new RedirectView("/T_school_war_exploded/cases/" + patientId + "/update/" + caseId);
    }
}