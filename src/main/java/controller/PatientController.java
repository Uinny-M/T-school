package controller;

import entities.Patient;
import org.springframework.web.servlet.ModelAndView;
import service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Manage patient
 */
@Controller
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    PatientService patientService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patientJSP", patientService.getPatient(1));
        modelAndView.setViewName("patient");
        return modelAndView;
    }






    //Return Patient bi ID
    @RequestMapping(value = "/{patientId}", method = RequestMethod.GET)
    @ResponseBody
   // public ModelAndView
    public Patient getPatient(@PathVariable("patientId") Integer patientId) {
        return patientService.getPatient(patientId);
    }

    //Return Patient bi name
    @RequestMapping(value = "/{patientName}", method = RequestMethod.GET)
    @ResponseBody
    public Patient getPatient(@PathVariable("patientName") String patientName) {
        return patientService.getPatient(patientName);
    }

    //Create new patient or update existing
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Patient createOrUpdateLecture(@RequestBody Patient patient) {
        return patientService.createOrUpdatePatient(patient);
    }

    //Delete existing patient
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity removeLecture(@RequestBody Patient patient) {
        patientService.removePatient(patient);
        return ResponseEntity.ok().build();
    }


}
