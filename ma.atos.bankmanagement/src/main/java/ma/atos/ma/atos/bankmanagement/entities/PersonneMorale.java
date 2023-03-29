package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "PersonneMorale", uniqueConstraints =
        {@UniqueConstraint( columnNames = {"numRegisterCom"})})
@DiscriminatorValue("PM")
public class PersonneMorale extends Tier{

    private String raionSociale;
    private String numRegisterComm;

    public void setRaionSociale(String raionSociale) {
        this.raionSociale = raionSociale;
    }

    public void setNumRegisterComm(String numRegisterComm) {
        this.numRegisterComm = numRegisterComm;
    }

    public String getRaionSociale() {
        return raionSociale;
    }

    public String getNumRegisterComm() {
        return numRegisterComm;
    }
}
