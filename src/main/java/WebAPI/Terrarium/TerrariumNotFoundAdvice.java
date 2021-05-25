package WebAPI.Terrarium;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TerrariumNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TerrariumNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String terrariumNotFoundHandler(TerrariumNotFoundException ex) {
        return ex.getMessage();
    }
}
