package WebAPI.MotherboardData;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class MotherboardDataNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MotherboardDataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String motherboardDataNotFoundHandler(MotherboardDataNotFoundException ex) {
        return ex.getMessage();
    }
}
