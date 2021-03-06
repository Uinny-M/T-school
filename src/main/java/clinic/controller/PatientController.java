package clinic.controller;

import clinic.dto.PatientDTO;
import clinic.exception.BusinessException;
import clinic.service.api.CaseService;
import clinic.service.api.EmployeeService;
import clinic.service.api.PatientService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;


/**
 * Manage patient
 * Сделать:
 * - CRUD Patient
 * - getCasesByPatientId - List(case) - список дел пациента по patientId
 * - getOpenCasesByPatientId - List(case) - список открытых дел пациента по patientId
 * - getPrescriptionsByPatientId - List(Prescriptions) - список назначений пациента по patientId
 * - getOpenPrescriptionsByPatientId - List(Prescriptions) - список назначений пациента по patientId
 */

@Controller
@RequestMapping(value = "/patient")
public class PatientController {
    private final PatientService patientService;
    private final String ROLE_DOCTOR = "ROLE_DOCTOR";

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    private static Logger log = Logger.getLogger(PatientController.class);

    //Return Patient by ID
    @GetMapping(value = "/{patientId}")
    public ModelAndView getPatientById(@PathVariable("patientId") Integer patientId) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.addObject("patient", patientService.getOneById(patientId));
        } catch (BusinessException e) {
            ModelAndView modelAndView1 = new ModelAndView();
            modelAndView1.setViewName("/error/exception");
            modelAndView1.addObject("error", e.getMessage());
            return modelAndView1;
        }
        modelAndView.setViewName("patient");
        return modelAndView;
    }

    //Return all patients
    @GetMapping(value = "/")
    public ModelAndView getAllPatients(@RequestParam(required = false, value = "name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patients", patientService.getPatientsByName(name));
        modelAndView.addObject("patientNew", new PatientDTO());
        modelAndView.addObject("search", name);
        modelAndView.setViewName("patients");
        return modelAndView;
    }

    //Return Patient by ID
    @Secured(ROLE_DOCTOR)
    @GetMapping(value = "/add")
    public ModelAndView getPatient(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patient", model.asMap().get("flashPatient") != null ? model.asMap().get("flashPatient") : new PatientDTO());
       // modelAndView.addObject("patient", new PatientDTO());
        modelAndView.setViewName("patient");
        return modelAndView;
    }

    //Add new patient
    @Secured(ROLE_DOCTOR)
    @PostMapping(value = "/add")
    public String addPatient(@ModelAttribute PatientDTO patientDto,
                             RedirectAttributes attributes) {
        try {
            patientService.createOrUpdatePatient(patientDto);
        } catch (BusinessException e) {
            attributes.addFlashAttribute("flashPatient", patientDto);
            attributes.addFlashAttribute("error", e.getMessage());
            String url = "redirect:/patient/add";
            return url;
        }
        String url = "redirect:/patient/";
        return url;
//        return new RedirectView("/T_school_war_exploded/patient/");
    }
}
