
package clinic.exception;

import clinic.controller.PrescriptionController;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
public class ExceptionController {
    private static final Logger log = Logger.getLogger(ExceptionController.class.getName());
//
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    @ExceptionHandler(Exception.class)
//    public ModelAndView redirect404(){
//        ModelAndView modelAndView = new ModelAndView("/error/404");
//        modelAndView.setViewName("/error/404");
////        modelAndView.addObject("message", "ай");
//        return modelAndView;
//    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ModelAndView redirect400() {
        log.info("error400");
        ModelAndView modelAndView = new ModelAndView("error/400");
        modelAndView.setViewName("error/400");
        return modelAndView;
    }

    @RequestMapping(value = "/error/404")
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public ModelAndView redirect404(@RequestParam(value = "error", required = false) String error,
                                    Model model) {
        ModelAndView modelAndView = new ModelAndView("error/404");
        log.info("error404");
        modelAndView.addObject("error", error);
        modelAndView.setViewName("error/404");
        return modelAndView;
    }

    @RequestMapping(value = "/error/403", method = RequestMethod.GET)
    public ModelAndView redirect403() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            modelAndView.addObject("username", userDetails.getUsername());
        }
        log.info("error403");
        modelAndView.setViewName("error/403");
        return modelAndView;
    }

    @RequestMapping(value = "/error/exception")
    public ModelAndView redirectException(@RequestParam(value = "error", required = false) String error,
                                    Model model) {
        ModelAndView modelAndView = new ModelAndView("error/exception");
        model.addAttribute("error", error);
        log.info("Business Exception: " + error);
        modelAndView.setViewName("error/exception");
        return modelAndView;
    }
}
