package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIER_TYPE")
@Table(name = "Tier", uniqueConstraints =
        {@UniqueConstraint( columnNames = {"numClient"})}
)
public abstract class Tier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idClient;
    private String numClient;
    protected String nationalite;
    protected Date dateSouscription;
    protected String adresse;
    @OneToMany
    protected List<Compte> comptes;
    @OneToMany
    protected List<Restriction> restrictions;

    @Column(name = "TIER_TYPE", insertable = false ,updatable = false)
    protected String tierType;

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public void setNumClient(String numClient) {
        this.numClient = numClient;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public void setDateSouscription(Date dateSouscription) {
        this.dateSouscription = dateSouscription;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public void setRestrictions(List<Restriction> restrictions) {
        this.restrictions = restrictions;
    }

    public void setTierType(String tierType) {
        this.tierType = tierType;
    }
}
