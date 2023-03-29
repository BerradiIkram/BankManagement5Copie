package ma.atos.ma.atos.bankmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ma.atos.ma.atos.bankmanagement.enums.SourceDepot;

import javax.persistence.*;

@DiscriminatorValue("depot")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "depot" )

public class Depot extends Operation{

    @Enumerated(EnumType.STRING) // specify that the enum should be persisted as a string
    private SourceDepot sourceDepot;


}


