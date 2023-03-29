package ma.atos.ma.atos.bankmanagement.mappers;


import ma.atos.ma.atos.bankmanagement.Dtos.AgenceDto;
import ma.atos.ma.atos.bankmanagement.Dtos.RestrictionDto;
import ma.atos.ma.atos.bankmanagement.entities.Operation;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import org.mapstruct.Mapper;

@Mapper
public interface RestrictionMapper {

    RestrictionDto restrictionToRestrictionDto(Restriction restriction);

    Restriction restrictionDtoToRestriction(RestrictionDto restrictionDto);

}
