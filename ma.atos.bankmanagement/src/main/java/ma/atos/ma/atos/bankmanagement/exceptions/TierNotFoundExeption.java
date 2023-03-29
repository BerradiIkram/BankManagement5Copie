package ma.atos.ma.atos.bankmanagement.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class TierNotFoundExeption extends RuntimeException {
    private String message;
    private String code;
    private HttpStatus httpStatus;

    public TierNotFoundExeption(String message) {
        super(message);
    }
    public TierNotFoundExeption(String message, String code) {
        super();
        this.message = message;
        this.code = code;}

    public TierNotFoundExeption(String message, String code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }


}
