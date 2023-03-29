package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "PersonnePhysique" ,
        uniqueConstraints =
        {@UniqueConstraint( columnNames = {"numTel","email"})})
@DiscriminatorValue("PP")
public class PersonnePhysique extends Tier{

    private String nomComplet ;
    private Date dateNaissance;
    private String typeIdentification;
    private String numTel;
    private String email;

}
