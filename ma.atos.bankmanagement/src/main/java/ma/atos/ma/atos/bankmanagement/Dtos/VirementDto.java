package ma.atos.ma.atos.bankmanagement.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ma.atos.ma.atos.bankmanagement.entities.Operation;
import ma.atos.ma.atos.bankmanagement.enums.SensOperation;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)

public class VirementDto extends OperationDto {

//    private double montant;
//    private String description;
//    private Date dateOperation;
//    private SensOperation sensOperation;

//    private String typeOperation;

//    @JsonIgnore
    private Long idCompte;

//    @JsonIgnore
    private Long ribCompte;

    @JsonIgnore
    public Long getRibCompte() {
        return ribCompte;
    }

    private Long ribCompteDestinataire;

    public Long getRibCompteDestinataire() {
        return ribCompteDestinataire;
    }

}
