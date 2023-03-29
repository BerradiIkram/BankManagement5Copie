package ma.atos.ma.atos.bankmanagement.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.ma.atos.bankmanagement.enums.TypeCompte;

import java.util.Date;
// POJO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteDto {

    private Long ribCompte;
    private TypeCompte typeCompte;
    private double balance;
    private Date dateCreation;
    private String devise;
}
