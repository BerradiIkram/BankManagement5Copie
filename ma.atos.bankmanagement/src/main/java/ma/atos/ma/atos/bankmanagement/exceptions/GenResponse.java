package ma.atos.ma.atos.bankmanagement.exceptions;

import lombok.Getter;
import lombok.Setter;
import ma.atos.ma.atos.bankmanagement.enums.ApiStatusCode;

@Getter
@Setter
public class GenResponse {
    private ApiStatusCode statusCode;
    private String description;
    private String descriptionFront;
    private boolean error;
}
