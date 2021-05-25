package WebAPI.TerrariumProfile;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TerrariumProfileNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TerrariumProfileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String terrariumProfileNotFoundHandler(TerrariumProfileNotFoundException ex) {
        return ex.getMessage();
    }
}
