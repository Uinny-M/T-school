
package clinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
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
    public ModelAndView redirect400(){
        ModelAndView modelAndView = new ModelAndView("/error/400");
        modelAndView.setViewName("/error/400");
//        modelAndView.addObject("message", "ай");
        return modelAndView;
    }
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public ModelAndView redirect404(){
        ModelAndView modelAndView = new ModelAndView("/error/404");
        modelAndView.setViewName("/error/404");
//        modelAndView.addObject("message", "ай");
        return modelAndView;
    }

    @RequestMapping(value = "/error/403", method = RequestMethod.GET)
    public ModelAndView redirect403(){
        ModelAndView modelAndView=new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails =(UserDetails) auth.getPrincipal();
            modelAndView.addObject("username", userDetails.getUsername());
        }
        modelAndView.setViewName("error/403");
        return modelAndView;
    }
}
