package clinic.controller;

import clinic.dao.api.EmployeeDao;
import clinic.dao.api.PatientDao;
import clinic.entities.Employee;
import clinic.entities.Patient;
import clinic.service.api.PatientService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Manage patient
 * Сделать:
 * - CRUD Patient
 * - getCasesByPatientId - List(case) - список дел пациента по patientId
 * - getOpenCasesByPatientId - List(case) - список открытых дел пациента по patientId
 * - getPrescriptionsByPatientId - List(Prescriptions) - список назначений пациента по patientId
 * - getOpenPrescriptionsByPatientId - List(Prescriptions) - список назначений пациента по patientId
 */
@Log4j
@Controller
@RequestMapping(value = "/patient")
public class PatientController {

    final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    PatientDao dao;

    //Return Patient by ID
 //   @RequestMapping(value = "/{patientId}", method = RequestMethod.GET)
    @GetMapping(value = "/{patientId}")
    @ResponseBody
    public ModelAndView getPatientById(@PathVariable("patientId") Integer patientId) {
        ModelAndView modelAndView = new ModelAndView();
    //    modelAndView.addObject("patient", patientService.getOneById(patientId));
        modelAndView.addObject("patient", dao.findById(patientId));
        modelAndView.setViewName("patient");
        System.out.println(dao.findById(patientId));
        return modelAndView;
    }


    //Return all patients
    @GetMapping(value = "/")
    @ResponseBody
    public ModelAndView getAllPatients() {
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("patients", dao.findAll());
     //   modelAndView.addObject("patient", patientService.getAll());
        modelAndView.setViewName("patients");
        return modelAndView;
    }
}
