package ma.atos.ma.atos.bankmanagement.mappers;
import ma.atos.ma.atos.bankmanagement.Dtos.PersonnePhysiqueDto;
import ma.atos.ma.atos.bankmanagement.Dtos.RestrictionDto;
import ma.atos.ma.atos.bankmanagement.entities.PersonnePhysique;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PersonnePhysiqueMapper {

    PersonnePhysiqueDto personnePhysiqueToPersonnePhysiqueDto(PersonnePhysique personnePhysique);

    PersonnePhysique PpDtoToPp(PersonnePhysiqueDto personnePhysiqueDto);
}
