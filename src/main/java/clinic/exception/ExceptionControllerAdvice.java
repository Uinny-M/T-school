package clinic.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionControllerAdvice {


    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handlerError404(HttpServletRequest request, Exception e) {
        ModelAndView modelAndView = new ModelAndView("/error/404");
//        modelAndView.addObject("errorcode", "404");
        return modelAndView;
    }
}
