package clinic.controller;

import clinic.dto.CaseDTO;
import clinic.dto.EmployeeDTO;
import clinic.service.api.CaseService;
import clinic.service.api.EmployeeService;
import clinic.service.api.PatientService;
import clinic.service.api.PrescriptionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/cases")
public class CaseController {
    private final CaseService caseService;
    private final PrescriptionService prescriptionService;
    private final EmployeeService employeeService;
    private final PatientService patientService;

    public CaseController(CaseService caseService, PrescriptionService prescriptionService, EmployeeService employeeService, PatientService patientService) {
        this.caseService = caseService;
        this.prescriptionService = prescriptionService;
        this.employeeService = employeeService;
        this.patientService = patientService;
    }



    //Return all cases by PatientId
    @GetMapping(value = "/{patientId}")
    public ModelAndView getAllCases(@PathVariable Integer patientId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patientId", patientId);
        modelAndView.addObject("cases", caseService.getCasesByPatientId(patientId));
        modelAndView.setViewName("cases");
        return modelAndView;
    }
    //Return Patient by ID
    @RequestMapping(value = "/{patientId}/update/{caseId}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getCaseById(@PathVariable("caseId") Long caseId,
                                    @PathVariable("patientId") Integer patientId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patientId", patientId);
        modelAndView.addObject("case", caseService.getOneById(caseId));
        modelAndView.addObject("prescription", prescriptionService.getAllByCaseId(caseId));
        modelAndView.setViewName("patientCase");
        return modelAndView;
    }

    //Return Case by ID
    @RequestMapping(value = "/{patientId}/update", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getCaseById(@PathVariable ("patientId") Integer patientId) {
        ModelAndView modelAndView = new ModelAndView();
        CaseDTO caseDTO = new CaseDTO();
        caseDTO.setStartDate(LocalDate.now());
        caseDTO.setDoctor(getCurrentUser());
        caseDTO.setPatient(patientService.getOneById(patientId));
        modelAndView.addObject("patientId", patientId);
//        caseDTO.setDoctor(Authentication.class);
        modelAndView.addObject("case", caseDTO);
        modelAndView.setViewName("patientCase");
        return modelAndView;
    }
    private EmployeeDTO getCurrentUser () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return employeeService.getEmployeeByUsername(username);
    }


//    //Add new case
//    @PostMapping(value = "/update")
//    public RedirectView addPatientCase(@ModelAttribute CaseDTO caseDTO) {
//        caseService.createOrUpdate(caseDTO);
//        return new RedirectView("/T_school_war_exploded/cases/");
//    }

   // Close case by Case's id
    @PostMapping(value = "/close/{caseId}")
    public ModelAndView closeCase(@PathVariable Long caseId) {
        caseService.closeCase(caseId);
        ModelAndView modelAndView = new ModelAndView(new RedirectView());
        return modelAndView;
    }


}