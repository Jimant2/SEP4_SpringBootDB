package WebAPI.SensorData;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SensorDataNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(SensorDataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String terrariumProfileNotFoundHandler(SensorDataNotFoundException ex) {
        return ex.getMessage();
    }
}
