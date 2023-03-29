package ma.atos.ma.atos.bankmanagement.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
@Data
public class PersonnePhysiqueDto   {
    protected Long idClient;
    private String numClient;
    protected String nationalite;
    protected Date dateSouscription;
    protected String adresse;
    protected List<CompteDto> comptes;
    protected List<RestrictionDto> restrictions;
    private String nomCompet ;
    private Date dateNaissance;
    private String typeIdentification;
    private String numTel;
    private String email;

}
