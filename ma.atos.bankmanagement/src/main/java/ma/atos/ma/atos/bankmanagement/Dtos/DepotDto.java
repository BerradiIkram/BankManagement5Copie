package ma.atos.ma.atos.bankmanagement.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ma.atos.ma.atos.bankmanagement.entities.Operation;
import ma.atos.ma.atos.bankmanagement.enums.SensOperation;
import ma.atos.ma.atos.bankmanagement.enums.SourceDepot;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Data
public class DepotDto extends OperationDto{

//    private double montant;
//    private String description;
//    private Date dateOperation;
//    private SensOperation sensOperation;
//  private String typeOperation;
//    @JsonIgnore
    private Long idCompte;
    private Long ribCompte;
    private SourceDepot sourceDepot;


//    public Long getRibCompte() {
//        return ribCompte;
//    }

//    public void setRibCompte(Long ribCompte) {
//        this.ribCompte = ribCompte;
//    }


    @JsonIgnore
    public Long getRibCompte() {
        return ribCompte;
    }

}


