package ma.atos.ma.atos.bankmanagement.mappers;

import ma.atos.ma.atos.bankmanagement.Dtos.AgenceDto;
import ma.atos.ma.atos.bankmanagement.entities.Agence;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AgenceMapper {

//        @Mapping(source = "inEntity", target = "inDTO")
        AgenceDto agenceToAgenceDto(Agence agence);

        Agence agenceDtoToAgence(AgenceDto agenceDto);

}
