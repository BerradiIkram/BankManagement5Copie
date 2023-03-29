package ma.atos.ma.atos.bankmanagement.exceptions;

import org.springframework.http.HttpStatus;

public class CompteNotFoundException extends RuntimeException{

    private String message;
    private String code;
    private HttpStatus httpStatus;

    public CompteNotFoundException(String message) {
        super();
        this.message = message;
    }

    public CompteNotFoundException(String message, String code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }

//    public CompteNotFoundException(String s, Object[] objects) {
//    }






}
