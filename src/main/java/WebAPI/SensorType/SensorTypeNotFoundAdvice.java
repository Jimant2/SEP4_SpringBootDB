package WebAPI.SensorType;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class SensorTypeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(SensorTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String terrariumProfileNotFoundHandler(SensorTypeNotFoundException ex) {
        return ex.getMessage();
    }
}
