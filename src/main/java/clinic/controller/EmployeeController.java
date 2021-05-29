package clinic.controller;

import clinic.dto.EmployeeDTO;
import clinic.service.api.EmployeeService;
import clinic.service.api.ManipulationService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final ManipulationService manipulationService;
    private final BCryptPasswordEncoder encoder;
    private final String ROLE_DOCTOR = "ROLE_DOCTOR";
    private final String ROLE_ADMIN = "ROLE_ADMIN";

    public EmployeeController(EmployeeService employeeService, ManipulationService manipulationService, BCryptPasswordEncoder encoder) {
        this.employeeService = employeeService;
        this.manipulationService = manipulationService;
        this.encoder = encoder;
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

    //Return Employee by ID
    @GetMapping(value = "/add")
    public ModelAndView getEmployeeById() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", new EmployeeDTO());
        modelAndView.setViewName("employee");
        return modelAndView;
    }

    //Add new employee
    @Secured(value = ROLE_ADMIN)
    @RequestMapping (value = "/add", method = { RequestMethod.POST})
    public RedirectView addEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
        employeeDTO.setPassword(encoder.encode(employeeDTO.getPassword()));
        employeeDTO.setEnable(true);
        employeeService.create(employeeDTO);
        return new RedirectView("/T_school_war_exploded/employee/");
    }
}
