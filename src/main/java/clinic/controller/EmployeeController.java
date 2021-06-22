package clinic.controller;

import clinic.dto.EmployeeDTO;
import clinic.exception.BusinessException;
import clinic.service.api.EmployeeService;
import clinic.service.api.ManipulationService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final ManipulationService manipulationService;
    private final BCryptPasswordEncoder encoder;
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
    @Secured(value = ROLE_ADMIN)
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getEmployeeById(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", model.asMap().get("flashEmployee") != null ? model.asMap().get("flashEmployee") : new EmployeeDTO());
//        modelAndView.addObject("employee", new EmployeeDTO());
        modelAndView.setViewName("employee");
        return modelAndView;
    }

    //Add new employee
    @Secured(value = ROLE_ADMIN)
    @RequestMapping (value = "/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute EmployeeDTO employeeDTO,
                               RedirectAttributes attributes) {
        employeeDTO.setPassword(encoder.encode(employeeDTO.getPassword()));
        employeeDTO.setEnable(true);
        try {
            employeeService.create(employeeDTO);
        } catch (BusinessException e){
            attributes.addFlashAttribute("flashEmployee", employeeDTO);
            attributes.addFlashAttribute("error", e.getMessage());
            String url = "redirect:/employee/add";
            return url;
        }
        String url = "redirect:/employee/";
        return url;
    }
}
