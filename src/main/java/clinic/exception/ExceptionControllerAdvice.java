package clinic.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError404(NoHandlerFoundException e)   {
        ModelAndView mav = new ModelAndView("error/404");
        mav.addObject("exception", e);
        return mav;
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ModelAndView handleError500(NoHandlerFoundException e)   {
        ModelAndView mav = new ModelAndView("error/500");
        mav.addObject("exception", e);
        return mav;
    }
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public void notFoundHandler() {
//    }

}
