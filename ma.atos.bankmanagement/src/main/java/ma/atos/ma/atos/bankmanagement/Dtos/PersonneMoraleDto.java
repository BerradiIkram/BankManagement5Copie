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

public class PersonneMoraleDto  {
    protected Long idClient;
    private String numClient;
    private String nationalite;
    private Date dateSouscription;
    private String adresse;
    private String raionSociale;
    private String numRegisterComm;

}
