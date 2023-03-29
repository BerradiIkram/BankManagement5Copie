package ma.atos.ma.atos.bankmanagement.exceptions;

import lombok.extern.log4j.Log4j2;
import ma.atos.ma.atos.bankmanagement.Dtos.responses.ErrorStatus;
import ma.atos.ma.atos.bankmanagement.Dtos.responses.GenericResponse;
import ma.atos.ma.atos.bankmanagement.enums.ApiStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Log4j2
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse> handleException(Exception e) {
        GenericResponse result = new GenericResponse();
        log.error(e.getMessage(), e);
        e.printStackTrace();
        result.setStatusCode(String.valueOf(ErrorStatus.TECHNICAL_ERROR.getCode()));
        result.setDescription(ErrorStatus.TECHNICAL_ERROR.description());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }
    @ExceptionHandler(TierNotFoundExeption.class)
    public ResponseEntity<GenericResponse> handleException(TierNotFoundExeption ex){
        GenericResponse result = new GenericResponse();
        log.error(ex.getMessage(), ex);
        ex.printStackTrace();
        result.setStatusCode(ex.getCode());
        result.setDescription(ex.getMessage());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @ExceptionHandler(RestrictionException.class)
    public ResponseEntity<GenericResponse> handleException(RestrictionException ex){
            GenericResponse result = new GenericResponse();
            log.error(ex.getMessage(), ex);
            ex.printStackTrace();
            ex.setMessage(String.valueOf(ErrorStatus.TECHNICAL_ERROR.getCode()));
            ex.setMessage(ErrorStatus.NOT_FOUND.description());
            return ResponseEntity.status(HttpStatus.OK).body(result);
    }

//    @ExceptionHandler(RestrictionException.class)
//    public ResponseEntity<GenericResponse> handleException(RestrictionException ex){
//            GenericResponse result = new GenericResponse();
//
//            log.error(ex.getMessage(), ex);
//            ex.printStackTrace();
//            ex.setMessage(String.valueOf(ErrorStatus.TECHNICAL_ERROR.getCode()));
//            ex.setMessage(ErrorStatus.NOT_FOUND.description());
//
//            return ResponseEntity.status(HttpStatus.OK).body(result);
//
//    }

//    @ExceptionHandler(CompteNotFoundException.class)
//    public ResponseEntity<GenericResponse> handleCompteNotFoundException(CompteNotFoundException ex) {
//        GenericResponse result = new GenericResponse();
//        result.setDescriptionForOperation(ex.getMessage());
//        result.setError(true);
//        result.setDescription(ex.getMessage());
//        result.setStatusCode(String.valueOf(HttpStatus.NOT_FOUND));
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(result);
//    }

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<GenericResponse> handleCustomerException(CustomerException ex) {
        GenericResponse result = new GenericResponse();
        result.setDescriptionForOperation(ex.getMessage());
        result.setError(true);
        result.setDescription(ex.getMessage());
        result.setStatusCode(String.valueOf(HttpStatus.NOT_FOUND));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ExceptionHandler(CompteException.class)
    public ResponseEntity<GenResponse> handleCompteException(CompteException e) {
            GenResponse response = new GenResponse();
            log.error(e.getMessage());
            e.printStackTrace();
            response.setError(true);
            response.setDescription(e.getMessage());
            response.setDescriptionFront(e.getMessageFront());
            response.setStatusCode(e.getCode());
            return ResponseEntity.status(e.getHttpStatus()).body(response);
    }


}
