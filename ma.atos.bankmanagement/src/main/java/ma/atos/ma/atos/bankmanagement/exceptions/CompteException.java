package ma.atos.ma.atos.bankmanagement.exceptions;

import lombok.Getter;
import lombok.Setter;
import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.enums.ApiStatusCode;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class CompteException extends Exception {

    private String message;
    private String messageFront;
    private ApiStatusCode code;
    private HttpStatus httpStatus;
    public CompteException(String message) {
        super();
        this.message = message;
    }

    public CompteException(String message, String messageFront , ApiStatusCode code) {
        super();
        this.message = message;
        this.messageFront = messageFront;
        this.code = code;
    }

    public CompteException(String message, ApiStatusCode code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public CompteException(String message, String messageFront, ApiStatusCode code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.messageFront = messageFront;
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
