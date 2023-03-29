package ma.atos.ma.atos.bankmanagement.mappers;

import ma.atos.ma.atos.bankmanagement.Dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.Dtos.GestionnaireDto;
import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.entities.Gestionnaire;
import org.mapstruct.Mapper;


@Mapper
public interface GestionnaireMapper {

    GestionnaireDto gestionnaireToGestionnaireDto(Gestionnaire gestionnaire);

    Gestionnaire gestionnaireDtoToGestionnaire(GestionnaireDto gestionnaireDto);



}
