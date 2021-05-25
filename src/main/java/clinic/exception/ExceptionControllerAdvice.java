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
        modelAndView.addObject("errorcode", "404");
        return modelAndView;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handlerError403(HttpServletRequest request, Exception e) {
        ModelAndView modelAndView = new ModelAndView("/error/403");
        modelAndView.addObject("errorcode", "403");
        return modelAndView;
    }

    @ExceptionHandler(BusinessException.class)
    public ModelAndView businessError(HttpServletRequest request, BusinessException e) {
        ModelAndView modelAndView = new ModelAndView("/error/403");
        modelAndView.addObject("errorcode", "403");
        return modelAndView;
    }
}
