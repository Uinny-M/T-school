package clinic.exception;

import clinic.controller.PrescriptionController;
import lombok.Getter;
import org.apache.log4j.Logger;


@Getter
public class BusinessException extends RuntimeException{
    private static final Logger log = Logger.getLogger(PrescriptionController.class);
    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
        log.info(message);
    }
}