package ma.atos.ma.atos.bankmanagement.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.enums.SensOperation;
import ma.atos.ma.atos.bankmanagement.enums.SourceDepot;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;


@Data

public class OperationDto {

       @JsonIgnore
       private Long idOperation;
        private double montant;
        private String description;
        private Date dateOperation;
        private SensOperation sensOperation;
        private String typeOperation;
//        @JsonIgnore
        private Long idCompte;



//        private Compte compte;

//        @JsonIgnore
        private Long ribCompte;

    private SourceDepot sourceDepot;


    private Long ribCompteDestinataire;

//        public OperationDto(double montant, String description, Date dateOperation, SensOperation sensOperation, String typeOperation, Compte compte) {
//                this.montant = montant;
//                this.description = description;
//                this.dateOperation = dateOperation;
//                this.sensOperation = sensOperation;
//                this.typeOperation = typeOperation;
//                this.idCompte = compte.getIdCompte();
//        }
//
//        public OperationDto() {
//        }






}







