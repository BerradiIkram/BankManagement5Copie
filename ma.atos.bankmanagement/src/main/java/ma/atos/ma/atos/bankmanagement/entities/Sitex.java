package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Sitex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSitex;
    private String type;
}
