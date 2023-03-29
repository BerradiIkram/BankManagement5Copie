package ma.atos.ma.atos.bankmanagement.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
public class CustomerException extends RuntimeException{

    private String message;
    private String code;
    private HttpStatus httpStatus;


    public CustomerException(String message) {
        super();
        this.message = message;
    }

    public CustomerException(String message, String code, HttpStatus httpStatus) {
            super();
            this.message = message;
            this.code = code;
            this.httpStatus = httpStatus;
        }

}
