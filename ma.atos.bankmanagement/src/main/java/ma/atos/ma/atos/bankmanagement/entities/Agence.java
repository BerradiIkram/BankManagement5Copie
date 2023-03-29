package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Agence", uniqueConstraints =
        {@UniqueConstraint( columnNames = {"codeAgence"})})
public class Agence {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    private String codeAgence;
    private String nomAgence;
    private String adressAgence;

}
