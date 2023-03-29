package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.Dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.Dtos.PersonnePhysiqueDto;
import ma.atos.ma.atos.bankmanagement.exceptions.TierNotFoundExeption;

import java.util.List;

public interface TierService {
 //   public List<PersonneMoraleDto> getAllPersonneMorale();
    public PersonneMoraleDto getPersonneMorale(Long id) throws TierNotFoundExeption;
    public PersonneMoraleDto savePersonneMorale(PersonneMoraleDto personneMoraleDto);
    public int deletPersonneMorale(Long id);

 //   public List<PersonnePhysiqueDto> getAllPersonnePhysique();

   List<PersonnePhysiqueDto> getAllPersonnePhysique(int page, int size);

   public PersonnePhysiqueDto getPersonnePhysique(Long id) throws TierNotFoundExeption;

    PersonnePhysiqueDto savePersonnePhysique(PersonnePhysiqueDto personnePhysiqueDto);

    public int deletPersonnePhysique(long id);

    List<PersonneMoraleDto> searchPersonneMorale(String numClient);
    List<PersonneMoraleDto> searchPersonneMorale(String numClient,int page,int size);

    /*  List<PersonneMoraleDto> searchPersonneMorale(String keyword);*/

    //public TierDto getTier(long Id) throws TierNotFoundExeption;

    List<PersonneMoraleDto> getAllPersonneMorale(int page, int size);

    Long nbrPersonne(String type);

    List<PersonnePhysiqueDto> searchPersonnePhysique(String numClient, int page, int size);

}
