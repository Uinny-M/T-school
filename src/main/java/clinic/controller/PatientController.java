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
    private final CaseService caseService;
    private final EmployeeService employeeService;

    @Autowired
    public PatientController(PatientService patientService, CaseService caseService, EmployeeService employeeService) {
        this.patientService = patientService;
        this.caseService = caseService;
        this.employeeService = employeeService;
    }

    //Return Patient by ID
    @GetMapping(value = "/{patientId}")
    public ModelAndView getPatientById(@PathVariable("patientId") Integer patientId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patient", patientService.getOneById(patientId));
        // modelAndView.addObject("cases", caseService.getAll());
        modelAndView.setViewName("patient");
        return modelAndView;
    }

    //Return all patients
    @GetMapping(value = "/")
    @ResponseBody
    public ModelAndView getAllPatients() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patients", patientService.getAll());
        modelAndView.addObject("patientNew", new PatientDTO());
//        modelAndView.addObject("patientName", new String());
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
    public ModelAndView addPatient(@ModelAttribute PatientDTO patientDto) {
        patientService.createOrUpdatePatient(patientDto);
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    //Return patients by secondName
    @GetMapping(value = "/search/{name}")
    public ModelAndView getPatientsByName(@PathVariable(required = false) String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);
        modelAndView.addObject("patients", patientService.getPatientsByName(name));
        modelAndView.setViewName("patients");
        return modelAndView;
    }

//    //Return patients by secondName
//    @GetMapping(value = "/search/{name}")
//    public String getPatientsByName(@PathVariable(required = false) String name) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("name", patientService.getPatientsByName(name));
//        modelAndView.setViewName("patients");
//        return "p";
//    }
}
