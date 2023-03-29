package ma.atos.ma.atos.bankmanagement.Dtos.responses;


import lombok.Data;

@Data
public class GenericResponse {

    private String statusCode;

    private boolean error;

    private boolean alert = true;

    private String description;

    private String descriptionForOperation;

}
