package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Gestionnaire",uniqueConstraints =
        {@UniqueConstraint( columnNames = {"matricule"})}
)
public class Gestionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricule;
    private String nom;
    @OneToMany
    private List<Compte> comptes;
}
