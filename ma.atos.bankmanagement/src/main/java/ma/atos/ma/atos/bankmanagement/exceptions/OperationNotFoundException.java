package ma.atos.ma.atos.bankmanagement.exceptions;

import org.springframework.http.HttpStatus;


//Handle exception when operation not found

public class OperationNotFoundException extends RuntimeException{

    private String message;
    private String code;
    private HttpStatus httpStatus;

    public OperationNotFoundException(String message) {
        super();
        this.message = message;
    }

    public OperationNotFoundException(String message, String code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public OperationNotFoundException(String s, Object[] objects) {
    }


}
