package ma.atos.ma.atos.bankmanagement.Dtos;
import lombok.Data;
import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data

public abstract class TierDto {
  protected Long idClient;
  private String type;

}
