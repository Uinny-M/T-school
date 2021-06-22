
package clinic.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
    private static final Logger log = Logger.getLogger(ExceptionController.class);
//
//    @RequestMapping(value = "/error/403", method = RequestMethod.GET)
//    public ModelAndView redirect403() {
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (!(auth instanceof AnonymousAuthenticationToken)) {
//            UserDetails userDetails = (UserDetails) auth.getPrincipal();
//            modelAndView.addObject("username", userDetails.getUsername());
//        }
//        log.info("error403");
//        modelAndView.setViewName("error/403");
//        return modelAndView;
//    }
//
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
