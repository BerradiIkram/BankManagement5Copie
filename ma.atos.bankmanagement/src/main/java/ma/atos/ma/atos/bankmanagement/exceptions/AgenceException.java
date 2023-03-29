package ma.atos.ma.atos.bankmanagement.exceptions;

public class AgenceException extends Exception{

    private String message;

    public AgenceException(String message){
        super();
        this.message=message;
    }
}
