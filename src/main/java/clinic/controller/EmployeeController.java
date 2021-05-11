package clinic.controller;

import clinic.service.api.EmployeeService;
import clinic.service.api.ManipulationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final ManipulationService manipulationService;

    public EmployeeController(EmployeeService employeeService, ManipulationService manipulationService) {
        this.employeeService = employeeService;
        this.manipulationService = manipulationService;
    }

    //Return all employees
    @GetMapping(value = "/")
    public ModelAndView getAllEmployees() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees", employeeService.getAll());
        modelAndView.setViewName("employees");
        return modelAndView;
    }

    //Return all manipulations
    @GetMapping(value = "/manipulation")
    public ModelAndView getAllManipulation() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("manipulation", manipulationService.getAll());
        modelAndView.setViewName("manipulations");
        return modelAndView;
    }
}
