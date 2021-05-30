package clinic.controller;

import clinic.dto.PatientDTO;
import clinic.service.api.CaseService;
import clinic.service.api.EmployeeService;
import clinic.service.api.PatientService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


/**
 * Manage patient
 * Сделать:
 * - CRUD Patient
 * - getCasesByPatientId - List(case) - список дел пациента по patientId
 * - getOpenCasesByPatientId - List(case) - список открытых дел пациента по patientId
 * - getPrescriptionsByPatientId - List(Prescriptions) - список назначений пациента по patientId
 * - getOpenPrescriptionsByPatientId - List(Prescriptions) - список назначений пациента по patientId
 */
@Log
@Controller
@RequestMapping(value = "/patient")
public class PatientController {
    private final PatientService patientService;
    private final String ROLE_DOCTOR = "ROLE_DOCTOR";
    private final String ROLE_ADMIN = "ROLE_ADMIN";

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    //Return Patient by ID
    @GetMapping(value = "/{patientId}")
    public ModelAndView getPatientById(@PathVariable("patientId") Integer patientId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patient", patientService.getOneById(patientId));
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
    @GetMapping(value = "/add")
    public ModelAndView getPatientById() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patient", new PatientDTO());
        modelAndView.setViewName("patient");
        return modelAndView;
    }

    //Add new patient
    @PostMapping(value = "/add")
    public RedirectView addPatient(@ModelAttribute PatientDTO patientDto) {
        patientService.createOrUpdatePatient(patientDto);
        return new RedirectView("/T_school_war_exploded/patient/");
    }
}
