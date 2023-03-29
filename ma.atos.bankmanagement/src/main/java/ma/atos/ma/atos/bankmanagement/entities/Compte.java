package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import ma.atos.ma.atos.bankmanagement.enums.TypeCompte;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

// POJO
@Data
@Entity
@Table(name = "Compte", uniqueConstraints =
        {@UniqueConstraint( columnNames = {"ribCompte"})})
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;
    private Long ribCompte;
    private TypeCompte typeCompte;
    private double balance;
    private Date dateCreation;
    private String devise;
    @ManyToOne
    private Tier tier;
    @OneToOne
    private Gestionnaire gestionnaire;
    @OneToMany
    private List<Sitex> sitexes;
    @OneToMany
    private List<Operation> operations;

}
